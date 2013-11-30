package com.thoughtworks.sonar.testpyramid;

import java.io.File;
import java.util.List;

public class TestPyramidAnalyzer {
    public TestPyramidAnalysis analyse(List<File> sourceDirs) {
        return new TestPyramidAnalysis();
    }
}
