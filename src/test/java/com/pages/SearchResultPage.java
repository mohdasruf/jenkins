package com.pages;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.BasePage;
import com.automation.DriverContext;


public class SearchResultPage extends BasePage {

	@FindBy(how = How.ID, using = "firstHeading")
	public WebElement firstHeading;

	@FindBy(how = How.XPATH, using = "//*[@id='p-lang']/div/ul/li/a")
	public List<WebElement> languageList;

	public String getHeadingText() {
		return firstHeading.getText();
	}

	public String getLangAttribute() {
		return firstHeading.getAttribute("lang");
	}

	public void selectLanguage() {
        JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;		
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("arguments[0].click();", languageList.get(0));
	}

	public boolean checkLangAttribute(String value) {
		Optional<WebElement> element = languageList.stream().filter(elem -> elem.getAttribute("lang").equals(value))
				.findFirst();
		return element.isPresent();
	}
}