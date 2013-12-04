package com.thoughtworks.sonar.testpyramid.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestsCounter {
    private List<TestCounter> testCounters;

    public TestsCounter(TestCounter... testCounters) {
        this.testCounters = Arrays.asList(testCounters);
    }

    public void incrementTestsFor(String packageName) {
        for (TestCounter counter : testCounters) {
            if (packageName.contains(counter.getPackageName())) {
                counter.increment();
            }
        }
    }

    public double getNumberOfTests(String packageName) {
        for (TestCounter counter : testCounters) {
            if (packageName.contains(counter.getPackageName())) {
                return counter.getNumberOfTests();
            }
        }
        return 0;
    }
}
