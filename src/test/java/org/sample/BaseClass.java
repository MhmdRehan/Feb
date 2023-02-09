package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void close() {
		driver.close();
	}

	public static void passValue(WebElement ele, String val) {
		ele.sendKeys(val);

	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void moveCursor(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	public static void doubleClick(WebElement ele) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	public static void switchFrame(int ind) {
		driver.switchTo().frame(ind);
	}

	public static void snap(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\moham\\eclipse-workspace\\Maven6pm\\Images\\" + name + ".png");
		FileUtils.copyFile(temp, dest);
	}

	public static void jsPassValue(String value, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('value','" + value + "')", ele);

	}

	public static void childWind(int ind) {
		Set<String> allWind = driver.getWindowHandles();
		List<String> li = new ArrayList();

		li.addAll(allWind);
		driver.switchTo().window(li.get(ind));

	}

	public static String readFromExcel(int stName,int rw,int cl) throws IOException {
		File f = new File("C:\\Users\\moham\\eclipse-workspace\\Maven6pm\\XLSheet\\DataDriven.xlsx");
		FileInputStream fis = new FileInputStream(f);  
		Workbook w = new XSSFWorkbook(fis);  
		Sheet s = w.getSheetAt(stName);
		Row r = s.getRow(rw);
		Cell c = r.getCell(cl);  
		int type = c.getCellType(); 
		String name="";  //global usage
		if (type==1) {
			 name = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			name = sdf.format(d);	
		}
		else {
			double num = c.getNumericCellValue();
			long l =(long)num;
			name = String.valueOf(l);	
		}
		return name;
	}
	
	public static void overWrite(int st,int rw,int cl,String cond,String val) throws IOException {
		File f = new File("C:\\Users\\moham\\eclipse-workspace\\Maven6pm\\XLSheet\\DataDriven.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet s = w.getSheetAt(st);
		
		Row r = s.getRow(rw);
		
		Cell c = r.getCell(cl); 
		
		String value = c.getStringCellValue();
		
		if (value.equals(cond)) {
			c.setCellValue(val);
			
		}
		
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}
	
	
	
	
	
	
	

}
