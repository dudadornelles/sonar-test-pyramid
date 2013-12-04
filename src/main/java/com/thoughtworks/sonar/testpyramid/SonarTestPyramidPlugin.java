package com.thoughtworks.sonar.testpyramid;

import com.google.common.collect.ImmutableList;
import org.sonar.api.SonarPlugin;

import java.util.List;

public class SonarTestPyramidPlugin extends SonarPlugin {

    public List getExtensions() {
        return ImmutableList.of(
                SonarTestPyramidSensor.class,
                SonarTestPyramidMetrics.class,
                SonarTestPyramidWidget.class
        );
    }
}
