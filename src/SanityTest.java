import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)

public class SanityTest {
   public static WebDriver driver ;
    Actions action = new Actions(driver);


    @BeforeClass
    public static void start () throws Exception {

        String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1";

        // Configure Firefox options
        FirefoxOptions options = new FirefoxOptions();

        // Create a Firefox profile
        FirefoxProfile profile = new FirefoxProfile();

        // Set the user agent in the profile
        profile.setPreference("general.useragent.override", userAgent);

        // Reject third-party cookies
        profile.setPreference("network.cookie.cookieBehavior", 1);

        // Set the profile in Firefox options
        options.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\avivit\\Documents\\GitHub\\Kobi'sExam\\geckodriver.exe");

        // Create a new Firefox WebDriver instance
        driver = new FirefoxDriver(options);

        // Example usage: Open a webpage
        driver.get("https://magento.softwaretestingboard.com/");

    }

       //  the before test is using "ReadBrowserAndURLFromFile" class to read the "browserType" parameter to define which type of browser driver to use
        // the condition is enveloped with "try catch" that write the result in the report

//        boolean driverEstablish = false;
//        try {
//            String browserType = ReadBrowserAndURLFromFile.getData("browserType");
//            if (browserType.equals("Chrome")) {
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\avivit\\Documents\\GitHub\\BuyMeProject\\chromedriver.exe");
//                ChromeOptions options = new ChromeOptions();
//                driver = new ChromeDriver(options);
//            } else if (browserType.equals("IE")) {
//                driver = new InternetExplorerDriver();
//            } else if (driver == null) {
//                WebElement e = driver.findElement(By.id("123"));
//                test.log(Status.FATAL, e.getText());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            fail("Cant connect to Driver");
//            test.log(Status.FATAL, "Driver Connection Failed! " + e.getMessage());
//            driverEstablish = false;
//        } finally {
//            if (driverEstablish == true) {
//                test.log(Status.PASS, "Driver established successfully");
//
//            }
//        }
//        //  the before test is using "ReadBrowserAndURLFromFile" class to read the "URL" parameter that define the site URL
//        // the condition is enveloped with "try catch" that write the result in the report
//        boolean pageOpened = false;
//        try {
//            driver.navigate().to(ReadBrowserAndURLFromFile.getData("url"));
//            pageOpened = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            test.log(Status.FAIL, "Buyme webpage was not found " + e.getMessage());
//            pageOpened = false;
//        } finally {
//            if (pageOpened) {
//                test.log(Status.PASS, "Buyme" + "Webpage opened successfully");
//
//            }
//
//            // this will wait up to 10 sec to verify that the elemand is displayed
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        }



@Test
// this test is verifying the registration of new user and report the result in the report
public void SanityTest01_Registration_Page_Verification(){
       action.moveToElement(MainPage.openGearDropdown(driver)).build().perform();
       MainPage.Bags(driver).click();
       BagsPage.pushItMessengerBag(driver).click();
       // MainPage.openGearDropdown(driver).click();
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





    @AfterClass
    public static void after (){
//        driver.quit();

    }



}


