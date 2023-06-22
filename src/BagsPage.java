import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this class is the object repository of the home screen page


public class BagsPage {

    public static WebElement element;

    // the amount drop down list
    public  static WebElement pushItMessengerBag (WebDriver driver){
        element = driver.findElement(By.xpath("//span//img[@alt=\"Push It Messenger Bag\"]"));
        return element;
    }

}
