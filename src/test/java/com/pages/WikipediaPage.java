package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.automation.BasePage;

public class WikipediaPage extends BasePage {

	@FindBy(how = How.ID, using = "searchInput")
	public WebElement search;

	@FindBy(how = How.ID, using = "searchLanguage")
	public WebElement selectLanguage;

	@FindBy(how = How.CLASS_NAME, using = "pure-button")
	public WebElement submitButton;

	public void selectLanguage(String value) {
		Select oSelect = new Select(selectLanguage);
		oSelect.selectByValue(value);
	}

	public SearchResultPage submitSearch() {
		submitButton.click();
		return new SearchResultPage();
	}

	public void enterSearchInput(String searchInput) {
		search.sendKeys(searchInput);
	}
}