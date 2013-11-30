package com.thoughtworks.sonar.testpyramid;

import com.google.common.collect.ImmutableList;
import org.sonar.api.SonarPlugin;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

import java.util.List;


public class SonarTestPyramidSensor extends SonarPlugin implements Sensor {

    public SonarTestPyramidSensor() {
    }

    public void analyse(Project project, SensorContext sensorContext) {
        TestPyramidAnalysis analysis = new TestPyramidAnalyzer().analyse(project.getFileSystem().getSourceDirs());


        sensorContext.saveMeasure(analysis.numberOfUnitTests());
        sensorContext.saveMeasure(analysis.numberOfIntegrationTests());
        sensorContext.saveMeasure(analysis.numberOfFunctionalTests());
    }

    public boolean shouldExecuteOnProject(Project project) {
        return true;
    }

    public List getExtensions() {
        return ImmutableList.of(
                SonarTestPyramidSensor.class, SonarTestPyramidMetrics.class, SonarTestPyramidWidget.class
        );
    }
}
