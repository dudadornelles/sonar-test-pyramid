package com.thoughtworks.sonar.testpyramid;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.RubyRailsWidget;

public class SonarTestPyramidWidget extends AbstractRubyTemplate implements RubyRailsWidget {

    public String getId() {
        return "artifact_size";
    }

    public String getTitle() {
        return "Artifact Size";
    }

    @Override
    protected String getTemplatePath() {
        return "/com/thoughtworks/sonar/artifactsize/widget.html.erb";
    }
}
