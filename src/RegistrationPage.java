import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this class is the elements repository of the registration web page

public class RegistrationPage {

    public static WebElement element;

    // the register \ login page link
    public  static WebElement pressLogin (WebDriver driver){
        //element=driver.findElement(By.cssSelector ("span[class=\"seperator-link\"]"));
        element = driver.findElement(By.className("seperator-link"));
        return element;
    }


    // the not registered Yet link
    public  static WebElement notRegisteredYet (WebDriver driver){
        element=driver.findElement(By.className("header-link"));
        return element;
    }

    // UserName Field
    public  static WebElement userName (WebDriver driver){
        element=driver.findElement(By.cssSelector("input[placeholder=\"שם פרטי\"]"));
        return element;
    }

    // mail Field
    public  static WebElement mailField (WebDriver driver) {
        element = driver.findElement(By.className("input-mail"));
        return element;
    }

    // Password Field
    public  static WebElement passwordField (WebDriver driver) {
        element = driver.findElement(By.id("valPass"));
        return element;
    }

    // Password validation Field
    public  static WebElement passwordValidation (WebDriver driver) {
        element = driver.findElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"));
        return element;
    }

    // I agree radio button
    public  static WebElement iAgreeRadioButton (WebDriver driver) {
        element = driver.findElement(By.cssSelector("label[for=\"register-consent\"]"));
        return element;
    }

    // Submit button
    public  static WebElement Submit (WebDriver driver) {
        element = driver.findElement(By.cssSelector("button[class=\"db fluid btn btn-theme\"]"));
        return element;
    }



}
