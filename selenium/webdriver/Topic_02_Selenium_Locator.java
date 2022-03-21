package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	// khai báo 1 biến driver đại diện cho Selenium WebDriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		// Set geckodriver : giao tiếp giữa browser và code 
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		// Bật trình duyệ Firefox lên
		driver = new FirefoxDriver();
		
		// Set thời gian đi tìm element
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Bật browser to lên 
		driver.manage().window().maximize();
		
		// Mở app ra
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_() {
		// Email Address textbox (HTML)
		// Element : tagname + attribute name + attribute value
		// <input type="text" class="inputtext _55r1 _6luy" 
		//name="email" id="email" data-testid="royal_email" 
		//placeholder="Email hoặc số điện thoại" autofocus="1" aria-label="Email hoặc số điện thoại">	
		// Selenium có 8 loại locator
		// Id
		driver.findElement(By.id("email"));
		
		// Class 
		// Name 
		driver.findElement(By.className("fb_logo"));
	
		// Tagname
		//driver.findElement(By.tagName("a")); // ra 1 cái đầu tiên 
		
		driver.findElements(By.tagName("a"));
		
		// LinkText : Truyền cả text vào
		driver.findElement(By.linkText("Tiếng Việt"));
		
		// Partial LinkText : truyền 1 phần của text
		// Độ chính xác không cao
		driver.findElement(By.partialLinkText("Tiếng Việt"));
		driver.findElement(By.partialLinkText("iếng Việ"));
		driver.findElement(By.partialLinkText("Việt"));
		driver.findElement(By.partialLinkText("Tiếng"));
		
		// Css
		driver.findElement(By.cssSelector("input[id='email']"));
		driver.findElement(By.cssSelector("input#email"));
		driver.findElement(By.cssSelector("#email"));
		
		driver.findElement(By.cssSelector("img[class='fb_logo _8ilh img']"));
		driver.findElement(By.cssSelector("img.fb_logo"));
		driver.findElement(By.cssSelector(".fb_logo"));
		
		driver.findElement(By.cssSelector("input[name='email']"));
		
		driver.findElement(By.cssSelector("a"));
		
		// Css không làm việc với text (dùng thuộc tính khác của thẻ a để thao tác)
		driver.findElement(By.cssSelector("a[title='Vietnamese']"));
		driver.findElement(By.cssSelector("a[onclick*='vi_VN']"));
		
		driver.findElement(By.cssSelector("a[title*='Vietnam']"));
		
		// Xpath
		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		driver.findElement(By.xpath("//img[contains(@class,'fb_logo')]"));
		driver.findElement(By.xpath("//img[starts-with(@class,'fb_logo')]"));
		driver.findElement(By.xpath("//input[@name='email']"));
		driver.findElement(By.xpath("//a"));
		driver.findElement(By.xpath("//a[text()='Tiếng Việt']"));
		driver.findElement(By.xpath("//a[contains(text(),'Tiếng Việt')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Việt')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Tiếng')]"));
	}

	@Test
	public void TC_02_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}