package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Command_I {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Browser() {
		// Mở page Url
		driver.get("https://messenger.com/");

		// Đóng 1 tab đang active (Handle WIndows/Tabs)
		driver.close();

		// Đóng trình duyệt
		driver.quit();

		// Lấy ra ID hiện tại của window/tab đang active
		String messengerID = driver.getWindowHandle();

		// Lấy ra tất cả các ID của tất cả tab/window đang có
		Set<String> allIDs = driver.getWindowHandles();

		// Tìm ra 1 element vs locator nào đó
		WebElement emailTextbox = driver.findElement(By.id(""));
		emailTextbox.clear();
		emailTextbox.sendKeys("");

		// Tìm ra tất cả các elements vs locators nào đó
		List<WebElement> textboxes = driver.findElements(By.id(""));

		// Trả về Url của page hiện tại
		String homePageUrl = driver.getCurrentUrl();

		// Trả về HTML source của page hiện tại
		String homePageSource = driver.getPageSource();

		// Trả về title của page hiện tại
		String homePageTitle = driver.getTitle();

		// Get/xóa cookie của page
		// Build framework: Share state of Class
		// Get cookie sau khi login xong -> Truyền vào các Class khác -> Reduce time
		// login cho từng Class
		driver.manage().deleteAllCookies();

		// Build framework: Get ra log của browser
		driver.manage().logs().getAvailableLogTypes();

		// Chờ cho việc tìm element (findElement()/findElements())
		// 1000ms = 1s
		// WebDriverWait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);

		// Chờ cho 1 page được load thành công (Option)
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		// Chờ cho 1 script được execute thành công (Option)
		// JavascriptExecutor
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);

		// Mở browser full màn hình
		driver.manage().window().fullscreen();

		// Maximize màn hình
		driver.manage().window().maximize();

		// Lấy ra vị trí hiện tại của browser
		driver.manage().window().getPosition();

		// Set vào cho browser tại vị trí nào đó
		driver.manage().window().setPosition(new Point(0, 0));

		// Lấy ra kích thước hiện tại của browser (rộng/cao)
		driver.manage().window().getSize();
		driver.manage().window().setSize(new Dimension(1920, 1080));

		// Back to page
		driver.navigate().back();

		// Forward to page
		driver.navigate().forward();

		// Tải lại trang
		driver.navigate().refresh();

		// Chuyển tới page Url -> Keep dc history -> thực hiện back/forward tốt hơn
		driver.navigate().to("https://messenger.com/");

		// Switch đến 1 tab/window nào đó
		// Switch arlert
		// Frame/Iframe
		driver.switchTo().window(messengerID);
		driver.switchTo().alert();
		driver.switchTo().frame("");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}