package com.thoughtworks.sonar.testpyramid;

import org.sonar.api.measures.Measure;
import org.sonar.api.measures.Metric;

public class TestPyramidAnalysis {

    public Measure numberOfUnitTests() {
        return new Measure(SonarTestPyramidMetrics.UNIT_TESTS_METRIC, 10.0);
    }

    public Measure numberOfIntegrationTests() {
        return new Measure(SonarTestPyramidMetrics.INTEGRATION_TESTS_METRIC, 5.0);
    }

    public Measure numberOfFunctionalTests() {
        return new Measure(SonarTestPyramidMetrics.FUNCTIONAL_TESTS_METRIC, 1.0);
    }

}
