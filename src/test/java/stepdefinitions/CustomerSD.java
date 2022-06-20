package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

public class CustomerSD {
	TestContext testContext;
	public CustomerSD(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@When("I click on New Customer button")
	public void i_click_on_new_customer_button() {
		testContext.driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click();
		try {
			testContext.driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");	
			testContext.driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]")).click();
			testContext.driver.switchTo().defaultContent();
		}catch(Exception e){
			testContext.driver.switchTo().frame("ad_iframe");
			testContext.driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]")).click();
			testContext.driver.switchTo().parentFrame();
			testContext.driver.switchTo().defaultContent();
		}
	}
	
	@When("I give customer details like {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void i_give_customer_details_like_and(String name, String gender, String dob, String address, String city, String state, String pin, String mobile, String email, String password) {
	    System.out.println("second: "+dob);
	    testContext.driver.findElement(By.name("name")).sendKeys(name);
	    testContext.driver.findElement(By.xpath("//input[@value=\""+gender+"\"]")).click();
	    testContext.driver.findElement(By.id("dob")).click();
	    JavascriptExecutor js = (JavascriptExecutor)testContext.driver;
	    js.executeScript("arguments[0].value='"+dob+"'", testContext.driver.findElement(By.id("dob")));
	    testContext.driver.findElement(By.name("addr")).sendKeys(address);
	    testContext.driver.findElement(By.name("city")).sendKeys(city);
	    testContext.driver.findElement(By.name("state")).sendKeys(state);
	    testContext.driver.findElement(By.name("pinno")).sendKeys(pin);
	    testContext.driver.findElement(By.name("telephoneno")).sendKeys(mobile);
	    testContext.driver.findElement(By.name("emailid")).sendKeys(email);
	    testContext.driver.findElement(By.name("password")).sendKeys(password);
	    
	}

	@When("click on submit button")
	public void click_on_submit_button() {
		testContext.driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}

	@Then("Customer should be able to see successful registeration message")
	public void customer_should_be_able_to_see_successful_registeration_message() {
	    System.out.println("fourth");    
	    Assert.assertEquals(testContext.driver.findElement(By.xpath("//p[text()=\"Customer Registered Successfully!!!\"]")).getText(), "Customer Registered Successfully!!!");
	}

	@Then("a customerID should be generated")
	public void a_customer_id_should_be_generated() {
		System.out.println("fifth");
		String customerID = testContext.driver.findElement(By.xpath("//td[text()=\"Customer ID\"]/following-sibling::td")).getText();
		System.out.println("CustomerID: "+customerID);
		Assert.assertNotNull(customerID);
	}
}
