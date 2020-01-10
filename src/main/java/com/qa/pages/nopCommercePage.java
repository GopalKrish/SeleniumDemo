package com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utility.Webgenericutility;
import com.qa.basetest.BaseTest;

import Trash.ReadExcel;

import org.apache.log4j.Logger;

public class nopCommercePage extends BaseTest {	

	Logger log = Logger.getLogger("devpinoyLogger");

	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[text()='Electronics ']")

	WebElement electronics;


	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[contains(text(),'Cell phones')]")

	WebElement cellphone;


	public nopCommercePage(){

		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	//this method clicks on the electronics submenu
	public void clickCellphone(){

		//electronics.click();
		Webgenericutility.mouseHover(electronics);
		cellphone.click();
		String exptedTitle = "nopCommerce demo store. Cell phones";
		String actualTilte = driver.getTitle();
		System.out.println("current page title: " +actualTilte);
		Assert.assertEquals(actualTilte, exptedTitle);




	}		

}


