package stepDefinations;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {
	WebDriver driver=null;
	@Given("Gmail Url")
	public void gmail_url() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions option = new ChromeOptions();
	  option.setExperimentalOption("useAutomationExtension", false);
	  option.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
	  driver = new ChromeDriver(option);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.gmail.com");
	    
	}




	@When("User enters username and Password")
	public void user_enters_username_and_password() {
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cyber.ashesh@gmail.com");
	    driver.findElement(By.xpath("//span[text()='Next']/ancestor::button")).click();
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("");
	   
	}
	@When("hit the login button")
	public void hit_the_login_button() {
		 driver.findElement(By.xpath("//span[text()='Next']/ancestor::button")).click();
	}
	@Then("Load the home page")
	public void load_the_home_page() {
	   if(driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).isDisplayed()) {
		   System.out.println("Login Successful");
	   }
	}
	

    @Given("^user in home page$")
    public void user_in_home_page() throws Throwable {
        
    }

    @When("^user clicked on compose mail$")
    public void user_clicked_on_compose_mail() throws Throwable {
    	driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
    }

    @Then("^Mail sent Successfully	$")
    public void mail_sent_successfully() throws Throwable {
    }

    @And("^Entered To and Subject$")
    public void entered_to_and_subject() throws Throwable {
    	driver.findElement(By.xpath("//textarea[@name='subjectbox']")).sendKeys("Incubyte");
    	driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hello World");
    }

    @And("^Clicked on Send button$")
    public void clicked_on_send_button() throws Throwable {
    	driver.findElement(By.xpath("(//div[contains(text(),'Send')])[2]")).click();
    	List<WebElement> l = driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr/td[6]//span"));
    	for(int i=0;i<l.size();i++) {
    		if(l.get(i).getText().contains("Incubyte")) {
    			System.out.println("Mail sent successfully");
    			break;
    		}
    	}
    }



}
