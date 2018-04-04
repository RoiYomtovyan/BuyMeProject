import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this class is the object repository of the Gift selection page

public class GiftSelection {

    public static WebElement element;

    // business selection
    public  static WebElement SelectedGift (WebDriver driver){
        element = driver.findElement(By.cssSelector("a[href=\"https://buyme.co.il/supplier/20620\"]"));
        return element;
    }
// enter the amount of the gift card in the pop up window
    public static WebElement selectPrice (WebDriver driver){
        element= driver.findElement(By.cssSelector("input[placeholder=\"מה הסכום?\"]"));
        return element;
    }
// submit command of the popup window
    public static WebElement buy (WebDriver driver){
        element= driver.findElement(By.cssSelector("div[class=\"btn-wrapper\"]"));
        return element;
    }


}
