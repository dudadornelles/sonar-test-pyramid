package com.thoughtworks.sonar.testpyramid;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.RubyRailsWidget;

public class SonarTestPyramidWidget extends AbstractRubyTemplate implements RubyRailsWidget {

    public String getId() {
        return "sonar_test_pyramid";
    }

    public String getTitle() {
        return "Test Pyramid";
    }

    @Override
    protected String getTemplatePath() {
        return "/com/thoughtworks/sonar/testpyramid/sonar-test-pyramid-widget.html.erb";
    }
}
