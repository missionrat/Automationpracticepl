package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait webDriverWait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else {
			logger.error("Invalid browser name---- please select chrome edge firefox only ");
			System.err.print("Invalid browser!!!");
		}

	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for" + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser for" + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new ChromeDriver());
				webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE)
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
				webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {

				driver.set(new FirefoxDriver());
				webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		}
	}

	public void navigateToApplication(String url) {
		logger.info("Navigating to the Website:" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximized the browser window");
		driver.get().manage().window().maximize();
	}

	public void ClickOn(By locator) {
		logger.info("Finding element with the locator" + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element found and performing click action" + locator);

		element.click();

	}

	public void ClickOnCheckbox(By locator) {
		logger.info("Finding element with the locator" + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and performing click action" + locator);

		element.click();

	}

	public void ClickOn(WebElement element) {

		logger.info("Element found and performing click action" + element);

		element.click();

	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter text" + textToEnter);

		element.sendKeys(textToEnter);

	}

	public void clearText(By textBoxlocator) {
		logger.info("Finding element with the locator" + textBoxlocator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(textBoxlocator));

		logger.info("Element found and clearing the text" + textBoxlocator);
		element.clear();
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning  the visible text" + element.getText());
		return element.getText();

	}

	public String getVisibleText(WebElement element) {
		logger.info("Finding element with the locator" + element);
		logger.info("Returning  the visible text" + element.getText());
		return element.getText();

	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Elements found and now printing  the list of elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding all elements with the locator" + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Elements found and now printing  the list of elements");

		return elementList;

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter text" + keyToEnter);

		element.sendKeys(keyToEnter);

	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenShot = (TakesScreenshot) driver.get();

		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm=ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with the locator" + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the option" + optionToSelect);
		select.selectByVisibleText(optionToSelect);

	}

	public void quit() {
		logger.info("Quit the browser window");
		driver.get().quit();
	}

}
