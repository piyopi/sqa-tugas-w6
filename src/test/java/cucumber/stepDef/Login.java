package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user launch the web app")
    public void user_launch_the_web_app(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("user input a registered user")
    public void user_input_a_registered_user(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input a registered password")
    public void user_input_a_registered_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user tap login button")
    public void user_tap_login_button(){
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("user can log in and redirected to Dashboard Page")
    public void user_can_log_in_and_redirected_to_Dashboard_Page(){
        Boolean flag = driver.findElement(By.xpath("//*[@id='inventory_container']")).isDisplayed();
        Assert.assertEquals(flag,true);
    }
}
