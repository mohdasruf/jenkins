package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.automation.BrowserType;
import com.automation.DriverContext;
import com.automation.FrameworkInitialize;
import com.pages.SearchResultPage;
import com.pages.WikipediaPage;

import org.junit.Assert;

public class WikiTests extends FrameworkInitialize {

	private WikipediaPage wikiPediaPage = null;
	private SearchResultPage searchResultPage = null;
	private String searchString = "Apple";
	private String searchLanguage = "en";

	@Before
	public void Initialize() {
		InitializeBrowser(BrowserType.Chrome);
		DriverContext.Browser.GoToUrl("https://www.wikipedia.org/");
		wikiPediaPage = new WikipediaPage();
	}

	@Test
	public void test1() {
		System.out.println("Driver1 :" + DriverContext.Driver.toString());
		wikiPediaPage.enterSearchInput(searchString);
		wikiPediaPage.selectLanguage(searchLanguage);
		searchResultPage = wikiPediaPage.submitSearch();
		Assert.assertTrue("Title is not as expected", searchResultPage.getHeadingText().equalsIgnoreCase(searchString));
		Assert.assertTrue("Language is not as expected",
				searchResultPage.getLangAttribute().equalsIgnoreCase(searchLanguage));
		searchResultPage.selectLanguage();
		Assert.assertTrue("Link for English is not present", searchResultPage.checkLangAttribute(searchLanguage));
	}
	
	@Test
	public void test2() {
		System.out.println("Driver2 :" + DriverContext.Driver.toString());
		wikiPediaPage.enterSearchInput(searchString);
		wikiPediaPage.selectLanguage(searchLanguage);
	}

	@After
	public void finish() {
		DriverContext.Driver.close();
	}
}
