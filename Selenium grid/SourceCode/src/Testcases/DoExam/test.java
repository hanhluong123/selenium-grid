package DoExam;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.Keys;

import common.Constant;

public class test {
	String[] pin = {"7cc241","7cca11","7cd1e1","7cd9b1","7ce182","7ce952","7cf122","7cf8f2","7d00c2","7d0893"};
	@Test
	public void testEnterPin() throws InterruptedException {
		// ======1. Open Do Exam page
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(common.Constant.doExamUrl);
		
		

		// ======2. Enter PIN

		String[] pinUpdate = pin;
		WebElement element = driver.findElement(EnterPIN.tbxEnterPIN);
		element.sendKeys(pin[0]);
		pinUpdate = ArrayUtils.remove(pinUpdate, 0);
		System.out.println("Content of Array after removing an object : " + Arrays.toString(pinUpdate));
		

		// ======3. Check candidate info
		WebElement element1 = driver.findElement(EnterPIN.btnShowCanInfo);
		element1.click();

		// ======4. Next to Guideline screen
		Thread.sleep(Constant.QUICK_SLEEP * 1000);
		WebElement element2 = driver.findElement(EnterPIN.btnNext);
		element2.click();

		// ======5. Start the test
		WebElement element3 = driver.findElement(Guideline.btnStart);
		element3.click();

		Thread.sleep(Constant.SHORT_TIME * 1000);
		/* ====update answers for Paired Reading sub-section==== */
		for (int i = 1; i <= 7; i++) {
			String answerxpath = "//div[@class='section-container']/div[1]//div[@class='card-body border-container']/div[1]//div[@class='full-width']["
					+ i + "]//label[text()='A']";
			WebElement answer = driver.findElement(By.xpath(answerxpath));
			answer.click();
		}

		/* ====update answers for Article Reading sub-section==== */
		for (int j = 1; j <= 8; j++) {
			String answerxpath = "//div[@class='section-container']/div[1]//div[@class='card-body border-container']/div[2]//div[@class='full-width']["
					+ j + "]//label[text()='A']";
			WebElement answer = driver.findElement(By.xpath(answerxpath));
			answer.click();
		}

		/* ====update answers for Conversation sections ==== */
		for (int i = 1; i <= 3; i++) {
			String xpathPlayButton = "//label[text()='" + i + ". ' and text()='Conversation']/../../button";
		
			WebElement btnPlay = driver.findElement(By.xpath(xpathPlayButton));
			btnPlay.click();
			Thread.sleep(Constant.QUICK_SLEEP * 1000);
				
			for (int j = 1; j <= 3; j++) {
				String answerxpath = "//div[@class='section-container']/div[2]//div[@class='card-body border-container']/div["+ i +"]//div[@class='full-width'][" + j
						+ "]//label[text()='A']";
				WebElement answer = driver.findElement(By.xpath(answerxpath));
				answer.click();
			}
		}
		
		/* ====update answers for Short speech sections ==== */
		for (int i = 4; i <= 5; i++) {
			String xpathPlayButton1 = "//label[text()='" + i + ". ' and text()='Short speech']/../../button";
		
			WebElement btnPlay1 = driver.findElement(By.xpath(xpathPlayButton1));
			btnPlay1.click();
			Thread.sleep(Constant.QUICK_SLEEP * 1000);
				
			for (int j = 1; j <= 3; j++) {
				String answerxpath = "//div[@class='section-container']/div[2]//div[@class='card-body border-container']/div["+ i +"]//div[@class='full-width'][" + j
						+ "]//label[text()='A']";
				WebElement answer = driver.findElement(By.xpath(answerxpath));
				answer.click();
			}
			
		}

		/* ==== Do writing test==== */
		for (int i = 1; i <= 10; i++) {
			/* ==== Add and Save Email writing ==== */
			WebElement email = driver.findElement(DoExam.areaEmail);
			email.sendKeys("Hanh test Email writing " + i);
			email.sendKeys(Keys.RETURN);
			WebElement btnSaveEmail = driver.findElement(DoExam.btnSaveEmail);
			btnSaveEmail.click();
			
			/* ==== Add and Save Essay writing ==== */
			WebElement essay = driver.findElement(DoExam.areaEssay1);
			essay.sendKeys("Hanh test Essay writing " + i);
			essay.sendKeys(Keys.RETURN);
			WebElement btnSaveEssay = driver.findElement(DoExam.btnSaveEssay1);
			btnSaveEssay.click();
		}
		
		/* ==== Finish exam ==== */
		WebElement btnFinish = driver.findElement(DoExam.btnFinish);
		btnFinish.click();		
		
		WebElement btnConfirm = driver.findElement(DoExam.btnConfirmFinish);
		btnConfirm.click();		
	}

}
