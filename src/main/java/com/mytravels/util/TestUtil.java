package com.mytravels.util;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestUtil {

	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> elements;
	public static Set<String> allWindows;
	public static FluentWait wait;
	public static Actions action;
	public static Select select;
	public static Properties prop;
	public static  ExtentHtmlReporter htmlReporter;
	public  static ExtentReports extent;
	public  static ExtentTest extentLog;
	

	public static String browserName = "chrome";
	public static String baseURL = "https://crm.mytravelstime.com/";
	public static long implicitWaitDuration = 20;
	public static String implicitWaitTimeUnit = "SECONDS";
	public static long explicitWaitDuration = 20;
	public static String explicitWaitTimeUnit = "SECONDS";
	public static long pageLoadTimeOutDuration = 20;
	public static String pageLoadTimeOutUnit = "SECONDS";

	public static String failedTCScreenshoFilePath = System.getProperty("user.dir") + "//FailedTC//";
	public static String exelPath = System.getProperty("user.dir") +"TestData//signin.xlxs";

	public static String email_Id = "sushanttayade123@gmail.com";
	public static String password = "sushant.123";

}
