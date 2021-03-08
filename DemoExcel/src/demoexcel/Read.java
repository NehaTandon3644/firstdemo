package demoexcel;

import java.io.FileInputStream;
//import java.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import jxl.Sheet;
import jxl.Workbook;




public class Read {
	
	
	 public static void main(String[] args) throws Exception {

		  System.setProperty("webdriver.chrome.driver","C:\\Users\\nehat\\Downloads\\chromedriver_win32/chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		 //System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.0-win64/geckodriver.exe");
		 //WebDriver driver = new FirefoxDriver();
		    driver.get("https://www.facebook.com/");
		    Thread.sleep(3000);
			FileInputStream file = new FileInputStream("E:\\Excel\\testing.xls");
			 
			Workbook wl = Workbook.getWorkbook(file);

			Sheet s1 = wl.getSheet(0); 
			
			String username =s1.getCell(0,1).getContents();
			String password =s1.getCell(1,1).getContents();
			
			driver.navigate().to("https://www.facebook.com/");
		
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
			Thread.sleep(2000);
			System.out.println(username);
			
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
			Thread.sleep(2000);
			System.out.println(password);
			
			driver.findElement(By.name("login")).click();	
			Thread.sleep(2000);
			driver.quit();
		
	}
}
