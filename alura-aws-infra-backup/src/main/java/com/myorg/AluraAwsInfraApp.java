package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        AluraVpcStack aluraVpcStack = new AluraVpcStack(app, "Vpc");
        AluraClusterStack aluraClusterStack = new AluraClusterStack(app, "Cluster", aluraVpcStack.getVpc());
        aluraClusterStack.addDependency(aluraVpcStack);

        AluraRdsStack aluraRdsStack = new AluraRdsStack(app, "Rds", aluraVpcStack.getVpc());
        aluraRdsStack.addDependency(aluraVpcStack);

        AluraServiceStack aluraServiceStack = new AluraServiceStack(app, "Service", aluraClusterStack.getCluster());
        aluraServiceStack.addDependency(aluraClusterStack);
        aluraServiceStack.addDependency(aluraRdsStack);

        app.synth();
    }
}

