package searchFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Bookingflight {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	
	{
		
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orbitz.com/");
        Thread.sleep(2000);
		
	    driver.findElement(By.linkText("Sign In")).click();
	    driver.findElement(By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div/div/a[1]")).click();
		driver.findElement(By.id("loginFormEmailInput")).sendKeys("poojaitalia@gmail.com");
		driver.findElement(By.id("loginFormPasswordInput")).sendKeys("Demotest_1234");
		driver.findElement(By.id("loginFormSubmitButton")).click();
		Thread.sleep(2000);
       
		driver.findElement(By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div[1]/div/div/ul/li[2]/a")).click();
		driver.findElement(By.linkText("One-way")).click();
		
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[1]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-origin\"]")).sendKeys("Toronto");
		driver.findElement(By.xpath("//input[@arial-label='Toronto (YYZ - Pearson Intl.) Ontario, Canada']")).click();
	
		driver.findElement(By.xpath("//input[@arial-label='Going to']")).click();
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-destination\"]")).sendKeys("London");
		driver.findElement(By.xpath("//input[@arial-label='London (LHR - Heathrow) United Kingdom']")).click();
		

		driver.findElement(By.id("d1-btn")).click();
		driver.findElement(By.xpath("//input[@arial-label='Jun 18, 2022 selected, current check in date.']")).click();
		driver.findElement(By.xpath("//*[@id=\"app-layer-datepicker-flights-departure-arrival-start\"]/div[2]/div/div/div[3]/button")).click();
	
		driver.findElement(By.cssSelector("//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[2]/button")).click();
		Thread.sleep(2000);

 //Assertions	
	    String exp_title = "YYZ to LHR flights";
	    String curr_window_title = driver.getTitle();
	    Assert.assertEquals(curr_window_title, exp_title);
	    System.out.println("Title is Correct");
	        
        driver.findElement(By.xpath("//input[@aria-label='Saturday, June 18 2022, $506, Selected date']")).isSelected();
        System.out.println("18th June is selected");
      
    	driver.findElement(By.id("stops-0")).click();  
        Assert.assertTrue(driver.findElement(By.id("stops-0")).isSelected());  
        System.out.println("Nonstop checkbox is selected");
     
		driver.close();
	}

}



