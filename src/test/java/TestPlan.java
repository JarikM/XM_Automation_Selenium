import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Register new account")
    public static void Register(){
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Register register = new Register(driver);
        register.pageUrl("https://www.xm.com/");
        register.pageTitle("Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™");
        register.btnCookiesContinue();
        register.PartnershipsPage();
        register.pageUrl("https://partners.xm.com/");
        register.pageTitle("Forex Affiliate Program | Forex Affiliates | XM Partners");
        register.RegisterPage();
        wait.until(ExpectedConditions.titleIs("XM Partner Account Registration"));
        register.pageUrl("https://partners.xm.com/registration");
        Assert.assertTrue(driver.getPageSource().contains("Partner Account Registration"));
        register.name();
        register.BirthDay();
        register.Address();
        register.Contact();
        register.AccountDetails();
        register.AccountPassword();
        register.Submit();
        Assert.assertTrue(driver.getPageSource().contains("To register a Real Account, you must accept all applicable Terms and Conditions"));
        register.AgreeTerms();
        register.Submit();
        wait.until(ExpectedConditions.urlContains("registration?success"));
        Assert.assertTrue(driver.getPageSource().contains("Congratulations on opening an XM Partner Account"));

    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}