package org.tcrun.examples.simple.selenium2;

import java.util.UUID;
import org.tcrun.tcapi.TestResult;
import org.tcrun.tcapi.selenium.AbstractSeleniumTest;
import org.tcrun.tcapi.selenium.PageElement;
import static org.tcrun.tcapi.assertlib.MatchBuilder.*;

/**
 *
 * @author jcorbett
 */
public class SearchForIntuit extends AbstractSeleniumTest
{
	private String url;

	@Override
	public void setup() throws Exception
	{
		url = configValue("URL.yp", "http://yp.com");
	}

	@Override
	public TestResult test() throws Exception
	{
		step("Going to Yellow Pages Website " + url, "We end on a page that has the form we are expecting.");
		browser.goTo(url);
		check.that(browser.isCurrentPage(YPHomePage.class), Is.True());

		step("Type search term \"Intuit\" into the search box.");
		browser.type(YPHomePage.SearchTermField, "Intuit");

		step("Type \"Mountain\" into the location box, and click on first result.");
		browser.type(YPHomePage.SearchLocationField, "Mountain");
		PageElement moutainViewCAResult = YPHomePage.firstLocationContaining("View, CA");
		browser.waitForVisible(moutainViewCAResult);
		browser.click(moutainViewCAResult);

		step("Click the Find button", "Browser goes to a results page with Intuit Inc. in the results.");
		browser.click(YPHomePage.FindButton);
		browser.waitFor(YPSearchResultsPage.class);
		browser.takeScreenShot("search-results");
		check.that(browser.exists(YPSearchResultsPage.resultByName("Intuit Inc.")), Is.True());

		return TestResult.PASS;
	}

	@Override
	public UUID getTestUUID()
	{
		return UUID.fromString("d5d385af-7075-4b62-ae5b-d87864b9f6ab");
	}
}
