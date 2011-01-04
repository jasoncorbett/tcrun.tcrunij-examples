package org.tcrun.example.usingabstract;

import java.net.URL;
import java.net.URLEncoder;
import org.tcrun.tcapi.selenium.FindBy;
import org.tcrun.tcapi.selenium.PageElement;
import org.tcrun.tcapi.selenium.SelfAwarePage;
import org.tcrun.tcapi.selenium.WebDriverWrapper;

/**
 * Page class representing the web page at "http://www.google.com"
 *
 * @author jcorbett
 */
public class GoogleSearchPage implements SelfAwarePage<String>
{
	public static PageElement SearchField = new PageElement("Google Search Field", FindBy.name("q"));
	public static PageElement GoogleSearchButton = new PageElement("Google Search Button", FindBy.name("btnG"));

	public static PageElement OriginalTermLink = new PageElement("Search for original term link", FindBy.id("msg_box_entered"));

	public static PageElement SearchResults = new PageElement("Search results span", FindBy.id("search"));

	public static PageElement resultByUrl(String url) throws Exception
	{
		return new PageElement("Result for url " + url, FindBy.hrefContains(url));
	}

	@Override
	public boolean isCurrentPage(WebDriverWrapper browser)
	{
		return browser.exists(SearchField, false);
	}

	@Override
	public void handlePage(WebDriverWrapper browser, String context) throws Exception
	{
		browser.type(SearchField, context);
		if(!SearchResults.exists(browser.getDriver(), 2))
		{
			// live search must not be on, click on the Google Search Button
			browser.click(GoogleSearchButton);
		}
	}

}
