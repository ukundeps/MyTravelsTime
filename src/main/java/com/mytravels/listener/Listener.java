package com.mytravels.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listener  implements ITestListener{
		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("Test Case Execution Started : " + result.getName());

		}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("Test Case Execution Successed : " + result.getName());
		}

		@Override
		public void onTestFailure(ITestResult result) {
			System.out.println("Test Case Execution Failed : " + result.getName());
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println("Test Case Execution Skipped : " + result.getName());
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		}

		@Override
		public void onStart(ITestContext context) {

		}

		@Override
		public void onFinish(ITestContext context) {

		}

	}

