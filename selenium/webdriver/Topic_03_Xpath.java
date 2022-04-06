package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
	}

	@Test
	public void TC_01_() {
		 // Gồm có 3 bước 
		// Tìm (find) - số ít - trả về 1 cái 
		// Thao tác trực tiếp ko khai báo biến - sử dụng 1 lần / ko dùng lại element này
		driver.findElement(By.id("")).clear();
		driver.findElement(By.id("")).click();
		driver.findElement(By.id("")).isDisplayed();

		//  Khai báo biến - dùng lại Element nhiều lần
		WebElement loginButton = driver.findElement(By.id(""));
		loginButton.click();
		loginButton.isDisplayed();

		// Tìm (find) - số nhiều - trả về 1 hoặc >1
		driver.findElements(By.id("")).size();

		// Lặp lại nhiều lần
		List<WebElement> loginCheckboxes = driver.findElements(By.id(""));

		 // Thao tác (action) : click/type/select/hover/..

		 // Kiểm tra(Verify/Assert):getText/getAttribute/getCss/..

		 // Thao tác với Email Textbox

		 // Thao tác với Password Textbox

		 // Thao tác Login
	}

	@Test
	public void TC_02_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}