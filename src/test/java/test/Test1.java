package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	@Test
	public void register()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://magento.com");
		driver.findElement(By.xpath("//*[@id=\"gnav_557\"]/span/span/span")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Harjinder");
		driver.findElement(By.id("lastname")).sendKeys("Kaur");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("fa-question-circle"))).perform();
		
				
	    driver.findElement(By.id("email_address")).sendKeys("hchahal@outlook.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("Atwal's");
		driver.findElement(By.id("password")).sendKeys("Harvir");
		driver.findElement(By.id("password-confirmation")).sendKeys("Harvir");
		
		Select cp=new Select(driver.findElement(By.id("company_type")));
		cp.selectByValue("development");
		
		Select role=new Select(driver.findElement(By.id("individual_role")));
		role.selectByValue("technical/developer");
		
		Select country=new Select(driver.findElement(By.id("country")));
		country.selectByValue("AF");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("#recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03 > div > div > iframe")));
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
		driver.switchTo().defaultContent();
		
		
		if(!driver.findElement(By.id("agree_terms")).isSelected())
		
			
		{
		
		driver.findElement(By.id("agree_terms")).click();
		
		}
		
		driver.quit();
	}
	

	
	
	@Test
	public void login() throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://magento.com");

	
	driver.findElement(By.id("gnav_557")).click();		
    driver.findElement(By.id("email")).sendKeys("hchahal@outlook.com");

	driver.findElement(By.id("pass")).sendKeys("Harvir");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(3000);
	String error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
	System.out.println(error);
	if(error.equals("Invalid login or password"))
	{	
		System.out.println("Test Pass");
		
		driver.quit();
	
	}
	}
}
	






