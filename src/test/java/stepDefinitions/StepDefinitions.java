package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    WebDriver driver;

    @Given("test given step")
    public void test_given_step() {
        System.out.println("I am given...");
    }
    @And("hit when step")
    public void hit_when_step() {
        System.out.println("I am When...");
    }
    @And("I should see condition")
    public void i_should_see_condition() {
        System.out.println("I am then...");
    }

    @Given("I open {string}")
    public void i_open(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }
    @When("I enter incorrect username and password")
    public void i_enter_incorrect_username_and_password() {
        driver.findElement(By.xpath("//*[@id='Username']")).sendKeys("its..me");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("its..not me");
    }
    @When("hit login")
    public void hit_login() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }
    @Then("I should see error message")
    public void i_should_see_error_message() {
        String et = driver.findElement(By.xpath("//*[@class='message-error validation-summary-errors']")).getText();
        Assert.assertTrue(et.contains("Login was unsuccessful"));
        driver.quit();
    }

}
