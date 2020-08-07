package DoExam;

import org.openqa.selenium.By;

public class DoExam {
	
	/*=================Finish exam==============*/
	public static By btnFinish = By.xpath("//div/button[text()='Finish']");
	public static By btnConfirmFinish = By.xpath("//span/button[text()='Yes']");
	
	/*=================Answer selection==============*/
	public static By cbxAnswerA = By.xpath("//div[@class='answer-container']//label[text()='A']");
	public static By cbxAnswerB = By.xpath("//div[@class='answer-container']//label[text()='B']");
	public static By cbxAnswerC = By.xpath("//div[@class='answer-container']//label[text()='C']");
	public static By cbxAnswerD = By.xpath("//div[@class='answer-container']//label[text()='D']");
	public static By cbxansA = By.xpath("//div[@class='section-container']/div[1]//div[@class='card-body border-container']/div[1]//div[@class='full-width'][4]//label[text()='A']");

	
	/*=================Play audio==============*/	
	public static By btnPlayConversation1 = By.xpath("//label[text()='1. ' and text()='Conversation']/../../button");
	public static By btnPlayConversation2 = By.xpath("//label[text()='2. ' and text()='Conversation']/../../button");
	public static By btnPlayConversation3 = By.xpath("//label[text()='3. ' and text()='Conversation']/../../button");
	public static By btnPlayShortSpeech1 = By.xpath("//label[text()='1. ' and text()='Short speech']/../../button");
	public static By btnPlayShortSpeech2 = By.xpath("//label[text()='2. ' and text()='Short speech']/../../button");
	
	/*=================Writing section==============*/
	public static By areaEmail = By.xpath("//label[text()='Email']/../../textarea");
	public static By btnSaveEmail = By.xpath("//label[text()='Email']/../../button");
	public static By areaEssay1 = By.xpath("//label[text()='1. ' and text()='Essay']/../../textarea");
	public static By btnSaveEssay1 = By.xpath("//label[text()='1. ' and text()='Essay']/../../button");
	/*==========section hyperlink=========*/
	//public static By linkPairedReading = By.xpath("//label[text()='Email']/../../button");
	//Paired reading
}
