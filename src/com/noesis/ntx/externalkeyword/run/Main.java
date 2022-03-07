package com.noesis.ntx.externalkeyword.run;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//Export this file to a JAR file and fill the "Secondary Data" field in NTX with the path to the jar
			
			boolean passed = true;
			String sessionId = args[0];
			String url = args[1];
			String xpath = args [2]; //Xpath received from NTX, if you don't select an object in NTX the "xpath" variable will be "xxxxx"
			String inputData = args [3]; //Input Data received from NTX, if you don't fill the "Input Data" field in NTX the "inputData" variable will be "xxxxx"
			String tertiaryData = args [4]; //Tertiary Data received from NTX, if you don't fill the "Tertiary Data" field in NTX the "tertiaryData" variable will be "xxxxx"
			
			SessionId session_id = new SessionId(sessionId);
			URL urlSelenium = new URL(url);
			
			RemoteWebDriver driver = CreateDriver.createDriverFromSession(session_id, urlSelenium);
		    
			//Write your code here, example:	
						
			//driver.get("http://abcdef123456.com");	    
			//WebElement element = getElement(xpath,driver);
			//element.click();
			
			//if the step is OK, response with "Passed" ->  System.out.prinln("Passed");
			if(passed){
				System.out.println("Passed");
			}
			//if the step Fails, response with something else than "Passed" ->  System.out.prinln("Write the error");
			else{
				System.out.println("Error Message..");
			}
			return;
		    
	    
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
	
	private static WebElement getElement(String xpath, WebDriver driver) throws Exception{
		
		try {
			WebElement element = null;
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			} catch (Exception e) {				
				throw new Exception("Element not found: " + e.getMessage());
			}
			
			element = driver.findElement(By.xpath(xpath));
			            
			return element;
		} catch (NoSuchElementException e) {			
			throw new Exception("Element not found: " + e.getMessage());
		}
	}
}
