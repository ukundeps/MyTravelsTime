package com.mytravels.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.DataProvider;

import com.mytravels.constant.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends Constant{
	public static Logger log = Logger.getLogger(Base.class);

	/**
	 * To get Configuration Input from ObjectRepository.properties file
	 * 
	 * @param ORParameterName
	 * @return ORParameterValue
	 */

	public static String getParameter(String parameter) {
		prop = new Properties();
		String locator = " ";
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\NewWorkspace\\MyTravelsTime\\src\\main\\resources\\ObjectRepository.properties");
			prop.load(fis);
			locator = prop.getProperty(parameter).trim();

		} catch (FileNotFoundException e) {
			System.out.println("Object repository not found!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("Config Parameter Name: "+locator);
		return locator;

	}

	/**
	 * 
	 * This method will open browser window
	 * 
	 * @param browserName
	 */
	public static void openBrowser() {
		String browser = getParameter("BrowserName");
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().version("2.40").setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:

			log.error("Entered  Browser Name not matched!!");
			break;

		}
		log.info(browser + " is opened!! ");

	}

	/**
	 * This Method will Maximised the opened Browser Window
	 */
	public static void maxiBrowserWindow() {
		driver.manage().window().maximize();
		log.info("Maximized Browser Window!!");
	}

	/**
	 * This method will delete all cookies
	 */
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		log.info("Deleted All Cookies!!");
	}

	/**
	 * Sets the amount of time to wait for a page load to complete
	 * 
	 * @param duration
	 *            :time
	 * @param timeUnit
	 *            :Unit
	 */
	public static void pageLoadTimeOut() {
		long duration = Long.parseLong(getParameter("PageLoadTimeOutDuration"));
		String timeUnit = getParameter("PageLoadTimeOutUnit");
		switch (timeUnit) {
		case "NANOSECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MICROSECONDS);
			break;
		case "MILLISECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.DAYS);
			break;
		default:
			log.error("Entered Time Unit  Not Matched!!");
			break;
		}
		log.info(duration + timeUnit + " Page load timeout  is applied!!");
	}

	/**
	 * Specifies the amount of time the driver should wait when searching for an
	 * element if it isnot immediately present.
	 * 
	 * @param duration
	 *            :time
	 * @param timeUnit
	 *            :Unit
	 */

	public static void implicitWait() {
		long duration = Long.parseLong(getParameter("ImplicitWaitDuration"));
		String timeUnit = getParameter("ImplicitWaitTimeUnit");
		switch (timeUnit) {
		case "NANOSECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MICROSECONDS);
			break;
		case "MILLISECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.DAYS);
			break;
		default:
			log.error("Entered Time Unit  Not Matched!!");
			break;
		}
		log.info(duration + timeUnit + " Implicit Wait is applied!!");

	}

	public static void expllicitWait() {
		long duration = Long.parseLong(getParameter("ExplicitWaitDuration"));
		String timeUnit = getParameter("ExplicitWaitTimeUnit");
		switch (timeUnit) {
		case "NANOSECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MICROSECONDS);
			break;

		case "MILLISECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.DAYS);
			break;
		default:
			log.error("Entered Time Unit  Not Matched!!");
			break;
		}
		log.info(duration + timeUnit + " Explicit wait is applied!!");
	}

	/**
	 * This method will launch specified url on browser window
	 * 
	 * @param url
	 */
	public static void launchURL() {
		String url = getParameter("BaseURL");
		driver.get(url);
		log.info(url + " is launched!!");
	}

	/**
	 * This method will closer Currently pointing Browser window by driver instance
	 **/
	public static void closeBrowserWindow() {
		driver.close();
		log.info("Current browser window is Closed!!");
	}

	/**
	 * This method will closer all Browser windows opened by driver instance
	 */
	public static void closeAllBrowserWindows() {
		driver.quit();
		log.info("All browser windows are closed!!");
	}

	/**
	 * This method will take screenshot of Failed Test cases
	 * 
	 * @param tcName
	 */
	public static void failedTCScreenshot(String tcName) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY  hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source,
					new File("C:\\Users\\NRK\\javapract\\PriyaRevison\\AAA_PriyaProject\\FailedTCScreenshots\\" + tcName
							+ " dated " + datetime + ".png"));
		} catch (IOException e) {
			log.error("Screenshot file not found!!");
			e.printStackTrace();
		}
		log.info("Screenshot taken Successfully!!");
	}

	/**
	 * This method will navigate the webpage to back
	 */
	public static void navigateBack() {
		driver.navigate().back();
		log.info("Navigated Back!!");
	}

	/**
	 * This method will navigate the webpage to forward
	 */
	public static void navigateForward() {
		driver.navigate().forward();
		log.info("Navigated Forward!!");
	}

	/**
	 * This method will navigate the webpage to specific webpage
	 */
	public static void navigateTo(String url) {
		driver.navigate().to(url);
		;
		log.info("Navigated to Webpage :  " + url);
	}

	/**
	 * This method will navigate the webpage to back
	 */
	public static void refresh() {
		driver.navigate().refresh();
		log.info("Page Refreshed!!");
	}

	/**
	 * This method will return Title of currently pointed window
	 * 
	 * @return:Title of current Window
	 */
	public static String getTitle() {
		String title = driver.getTitle();
		log.info(title + "  :Returned Current Webpage Title!!");
		return title;
	}

	// This method will return path of Screenshot so that from this path captured
	// screenshot can be attached to Extent Report Automatically
	public static String screenshotforExtentReport(WebDriver driver, String tcName) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);

		String screenshotPath = getParameter("failedTCScreenshoFilePath")+tcName + " dated " + datetime + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotPath));
		} catch (IOException e) {
			log.info("Screenshot file not found!!");
			e.printStackTrace();
		}
		log.info("Screenshot taken Successfully!!");

		return screenshotPath;

	}
	
	/** 
	 * This method will read the data from excel.
	 */
	@DataProvider
	public static Object[][] excelFileReading(String filepath) {
		Object[][] data = null;
		try {
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			XSSFRow row = sheet.getRow(0);
			int columns = row.getLastCellNum();
			data = new Object[rows][columns];
			DataFormatter formatter=new DataFormatter();
			for (int i = 0; i < rows; i++) {
				row = sheet.getRow(i);

				for (int j = 0; j < columns; j++) {

					XSSFCell cell = row.getCell(j);
					
					data[i][j]=formatter.formatCellValue(cell);
					
					}

				}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return data;
	}
	
	

}
