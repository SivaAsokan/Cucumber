package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelStepDef {
	WebDriver driver;

	@Given("user is on adactin webpage")
	public void user_is_on_adactin_webpage() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@When("user should enter {string},{string} and click login button")
	public void user_should_enter_and_click_login_button(String s1, String s2) {
		WebElement userid = driver.findElement(By.id("username"));
		userid.sendKeys(s1);
		WebElement userPass = driver.findElement(By.id("password"));
		userPass.sendKeys(s2);
		WebElement btn = driver.findElement(By.id("login"));
		btn.click();
	}

	@When("user should Select hotel {string},{string},{string},{string},{string},{string},{string}and click Search button")
	public void user_should_Select_hotel_and_click_Search_button(String s3, String s4, String s5, String s6, String s7,
			String s8, String s9) {
		WebElement loc = driver.findElement(By.id("location"));
		Select select = new Select(loc);
		select.selectByVisibleText(s3);
		WebElement hot = driver.findElement(By.id("hotels"));
		Select select2 = new Select(hot);
		select2.selectByVisibleText(s4);
		WebElement rType = driver.findElement(By.id("room_type"));
		Select select3 = new Select(rType);
		select3.selectByVisibleText(s5);
		WebElement rNo = driver.findElement(By.id("room_nos"));
		Select select4 = new Select(rNo);
		select4.selectByVisibleText(s6);
		WebElement dPick = driver.findElement(By.id("datepick_in"));
		Select select5 = new Select(dPick);
		select5.selectByVisibleText(s7);
		WebElement dPack = driver.findElement(By.id("datepick_out"));
		Select select6 = new Select(dPack);
		select6.selectByVisibleText(s8);
		WebElement adult = driver.findElement(By.id("adult_room"));
		Select select7 = new Select(adult);
		select7.selectByVisibleText(s9);
		WebElement search = driver.findElement(By.id("Submit"));
		search.click();
	}

	@When("user should click radio button and continue")
	public void user_should_click_radio_button_and_continue() {
		WebElement radio = driver.findElement(By.id("radiobutton_0"));
		radio.click();
		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();
	}

	@When("user should enter personal details {string},{string},{string},{string},{string},{string},{string},{string} and click booking button")
	public void user_should_enter_personal_details_and_click_booking_button(String s10, String s11, String s12,
			String s13, String s14, String s15, String s16, String s17) {
		WebElement fName = driver.findElement(By.id("first_name"));
		fName.sendKeys(s10);
		WebElement lName = driver.findElement(By.id("last_name"));
		lName.sendKeys(s11);
		WebElement add = driver.findElement(By.id("address"));
		add.sendKeys(s12);
		WebElement cNo = driver.findElement(By.id("cc_num"));
		cNo.sendKeys(s13);
		WebElement cType = driver.findElement(By.id("cc_type"));
		cType.sendKeys(s14);
		WebElement cMon = driver.findElement(By.id("cc_exp_month"));
		Select select = new Select(cMon);
		select.selectByVisibleText(s15);
		WebElement cYear = driver.findElement(By.id("cc_exp_year"));
		Select select2 = new Select(cYear);
		select2.selectByVisibleText(s16);
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys(s17);
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();
	}

	@Then("user  should get the order id on console")
	public void user_should_get_the_order_id_on_console() throws InterruptedException {
		Thread.sleep(5000);
		WebElement orderNo = driver.findElement(By.id("order_no"));
		String order = orderNo.getAttribute("value");
		System.out.println(order);
		driver.quit();
	}

}
