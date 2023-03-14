package com.dotKonnekt.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;



public class ListenersClass extends ExtentManager implements ITestListener {
	//WebDriver driver;
	Action action = new Action();
	 public void onTestStart(ITestResult result) {
		  test = extent.createTest(result.getName());
		 }
	 
		 public void onTestSuccess(ITestResult result) {
		  if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Pass Test case is: " + result.getName());
		  }
		 }
		 
		 public void onTestFailure(ITestResult result) {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		   test.log(Status.FAIL,
		     MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			
			  String pathString;
			  
			  pathString = Action.screenShot(BaseClass.getDriver(), result.getName());
			  
			  test.addScreenCaptureFromPath(pathString);
			  test.fail("ScreenShot is Attached" );
			
			 
		  }
		 }
		 

		 public void onTestSkipped(ITestResult result) {
		  if (result.getStatus() == ITestResult.SKIP) {
		   test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		  }
		 }
		 
		 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  // TODO Auto-generated method stub
		 }
		 
		 public void onStart(ITestContext context) {
			 //test.log(Status.INFO, "Status is going on");
		 }
		 
		 public void onFinish(ITestContext context) {
		  // TODO Auto-generated method stub
		 }
		 
		 
		 
}
