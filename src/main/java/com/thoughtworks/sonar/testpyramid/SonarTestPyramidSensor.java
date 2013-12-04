package com.thoughtworks.sonar.testpyramid;

import com.thoughtworks.sonar.testpyramid.analysis.TestPyramidAnalysis;
import com.thoughtworks.sonar.testpyramid.analysis.TestPyramidAnalyzer;
import com.thoughtworks.sonar.testpyramid.tinytypes.FunctionalTestsPackage;
import com.thoughtworks.sonar.testpyramid.tinytypes.IntegrationTestsPackage;
import com.thoughtworks.sonar.testpyramid.tinytypes.UnitTestsPackage;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

import java.io.File;
import java.util.List;


public class SonarTestPyramidSensor implements Sensor {

    public SonarTestPyramidSensor() {
    }

    public void analyse(Project project, SensorContext sensorContext) {
        List<File> testDirs = project.getFileSystem().getTestDirs();

        TestPyramidAnalyzer testPyramidAnalyzer = new TestPyramidAnalyzer(
                new UnitTestsPackage("com.thoughtworks.sonar.testpyramid"),
                new IntegrationTestsPackage("com.thoughtworks.sonar.test.integration"),
                new FunctionalTestsPackage("com.thoughtworks.sonar.test.functional"));

        TestPyramidAnalysis analysis = testPyramidAnalyzer.analyse(testDirs.get(0));

        sensorContext.saveMeasure(analysis.numberOfUnitTests());
        sensorContext.saveMeasure(analysis.numberOfIntegrationTests());
        sensorContext.saveMeasure(analysis.numberOfFunctionalTests());
    }

    public boolean shouldExecuteOnProject(Project project) {
        return true;
    }

}
