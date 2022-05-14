package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterTest {
	
	WebDriver driver = null;
	public String baseUrl = "https://demo.aspnetawesome.com/";
	
	@Given("browser is open")
	public void open_the_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@And("user input the url")
	public void user_input_the_url() {
		driver.get(baseUrl);
	}

	@When("user is on the page and scroll on the table")
	public void user_is_on_the_page_and_scroll_on_the_table() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,2000)");
	}

	@And("input person name on the field")
	public void input_person_name_on_the_field() throws InterruptedException {
	   driver.findElement(By.id("GridFrow2fltPerson-awed")).sendKeys("Jennifer");
	   driver.findElement(By.id("GridFrow2fltPerson-awed")).sendKeys(Keys.ENTER);
	   WebElement staticDropdown = driver.findElement(By.id("GridFrow2fltFood-awed"));
	   staticDropdown.click();
	   Thread.sleep(2000);
	   List<WebElement> autoSuggest = driver.findElements(By.xpath("//li/a[@class='ui-corner-all']"));
	   for (WebElement option : autoSuggest) {
			
			System.out.println(option.getText());
			
		}
	   Thread.sleep(4000);
	}

	@Then("the product mapped on the user should be displayed")
	public void the_product_mapped_on_the_user_should_be_displayed() {
	    driver.quit();
	}


}
