package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class Constant{

		/*===============common info===============*/
		public static String[] pin = {"c7ccfd","c7d4cd","c7dc9d","c7e46d","c7ec3e","c7f40e","c7fbde","c803ae","c80b7e","c8134f","c81b1f","c822ef","c82abf","c8328f"};
		public static final String doExamUrl = "http://onlinetest.logigear.com/user";
		
		
		/*=====================Time=====================*/
		public static final Integer SLEEP_UpdateAnswer = 500;
		public static final Integer QUICK_SLEEP = 1;
		public static final Integer SHORT_TIME = 3;
		public static final Integer MEDIUM_TIME = 7;
		public static final Integer LONG_TIME = 30;
		public static final Integer waitControl_TIME = 60;
		
		/*=====================WebDriver=====================*/
		public static WebDriver driver = null;
		public static String sessionID = null;
		public static String className=null;
		
		/*====================Files=====================*/
		public static final String JSON_FILE = "src\\Resources\\test.data.json";
		public static final String XML_FILE = "src\\Resources\\automation.configuration.xml";
		
		/*===================*/
		
			   
}
