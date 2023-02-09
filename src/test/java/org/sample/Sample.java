package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//Way-1
//@RunWith(Suite.class)
//@SuiteClasses({Amazon.class,Flipkart.class,LaunchBrowser.class})

public class Sample extends BaseClass{
	
//Way-2
	@Test
	public void execute() {
		Result r = JUnitCore.runClasses(Amazon.class,Flipkart.class,LaunchBrowser.class);

		System.out.println(r.getFailureCount());
		System.out.println(r.getRunTime());
		System.out.println(r.getIgnoreCount());
		List<Failure> fails = r.getFailures();
		
		for (int i = 0; i < fails.size(); i++) {
			Failure fail = fails.get(i);
			String ss = fail.getMessage();
			System.out.println(ss);
		}
		
	}
	
		
	}

