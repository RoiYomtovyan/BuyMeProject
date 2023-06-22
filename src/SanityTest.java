import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)

public class SanityTest {
   public static WebDriver driver ;

    Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(10 ,TimeUnit.MILLISECONDS);
    @Rule
   public TestName name = new TestName();
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;
    @BeforeClass
    public static void start () throws Exception {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C://Users//avivit//Desktop//Report.html");

        // choose to append each test
        htmlReporter.setAppendExisting(true);
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name the test and add description
        test = extent.createTest("SanityTest", "sanity tests of BuyMe Site");

        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "RoiY");

        // log results
        test.log(Status.INFO, "@Before class");
        //  the before test is using "ReadBrowserAndURLFromFile" class to read the "browserType" parameter to define which type of browser driver to use
        // the condition is enveloped with "try catch" that write the result in the report

        boolean driverEstablish = false;
        try {
            String browserType = ReadBrowserAndURLFromFile.getData("browserType");
            if (browserType.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\avivit\\Documents\\GitHub\\BuyMeProject\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            } else if (browserType.equals("IE")) {
                driver = new InternetExplorerDriver();
            } else if (driver == null) {
                WebElement e = driver.findElement(By.id("123"));
                test.log(Status.FATAL, e.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect to Driver");
            test.log(Status.FATAL, "Driver Connection Failed! " + e.getMessage());
            driverEstablish = false;
        } finally {
            if (driverEstablish == true) {
                test.log(Status.PASS, "Driver established successfully");

            }
        }
        //  the before test is using "ReadBrowserAndURLFromFile" class to read the "URL" parameter that define the site URL
        // the condition is enveloped with "try catch" that write the result in the report
        boolean pageOpened = false;
        try {
            driver.navigate().to(ReadBrowserAndURLFromFile.getData("url"));
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Buyme webpage was not found " + e.getMessage());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Buyme" + "Webpage opened successfully");

            }

            // this will wait up to 10 sec to verify that the elemand is displayed
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }


@Test
// this test is verifying the registration of new user and report the result in the report
public void SanityTest01_Registration_Page_Verification(){
        RegistrationPage.pressLogin(driver).click();
//    RegistrationPage.notRegisteredYet(driver).click();
//    RegistrationPage.userName(driver).sendKeys("Roi");
//    // this function is calling the "generateString" method from "RandomStringGenerator" to generate unique email address
//    RegistrationPage.mailField(driver).sendKeys(RandomStringGenerator.generateString()+"@Roi.com" );
//    RegistrationPage.passwordField(driver).sendKeys("1234.Com");
//    RegistrationPage.passwordValidation(driver).sendKeys("1234.Com");
//    RegistrationPage.iAgreeRadioButton(driver).click();
//    boolean pressed = false;
//    try {
//    RegistrationPage.Submit(driver).click();
//        pressed = true;
//    } catch (Exception e) {
//        e.printStackTrace();
//        test.log(Status.FAIL, "Submit button of regestration form was not clicked " + e.getMessage());
//        pressed = false;
//    } finally {
//        if (pressed) {
//            test.log(Status.PASS, "the user was registers successfully");
//
//        }
//    }
}

    @Test
    // this test is verifying the search present process and report the result in the report
    public void SanityTest02_Search_Parameters_Window_Verification() throws InterruptedException {
       // WebDriverWait wait =new WebDriverWait (driver,10);
        Thread.sleep(3000);
        HomeScreen.AmountField(driver).click();
        HomeScreen.Amountselection(driver).click();
        HomeScreen.AreaField(driver).click();
        HomeScreen.AreaSlection(driver).click();
        HomeScreen.CategoryField(driver).click();
        HomeScreen.CategorySlection(driver).click();
        boolean pressed = false;
        try {
        HomeScreen.Submit(driver).click();
            pressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Submit button of gift search parameters window form was not clicked " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "the gift search parameters were defined successfully");

            }
        }
}

@Test
// this test is verifying after successful completion of the last 2 tests that  the site is redirects to the right URL and report the result in the report
    public void SanityTest03_Redirect_To_Gift_Amount_page_and_Definition () throws InterruptedException {
    Thread.sleep(3000);
    boolean compertion = false;
    try {
    Assert.assertEquals("https://buyme.co.il/search?budget=1&category=15&region=2835", driver.getCurrentUrl());
        compertion = true;
    } catch (Exception e) {
        e.printStackTrace();
        test.log(Status.FAIL, "the site URL is not as expected! " + e.getMessage());
        compertion = false;
    } finally {
        if (compertion) {
            try {
                test.log(Status.PASS, "the redirect to https://buyme.co.il/search?budget=1&category=15&region=2835 was performed as expected " , MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\1")).build());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
// the test is continued with gift selection and amount definition process and report the result in the report
    GiftSelection.SelectedGift(driver).click();
    GiftSelection.selectPrice(driver).sendKeys("200");
    boolean pressed = false;
    try {
    GiftSelection.buy(driver).click();
        pressed = true;
    } catch (Exception e) {
        e.printStackTrace();
        test.log(Status.FAIL, "Submit button of gift amount definition popup window form was not clicked " + e.getMessage());
        pressed = false;
    } finally {
        if (pressed) {
            try {
                test.log(Status.PASS, "the gift amount definition were defined successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\2")).build());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}
@Test
// this test is verifing the sender and receiver definition process and report the result in the report

    public void SanityTest04_Sender_And_Reciver_Window_Definition () throws InterruptedException {
        SenderReceverDetailes.ForFrindRadioButton(driver).click();
        SenderReceverDetailes.ReceverName(driver).sendKeys("Avivit");
        SenderReceverDetailes.SenderName(driver).sendKeys("Roi");
        SenderReceverDetailes.blassing(driver).sendKeys("מזל טוב!");
        Thread.sleep(3000);
        //this step is verify the upload picture file
        SenderReceverDetailes.UploadFile(driver).sendKeys("C:\\Users\\roi.yomtovyan\\Pictures\\ForAutomationProject.JPG");
        SenderReceverDetailes.EventList(driver).click();
        // wait definition till the events list fully appears in order not to fail with no such element error in the next step
        Thread.sleep(3000);
        SenderReceverDetailes.EventSelection(driver).click();
        SenderReceverDetailes.SendNow(driver).click();
        SenderReceverDetailes.SendByMail(driver).click();
        SenderReceverDetailes.receiverMail(driver).sendKeys("avivit@avivit.com");
    boolean pressed = false;
    try {
        SenderReceverDetailes.SubmitAndPay(driver).click();
    } catch (Exception e) {
        e.printStackTrace();
        test.log(Status.FAIL, "the Submit and pay button was not clicked " + e.getMessage());
        pressed = false;
    } finally {
        if (pressed) {
            try {
                test.log(Status.PASS, "the  Submit and pay button was pressed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\3")).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    @AfterClass
    public static void after (){
        driver.quit();
        // build and flush report
        extent.flush();

    }


    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }

}


