package configuration;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import common.CommonActions;
import common.Constant;

public class TestNGITestListener implements ITestListener {
	WebDriver driver = null;
	String filePath = "src\\screenshot\\";

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();

		Capabilities cap = ((RemoteWebDriver) Constant.driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();

		takeScreenShot(browserName + "_" + methodName + " " + CommonActions.getDateTime("yyyy-MM-dd HH-mm-ss"),
				result.getTestClass().getName(), result.getMethod().getMethodName());
	
	}

	public void takeScreenShot(String methodName, String testclass, String testmethod) {
		File scrFile = (((TakesScreenshot) Constant.driver).getScreenshotAs(OutputType.FILE));
		BufferedImage image = null;
		try {
			image = ImageIO.read(scrFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graphics g = image.getGraphics();
		g.setColor(Color.red);
		g.setFont(new Font("SansSerif", Font.BOLD, 30));
		g.drawString("Class: " + testclass, 50, 800);
		g.drawString("Method: " + testmethod, 50, 850);
		g.dispose();
		try {
			ImageIO.write(image, "png", new File(filePath + methodName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void onFinish(ITestContext context) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		/*
		 * try { Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe"
		 * ); Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe"); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}
}