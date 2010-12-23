package org.tcrun.examples.simple.selenium2;

import org.tcrun.tcapi.selenium.FindBy;
import org.tcrun.tcapi.selenium.PageElement;
import org.tcrun.tcapi.selenium.SelfAwarePage;
import org.tcrun.tcapi.selenium.WebDriverWrapper;

/**
 *
 * @author jcorbett
 */
public class YPSearchResultsPage implements SelfAwarePage<Object>
{
	public static PageElement ResultsDiv = new PageElement("Div that contains all search results", FindBy.id("results"));

	@Override
	public boolean isCurrentPage(WebDriverWrapper browser)
	{
		return browser.exists(ResultsDiv);
	}

	@Override
	public void handlePage(WebDriverWrapper browser, Object context) throws Exception
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
