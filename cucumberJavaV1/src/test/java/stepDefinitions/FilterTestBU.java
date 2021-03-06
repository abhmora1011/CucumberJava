//package stepDefinitions;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.HomePage;
//import testdata.TestData;
//
//public class FilterTestBU extends TestData {
//
//	WebDriver driver;
//
//	@Given("browser is open")
//	public void open_the_browser() {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	}
//
//	@And("user input the url")
//	public void user_input_the_url() {
//		driver.get(baseUrl);
//	}
//
//	@When("user is on the page and scroll on the table")
//	public void user_is_on_the_page_and_scroll_on_the_table() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scroll(0,2000)");
//		Thread.sleep(2000);
//	}
//
//	@And("^filter a record using (.*), (.*) and (.*)$")
//	public void filter_record(String name, String year, String food) throws InterruptedException {
//
//		setYear = year;
//		setFood = food;
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement personCol = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.id("GridFrow2fltPerson-awed")));
//
//		personCol.sendKeys(name);
//		personCol.sendKeys(Keys.ENTER);
//		
//
//		Thread.sleep(2000);
//
//		WebElement dateFilter = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.id("GridFrow2fltDate-awed")));
//		dateFilter.click();
//
//		List<WebElement> foodYear = driver.findElements(By.xpath("//*[@id='GridFrow2fltDate-dropmenu']/div[2]/ul/li"));
//
//		for (WebElement yrOption : foodYear) {
//
//			if (yrOption.getText().equalsIgnoreCase(setYear)) {
//				selectedYear = yrOption.getText();
//				yrOption.click();
//				break;
//			}
//		}
//
//		Thread.sleep(2000);
//
//		WebElement foodCol = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GridFrow2fltFood-awed")));
//		foodCol.click();
//
//		List<WebElement> foods = driver.findElements(By.xpath("//*[@id='GridFrow2fltFood-dropmenu']/div[2]/ul/li/div"));
//		for (WebElement option : foods) {
//
//			if (option.getText().equalsIgnoreCase(food)) {
//				selectedFood = option.getText();
//				option.click();
//				break;
//			}
//		}
//
//	}
//
//	@Then("the product mapped on the users input should be displayed")
//	public void the_product_mapped_on_the_user_should_be_displayed() {
//		Assert.assertEquals(setFood, selectedFood);
//		Assert.assertEquals(setYear, selectedYear);
//		driver.quit();
//	}
//
//}
