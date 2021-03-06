package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import testdata.TestData;


public class FilterTest extends TestData{

	WebDriver driver;
	HomePage home;
	TestData test;

	@Given("browser is open")
	public void open_the_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("user input the url")
	public void user_input_the_url() {
		home = new HomePage(driver);
		home.launchBrowser(baseUrl);
	}

	@When("user is on the page and scroll on the table")
	public void user_is_on_the_page_and_scroll_on_the_table() throws InterruptedException {
		driver.getTitle().equals("Overview - Awesome ASP.net Core and MVC Controls demos");
		home.scrollPageByValue(0, 2000);
		home.pause(2000);
	}

	@And("^filter a record using (.*), (.*) and (.*)$")
	public void filter_record(String name, String year, String food) throws InterruptedException {

		home.enterName(name);
		home.pause(2000);
		home.selectYear(year);
		home.pause(2000);
		home.selectFood(food);
	}

	@Then("the product mapped on the users input should be displayed")
	public void the_product_mapped_on_the_user_should_be_displayed() {

		home.assertValue(setFood, selectedFood);
		home.assertValue(setYear, selectedYear);
		home.tearDown();
	}

}
