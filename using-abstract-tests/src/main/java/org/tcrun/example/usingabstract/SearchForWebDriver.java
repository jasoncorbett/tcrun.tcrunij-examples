package org.tcrun.example.usingabstract;

import java.util.UUID;
import org.tcrun.api.annotations.TestGroup;
import org.tcrun.api.annotations.TestName;

/**
 *
 * @author jcorbett
 */
@TestName("Google Search: Search for web driver")
@TestGroup("using-abstract")
public class SearchForWebDriver extends AbstractSearchGoogleTest
{

	@Override
	protected String getWhatToSearchFor()
	{
		return "web driver";
	}

	@Override
	protected String getExpectedURLResult()
	{
		return "http://code.google.com/p/selenium";
	}

	@Override
	public UUID getTestUUID()
	{
		return UUID.fromString("6ced2f3a-9875-4f58-81dc-6841c1c45987");
	}
}
