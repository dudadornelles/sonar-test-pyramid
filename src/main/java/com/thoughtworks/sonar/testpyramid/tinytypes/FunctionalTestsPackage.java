package com.thoughtworks.sonar.testpyramid.tinytypes;

public class FunctionalTestsPackage {
    String functionalTestsPackageName;

    public FunctionalTestsPackage(String functionalTestsPackageName) {
        this.functionalTestsPackageName = functionalTestsPackageName;
    }

    public String getFunctionalTestsPackageName() {
        return functionalTestsPackageName;
    }
}