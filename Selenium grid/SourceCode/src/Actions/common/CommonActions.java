package common;

import common.JsonHelper;
import common.XMLHelper;
import common.Constant;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonActions {

	/**
	 * Method to read data from xml file
	 * 
	 * @param configData
	 * @return
	 */
	public static String readDataFromXML(String configData) {

		String file = Constant.XML_FILE;
		return XMLHelper.readDataFromXML(file, configData);
	}

	/**
	 * Method to read data from json file
	 * 
	 * @param node
	 * @param variable
	 * @return
	 * 
	 */
	public static String readDataFromJson(String node, String variable) {
		String file = Constant.JSON_FILE;
		return JsonHelper.getJsonObjectValue(file, node, variable);
	}

	/**
	 * Method to get date time of system
	 * 
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
		Date date = new Date();
		String getText = dateFormat.format(date);
		return getText;
	}

	/**
	 * get Date & Time in given format
	 * 
	 * @param format
	 * @return
	 */
	public static String getDateTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		String getText = dateFormat.format(date);
		return getText;
	}

	/**
	 * generate Random Number
	 * 
	 * @return
	 */
	public static Integer generateRandomNumber() {
		Random rndNum = new Random();
		return rndNum.nextInt();
	}

	/**
	 * generate Random Number
	 * 
	 * @param maxValue
	 * @return
	 */
	public static Integer generateRandomNumber(Integer maxValue) {
		Random rndNum = new Random();
		return rndNum.nextInt(maxValue);
	}

	/**
	 * 
	 * @param input
	 * @param chars
	 * @return
	 */
	public static String removeSpecialChars(String input, String chars) {
		return input.replaceAll(chars, "");
	}
}