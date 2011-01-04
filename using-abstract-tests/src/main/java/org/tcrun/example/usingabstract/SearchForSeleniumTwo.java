package org.tcrun.example.usingabstract;

import java.util.UUID;
import org.tcrun.api.annotations.TestGroup;
import org.tcrun.api.annotations.TestName;

/**
 *
 * @author jcorbett
 */
@TestName("Google Search: Search for selenium 2.0")
@TestGroup("using-abstract")
public class SearchForSeleniumTwo extends AbstractSearchGoogleTest
{

	@Override
	protected String getWhatToSearchFor()
	{
		return "selenium 2.0";
	}

	@Override
	protected String getExpectedURLResult()
	{
		return "http://code.google.com/p/selenium";
	}

	@Override
	public UUID getTestUUID()
	{
		return UUID.fromString("1a34a76c-336a-4801-927d-e818e81e63fc");
	}
}
