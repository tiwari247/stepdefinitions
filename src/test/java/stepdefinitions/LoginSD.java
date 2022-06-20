package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

public class LoginSD {
	TestContext testContext;
	public LoginSD(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Given("I open a browser and navigated to the login page")
	public void i_open_a_browser_and_navigated_to_the_login_page() {
	    System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\cpadmin\\\\Desktop\\\\drivers\\\\chromedriver.exe");
	    testContext.driver = new ChromeDriver();
	    testContext.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    testContext.driver.manage().window().maximize();
	    testContext.driver.get("http://www.demo.guru99.com/V4/");
	}
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		System.out.println(username+" - "+password);
		testContext.driver.findElement(By.name("uid")).sendKeys(username);
		testContext.driver.findElement(By.name("password")).sendKeys(password);
	}
	@When("I click login")
	public void i_click_login() {
		System.out.println("click login");
		testContext.driver.findElement(By.name("btnLogin")).click();
	}
	@Then("Manager home page should be displayed")
	public void manager_home_page_should_be_displayed() {
		System.out.println("manager home");
		WebDriverWait wait = new WebDriverWait(testContext.driver,10);
		wait.until(ExpectedConditions.urlContains("Manager"));
		Assert.assertEquals(testContext.driver.getCurrentUrl().contains("Manager"), true);
	}
	@Then("validate managerID {string}")
	public void validate_manager_id(String managerID) {
		System.out.println("manager ID: "+managerID);
		String managerText = testContext.driver.findElement(By.xpath("(//table[@class=\"layout\"]//table//tr//td)[2]")).getText();
		Assert.assertEquals(managerText.contains(managerID), true);
	}
}
