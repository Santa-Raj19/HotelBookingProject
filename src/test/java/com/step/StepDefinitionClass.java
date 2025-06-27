
package com.step;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inputs.ExcelDatas;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionClass{
    
	WebDriver driver;
	
	
	@Given("User is on Adactin login page")
	public void user_is_on_Adactin_login_page()  {
		 
		  
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  driver.manage().deleteAllCookies();
	   	  driver.get("https://adactinhotelapp.com/index.php"); 
		
	}

	@Test(dataProvider = "LoginData")
	@When("User enters the Valid {string} and Valid {string}")
	public void user_enters_the_Valid_and_Valid(String email, String pass)  {
	
		
		driver.findElement(By.id("username")).sendKeys(email);
		 
		 driver.findElement(By.id("password")).sendKeys(pass);
	}

		

	

	@And("User clicks on the login button and validate hotel booking fields")
	public void user_clicks_on_the_login_button_and_validate_hotel_booking_fields() {
		
    	   driver.findElement(By.name("login")).click();
    	   
		   WebElement location = driver.findElement(By.xpath("(//select[@class='search_combobox'])[1]"));
			
			Select s=new Select(location);
			
			s.selectByIndex(5);
			
			
			WebElement hotel = driver.findElement(By.xpath("(//select[@name='hotels'])[1]"));
			Select s1=new Select(hotel);
			s1.selectByValue("Hotel Sunshine");
			
			WebElement room = driver.findElement(By.name("room_type"));
			Select s3=new Select(room);
			s3.selectByVisibleText("Double");
			
			WebElement nos = driver.findElement(By.xpath("//select[@name='room_nos']"));
			Select s4=new Select(nos);
			s4.selectByValue("2");
			

			WebElement dayIn = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		    dayIn.clear();
		    dayIn.sendKeys("20/03/2025");
			  
			WebElement dayOut = driver.findElement(By.xpath("//input[@name='datepick_out']"));
			dayOut.clear();
	    	dayOut.sendKeys("23/03/2025");
			
			WebElement ad = driver.findElement(By.xpath("//select[@name='adult_room']"));
			Select s5=new Select(ad);
			s5.selectByValue("2");
			
			WebElement ch = driver.findElement(By.xpath("//select[@name='child_room']"));
			Select s6=new Select(ch);
			s6.selectByVisibleText("2 - Two");
			
			WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
			submit.click();
			
			WebElement rButton = driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
			rButton.click();
			
			WebElement con = driver.findElement(By.id("continue"));
			con.click();
			
			driver.findElement(By.name("first_name")).sendKeys("Rajesh");
			driver.findElement(By.name("last_name")).sendKeys("kumar");
			driver.findElement(By.name("address")).sendKeys("Ambattur, chennai");
			driver.findElement(By.name("cc_num")).sendKeys("3453784953749405");
			
			WebElement cc = driver.findElement(By.xpath("//select[@name='cc_type']"));
			Select s7=new Select(cc);
			s7.selectByVisibleText("VISA");
			
			WebElement month = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
			Select s8=new Select(month);
			s8.selectByValue("5");
			
			WebElement year = driver.findElement(By.xpath("//select[@name='cc_exp_year']"));
			Select s9=new Select(year);
			s9.selectByVisibleText("2028");
			
			driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("6543");
			driver.findElement(By.name("book_now")).click();
			
			driver.findElement(By.name("my_itinerary")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			driver.findElement(By.name("cancelall")).click();
			
			Alert confirm = driver.switchTo().alert();
			confirm.accept();
			
			driver.findElement(By.name("logout")).click();
		
	}
	 
	
	@Then("Validate the cancellation and logout messages")
	public void validate_the_cancellation_and_logout_messages() {
		
    	
		WebElement text = driver.findElement(By.xpath("//td[text()='You have successfully logged out. ']"));
		String text2 = text.getText();
		System.out.println(text2);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
		Date d=new Date();
		System.out.println(d);
	}
	
	@AfterSuite
    public void afterSuite() {
		
    	System.out.println("programme completed");
    }
}
