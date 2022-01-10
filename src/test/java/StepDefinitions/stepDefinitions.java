package StepDefinitions;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten;
    public WebDriverWait fifteen;
    public WebDriverWait twenty;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public WebDriverWait threehundred;
    public JavascriptExecutor jse;
    public Actions actions;


    public static sharedatastep sharedata;
    public String ReferenceNumber = "IA000000046";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        five = new WebDriverWait(driver, Duration.ofSeconds(5));
        ten = new WebDriverWait(driver, Duration.ofSeconds(10));
        fifteen = new WebDriverWait(driver, Duration.ofSeconds(15));
        twenty = new WebDriverWait(driver, Duration.ofSeconds(20));
        twentyfive = new WebDriverWait(driver, Duration.ofSeconds(25));
        thirty = new WebDriverWait(driver, Duration.ofSeconds(30));
        thirtyfive = new WebDriverWait(driver, Duration.ofSeconds(35));
        fourty = new WebDriverWait(driver, Duration.ofSeconds(40));
        fourtyfive = new WebDriverWait(driver, Duration.ofSeconds(45));
        fifty = new WebDriverWait(driver, Duration.ofSeconds(50));
        fiftyfive = new WebDriverWait(driver, Duration.ofSeconds(55));
        sixty = new WebDriverWait(driver, Duration.ofSeconds(60));
        sixtyfive = new WebDriverWait(driver, Duration.ofSeconds(65));
        seventy = new WebDriverWait(driver, Duration.ofSeconds(70));
        seventyfive = new WebDriverWait(driver, Duration.ofSeconds(75));
        eighty = new WebDriverWait(driver, Duration.ofSeconds(80));
        eightyfive = new WebDriverWait(driver, Duration.ofSeconds(85));
        ninety = new WebDriverWait(driver, Duration.ofSeconds(90));
        ninetyfive = new WebDriverWait(driver, Duration.ofSeconds(95));
        onehundred = new WebDriverWait(driver, Duration.ofSeconds(100));
        twohundred = new WebDriverWait(driver, Duration.ofSeconds(200));
        threehundred = new WebDriverWait(driver, Duration.ofSeconds(300));

    }

    public void switchToFrameBackoffice() {
        WebElement frame = fourty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(15));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("Verify late lodgement message for {string} with year {string} and period {string}")
    public void verifyLateLodgementMessageForWithYearAndPeriod(String taxtype, String year, String period) {
        if (taxtype.equals("PAYE Returns") & year.equals("2020") & period.equals("1")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(15));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Returns Lodgement is Late')]")));
            if (successMessage.isDisplayed()) {
                System.out.println("Success message ('Returns Lodgement is Late') has been displayed");
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver.get(Pro.getProperty("NRA_BackOffice_URL"));
        driver.manage().window().maximize();
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String username, String password) throws Throwable {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginForm:username"))).sendKeys(username);
        driver.findElement(By.id("loginForm:password")).sendKeys(password);
        driver.findElement(By.xpath("//button[span='Login']")).click();

    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
//        driver = getDriver();
        driver.get("http://" + strArg1 + ":Passw0rd@trips-crm:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        switch_to_frame0();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Active Cases in Progress Overview')]"))).isDisplayed();
        switchToDefault();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
        Thread.sleep(1000);
    }

    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {
        WebElement elementLocator = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @And("^wait for plan to load \"([^\"]*)\"$")
    public void wait_for_duplicate_check(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("contentIFrame1");
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame(frame);
        WebElement DebtCaseSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + strArg1 + "']")));
        Assert.assertTrue(DebtCaseSummary.isDisplayed());
    }

    @And("^clicks Submit button$")
    public void clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(2000);

    }

    @And("^Select Approval outcome value to Approve \"([^\"]*)\"$")
    public void select_approval_outcome_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("^Select Reject outcome dropdown value to Approve \"([^\"]*)\"$")
    public void select_reject_outcome_dropdown_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id("WebResource_DebtManagementRejectionDataReferenceResource")));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("viewoption")).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statuscode_i\"]/option[2]"))).click();

    }


    @Then("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_registrationapplication|NoRelationship|Form|Mscrm.Form.tbg_registrationapplication.Save")).click();
    }

    @Then("^Click on NextStage button$")
    public void click_on_NextStage_button() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath(Pro.getProperty("Individual_NextStage_Button_XPATH"))).click();
        Thread.sleep(1000);
    }


    @Then("^Click reporting > reports$")
    public void goToReportingScreen() throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reports']"))).click();
    }

    @Then("Switch to backoffice frame")
    public void switchToBackofficeFrame() {
        switchToFrameBackoffice();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("NRA_crm_url_Registration"));

        WebElement specificframe = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("InlineDialog_Iframe")));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }


    @Then("^approve transaction$")
    public void approve_transaction() throws Throwable {

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Instalment Agreement Number:']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("reject transaction after text {string} loads")
    public void rejectTransactionAfterTextLoads(String text) throws InterruptedException {
        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + text + "']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("^Enter Outcome Notes (.+)$")
    public void enter_outcome_notes(String Notes) throws Throwable {
        Thread.sleep(3000);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id((Pro.getProperty("Individual_NextStage_RefNum_Reject_OutComeNotes_ID"))));
        action1.sendKeys(element1, Notes).build().perform();
        Thread.sleep(5000);
    }

    @Then("^Click save CRM$")
    public void ClickSaveCRM() throws Throwable {
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_debtmanagementapplication|NoRelationship|Form|Mscrm.Form.tbg_debtmanagementapplication.Save")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Then("^Select report to print \"([^\"]*)\"$")
    public void select_report_to_print(String reportType) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + reportType + "']"))).click();

    }

    @Then("^Select report file type \"([^\"]*)\"$")
    public void select_report_file_type(String reportFormat) throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:ReportFormat\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reportFormat + "')]")).click();
    }

    @Then("^Select tax office \"([^\"]*)\"$")
    public void select_tax_office(String taxOffice) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"frmReportDetails:TAX_OFFICE\"]/div[3]")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Verify file \"([^\"]*)\" has been downloaded in downloads directory \"([^\"]*)\"$")
    public void verify_file_has_been_downloaded_in_downloads_directory(String fileName, String downloadPath) throws Throwable {
        Thread.sleep(5000);
        if (isFileDownloaded(downloadPath, fileName)) {
            System.out.println(fileName + ": has been downloaded");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(fileName + ": has not been downloaded", false);
        }
    }

    @Then("^Click Cancel \"([^\"]*)\"$")
    public void click_cancel(String cancelID) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cancelID))).click();
    }

    @Then("^Verify switch to page with url \"([^\"]*)\"$")
    public void verify_switch_to_page_with_url(String url) throws Throwable {
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, url);
    }

    @Then("^Select return type two$")
    public void select_return_type_two() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:TAX_TYPE\"]/div[3]"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Select return type$")
    public void select_return_type() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:TAX_TYPE\"]/div[3]"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Click run report \"([^\"]*)\"$")
    public void click_run_report(String buttonID) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(buttonID))).click();
    }

    @Then("^Enter start date as \"([^\"]*)\"$")
    public void enter_start_date(String startDate) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:StartDate_input"))).sendKeys(startDate);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
    }

    @Then("^Enter end date as today$")
    public void enter_end_date() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.id("frmReportDetails:EndDate_input")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys(Keys.TAB).perform();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }


    @And("Download the Attachment")
    public void downloadTheAttachment() throws InterruptedException {
        WebElement downloadAttach = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Download']")));
        downloadAttach.click();
        Thread.sleep(5000);
        //change path
//        String downloadPath = "C:\\Users\\maxma\\Downloads";
//        String fileName = strArg1;
//        Thread.sleep(5000);
//        if (isFileDownloaded(downloadPath, fileName)) {
//            System.out.println(fileName + ": has been downloaded");
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertFalse(fileName + ": has not been downloaded", false);
//        }

    }

    @Then("Select Identification Outcome dropdown value for Individual Taxpayer Approval")
    public void selectIdentificationOutcomeDropdownValueForIndividualTaxpayerApproval() {
        driver.findElement(By.xpath("//span[text()='click to enter']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("wait for duplicate check {string}")
    public void waitForDuplicateCheck(String name) {
        WebElement frame = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_RegistrationApplicationAngular")));
        driver.switchTo().frame(frame);
        twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + name + "']")));
    }

    @And("Select Approval outcome dropdown value to Approve {string}")
    public void selectApprovalOutcomeDropdownValueToApprove(String confirmation) throws InterruptedException {
        driver.switchTo().frame("WebResource_RegistrationApplicationAngular");
        WebElement downloadAttach = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + confirmation + "']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement specificframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("Verify approval {string}")
    public void verifyApproval(String Status) throws InterruptedException {
        WebElement statusLabel = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + Status + "')]")));
        if (statusLabel.isDisplayed()) {
            Assert.assertTrue("Approved", true);
        } else {
            Assert.fail("Approval failed");
        }
        Thread.sleep(2000);
    }

    @And("Clicks on Taxpayer name CRM")
    public void clicksOnTaxpayerNameCRM() throws InterruptedException {

        WebElement NameLabel = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_tbg_taxpayer_lookupValue")));
        NameLabel.click();
    }

    @And("^refresh page$")
    public void refresh_page() throws Throwable {
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @Then("^Taxpayer Tin is displayed$")
    public void taxpayer_tin_is_displayed() throws Throwable {


        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement tinLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TIN Number_label\"]")));
        System.out.println("---------------------------------------------------------");
        Thread.sleep(2000);
        sharedatastep.Individual_tin = tinLabel.getText();
        if (sharedatastep.Individual_tin == null || sharedatastep.Individual_tin.equals("--")) {
            refresh_page();
            switchToDefault();
            switch_to_frame0();
            taxpayer_tin_is_displayed();
        } else {
            System.out.println("Taxpayer TIN is " + sharedatastep.Individual_tin);
            System.out.println("---------------------------------------------------------");
        }

    }

    @And("Click on return filing and processing > Lodge return")
    public void clickOnReturnFilingAndProcessingLodgeReturn() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Lodge Return']")).click();
    }

    @Then("Click Return document search button")
    public void clickReturnDocumentSearchButton() {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:searchId"))).click();
    }

    @Then("Search for taxtype with tin {string} and taxtype {string} for period year {string} and number {string}")
    public void searchForTaxtypeWithCategoryAndTaxtype(String tin, String taxtype, String year, String number) throws InterruptedException {
        switchToFrameBackoffice();

        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:TIN"))).sendKeys(tin);
        driver.findElement(By.xpath("//*[@id=\"SearchForm:ReturnType_label\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        driver.findElement(By.id("SearchForm:PeriodNumber")).sendKeys(number);
        driver.findElement(By.id("SearchForm:PeriodYear")).sendKeys(year);

        driver.findElement(By.id("SearchForm:j_idt21")).click();
        switchToDefault();
    }

    @Then("Enter liability {string}")
    public void enterLiability(String amount) throws InterruptedException {

        WebElement liability = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_Liability_input")));
        Thread.sleep(5000);
        liability.clear();
        liability.sendKeys(amount);
    }
    @Then("Enter date of lodgement as {string}")
    public void enterDateOfLodgementAs(String date) throws InterruptedException {
        WebElement datefield = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_LodgementDate_input")));
        Thread.sleep(5000);
        datefield.clear();
        datefield.sendKeys(date);
    }

    @Then("Submit lodge return application")
    public void submitLodgeReturnApplication() throws InterruptedException {

        WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:SaveLodgement")));
        Thread.sleep(4000);
        jse.executeScript("arguments[0].click()", field);
    }

    @And("Click on return filing and processing > File return")
    public void clickOnReturnFilingAndProcessingFileReturn() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[span='File Return']")).click();
    }

    @Then("Select return document as {string}")
    public void selectReturnDocumentAs(String taxtype) throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FormSelection:returnType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        driver.findElement(By.id("FormSelection:nextReturnButton")).click();
    }

    @Then("Find tax return for tin {string} with year {string} and number {string}")
    public void findTaxReturnForCategoryWithYearAndNumber(String tin, String year, String number) {

        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:periodyear")).sendKeys(year);
        driver.findElement(By.id("SearchForm:periodnumber")).sendKeys(number);
        driver.findElement(By.id("SearchForm:j_idt40")).click();

    }

    @Then("Fill in file return details for taxtype {string}")
    public void fillInFileReturnDetailsForTaxtype(String taxtype) throws InterruptedException, AWTException {

        if (taxtype.equals("PAYE Returns")) {
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id5"))).click();
            switchToFrameBackoffice();
            Thread.sleep(1000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleCSVFileUpload:fileCSVFiletoUpload\"]/div[1]/span"))).click();
            Thread.sleep(2000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleCSVFileUpload:fileCSVFiletoUpload_input"))).sendKeys("C:\\template.csv");
            Robot rb = new Robot();

            // copying File path to Clipboard
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\paye.csv";
            StringSelection str = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

            // press Contol+V for pasting
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            Thread.sleep(3000);
            // for pressing and releasing Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"FlexbleCSVFileUpload:fileCSVFiletoUpload\"]/div[1]/button[1]")).click();
            fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleCSVFileUpload:id_filename"))).isDisplayed();
            Thread.sleep(4000);
            driver.findElement(By.id("FlexbleCSVFileUpload:btnNext")).click();
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("document.getElementById('FlexibleFormEntity:declarationDate_input').setAttribute('value', '01/01/2018')");
        }

        if (taxtype.equals("PIT Return (Final)")) {
            WebDriverWait wait = new WebDriverWait(driver, 70);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'BALANCE SHEET')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:balanceSheetDate_input"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:balanceSheetDate_input"))).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:stocksInventories_input")).sendKeys("8000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:receivables_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:bankBalances_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherCurrentAssets_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:prePayment_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:building_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:furnitureAndEquipments_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:motorVehicles_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherAssets_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:billsPayable_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:loans_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:accruals_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherPayables_input")).sendKeys("7000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:capital_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:netProfitBalanceSheet_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:drawings_input")).sendKeys("0");
            Thread.sleep(700);

            driver.findElement(By.xpath("//a[contains(text(),'INCOME STATEMENT')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:basicSalary_input")).sendKeys("65000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:cashAllowance_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherCashBenefit_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:bonus_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:accomodation_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:vehicle_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:bkOthers_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherEmploymentIncome_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:rentIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:dividends_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:interest_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:naturalResourcePayment_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:royalty_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:directorsFees_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:commission_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:charges_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:discounts_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:premium_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:annuity_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherInvestmentIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:costOfSales_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:operatingExpenses_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:generalExpenses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:depreciation_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:foreignExchangeLoss_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherCostsExpenses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:unrealisedExchangeLoss_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackDepreciation_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackBadDebt_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackServiceBenifit_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackDisallowedInterest_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackCapitalisedRepairs_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackEntertainmentExpenses_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackSaleBusinessAsset_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackOther_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxInterestIncome_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxSaleBusinessAsset_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxRentalIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxOthers_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adExchangeGain_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adCapitalAllowance_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adEndOfServicePaid_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adSaleOfBusinessAsset_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adInvestmentAllowance_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adOthers_input")).sendKeys("0");
            Thread.sleep(700);

            driver.findElement(By.xpath("//a[contains(text(),'TAX COMPUTATION')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:finalTotalEmploymentIncome_input")).sendKeys("90000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:lossBroughtFromPreviousYear_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:lossReliefForTheYear_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpWHT_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpTaxesPaidDirectly_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpPAYETaxPaid_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpPriorPeriodCredit_input")).sendKeys("0");
            Thread.sleep(700);

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'ATTACHMENTS')]")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:attachmentTable:j_id1"))).click();
            WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(frame);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Annual Financial Statements')]"))).click();
            Thread.sleep(2000);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys(String.valueOf(timestamp.getTime()));
            Thread.sleep(1000);
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            Thread.sleep(3000);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            driver.switchTo().defaultContent();

            Thread.sleep(6000);
            driver.findElement(By.xpath("//a[contains(text(),'PERSONAL DETAILS')]")).click();
            Thread.sleep(1000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:declarantPosition")).sendKeys("Doctor");
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //jse.executeScript("FlexibleFormEntity:pitShowTab:declarationDate_input').setAttribute('value', '01/01/2018')");
            //driver.findElement(By.id("FlexibleFormEntity:pitShowTab:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("PIT Return (Provisional)")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:businessIncome_input"))).sendKeys("90000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:employmentIncome_input")).sendKeys("50000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:otherIncome_input")).sendKeys("50000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:totalChargableIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:quarterlyTaxPayable_input")).sendKeys("0");

            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("GST Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:standardSalesExclusive_input"))).sendKeys("20000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:zeroRatedSupplies_input")).sendKeys("20000000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:exemptSupplies_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:relievedSuppliesExclusive_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:InputTaxDeductible_input")).sendKeys("0");
            Thread.sleep(2000);

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:attachmentTable:j_id1"))).click();

            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();

            fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleFormAttachment:DocType_1"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys("Attachment");
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            switchToDefault();
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("CIT Return (Final)")) {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab:BusinessLocation\"]/div[3]"))).click();
            Thread.sleep(1000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Balance Sheet')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:balanceSheetDate_input"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:balanceSheetDate_input"))).sendKeys(Keys.ENTER);


            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:currentAssetsLocalCurrencies_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:currentAssetsCedis_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:stocksInventories_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:accountReceivables_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:fixedAssets_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherAssets_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:tradePayablesLocalCurrencies_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:tradePayablesLeones_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherPayablesLocalCurrencies_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherPayablesLeones_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:shareholdersFund_input")).sendKeys("0");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Income Statement')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:localSales_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:exportSales_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:rentIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:dividends_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:interest_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:naturalResourcePayment_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:royalty_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:annuity_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherSpecify_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:lessCostOfSalesAndExpenses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:generalExpenses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:depreciation_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:foreignExchangeLosses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherCostsExpenses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:unrealisedExchangeLoss_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:depreciation_ab_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:gpForBadDebt_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:serviceBenefit_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:disallowedInterest_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:capitalisedRepairs_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:entertainmentExpenses_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:businessAsset_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:othersSpecify_ab_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:interestIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:saleBusinessAsset_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:nt_rentalIncome_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:nt_othersSpecify_input")).sendKeys("2000");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_exchangeGain_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_capitalAllowance_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_endOfServicePaid_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_saleOfBusinessAsset_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_investmentAllowance_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_othersSpecify_input")).sendKeys("2000");
            Thread.sleep(700);

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Computation Of Taxes')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:lossBroughtFromPrevYear_input")).sendKeys("2000");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:lossRelief_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:wht_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:taxesPaidDirectly_input")).sendKeys("2000");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:priorPeriodCredit_input")).sendKeys("0");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Attachments')]")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:attachmentTable:j_id1"))).click();
            WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(frame);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Annual Financial Statements')]"))).click();
            Thread.sleep(2000);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys(String.valueOf(timestamp.getTime()));
            Thread.sleep(1000);
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            Thread.sleep(3000);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            driver.switchTo().defaultContent();

            Thread.sleep(4000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:declarantPosition")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("CIT Return (Provisional)")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:chargeableIncome_input"))).sendKeys("80000");
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:quarterlyPayment_input")).sendKeys("10000");
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("Excise Tax Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items_Goods:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:natureOfActivity\"]/div[3]"))).click();
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:productType\"]/div[3]"))).click();
            Thread.sleep(2000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            driver.findElement(By.id("TestFlexibleForm:openingUnits_input")).sendKeys("25");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:unitsProduced_input")).sendKeys("7");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:unitsProduced_input")).sendKeys("7");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:closingUnits_input")).sendKeys("3");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:valueOfDisposedUnits_input")).sendKeys("3000");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:returnInwards_input")).sendKeys("300");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:destructions_input")).sendKeys("300");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:destructions_input")).sendKeys("300");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:exports_input")).sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:dutyFreeSupplies_input")).sendKeys("0");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:otherSpecify_input")).sendKeys("1200");
            Thread.sleep(3000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Manufacturing')]"))).isDisplayed();
            Thread.sleep(2000);

            //raw materials
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items_Raw_Materials:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:typeOfRawMaterials"))).sendKeys("Metal");
            Thread.sleep(700);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:unitOfMeasure\"]/div[3]")).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:openingRawMaterials_input")).sendKeys("50");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:rawMaterialsPurchased_input")).sendKeys("50");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:closingRawMaterials_input")).sendKeys("10");
            Thread.sleep(2000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Metal')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");

        }

        if (taxtype.equals("FTT Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:ecoNoPass1CIn_input"))).sendKeys("40");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:ecoNoPassBusCIn_input")).sendKeys("10");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:ecoNoPassEcoIn_input")).sendKeys("10");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:nonEcoNoPass1CIn_input")).sendKeys("40");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:nonEcoNoPassBusCIn_input")).sendKeys("10");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:nonEcoNoPassEcoCIn_input")).sendKeys("10");
            Thread.sleep(1000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:DeclarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:DeclarantPosition")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:DeclarationDate_input")).sendKeys("01/01/2018");

        }

        if (taxtype.equals("Payroll Tax Return")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:employeeName"))).sendKeys("Maxipain " + getRandom(5));
            Thread.sleep(700);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:nationality\"]/div[3]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'Kenya')]")).click();
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:passportNumber")).sendKeys(getRandom(7));
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:designation")).sendKeys("Software Engineer");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:dateOfEmployment_input")).sendKeys("05/01/2019");
            Thread.sleep(2000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Software Engineer')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");

        }

        if (taxtype.equals("Rental income Return")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:entityName"))).sendKeys("Maxipain " + getRandom(5));
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:phoneNumber")).sendKeys("254707338839");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:Address")).sendKeys("Utawala");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:annualAmount_input")).sendKeys("40000");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'254707338839')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");

        }

        if (taxtype.equals("Withholding Tax")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:j_id4"))).click();
            switchToDefault();
            Thread.sleep(5000);
            driver.switchTo().frame(1);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys("1000065405");
            Thread.sleep(800);
            driver.findElement(By.id("SearchForm:j_idt40")).click();
            Thread.sleep(1000);
            switchToDefault();
            Thread.sleep(3000);
            switchToBackofficeFrame();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:natureOfPayment\"]/div[3]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'Dividends')]")).click();
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:grossAmountDue_input")).sendKeys("650000");
            Thread.sleep(2000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'1000065405')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");

        }

        if (taxtype.equals("Capital Gains Tax Return")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:assetBuyerName"))).sendKeys("Maxipain " + getRandom(5));
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:assetBuyerEmail")).sendKeys(getRandom(5) + "@gmail.com");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:assetBuyerContact")).sendKeys("0707445567");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:assetBuyerPostalAddress")).sendKeys("Utawala");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id1")).click();

            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:typeOfAsset\"]/div[3]"))).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//li[text()='Real estate (Land and Buildings)']")).click();

            Thread.sleep(3000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:assetNumber\"]/div[3]"))).click();
            Thread.sleep(700);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:disposalDate_input")).sendKeys("30/09/2020");
            Thread.sleep(300);
            actions.sendKeys(Keys.TAB).perform();
            driver.findElement(By.id("TestFlexibleForm:disposalValue_input")).sendKeys("9000");
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:valuationAtDisposal_input")).sendKeys("9000");
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:dateOfAcquisition_input")).sendKeys("02/09/2020");
            Thread.sleep(300);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:costOfAcquisition_input")).sendKeys("9000");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();

            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'9,000.00')]"))).isDisplayed();
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
        }
    }

    @Then("Submit file return application")
    public void submitFileReturnApplication() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.id("FlexibleFormEntity:save")).click();
    }

    @And("Click on return filing and processing > Adjust return")
    public void clickOnReturnFilingAndProcessingAdjustReturn() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Adjust Return']")).click();
    }

    @Then("Perform amendment for taxtype {string}")
    public void performAmendmentForTaxtype(String taxtype) throws InterruptedException {
        if (taxtype.equals("PAYE Returns")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).sendKeys("DR Muthoni");

        }

        if (taxtype.equals("PIT Return (Final)")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:pitShowTab:reasonForAdjustment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'BALANCE SHEET')]"))).click();
            Thread.sleep(2000);
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:otherAssets_input")));
            field.clear();
            field.sendKeys("45000");
        }

        if (taxtype.equals("GST Return")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).sendKeys("DR Muthoni");
            Thread.sleep(1000);
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:standardSalesExclusive_input")));
            field.clear();
            field.sendKeys("45000");

        }

        if (taxtype.equals("CIT Return (Final)")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Balance Sheet')]"))).click();
            Thread.sleep(2000);
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:otherAssets_input")));
            field.clear();
            field.sendKeys("45000");
            driver.findElement(By.xpath("//a[contains(text(),'Attachments')]")).click();
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab:reasonForAdjustment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if (taxtype.equals("Excise Tax Return")) {
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_Goods_data\"]/tr/td[6]")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items_Goods:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:valueOfDisposedUnits_input")));
            field.clear();
            field.sendKeys("7000");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Manufacturing')]"))).isDisplayed();
        }

        if (taxtype.equals("FTT Return")) {

            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:ecoNoPass1CIn_input")));
            field.clear();
            field.sendKeys("35");
            Thread.sleep(1000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:ReasonForAdjustment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        }

        if (taxtype.equals("Payroll Tax Return")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if (taxtype.equals("Rental income Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_data\"]/tr/td[1]"))).click();
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:annualAmount_input")));
            field.clear();
            field.sendKeys("40000");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'254707338839')]"))).isDisplayed();
            Thread.sleep(3000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if (taxtype.equals("Withholding Tax")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_data\"]/tr/td[2]"))).click();
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:grossAmountDue_input")));
            field.clear();
            field.sendKeys("660000");
            Thread.sleep(2000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'1000065405')]"))).isDisplayed();
            Thread.sleep(3000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }
    }

    @Then("Submit adjust return application")
    public void submitAdjustReturnApplication() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("FlexibleFormEntity:save")).click();
    }

    @Then("Obtain reference number for adjust {string}")
    public void obtainReferenceNumberForAdjust(String refno) {
        String text = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + refno + "')]"))).getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(75));
        sharedatastep.Reference_number = text.substring(75);
        //Tax return has been successfully saved.The status is now pending approval. PAYER/000001429/2020

        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.Reference_number);
    }

    @And("click on Returns Tax return application")
    public void clickOnReturnsTaxReturnApplication() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbg_taxreturnapplication"))).click();
    }

    @When("enters adjust reference number in search results")
    public void entersAdjustReferenceNumberInSearchResults() {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));
        search.sendKeys(sharedatastep.Reference_number);
        //search.sendKeys("PAYER/000003143/2021");
        search.sendKeys(Keys.ENTER);
    }

    @When("enters cancel reference number in search results")
    public void entersCancelReferenceNumberInSearchResults() {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));
        search.sendKeys(sharedatastep.Reference_number);
        //search.sendKeys("PAYER/000003143/2021");
        search.sendKeys(Keys.ENTER);
    }

    @And("Approve adjust returns application")
    public void approveAdjustReturnsApplication() throws Throwable {

        WebElement detailsframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_TaxReturnApplicationAngular")));
        driver.switchTo().frame(detailsframe);
        WebElement downloadAttach = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Taxpayer Name']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement specificframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click on Returns Save button")
    public void clickOnReturnsSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_taxreturnapplication|NoRelationship|Form|Mscrm.Form.tbg_taxreturnapplication.Save")).click();
    }


    @And("Click on return filing and processing > Cancel return")
    public void clickOnReturnFilingAndProcessingCancelReturn() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Cancel Return demo']")).click();
    }

    @Then("^Select reason for cancellation as \"([^\"]*)\" \"([^\"]*)\"$")
    public void select_reason_for_cancellation(String cancellationReason, String returnType) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        String dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";

        if (returnType.equals("CIT Return (Final)")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab\"]/ul/li[6]/a"))).click();
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:CITDetailsTab:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();

        }
        if (returnType.equals("Capital Gains Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();

        }
        if (returnType.equals("PAYE Returns")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Excise Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("FTT Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("GST Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("PIT Return (Final)")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:pitShowTab:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("PIT Return (Provisional)")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Payroll Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Rental income Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Withholding Tax ")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }
    }

    @Then("^Click cancel return$")
    public void click_cancel_return() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:cancel"))).click();
    }

    @Then("^Click yes$")
    public void click_yes() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:j_idt31"))).click();
    }

    @Then("Obtain reference number for cancellation {string}")
    public void obtainReferenceNumberForCancellation(String refno) throws Throwable {
        String text = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + refno + "')]"))).getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(74));
        sharedatastep.Reference_number = text.substring(74);
        //Tax return has successfully saved.The status is now pending cancellation. CGTR/000002235/2021

        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.Reference_number);
    }

    @Then("Fill in sole proprietor additional details")
    public void fillInSoleProprietorAdditionalDetails() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Sole Proprietor Additional Details')]"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:tradingNameTableHandler:AddTradingNameDetails"))).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TradingNameDetails:TradingName"))).sendKeys("Codei " + getRandom(5));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"TradingNameDetails:PrimaryTradingName\"]/div[2]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("TradingNameDetails:EffectiveDate_input")).sendKeys(daysFromToday(2));
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        driver.findElement(By.id("TradingNameDetails:AddTradingAddress")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(4500);
        driver.switchTo().frame(1);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:AddressType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Local Postal Address')]")).click();

        //wait for postal address details to load
        WebElement region = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:PostalRegion\"]/div[3]")));
        region.isDisplayed();
        //end wait

        driver.findElement(By.id("AddressDetails:City")).sendKeys("Kenema");
        region.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'East')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"AddressDetails:District1\"]/div[3]")).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Kenema')]"))).click();

        driver.findElement(By.id("AddressDetails:addOk")).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        switchToFrameBackoffice();
        Thread.sleep(3000);
        driver.findElement(By.id("TradingNameDetails:SourceOfCapitalInv")).sendKeys("Loan");
        Thread.sleep(1000);
        driver.findElement(By.id("TradingNameDetails:ExistBusinessCapital_input")).sendKeys("100000");
        Thread.sleep(1000);
        driver.findElement(By.id("TradingNameDetails:TotCapitalInvst_input")).sendKeys("5000");
        Thread.sleep(1000);
        driver.findElement(By.id("TradingNameDetails:NatureOfBusiness")).sendKeys("Software development");
        Thread.sleep(500);
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TradingNameDetails:AccountYearEndDateDD\"]/div[3]"))).click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        // driver.findElement(By.xpath("//li[contains(text(),'February')]")).click();
        Thread.sleep(2000);
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TradingNameDetails:AccountYearEndDateMM\"]/div[3]"))).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//        driver.findElement(By.xpath("//li[contains(text(),'02')]")).click();
        Thread.sleep(1000);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        driver.findElement(By.id("TradingNameDetails:OK")).click();
        switchToDefault();
        Thread.sleep(4000);

    }

    @Then("Enter property details")
    public void enterPropertyDetails() throws InterruptedException {
        Thread.sleep(3000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Property Details')]"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:propertyTableHandler:AddProperty"))).click();
        switchToFrameBackoffice();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PropertyDetails:PropertyType\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'Cafeteria')]")).click();
        Thread.sleep(1000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PropertyDetails:Ownership\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'Owned')]")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("PropertyDetails:TradersPremises")).sendKeys(getRandom(5) + ", " + getRandom(5));
        Thread.sleep(1500);
        driver.findElement(By.id("PropertyDetails:AddPropertyAddress")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(4500);
        driver.switchTo().frame(1);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:AddressType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Local Postal Address')]")).click();

        //wait for postal address details to load
        WebElement region = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:PostalRegion\"]/div[3]")));
        region.isDisplayed();
        //end wait

        driver.findElement(By.id("AddressDetails:City")).sendKeys("Kenema");
        region.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'East')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"AddressDetails:District1\"]/div[3]")).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Kenema')]"))).click();

        driver.findElement(By.id("AddressDetails:addOk")).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        switchToFrameBackoffice();
        Thread.sleep(2000);
        WebElement ok = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("PropertyDetails:Ok")));
        jse.executeScript("arguments[0].click()", ok);
        switchToDefault();
    }

    @Then("Verify and obtain ARN {string}")
    public void verifyARN(String arn) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + arn + "')]")));
        String text = successMessage.getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(54));
        ReferenceNumber = text.substring(54);
        //Returns Lodgement is Successful with Reference Number FTTR/000002727/2021
        System.out.println(ReferenceNumber);
        if (successMessage.isDisplayed()) {
            System.out.println("ARN ('" + arn + "') is valid");
            Assert.assertTrue(true);
        } else {
            Assert.fail("ARN invalid");
        }
    }

    @Then("Verify and obtain ARN for file {string}")
    public void verifyAndObtainARNForFile(String arn) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + arn + "')]")));
        String text = successMessage.getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(48));
        ReferenceNumber = text.substring(48);
        //Record successfully saved with reference number PAYER/000001507/2020
        System.out.println(ReferenceNumber);
        if (successMessage.isDisplayed()) {
            System.out.println("ARN ('" + arn + "') is valid");
            Assert.assertTrue(true);
        } else {
            Assert.fail("ARN invalid");
        }
    }

    @Then("Verify ARN {string}")
    public void verifyARNForAdjust(String arn) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + arn + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("ARN ('" + arn + "') is valid");
            Assert.assertTrue(true);
        } else {
            Assert.fail("ARN invalid");
        }
    }

    @Then("Verify ARN for cancel {string}")
    public void verifyARNForCancel(String arn) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + arn + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("ARN ('" + arn + "') is valid");
            Assert.assertTrue(true);
        } else {
            Assert.fail("ARN invalid");
        }
    }

    @Then("go to taxpayer accounting > taxpayer account inquiry")
    public void goToTaxpayerAccountingTaxpayerAccountInquiry() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Accounting']"))).click();
        driver.findElement(By.xpath("//a[span='Taxpayer Account Enquiry']")).click();
    }

    @Then("Search for tin {string}")
    public void searchForTin(String tin) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt40")).click();
    }

    @Then("Search for taxtype {string}")
    public void searchForTaxtype(String taxtype) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:TaxTypeAccount\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("AccountEnquiry:j_idt64")).click();

    }


    @Then("Verify taxtype {string} and status {string} is shown in table for {string}")
    public void verifyTaxtypeAndStatusIsShownInTableFor(String taxtype, String status, String returnType) {
        WebDriverWait wait = new WebDriverWait(driver, 30);


        if (returnType.equals("CIT Return (Final)")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'CIT Return (Final)')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnType.equals("CIT Return (Provisional)")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'CIT Return (Provisional)')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnType.equals("Capital Gains Tax Return")) {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Capital Gains Tax Return')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnType.equals("PAYE Returns")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'PAYE Returns')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("Excise Tax Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Excise Tax Return')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("FTT Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'FTT Return')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("GST Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'GST Return')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("PIT Return (Final)")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'PIT Return (Final)')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("PIT Return (Provisional)")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'PIT Return (Provisional)')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("Payroll Tax Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Payroll Tax Return')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("Rental income Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Rental income Return')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }

        if (returnType.equals("Withholding Tax")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr/td[1]/div"))).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Withholding Tax')]"))).isDisplayed()) {
                System.out.println(returnType + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
    }

    @Then("Verify status is {string}")
    public void verifyStatusIs(String status) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]")));

        if (successMessage.isDisplayed()) {
            System.out.println("Status ('" + status + "') is shown");
            Assert.assertTrue(true);
        } else {
            Assert.fail("status not correct");
        }
    }

    @Then("Click on case")
    public void clickOnCase() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).click();
    }

    @Then("Verify lodgement screen has data")
    public void verifyLodgementScreenHasData() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String tin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_Tin"))).getAttribute("value");
        if (tin.isEmpty()) {
            Assert.fail("Field does not contain any data");
        } else {
            Assert.assertTrue("Field contains data", !tin.isEmpty());
        }
    }


    @Then("Verify file returns screen has data for {string}")
    public void verifyFileReturnsScreenHasData(String returnType) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        String declarantNameLocator = "";

        if (returnType.equals("Capital Gains Tax Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnType.equals("CIT Return (Final)")) {
            declarantNameLocator = "FlexibleFormEntity:taxpayerName";
        }
        if (returnType.equals("CIT Return (Provisional)")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnType.equals("PAYE Returns")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }

        if (returnType.equals("Excise Tax Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }

        if (returnType.equals("FTT Return")) {
            declarantNameLocator = "FlexibleFormEntity:DeclarantName";
        }

        if (returnType.equals("GST Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }

        if (returnType.equals("PIT Return (Final)")) {
            declarantNameLocator = "FlexibleFormEntity:pitShowTab:declarantName";
        }

        if (returnType.equals("PIT Return (Provisional)")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }

        if (returnType.equals("Payroll Tax Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }

        if (returnType.equals("Rental income Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnType.equals("WHT (10.5% and 5.5%) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:nilReturn\"]/div[2]/span"))).click();
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnType.equals("CGT Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }

        String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(declarantNameLocator))).getAttribute("value");
        if (name.isEmpty()) {
            Assert.fail("Field does not contain any data");
        } else {
            Assert.assertTrue("Field contains data", !name.isEmpty());
        }
    }



}




