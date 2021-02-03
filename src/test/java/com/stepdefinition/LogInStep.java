package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInStep {
	public WebDriver driver;

	@Given("user is on adactinhotel webpage.")
	public void user_is_on_adactinhotel_webpage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.adactinhotelapp.com/");
		driver.manage().window().maximize();

	}

	@When("user should enter username and password.")
	public void user_should_enter_username_and_password() {
		WebElement userid = driver.findElement(By.id("username"));
		userid.sendKeys("Kannansiva");
		WebElement userPass = driver.findElement(By.id("password"));
		userPass.sendKeys("kannan2003");

	}

	@When("user should click the login button.")
	public void user_should_click_the_login_button() {
		WebElement btn = driver.findElement(By.id("login"));
		btn.click();
	}

	@Then("user should verify the success message.")
	public void user_should_verify_the_success_message() {
		String url = driver.getCurrentUrl();
		boolean b = url.contains("Search");
		Assert.assertTrue(b);
		driver.quit();
	}

}
