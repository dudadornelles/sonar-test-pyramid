package com.thoughtworks.sonar.testpyramid.analysis;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnalysisUtilsTest {

    @Test
    public void testIsPackageDeclaration() throws Exception {
        assertTrue(AnalysisUtils.isPackageDeclaration("package la.lu.li"));
    }

    @Test
    public void testIsTestAnnotation() throws Exception {
        assertTrue(AnalysisUtils.isTestAnnotation("   @Test"));
    }
}
