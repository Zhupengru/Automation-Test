package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpTwitterAndPost {
	public static void main(String[] args){
		WebDriver driver ;
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 10);
	    String baseUrl = "https://twitter.com";
	    driver.get(baseUrl);
	    
	    driver.findElement(By.partialLinkText("Sign up")).click();
	    
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full-name")));
	    driver.findElement(By.id("full-name")).sendKeys("PengRooJoo");
	    
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	    driver.findElement(By.id("email")).sendKeys("Test008@qq.com"); // need
	    
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    driver.findElement(By.id("password")).sendKeys("qwert250");
	    
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_button")));
	    driver.findElement(By.id("submit_button")).click();
	    
	    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Skip")));
	    driver.findElement(By.linkText("Skip")).click();
	    
	   if(driver.getTitle().equals("Twitter"));
	   else{
		   myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		    driver.findElement(By.id("username")).sendKeys("PengRooJoo008"); // need
		    
		    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_button")));
		    driver.findElement(By.id("submit_button")).click();
		    
		    myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Let's go!")));
		    driver.findElement(By.linkText("Let's go!")).click();
	   }
	    
	}
}
