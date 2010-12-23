package org.tcrun.examples.simple.selenium2;

import org.tcrun.tcapi.selenium.PageElement;
import org.tcrun.tcapi.selenium.SelfAwarePage;
import org.tcrun.tcapi.selenium.WebDriverWrapper;
import org.tcrun.tcapi.selenium.FindBy;

/**
 *
 * @author jcorbett
 */
public class YPHomePage implements SelfAwarePage<Object>
{
	public static PageElement SearchTermField = new PageElement("Search Term Field", FindBy.id("search-terms"));
	public static PageElement SearchLocationField = new PageElement("Search Location Field", FindBy.id("search-location"));
	public static PageElement FindButton = new PageElement("Find Button", FindBy.id("search-submit"));

	// Ajax Elements
	public static PageElement firstLocationContaining(String part)
	{
		return new PageElement("Location result containing " + part, FindBy.xpath("(//li[contains(text(), \"" + part + "\")])[1]" ));
	}


	@Override
	public boolean isCurrentPage(WebDriverWrapper browser)
	{
		return browser.exists(SearchTermField, false) && browser.exists(SearchLocationField, false);
	}

	@Override
	public void handlePage(WebDriverWrapper browser, Object context) throws Exception
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
