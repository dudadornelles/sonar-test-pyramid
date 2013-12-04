package com.thoughtworks.sonar.testpyramid;

import com.thoughtworks.sonar.testpyramid.model.TestCounter;
import com.thoughtworks.sonar.testpyramid.model.TestsCounter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestsCounterTest {

    @Test
    public void testIncrementForNoPackage() throws Exception {
        TestCounter testCounterForAPackage = new TestCounter("a.package");
        TestCounter testCounterForAnotherPackage = new TestCounter("another.package");

        TestsCounter testsCounter = new TestsCounter(testCounterForAPackage, testCounterForAnotherPackage);

        testsCounter.incrementTestsFor("");

        assertThat(testCounterForAPackage.getNumberOfTests(), is(0.0));
    }

    @Test
    public void testIncrementForAPackage() throws Exception {
        TestCounter testCounterForAPackage = new TestCounter("a.package");
        TestCounter testCounterForAnotherPackage = new TestCounter("another.package");

        TestsCounter testsCounter = new TestsCounter(testCounterForAPackage, testCounterForAnotherPackage);

        testsCounter.incrementTestsFor("package a.package;");

        assertThat(testCounterForAPackage.getNumberOfTests(), is(1.0));
    }
}
