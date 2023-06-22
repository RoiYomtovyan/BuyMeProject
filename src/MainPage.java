import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this class is the elements repository of the registration web page

public class MainPage {

    public static WebElement element;

    public static WebElement openGearDropdown (WebDriver driver){
        element=driver.findElement(By.cssSelector ("li.level0.nav-4"));
        return element;
    }

    public static WebElement Bags (WebDriver driver){
        element=driver.findElement(By.id ("ui-id-25"));
        return element;
    }

}
