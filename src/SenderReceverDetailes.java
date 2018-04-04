import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this class is the elements repository of the sander and receiver window

public class SenderReceverDetailes {

    public static WebElement element;
// for friend radio button
    public  static WebElement ForFrindRadioButton (WebDriver driver){
        element = driver.findElement(By.className("for-friend-label"));
        return element;
    }

    // ReceverName field
    public  static WebElement ReceverName (WebDriver driver){
        element = driver.findElement(By.cssSelector("input[data-parsley-required-message=\"מי הזוכה המאושר? יש להשלים את שם המקבל/ת\"]"));
        return element;
    }
    //SenderName field
    public  static WebElement SenderName (WebDriver driver){
        element = driver.findElement(By.cssSelector("input[data-parsley-required-message=\"למי יגידו תודה? שכחת למלא את השם שלך\"]"));
        return element;
    }
// the event dropdown list
    public static WebElement EventList (WebDriver driver) {
        element = driver.findElement(By.linkText("לאיזה אירוע?"));
        return element;
    }

    // the event selection from the dropdown list
    public static WebElement EventSelection (WebDriver driver) {
        element = driver.findElement(By.cssSelector("li[data-option-array-index=\"6\"]"));
        return element;
    }
    // the upload file field
    public static WebElement UploadFile (WebDriver driver) {
        element = driver.findElement(By.cssSelector("input[type=\"file\"]"));
        return element;
    }

    // the send right after the payment option
    public static WebElement SendNow (WebDriver driver) {
        element = driver.findElement(By.className("send-now"));
        return element;
    }

    public static WebElement blassing (WebDriver driver){
        element =driver.findElement(By.cssSelector("textarea[id=\"msg\"]"));
        return element;
    }

    // the send by Mail option
    public static WebElement SendByMail (WebDriver driver) {
        element = driver.findElement(By.className("icon-envelope"));
        return element;
    }
    // the receiver Mail address
    public static WebElement receiverMail (WebDriver driver) {
        element = driver.findElement(By.cssSelector("input[placeholder=\"כתובת המייל של מקבל/ת המתנה\"]"));
        return element;
    }

    //submit option
    public static WebElement SubmitAndPay (WebDriver driver){
        element =driver.findElement(By.cssSelector("button[data-target=\"#forgot-password\"]"));
        return element;
    }



}
