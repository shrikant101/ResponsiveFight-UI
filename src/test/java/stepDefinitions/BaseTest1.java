package stepDefinitions;

import java.io.File;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest1 {
	protected static WebDriver driver;
	static File file;
	static Logger LOGGER = Logger.getLogger(BaseTest1.class);
	public static WebDriver init() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
		intiateLoggers();
		long implicitWait = 10L;
		long explicitWait = 3000L;

			driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(explicitWait, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		return driver;
	}

	public void teardown() {
		driver.quit();
	}

	// Write Text
	public void writeText(By elementLocation, String text) {
		driver.findElement(elementLocation).sendKeys(text);
		LOGGER.info("Entered text " + text + " for " + elementLocation);
		
	}

	// Read Text
	public String readText(By elementLocation) {
		
		String text = driver.findElement(elementLocation).getText();
		LOGGER.info("Found text value " + text);
		return text;
		
	}

	public void click(By elemenLocation) {
		LOGGER.info("Clicked element " + elemenLocation);
		driver.findElement(elemenLocation).click();
	}

	/**
	 * Initialize log4j logger instance.
	 */
	public static void intiateLoggers() {

		try {

			System.setProperty("log4j.time", Long.toString(Calendar.getInstance().getTimeInMillis()));
			System.setProperty("pwd", System.getProperty("user.dir"));
			String logfileName = "log4j.properties";
			PropertyConfigurator.configure(logfileName);
			LOGGER = Logger.getLogger(BaseTest1.class);
			LOGGER.info("log4j properties filepath: " + logfileName);
		} catch (Exception e) {
			LOGGER.error("Error while intiating Loggers.", e);
		}
	}

}
