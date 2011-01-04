package org.tcrun.example.usingabstract;

import java.util.UUID;
import org.tcrun.api.annotations.TestGroup;
import org.tcrun.api.annotations.TestName;

/**
 *
 * @author jcorbett
 */
@TestName("Google Search: Search for tcrun")
@TestGroup("using-abstract")
public class SearchForTCRun extends AbstractSearchGoogleTest
{

	@Override
	protected String getWhatToSearchFor()
	{
		return "tcrun";
	}

	@Override
	protected String getExpectedURLResult()
	{
		return "http://code.google.com/p/tcrun";
	}

	@Override
	public UUID getTestUUID()
	{
		return UUID.fromString("06767cd1-1d98-477f-a204-b79499f75818");
	}
}
