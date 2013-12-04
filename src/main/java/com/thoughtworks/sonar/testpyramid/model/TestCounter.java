package com.thoughtworks.sonar.testpyramid.model;

public class TestCounter {
    private double numberOfTests;
    private String packageName;

    public TestCounter(String packageName) {
        this.packageName = packageName;
        this.numberOfTests = 0.0;
    }

    public double getNumberOfTests() {
        return numberOfTests;
    }

    public void increment() {
        this.numberOfTests++;
    }

    public String getPackageName() {
        return packageName;
    }
}
