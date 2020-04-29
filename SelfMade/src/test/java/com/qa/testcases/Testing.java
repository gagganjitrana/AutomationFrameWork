package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.allPages.HomePage;
import com.qa.base.TestBase;

public class Testing extends TestBase {


	
	@Test
	public void test()
	{
		TestBase.selectBrowser();
		HomePage hp = new HomePage();
		System.out.println(hp.getTitle1());
		hp.navigateTOJQuery();
		TestBase.closeBrowser();
		
	
	}
	
	

}
