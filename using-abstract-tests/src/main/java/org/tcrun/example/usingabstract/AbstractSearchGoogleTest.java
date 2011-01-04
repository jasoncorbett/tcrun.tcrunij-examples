package org.tcrun.example.usingabstract;

import org.tcrun.api.annotations.TestGroup;
import org.tcrun.tcapi.TestResult;
import static org.tcrun.tcapi.assertlib.MatchBuilder.*;
import org.tcrun.tcapi.selenium.AbstractSeleniumTest;
import org.tcrun.tcapi.selenium.PageElement;

/**
 * Page class representing the page at http://www.google.com
 *
 * @author jcorbett
 */
public abstract class AbstractSearchGoogleTest extends AbstractSeleniumTest
{
	protected abstract String getWhatToSearchFor();
	protected abstract String getExpectedURLResult();

	protected String url;

	@Override
	public void setup() throws Exception
	{
		url = configValue("URLS.google_search", "http://www.google.com");
	}

	@Override
	public TestResult test() throws Exception
	{
		step("Go to google homepage", "Arrive on a google page that has a search field.");
		browser.goTo(url);

		step("Type in search " + getWhatToSearchFor(), "See a result containing url " + getExpectedURLResult());
		browser.handlePage(GoogleSearchPage.class, getWhatToSearchFor());

		if(browser.exists(GoogleSearchPage.OriginalTermLink))
		{
			tclog.info("Google has search for something else, forcing it to search for {}", getWhatToSearchFor());
			browser.click(GoogleSearchPage.OriginalTermLink);
		}

		PageElement expectedResult = GoogleSearchPage.resultByUrl(getExpectedURLResult());
		try
		{
			browser.waitForVisible(expectedResult, 5);
		} catch(RuntimeException e)
		{
			tclog.warn("Unable to find result with url "+ getExpectedURLResult() + ".", e);
		}

		check.that(browser.exists(expectedResult), Is.True());

		return TestResult.PASS;
	}
}
