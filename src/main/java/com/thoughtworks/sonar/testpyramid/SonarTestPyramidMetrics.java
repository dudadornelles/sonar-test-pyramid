package com.thoughtworks.sonar.testpyramid;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.Arrays;
import java.util.List;

public class SonarTestPyramidMetrics implements Metrics {
    public final static Metric UNIT_TESTS_METRIC = new Metric.Builder(
            "sonar.testpyramid.unittests",
            "Number Of Unit Tests",
            Metric.ValueType.INT)
            .create();
    public final static Metric INTEGRATION_TESTS_METRIC = new Metric.Builder(
            "sonar.testpyramid.integrationtests",
            "Number Of Integration Tests",
            Metric.ValueType.INT)
            .create();
    public static final Metric FUNCTIONAL_TESTS_METRIC = new Metric.Builder(
            "sonar.testpyramid.integrationtests",
            "Number Of Integration Tests",
            Metric.ValueType.INT)
            .setBestValue(5.0)
            .create();

    public List<Metric> getMetrics() {
        return Arrays.asList(UNIT_TESTS_METRIC, INTEGRATION_TESTS_METRIC, FUNCTIONAL_TESTS_METRIC);
    }
}