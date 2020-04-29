package com.qa.allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	// Using pagefacotry to provide all the elements on the page (also known as object repository )
	// In Page factory we use @findBy annotation to provide the element locator.
	
	@FindBy(xpath="//a[contains(text(),'Demo Home')]")
	WebElement DemoHomebutton;
	
	@FindBy(xpath = "//li[@class='tree-branch']//a[contains(text(),'Input Forms')]")
	WebElement InputForms;
	
	
	@FindBy(xpath="//li[@class='tree-branch']//a[contains(text(),'JQuery Select dropdown')]")
	WebElement JquerySelectDropdown;
	
	// In order to initalize all webelemnts created using page factory, we need to create a class constructor and call init()
	
	public HomePage() {
		PageFactory.initElements(driver,this); 
	}
	
	public String getTitle1()
	{
		//return driver.getTitle();
		return null;
	}
	
	public void navigateTOJQuery()
	{
		InputForms.click();
		JquerySelectDropdown.click();
	}
}
