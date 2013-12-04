package com.thoughtworks.sonar.testpyramid.analysis;

import com.thoughtworks.sonar.testpyramid.model.TestCounter;
import com.thoughtworks.sonar.testpyramid.model.TestsCounter;
import com.thoughtworks.sonar.testpyramid.tinytypes.FunctionalTestsPackage;
import com.thoughtworks.sonar.testpyramid.tinytypes.IntegrationTestsPackage;
import com.thoughtworks.sonar.testpyramid.tinytypes.UnitTestsPackage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static com.thoughtworks.sonar.testpyramid.analysis.AnalysisUtils.isPackageDeclaration;
import static com.thoughtworks.sonar.testpyramid.analysis.AnalysisUtils.isTestAnnotation;

public class TestPyramidAnalyzer {

    private final String unitTestsPackageName;
    private final String integrationTestsPackageName;
    private final String functionalTestsPackageName;

    public TestPyramidAnalyzer(UnitTestsPackage unitTestsPackage, IntegrationTestsPackage integrationTestsPackage, FunctionalTestsPackage functionalTestsPackage) {
        unitTestsPackageName = unitTestsPackage.getUnitTestsPackageName();
        integrationTestsPackageName = integrationTestsPackage.getIntegrationTestsPackageName();
        functionalTestsPackageName = functionalTestsPackage.getFunctionalTestsPackageName();
    }

    public TestPyramidAnalysis analyse(File testDirs) {
        TestsCounter testsCounter = createTestsCounter();

        for (File file : getFilesRecursively(testDirs)) {
            try {
                countTests(file, testsCounter);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return new TestPyramidAnalysis(testsCounter, unitTestsPackageName, integrationTestsPackageName, functionalTestsPackageName);
    }

    private TestsCounter createTestsCounter() {
        return new TestsCounter(
                new TestCounter(unitTestsPackageName),
                new TestCounter(integrationTestsPackageName),
                new TestCounter(functionalTestsPackageName));
    }

    private Collection<File> getFilesRecursively(File testDirs) {
        return new ArrayList<File>(FileUtils.listFiles(
                testDirs,
                new RegexFileFilter(".*Test.java"),
                DirectoryFileFilter.DIRECTORY));
    }

    private void countTests(File file, TestsCounter testsCounter) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String packageName = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (isPackageDeclaration(line)) {
                packageName = line;
            }

            if (isTestAnnotation(line)) {
                testsCounter.incrementTestsFor(packageName);
            }

        }
    }

}
