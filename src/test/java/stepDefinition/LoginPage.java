package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class LoginPage {
    public static WebDriver driver;
    public static String txtUsername = "//input[@name='username']";
    public static String txtPassword = "//*[@name='password']";
    public static String btnLogin = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']";
    public static String dropdownUsername = "//p[@class='oxd-userdropdown-name']";

    @Before
    public static void beforeTest() {
        // Menggunakan WebDriverManager untuk mengatur ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Konfigurasi ChromeOptions seperti capabilities di WebDriverIO
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Buka browser dalam mode full screen
        options.addArguments("--disable-infobars"); // Disable info bars
        options.addArguments("--disable-extensions"); // Disable ekstensi browser
        // options.addArguments("--headless"); // Headless

        // Inisialisasi driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Given("User navigates to the login page")
    public void User_navigates_to_the_login_page() {
        // Open a webpage
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("Input Username and Password")
    public void Input_Username_and_Password() {
        //Wait Txt Username Displayed
        waitForDisplayed(txtUsername);

        // Set Username
        driver.findElement(By.xpath(txtUsername)).sendKeys("Admin");

        // Set Password
        driver.findElement(By.xpath(txtPassword)).sendKeys("admin123");

        // Click Button Login
        driver.findElement(By.xpath(btnLogin)).click();
    }

    @Then("User verifies the dropdown name is {string}")
    public void User_verifies_the_dropdown_name(String expectedName) {
        //Wait Dropdown Displayed
        waitForDisplayed(dropdownUsername);

        //Verify
        Assert.assertEquals(driver.findElement(By.xpath(dropdownUsername)).getText(),expectedName);
    }


    @After
    public static void afterTest() {
        driver.quit();
    }


    public static void waitForDisplayed(String xpath) {
        //Wait For Displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }




}
