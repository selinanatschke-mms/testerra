package io.testerra.report.test.report_test.methodpages;

import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.report.Status;
import eu.tsystems.mms.tic.testframework.report.model.steps.TestStep;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import io.testerra.report.test.AbstractReportTest;
import io.testerra.report.test.pages.ReportMethodPageType;
import io.testerra.report.test.pages.ReportSidebarPageType;
import io.testerra.report.test.pages.report.methodReport.ReportMethodPage;
import io.testerra.report.test.pages.report.sideBarPages.ReportDashBoardPage;
import io.testerra.report.test.pages.report.sideBarPages.ReportTestsPage;
import io.testerra.report.test.pages.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReportDetailsTabTest extends AbstractReportTest {

    @Test(dataProvider = "dataProviderForPreTestMethodsWithFailureAspect")
    public void testT01_checkFailureAspectContainsCorrectStatus(TestData data) {
        WebDriver driver = WebDriverManager.getWebDriver();
        String method = data.getMethod();
        Status status = data.getStatus1();

        TestStep.begin("Navigate to dashboard page.");
        ReportDashBoardPage reportDashBoardPage = this.visitTestPage(ReportDashBoardPage.class, driver, PropertyManager.getProperty("file.path.content.root"));

        TestStep.begin("Navigate to tests page.");
        ReportTestsPage reportTestsPage = reportDashBoardPage.gotoToReportPage(ReportSidebarPageType.TESTS, ReportTestsPage.class);

        TestStep.begin("Check whether the displayed test state corresponds to each method");
        reportTestsPage = reportTestsPage.selectTestStatus(status);
        ReportMethodPage reportMethodPage = reportTestsPage.navigateToMethodReport(method, status, ReportMethodPageType.DETAILS);
        reportMethodPage.assertPageIsValid(ReportMethodPageType.DETAILS);
        reportMethodPage.detailPageAsserts_FailureAspectsCorrespondsToCorrectStatus(status.title);
    }

    @Test
    public void testT02_passedTestsWithFailureAspectsContainOptionalAssert() {
        WebDriver driver = WebDriverManager.getWebDriver();
        String methodName = "test_Optional_Assert";
        String expectedFailureAspect = "OptionalAssert";

        TestStep.begin("Navigate to dashboard page.");
        ReportDashBoardPage reportDashBoardPage = this.visitTestPage(ReportDashBoardPage.class, driver, PropertyManager.getProperty("file.path.content.root"));

        TestStep.begin("Navigate to tests page.");
        ReportTestsPage reportTestsPage = reportDashBoardPage.gotoToReportPage(ReportSidebarPageType.TESTS, ReportTestsPage.class);

        TestStep.begin("Select passed status and check target tab for non-failure-aspects methods");
        reportTestsPage = reportTestsPage.selectTestStatus(Status.PASSED);

        ReportMethodPage reportMethodPage = reportTestsPage.navigateToMethodReport(methodName, ReportMethodPageType.DETAILS);
        reportMethodPage.assertPageIsValid(ReportMethodPageType.DETAILS);
        reportMethodPage.detailsPageAssertsTestMethodContainsCorrectFailureAspect(expectedFailureAspect);
    }

    @Test(dataProvider = "dataProviderForPreTestMethodsWithStatusFailed")
    public void testT03_failedTestsContainCorrespondingFailureAspect(String method) {
        WebDriver driver = WebDriverManager.getWebDriver();
        // TODO: tie correct failure aspect to provided data, to avoid checking whole array each execution
        String[] expectedFailureAspects = {"AssertCollector.fail", "PageNotFoundException", "Assert.fail"};

        TestStep.begin("Navigate to dashboard page.");
        ReportDashBoardPage reportDashBoardPage = this.visitTestPage(ReportDashBoardPage.class, driver, PropertyManager.getProperty("file.path.content.root"));

        TestStep.begin("Navigate to tests page.");
        ReportTestsPage reportTestsPage = reportDashBoardPage.gotoToReportPage(ReportSidebarPageType.TESTS, ReportTestsPage.class);

        TestStep.begin("Check for each failed test method whether it contains a valid failure aspect");
        reportTestsPage = reportTestsPage.selectTestStatus(Status.FAILED);
        ReportMethodPage reportMethodPage = reportTestsPage.navigateToMethodReport(method, ReportMethodPageType.DETAILS);
        reportMethodPage.assertPageIsValid(ReportMethodPageType.DETAILS);
        reportMethodPage.detailsPageAssertsTestMethodContainsCorrectFailureAspect(expectedFailureAspects);
    }

    @Test(dataProvider = "dataProviderForPreTestMethodsWithStatusExpectedFailed")
    public void testT04_expectedFailedTestsContainCorrespondingFailureAspectAndFailsAnnotation(String method) {
        WebDriver driver = WebDriverManager.getWebDriver();
        // TODO: tie correct failure aspect to provided data, to avoid checking whole array each execution
        String[] expectedFailureAspects = {"AssertCollector.fail", "PageNotFoundException", "Assert.fail"};

        TestStep.begin("Navigate to dashboard page.");
        ReportDashBoardPage reportDashBoardPage = this.visitTestPage(ReportDashBoardPage.class, driver, PropertyManager.getProperty("file.path.content.root"));

        TestStep.begin("Navigate to tests page.");
        ReportTestsPage reportTestsPage = reportDashBoardPage.gotoToReportPage(ReportSidebarPageType.TESTS, ReportTestsPage.class);

        TestStep.begin("Check for each failed test method whether it contains a valid failure aspect");
        reportTestsPage = reportTestsPage.selectTestStatus(Status.FAILED_EXPECTED);

        ReportMethodPage reportMethodPage = reportTestsPage.navigateToMethodReport(method, ReportMethodPageType.DETAILS);
        reportMethodPage.assertPageIsValid(ReportMethodPageType.DETAILS);
        reportMethodPage.detailsPageAssertsTestMethodContainsCorrectFailureAspect(expectedFailureAspects);
        reportMethodPage.assertTestMethodeReportContainsFailsAnnotation();
    }

    @Test
    public void testT05_repairedTestsArePassedButContainFailsAnnotation() {
        WebDriver driver = WebDriverManager.getWebDriver();
        String repairedTest = "test_expectedFailedPassed";

        TestStep.begin("Navigate to dashboard page.");
        ReportDashBoardPage reportDashBoardPage = this.visitTestPage(ReportDashBoardPage.class, driver, PropertyManager.getProperty("file.path.content.root"));

        TestStep.begin("Navigate to tests page.");
        ReportTestsPage reportTestsPage = reportDashBoardPage.gotoToReportPage(ReportSidebarPageType.TESTS, ReportTestsPage.class);

        TestStep.begin("Check for each failed test method whether it contains a valid failure aspect");
        reportTestsPage = reportTestsPage.selectTestStatus(Status.REPAIRED);

        ReportMethodPage reportMethodPage = reportTestsPage.navigateToMethodReport(repairedTest, ReportMethodPageType.STEPS);
        reportMethodPage.assertPageIsValid(ReportMethodPageType.STEPS);
        reportMethodPage.assertTestMethodeReportContainsFailsAnnotation();
    }

    @Test(dataProvider = "dataProviderForPreTestMethodsWithStatusSkipped")
    public void testT06_skippedTestsContainCorrectFailureAspects(String method) {
        WebDriver driver = WebDriverManager.getWebDriver();

        TestStep.begin("Navigate to dashboard page.");
        ReportDashBoardPage reportDashBoardPage = this.visitTestPage(ReportDashBoardPage.class, driver, PropertyManager.getProperty("file.path.content.root"));

        TestStep.begin("Navigate to tests page.");
        ReportTestsPage reportTestsPage = reportDashBoardPage.gotoToReportPage(ReportSidebarPageType.TESTS, ReportTestsPage.class);

        TestStep.begin("Check for each failed test method whether it contains a valid failure aspect");
        reportTestsPage = reportTestsPage.selectTestStatus(Status.SKIPPED);

        ReportMethodPage reportMethodPage = reportTestsPage.navigateToMethodReport(method, ReportMethodPageType.DETAILS);
        reportMethodPage.assertPageIsValid(ReportMethodPageType.DETAILS);
        reportMethodPage.detailsPageAssertSkippedTestContainsCorrespondingFailureAspect();
    }

}