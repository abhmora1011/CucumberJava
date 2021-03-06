package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testdata.TestData;

public class HomePage extends TestData {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By txt_PersonCol = By.id("GridFrow2fltPerson-awed");
	By drop_dateFilter = By.id("GridFrow2fltDate-awed");
	By drop_ListOfYear = By.xpath("//*[@id='GridFrow2fltDate-dropmenu']/div[2]/ul/li");
	By drop_foodFilter = By.id("GridFrow2fltFood-awed");
	By drop_ListOfFood = By.xpath("//*[@id='GridFrow2fltFood-dropmenu']/div[2]/ul/li");

	public void enterName(String name) {
		WebElement personCol = explicitWait(txt_PersonCol);
		personCol.sendKeys(name);
		personCol.sendKeys(Keys.ENTER);
	}

	public void selectYear(String year) {

		setYear = year;
		
		WebElement dateFilter = explicitWait(drop_dateFilter);
		dateFilter.click();

		List<WebElement> foodYear = driver.findElements(drop_ListOfYear);

		for (WebElement yrOption : foodYear) {
			if (yrOption.getText().equalsIgnoreCase(year)) {
				selectedYear = yrOption.getText();
				yrOption.click();
				break;
			}
		}

	}

	public void selectFood(String food) {
		
		selectedFood = food;
		
		WebElement foodCol = explicitWait(drop_foodFilter);
		foodCol.click();

		List<WebElement> foods = driver.findElements(drop_ListOfFood);

		for (WebElement option : foods) {
			if (option.getText().equalsIgnoreCase(food)) {
				selectedFood = option.getText();
				option.click();
				break;
			}
		}
	}

	public WebElement explicitWait(By element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		return w.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void pause(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	public void scrollPageByValue(int pixelValue1, int pixelValue2) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll( " + pixelValue1 + "," + pixelValue2 + ")");
	}

	public void assertValue(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}

	public void tearDown() {
		driver.quit();
	}
	
	public void launchBrowser(String url) {
		driver.get(url);
	}
}
