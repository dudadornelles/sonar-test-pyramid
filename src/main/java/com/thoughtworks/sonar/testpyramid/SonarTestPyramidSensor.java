package com.thoughtworks.sonar.testpyramid;

import com.thoughtworks.sonar.testpyramid.analysis.TestPyramidAnalysis;
import com.thoughtworks.sonar.testpyramid.analysis.TestPyramidAnalyzer;
import com.thoughtworks.sonar.testpyramid.tinytypes.FunctionalTestsPackage;
import com.thoughtworks.sonar.testpyramid.tinytypes.IntegrationTestsPackage;
import com.thoughtworks.sonar.testpyramid.tinytypes.UnitTestsPackage;
import org.sonar.api.Properties;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

import java.io.File;
import java.util.List;


public class SonarTestPyramidSensor implements Sensor {

    private Settings settings;

    public SonarTestPyramidSensor(Settings settings) {
        this.settings = settings;
    }

    public void analyse(Project project, SensorContext sensorContext) {
        List<File> testDirs = project.getFileSystem().getTestDirs();

        TestPyramidAnalysis analysis = createAnalyzer().analyse(testDirs.get(0));

        sensorContext.saveMeasure(analysis.numberOfUnitTests());
        sensorContext.saveMeasure(analysis.numberOfIntegrationTests());
        sensorContext.saveMeasure(analysis.numberOfFunctionalTests());
    }

    private TestPyramidAnalyzer createAnalyzer() {
        return new TestPyramidAnalyzer(
                new UnitTestsPackage(settings.getString("sonar.testpyramid.unittests")),
                new IntegrationTestsPackage(settings.getString("sonar.testpyramid.integrationtests")),
                new FunctionalTestsPackage(settings.getString("sonar.testpyramid.functionaltests")));
    }

    public boolean shouldExecuteOnProject(Project project) {
        return true;
    }

}
