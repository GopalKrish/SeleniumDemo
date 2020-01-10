package com.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.qa.Utility.ExcelUtility;
import com.qa.Utility.Webgenericutility;
import com.qa.basetest.BaseTest;

public class CellPhonesPage extends BaseTest {
Webgenericutility webTestUtil = new Webgenericutility();
ExcelUtility excellUtility = new ExcelUtility();
private final static Logger log = Logger.getLogger(CellPhonesPage.class);

public CellPhonesPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Cell phones')]")
WebElement CellPhone;
@FindBy(xpath = "//select[@id='products-orderby']")
WebElement cellPhoneSort;
@FindBy(xpath = "//input[@value='Add to cart']")
WebElement AddProduct;
@FindBy(xpath = "//span[@class='price actual-price']")
WebElement PriceofProdcut;
@FindBy(xpath = "//div[@class='item-grid']")
WebElement ProductTable;
@FindBy(xpath = "//div[@class='bar-notification success']/p[text()='The product has been added to your ']")
WebElement barnotification;

public void selectLPCellphone() {
// CellPhone.click();
webTestUtil.waitForLoad(2000);
cellPhoneSort.click();
log.info("cellPhoneSort by low price to high price");
Select s = new Select(cellPhoneSort);
// List<WebElement> sortByOptions = s.getOptions();
s.selectByIndex(3);
}

public void ProductPrice() {
List<WebElement> price = driver.findElements(By.xpath("//span[@class='price actual-price']"));
List<WebElement> product = driver.findElements(By.xpath("//h2[@class='product-title']"));
for (int i = 0; i < price.size(); i++) {
String ProductnamePrice = product.get(i).getText() + "-" + price.get(i).getText().toString();
System.out.println(ProductnamePrice);
}
}

public void sortPrice() {
List<String> currentOptions = new ArrayList<String>();
List<WebElement> price = driver.findElements(By.xpath("//span[@class='price actual-price']"));
for (WebElement option : price) {
currentOptions.add(option.getText());
Collections.sort(currentOptions);
}
for (int i = 0; i < currentOptions.size(); i++) {
log.info("sortPrice");
System.out.println("Price" + currentOptions.get(i));
}
}

public void AddToCart() throws InterruptedException {
List<String> cartOptions = new ArrayList<String>();
List<WebElement> cartList = driver.findElements(By.xpath("//input[@value='Add to cart']"));
int j = cartList.size();
System.out.println(j);
for (int i = 0; i < cartList.size(); i++) {
// System.out.println(cartList.get(i).getText());
cartList.get(i).click();
Thread.sleep(3000);
String NotificationText = barnotification.getText();
System.out.println(NotificationText);
Assert.assertEquals(NotificationText, "The product has been added to your shopping cart");
log.info("Adding the cell to cart");
}
}

}