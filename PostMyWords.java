package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostMyWords {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		String baseUrl = "https://twitter.com";
		driver.get(baseUrl);

		driver.findElement(By.partialLinkText("Log in")).click();

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("remember_me")));
		driver.findElement(By.name("remember_me")).click();

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));
		driver.findElement(By.name("session[username_or_email]")).sendKeys("Test006@qq.com");

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[password]")));
		driver.findElement(By.name("session[password]")).sendKeys("qwert250");
		driver.findElement(By.name("session[password]")).submit();

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tweet-box-home-timeline")));
		driver.findElement(By.id("tweet-box-home-timeline")).sendKeys("This is my 1st tweet!! Hello World!!");
		
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']")));
		driver.findElement(By
				.cssSelector("button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']"))
				.click();

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-nav-home")));
		driver.findElement(By.id("global-nav-home")).click();
		
		TimeUnit.SECONDS.sleep(1);

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tweet-box-home-timeline")));
		driver.findElement(By.id("tweet-box-home-timeline")).sendKeys("This is my 2nd tweet!! Hello World!!");

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']")));
		driver.findElement(By
				.cssSelector("button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']"))
				.click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-nav-home")));
		driver.findElement(By.id("global-nav-home")).click();
		
		TimeUnit.SECONDS.sleep(1);

		for (int i = 3; i < 6; i++) {
			TimeUnit.SECONDS.sleep(1);
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tweet-box-home-timeline")));
			driver.findElement(By.id("tweet-box-home-timeline"))
					.sendKeys("This is my " + i + "nd tweet!! Hello World!!");

			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']")));
			driver.findElement(By.cssSelector(
					"button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']")).click();

			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-nav-home")));
			driver.findElement(By.id("global-nav-home")).click();

		}
		
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-nav-home")));
		driver.findElement(By.id("global-nav-home")).click();
		
		driver.navigate().refresh();
		
		TimeUnit.SECONDS.sleep(1);
		
		while (driver
				.findElement(By.cssSelector(
						"button[class='ProfileTweet-actionButton u-textUserColorHover dropdown-toggle js-dropdown-toggle']"))
				.isEnabled()) {
			driver.findElement(By.cssSelector(
					"button[class='ProfileTweet-actionButton u-textUserColorHover dropdown-toggle js-dropdown-toggle']"))
					.click();
			driver.findElement(By
					.xpath("//html/body/div[2]/div[3]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div[1]/div[2]/div[1]/div/div/div/ul/li[6]/button"))
					.click();
			driver.findElement(By.cssSelector("button[class='EdgeButton EdgeButton--danger delete-action']")).click();

			TimeUnit.SECONDS.sleep(1);
		}
		
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tweet-box-home-timeline")));
		driver.findElement(By.id("tweet-box-home-timeline")).sendKeys("All Done!!");
		
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']")));
		driver.findElement(By
				.cssSelector("button[class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn'][type='button']"))
				.click();
	}
}
