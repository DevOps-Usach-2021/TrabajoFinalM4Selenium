package selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class RegistrousuarioTest {
  private WebDriver driver;
  private Map<String, String> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, String>();
    vars.put("email", "grupo1.usach@usach5.cl");
    vars.put("password","12345678");
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void registrousuario() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).sendKeys(vars.get("email"));
    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
    }
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).click();
    driver.findElement(By.id("customer_firstname")).sendKeys("Fernando");
    driver.findElement(By.id("customer_lastname")).sendKeys("Gutierrez");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys(vars.get("password"));
    driver.findElement(By.id("address1")).click();
    driver.findElement(By.id("address1")).sendKeys("Av. Arturo Pérez Canto 660");
    driver.findElement(By.cssSelector(".account_creation:nth-child(2) > .required:nth-child(5)")).click();
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Antofagasta");
    driver.findElement(By.cssSelector(".required:nth-child(7)")).click();
    driver.findElement(By.id("id_country")).click();
    driver.findElement(By.id("id_state")).click();
    {
      WebElement dropdown = driver.findElement(By.id("id_state"));
      dropdown.findElement(By.xpath("//option[. = 'Alabama']")).click();
    }
    driver.findElement(By.id("postcode")).click();
    driver.findElement(By.id("postcode")).sendKeys("12345");
    driver.findElement(By.cssSelector(".postcode")).click();
    driver.findElement(By.id("phone_mobile")).click();
    driver.findElement(By.id("phone_mobile")).sendKeys("987654321");
    driver.findElement(By.id("alias")).click();
    driver.findElement(By.id("account-creation_form")).click();
    {
      WebElement element = driver.findElement(By.id("account-creation_form"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("alias")).sendKeys("Casa");
    driver.findElement(By.cssSelector("#submitAccount > span")).click();
  }

  @Test
  public void login() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(vars.get("email"));
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys(vars.get("password"));
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo.img-responsive")));
    }
  }
}
