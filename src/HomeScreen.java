import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// this class is the object repository of the home screen page


public class HomeScreen {

    public static WebElement element;

    // the amount drop down list
    public  static WebElement AmountField (WebDriver driver){
        element = driver.findElement(By.linkText("סכום"));
        return element;
    }
    // the amount selection from the drop down list
    public  static WebElement Amountselection (WebDriver driver){
        element=driver.findElement(By.cssSelector("li[data-option-array-index=\"1\"]"));
        return element;
    }
    // the area drop down list
    public  static WebElement AreaField (WebDriver driver) {
        element = driver.findElement(By.linkText("אזור"));
        return element;
    }
    // the area selection from the  drop down list
    public  static WebElement AreaSlection (WebDriver driver){
        element=driver.findElement(By.cssSelector("li[data-option-array-index=\"7\"]"));
        return element;
    }

    // the Category drop down list
    public  static WebElement CategoryField (WebDriver driver) {
        element = driver.findElement(By.linkText("קטגוריה"));
        return element;
    }
    // the Category selection from the  drop down list
    public  static WebElement CategorySlection (WebDriver driver){
        element = driver.findElement(By.cssSelector("li[data-option-array-index=\"12\"]"));
        return element;
    }
    // the submit command
    public  static WebElement Submit (WebDriver driver) {
        element = driver.findElement(By.cssSelector("button[class=\"btn btn-primary fluid\"]"));
        return element;
    }
}
