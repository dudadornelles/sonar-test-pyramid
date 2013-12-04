package com.thoughtworks.sonar.testpyramid.analysis;

import com.thoughtworks.sonar.testpyramid.SonarTestPyramidMetrics;
import com.thoughtworks.sonar.testpyramid.model.TestsCounter;
import org.sonar.api.measures.Measure;

public class TestPyramidAnalysis {

    private Measure measureForUnitTests;
    private Measure measureForIntegrationTests;
    private Measure measureForFunctionalTests;

    public TestPyramidAnalysis(TestsCounter testsCounter, String unitTestsPackageName, String integrationTestsPackageName, String functionalTestsPackageName) {
        measureForUnitTests = new Measure(SonarTestPyramidMetrics.UNIT_TESTS_METRIC,
                testsCounter.getNumberOfTests(unitTestsPackageName));
        measureForIntegrationTests = new Measure(SonarTestPyramidMetrics.INTEGRATION_TESTS_METRIC,
                testsCounter.getNumberOfTests(integrationTestsPackageName));
        measureForFunctionalTests = new Measure(SonarTestPyramidMetrics.FUNCTIONAL_TESTS_METRIC,
                testsCounter.getNumberOfTests(functionalTestsPackageName));
    }

    public Measure numberOfUnitTests() {
        return measureForUnitTests;
    }

    public Measure numberOfIntegrationTests() {
        return measureForIntegrationTests;
    }

    public Measure numberOfFunctionalTests() {
        return measureForFunctionalTests;
    }

}
