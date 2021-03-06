package webdriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button_Radio_Checkbox {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait explicitWait;

	String projectPath = System.getProperty("user.dir");

	By loginTab = By.xpath("//li[@class='popup-login-tab-item popup-login-tab-login']");
	By loginBtn = By.xpath("//button[@class='fhs-btn-login']");

	By acceptCookiesBtn = By.xpath("//button[normalize-space()='Accept Cookies']");
	By DualZoneAirConditioningCheckbox = By
			.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
	By petrol147kW = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
	
	By checkedCheckbox = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
	By indeterminateCheckbox = By.xpath("//span[text()='Indeterminate']/preceding-sibling::span/input");
	
	String email = "kane" + getStringCurrentDateAndTime() + "@gmail.net";
	String password = "12345678";
	String loginBtnBackgroundColor = "#C92127";
	String season = "Summer";

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		explicitWait = new WebDriverWait(driver, 15);
		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Button_Javascript_Executor() {

		System.out.println("TC 01 - Button Javascript Executor");

		System.out.println("	Step 01: Truy c???p v??o trang: https://www.fahasa.com/customer/account/create");
		driver.get("https://www.fahasa.com/customer/account/create");

		System.out.println("	Step 02: Navigate qua tab ????ng nh???p");
		driver.findElement(loginTab).click();

		System.out.println("	Step 03: Verify \"????ng nh???p\" button l?? disabled");
		Assert.assertFalse(driver.findElement(loginBtn).isEnabled());

		System.out.println("	Step 04: Input d??? li???u h???p l??? v??o Email/ M???t kh???u textbox");
		driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys(password);

		System.out.println("	Step 05: Verify \"????ng nh???p\" l?? enabled");
		Assert.assertTrue(driver.findElement(loginBtn).isEnabled());

		System.out.println("	Step 06: Verify \"????ng nh???p\" button c?? background color l?? m??u ?????");
		String actualLoginBtnBackgroundColor = Color
				.fromString(driver.findElement(loginBtn).getCssValue("background-color")).asHex().toUpperCase();
		Assert.assertEquals(actualLoginBtnBackgroundColor, loginBtnBackgroundColor);

		System.out.println("	Step 07: T???i l???i trang sau ???? navigate qua tab ????ng nh???p");
		driver.navigate().refresh();
		driver.findElement(loginTab).click();

		System.out.println("	Step 08: Remove thu???c t??nh disabled c???a button \"????ng nh???p\"");
		js.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(loginBtn));

		System.out.println("	Step 09: Click v??o button \"????ng nh???p\"");
		driver.findElement(loginBtn).click();

		System.out.println("	Step 10: Ki???m tra error message xu???t hi???n t???i Email/ M???t kh???u");
		Assert.assertEquals(driver.findElement(By.xpath(
				"//div[@class='popup-login-content']//label[text()='S??? ??i???n tho???i/Email']/following-sibling::div[@class='fhs-input-alert']"))
				.getText(), "Th??ng tin n??y kh??ng th??? ????? tr???ng");

		Assert.assertEquals(driver.findElement(By.xpath(
				"//div[@class='popup-login-content']//label[text()='M???t kh???u']/following-sibling::div[@class='fhs-input-alert']"))
				.getText(), "Th??ng tin n??y kh??ng th??? ????? tr???ng");
	}

	/*@Test
	public void TC_02_Default_Checkbox_or_Radio_button() {

		System.out.println("\nTC 02 - Default Checkbox or Radio button");

		System.out.println("	Step 01: Truy c???p v??o trang: http://demos.telerik.com/kendo-ui/styling/checkboxes");
		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		clickAcceptCookiesBtn(acceptCookiesBtn);

		System.out.println("	Step 02: CLick v??o checkbox: Dual-zone air conditioning");
		checkToCheckbox(DualZoneAirConditioningCheckbox);

		System.out.println("	Step 03: Ki???m tra checkbox ???? ???? ch???n");
		Assert.assertTrue(driver.findElement(DualZoneAirConditioningCheckbox).isSelected());

		System.out.println("	Step 04: Sau khi checkbox ???? ???????c ch???n - b??? ch???n n?? v?? ki???m tra n?? ch??a ???????c ch???n");
		uncheckToCheckbox(DualZoneAirConditioningCheckbox);
		Assert.assertFalse(driver.findElement(DualZoneAirConditioningCheckbox).isSelected());

		System.out.println("	Step 05: Truy c???p v??o trang: http://demos.telerik.com/kendo-ui/styling/radios");
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");

		System.out.println("	Step 06: Click v??o radio button: 2.0 Petrol, 147kW");
		clickRadioBtn(petrol147kW);

		System.out.println("	Step 07: Ki???m tra radio button ???? ???? ch???n hay ch??a/ n???u ch??a ch???n l???i");
		if (!driver.findElement(petrol147kW).isSelected())
			clickRadioBtn(petrol147kW);

		Assert.assertTrue(driver.findElement(petrol147kW).isSelected());
	}*/

//	@Test
//	public void TC_03_Angular_Custom_Checkbox_or_Radio_button() {
//
//		System.out.println("TC 03 - Angular Custom Checkbox or Radio button");
//
//		System.out.println("	Step 01: Truy c???p v??o trang: https://material.angular.io/components/radio/examples");
//		driver.get("https://material.angular.io/components/radio/examples");
//		clickAcceptCookiesBtn(By.xpath("//button[@color='primary']"));
//		
//		System.out.println("	Step 02: Click v??o radio button: Summer");
//		clickRadioBtnByJS(By.xpath("//input[@value='" + season + "']"));
//		
//		System.out.println("	Step 03: Ki???m tra radio button ???? ???? ch???n hay ch??a/ n???u ch??a ch???n l???i");
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='" + season + "']")).isSelected());
//		
//		System.out.println("	Step 04: Truy c???p v??o trang: https://material.angular.io/components/checkbox/examples");
//		driver.get("https://material.angular.io/components/checkbox/examples");
//
//		System.out.println("	Step 05: Click v??o checkbox: Checked, Inderterminate");
//		checkToCheckboxByJS(checkedCheckbox);
//		checkToCheckboxByJS(indeterminateCheckbox);
//	
//		System.out.println("	Step 06: Ki???m tra checkbox ???? ???? ch???n");
//		Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
//		Assert.assertTrue(driver.findElement(indeterminateCheckbox).isSelected());
//		
//		System.out.println("	Step 07: Sau khi checkbox ???? ???????c ch???n - b??? c???n n?? v?? ki???m tra n?? ch??a ???????c ch???n");
//		uncheckToCheckboxByJS(checkedCheckbox);
//		uncheckToCheckboxByJS(indeterminateCheckbox);	
//		
//		Assert.assertFalse(driver.findElement(checkedCheckbox).isSelected());
//		Assert.assertFalse(driver.findElement(indeterminateCheckbox).isSelected());
//	}

	@Test
	public void TC_04_Google_Form_Custom_Checkbox_or_Radio_button() {

		System.out.println("TC 04 - Google Form Custom Checkbox or Radio button");

		System.out.println("	Step 01: Truy c???p v??o trang: https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		
		System.out.println("	Step 02: Ki???m tra 'C???n Th??' radio button l?? ch??a ???????c ch???n");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='C???n Th??']")).getAttribute("aria-checked"), "false");

		System.out.println("	Step 03: Click ch???n 'C???n Th??' radio button");
		driver.findElement(By.xpath("//div[@aria-label='C???n Th??']")).click();
		
		System.out.println("	Step 04: Ki???m tra 'C???n Th??' radio button l?? ???? ???????c ch???n");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='C???n Th??']")).getAttribute("aria-checked"), "true");		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSeconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	public String getStringCurrentDateAndTime() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyHH:mm:ss");
		return dateFormat.format(currentDate).toString().replace(":", "");
	}

	public void checkToCheckbox(By checkbox) {
		WebElement element = driver.findElement(checkbox);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		if (!element.isSelected())
			element.click();
	}

	public void uncheckToCheckbox(By checkbox) {
		WebElement element = driver.findElement(checkbox);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		if (element.isSelected())
			element.click();
	}

	public void clickRadioBtn(By checkbox) {
		WebElement element = driver.findElement(checkbox);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		element.click();
	}

	public void clickAcceptCookiesBtn(By acceptCookies) {
		driver.findElement(By.xpath("//div[@class='qual_x_close']")).click();
		List<WebElement> acceptCookiesBtn = driver.findElements(acceptCookies);
		if (acceptCookiesBtn.size() > 0) {
			driver.findElement(acceptCookies).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookies));
		}
	}
	
	public void clickRadioBtnByJS(By checkbox) {
		WebElement element = driver.findElement(checkbox);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void checkToCheckboxByJS(By checkbox) {
		WebElement element = driver.findElement(checkbox);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		if (!element.isSelected())
			js.executeScript("arguments[0].click();", element);
	}

	public void uncheckToCheckboxByJS(By checkbox) {
		WebElement element = driver.findElement(checkbox);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		if (element.isSelected())
			js.executeScript("arguments[0].click();", element);
	}
	
}