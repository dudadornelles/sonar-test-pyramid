package com.thoughtworks.sonar.testpyramid.analysis;

import java.util.regex.Pattern;

public class AnalysisUtils {

    public static final Pattern PACKAGE_PATTERN = Pattern.compile("^package.*");
    public static final Pattern TESTS_PATTERN = Pattern.compile("\\s*@Test.*");

    static boolean isPackageDeclaration(String line) {
        return PACKAGE_PATTERN.matcher(line).matches();
    }

    static boolean isTestAnnotation(String line) {
        return TESTS_PATTERN.matcher(line).matches();
    }
}