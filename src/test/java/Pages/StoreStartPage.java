package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class StoreStartPage {
    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GAMES']")
    private MobileElement gamesButton;

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "6.0.0");
        capabilities.setCapability("deviceName", "LG K109");
        capabilities.setCapability("udid", "LGK4308HGQFUGU");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", "UiAutomator2");
        return capabilities;
    }

    public StoreStartPage(ITestContext context) {
        this.driver = (AndroidDriver<AndroidElement>)context.getAttribute("driver");
        this.wait = (FluentWait<WebDriver>)context.getAttribute("wait");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public StoreStartPage() throws MalformedURLException {
        this.driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"),getCapabilities());
        this.wait = new WebDriverWait(driver,90)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NullPointerException.class)
            .ignoring(ClassCastException.class)
            .ignoring(NoSuchElementException.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void NavigateToGames()
    {
        WebElement elem = this.driver.findElementByXPath("//android.widget.TextView[@text='GRY']");
        elem.click();
    }


    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(gamesButton));
        return true;
    }

    public void CloseDriver()
    {
        driver.quit();
    }
}
