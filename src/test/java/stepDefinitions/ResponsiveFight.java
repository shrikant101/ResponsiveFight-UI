package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResponsiveFight extends BaseTest1 {
	WebDriver driver;
	String baseUrl = "https://responsivefight.herokuapp.com/";
	String dashboardUrl = "https://responsivefight.herokuapp.com/covid";
	String scoreUrl = "https://responsivefight.herokuapp.com/leaderboard";

	String username = "shri";
	String xpath_user = "//input[@id='worrior_username']";
	String xpath_homePage_warrior_btn = "//a[@id='warrior']";
	String xpath_homePage_btn = "//a[contains(.,'Start')]";

	String xpath_startChallenge = "//button[.='Start']";

	String xpath_are_you_game = "//a[.='Are you game?']";
	String xpath_take_the_bus = "//a[.='Take the bus']";
	String xpath_goto_public = "//a[.='Go to a public place']";
	String xpath_goto_office = "//a[.='Go to the office']";

	String xpath_first_answer = "(//a[@class='btn text-wrap'])[1]";
	String xpath_nextChallenge = "//button[contains(.,'Try the')]";

	String xpath_totalScoreLink = "//button[contains(.,'Check')]";
	String xpath_totalScore = "//td[.='shri']/following-sibling::td";

	@Given("^user is on homepage$")
	public void launchBrowser() throws InterruptedException {
		driver = init();
		driver.navigate().to(baseUrl);

	}

	@When("^user enters username and logs in$")
	public void userEntersUsernameAndLogsIn() throws Throwable {

		writeText(By.xpath(xpath_user), username);

		click(By.xpath(xpath_homePage_warrior_btn));
		click(By.xpath(xpath_homePage_btn));

	}

	@Then("^user successfully lands on dashboard page$")
	public void userSuccessfullyLandsOnDashboardPage() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(dashboardUrl));

	}

	@And("^user navigates to multiple challenges$")
	public void userNavigatesToMultipleChallenges() throws Throwable {

		click(By.xpath(xpath_are_you_game));
		click(By.xpath(xpath_startChallenge));
		driver.navigate().back();

		click(By.xpath(xpath_take_the_bus));
		click(By.xpath(xpath_startChallenge));
		driver.navigate().back();

		click(By.xpath(xpath_goto_public));
		click(By.xpath(xpath_startChallenge));
		driver.navigate().back();

		click(By.xpath(xpath_goto_office));
		click(By.xpath(xpath_startChallenge));
		driver.navigate().back();
	}

	@And("^user starts multiple challenges and completes it$")
	public void userStartsMultipleChallengesAndCompletesIt() throws Throwable {

		click(By.xpath(xpath_take_the_bus));
		click(By.xpath(xpath_startChallenge));
		click(By.xpath(xpath_first_answer));
		click(By.xpath(xpath_nextChallenge));

		click(By.xpath(xpath_startChallenge));
		click(By.xpath(xpath_first_answer));
		click(By.xpath(xpath_nextChallenge));

		click(By.xpath(xpath_startChallenge));
		click(By.xpath(xpath_first_answer));
	}

	@And("^user goes to summary page$")
	public void userGoesToSummaryPage() throws Throwable {
		click(By.xpath(xpath_totalScoreLink));
		driver.navigate().to(scoreUrl);

	}

	@And("^user total score is displayed in scoreboard$")
	public void userTotalScoreIsDisplayedInScoreboard() throws Throwable {

		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(scoreUrl));
		readText(By.xpath(xpath_totalScore));
	}

	@And("^user completes challenge successfully$")
	public void userCompletesChallengeSuccessfully() throws Throwable {
		teardown();
	}

}
