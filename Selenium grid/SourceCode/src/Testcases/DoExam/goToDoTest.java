package DoExam;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.selenium.webdriven.commands.Click;

import common.Constant;
import common.AbstractTest;
import common.Constant;
import common.CommonActions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.AutomationActions;

public class goToDoTest extends AbstractTest {
	@BeforeClass
//	@Test
	@Parameters({ "browser", "ip", "port"})
	public void SETUP(String browser, String ip, String port) {

		driver = openBrowser(driver, browser, ip, port);
		navigateBrowser(driver, url);
		System.out.println("opened successfully : " + port);
	}

	
	  @Test
	  @Parameters({"pinIndex", "port"}) 
	  public void doAnExam (int pinIndex, String port) throws InterruptedException { 
//		  //======1. Open Do Exam page
//		  //System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//		  //WebDriver driver = new ChromeDriver();
//		  //driver.get(common.Constant.doExamUrl);
//		  
		  // ======2. Enter PIN Thread.sleep(85000); 
//		  Thread.sleep(Constant.SHORT_TIME * 1000);
//		  WebElement element = driver.findElement(EnterPIN.tbxEnterPIN);
		  WebElement element = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(EnterPIN.tbxEnterPIN));
		  element.sendKeys(common.Constant.pin[pinIndex]);  
		   System.out.println("Used PIN : " + common.Constant.pin[pinIndex]); 
//		  Thread.sleep(Constant.SHORT_TIME * 1000);
		  
		  // ======3. Check candidate info //
//		  WebElement element1 = driver.findElement(EnterPIN.btnShowCanInfo);
		  WebElement element1 = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(EnterPIN.btnShowCanInfo));
		  element1.click();
		  Thread.sleep(Constant.SHORT_TIME * 1000);
		  		  
		  // ======4. Next to Guideline screen // WebDriverWait wait1 = new
//		  WebElement element2 = driver.findElement(EnterPIN.btnNext); 
		  WebElement element2 = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(EnterPIN.btnNext));
		  element2.click();
//		  String expectedUrl1 = "http://onlinetest.logigear.com/user/guideline/" + common.Constant.pin[pinIndex];
//		  Boolean test = true;
//		  while (test) {
//			  String openedUrl1 = driver.getCurrentUrl();
//			  element2.click();
//			  if(openedUrl1.equals(expectedUrl1)){
//				 test = false; 
//			  }
//		  }
			  
		  		  
//		  Thread.sleep(Constant.SHORT_TIME * 1000);
		  		  
		  // ======5. Start the test 
//		  WebElement element3 = driver.findElement(Guideline.btnStart); 
		  WebElement element3 = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(Guideline.btnStart));
		  element3.click();
		  
//		  Thread.sleep(Constant.SHORT_TIME * 1000);
//		  String expectedUrl = "http://onlinetest.logigear.com/user/doExam";
//		  String openedUrl = driver.getCurrentUrl();
//		  System.out.println("openedUrl : " + openedUrl);
//		  if( openedUrl.equals(expectedUrl)) {
		  if(driver.findElements(DoExam.btnFinish).size() != 0){
			  System.out.println("load exam successfully : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port); 
//			  driver.quit();
		  }
		  else{
			  System.out.println("load exam unsuccessfully : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port);
		  }
//		  Thread.sleep(Constant.SHORT_TIME * 1000);
//		  
		  //====update answers for Paired Reading sub-section==== 
			for (int i = 1; i <= 7; i++) { 
				String answerxpath = "//div[@class='section-container']/div[1]//div[@class='card-body border-container']/div[1]//div[@class='full-width']["+ i + "]//label[text()='A']"; 
//				WebElement answer =  driver.findElement(By.xpath(answerxpath)); 
//				WebDriverWait wait4 = new WebDriverWait(driver, 20);
//				wait4.until(ExpectedConditions.visibilityOf(answer));
				
				WebElement answer = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(answerxpath)));
				answer.click(); 
//				Thread.sleep(Constant.SHORT_TIME * 1000);
			}
//		  
//		  //====update answers for Article Reading sub-section==== 
			for (int j = 1; j <= 8; j++) { 
				String answerxpath = "//div[@class='section-container']/div[1]//div[@class='card-body border-container']/div[2]//div[@class='full-width'][" + j + "]//label[text()='A']"; 
//				WebElement answer =  driver.findElement(By.xpath(answerxpath)); 
				WebElement answer = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(answerxpath)));
				answer.click(); 
//				Thread.sleep(Constant.SLEEP_UpdateAnswer);
			}
			System.out.println("do reading test successfully : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port); 
//			Thread.sleep(Constant.SHORT_TIME * 1000);
//		  
//		  //====update answers for Conversation sections ==== 
			for (int i = 1; i <= 3; i++) { 
				String xpathPlayButton = "//label[text()='" + i + ". ' and text()='Conversation']/../../button";	  
//				WebElement btnPlay = driver.findElement(By.xpath(xpathPlayButton));
				WebElement btnPlay = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathPlayButton)));
				btnPlay.click(); 
				Thread.sleep(Constant.QUICK_SLEEP * 1000);
		  
				for (int j = 1; j <= 3; j++) { 
					String answerxpath = "//div[@class='section-container']/div[2]//div[@class='card-body border-container']/div[" + i +"]//div[@class='full-width'][" + j + "]//label[text()='A']"; 
//					WebElement answer = driver.findElement(By.xpath(answerxpath)); 
//					WebDriverWait wait = new WebDriverWait(driver, Constant.waitControl_TIME);
//					WebElement answer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(answerxpath)));
					WebElement answer = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(answerxpath)));
					answer.click(); 
					Thread.sleep(Constant.SLEEP_UpdateAnswer);
				} 
			}
			System.out.println("do Conversation listening test successfully : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port); 
//		  
//		  //====update answers for Short speech sections ==== 
			for (int i = 4; i <= 5; i++) { 
				String xpathPlayButton1 = "//label[text()='" + i + ". ' and text()='Short speech']/../../button";
//				WebElement btnPlay1 = driver.findElement(By.xpath(xpathPlayButton1));
				WebElement btnPlay1 = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathPlayButton1)));
				btnPlay1.click(); 
				Thread.sleep(Constant.QUICK_SLEEP * 1000);
		  
				for (int j = 1; j <= 3; j++) { 
					String answerxpath = "//div[@class='section-container']/div[2]//div[@class='card-body border-container']/div[" + i +"]//div[@class='full-width'][" + j + "]//label[text()='A']"; 
//					WebElement answer = driver.findElement(By.xpath(answerxpath)); 
					WebElement answer = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(answerxpath)));
					answer.click(); 
					Thread.sleep(Constant.SLEEP_UpdateAnswer);
					}
		    }
			System.out.println("do short speech listening test successfully : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port); 
//		  
////		  //==== Do writing test==== 
//			for (int i = 1; i <= 2; i++) { 
//				//==== Add and Save Email writing ==== 
////				WebElement email = driver.findElement(DoExam.areaEmail);
//				WebElement email = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(DoExam.areaEmail));
//				email.sendKeys("Hanh test Email writing " + i); 
//				email.sendKeys(Keys.RETURN);
////				WebElement btnSaveEmail = driver.findElement(DoExam.btnSaveEmail);
//				WebElement btnSaveEmail = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(DoExam.btnSaveEmail));
//				btnSaveEmail.click();
////				Thread.sleep(Constant.QUICK_SLEEP * 1000);
//		  
//				//==== Add and Save Essay writing ==== 
////				WebElement essay = driver.findElement(DoExam.areaEssay1);
//				WebElement essay = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(DoExam.areaEssay1));
//				essay.sendKeys("Hanh test Essay writing " + i); essay.sendKeys(Keys.RETURN);
////				WebElement btnSaveEssay = driver.findElement(DoExam.btnSaveEssay1);
//				WebElement btnSaveEssay = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(DoExam.btnSaveEssay1));
//				btnSaveEssay.click(); 
////				Thread.sleep(500);
//			}
//			System.out.println("do writing test successfully : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port); 
//		  
//		  //==== Finish exam ==== 
//			WebElement btnFinish = driver.findElement(DoExam.btnFinish); 
			WebElement btnFinish = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(DoExam.btnFinish));
			btnFinish.click();
//			WebElement btnConfirm = driver.findElement(DoExam.btnConfirmFinish);
			WebElement btnConfirm = (new WebDriverWait(driver, Constant.waitControl_TIME)).until(ExpectedConditions.presenceOfElementLocated(DoExam.btnConfirmFinish));
			btnConfirm.click(); 
			Thread.sleep(Constant.MEDIUM_TIME * 1000);
		  	System.out.println("The test has been done : " + pinIndex + " " + common.Constant.pin[pinIndex] + " on " + port); 
//		  	
//		  	//==== Close browser ==== 
		  	driver.quit();
	  }	

	  
	
//	  @AfterClass public void CLEAN() { driver.quit(); }
	 

	/* Initialize Objects */
	WebDriver driver;

	/* Class Variables */
	String url = CommonActions.readDataFromXML("urlBap");
}
