package com.hybridFramework.AddMaker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromedriverTest {
	static WebDriver driver;
	public static void main(String[] args) {
   
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ghulam Sarwar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        driver=  new ChromeDriver();
        driver.get("https://google.com");
	}

}
