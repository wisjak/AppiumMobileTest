import Pages.StoreStartPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MyTest {

//    Pages.StoreStartPage storePage = new StoreStartPage();

//    private AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"),getCapabilities());
//    private FluentWait<WebDriver> wait =  new WebDriverWait(this.driver,90)
//            .ignoring(StaleElementReferenceException.class)
//            .ignoring(NullPointerException.class)
//            .ignoring(ClassCastException.class)
//            .ignoring(NoSuchElementException.class);

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

    public MyTest() throws MalformedURLException {
    }

    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException {
//        context.setAttribute("driver",this.driver); // comment -- ctrl + /
//        context.setAttribute("wait",this.wait);
    }

//    @AfterMethod
//    public void tearDown() {
//        storePage.CloseDriver();
//    }

//    @Test
//    public void MyNewTest() throws MalformedURLException {
//        storePage.NavigateToGames();
//    }

    @Test(dataProvider = "create")
    public void ManyTests(String n1, Integer n2)
    {

    }

    @Test(groups = {"groups", "regression"})
    public void SecondTest()
    {

    }

    @Test(groups = {"groups"})
    public void FristTest()
    {

    }

    @DataProvider(name = "create")
    public static Object[][] createData() {
        return new Object[][] {
                { "Cedric", 36 },
                { "Anne", 37},
                { "Magda", 38}
        };
    }
}
