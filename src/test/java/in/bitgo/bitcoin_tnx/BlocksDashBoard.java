package in.bitgo.bitcoin_tnx;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import in.bitgo.bitcoin_blocks_pageobject.BlocksDashboardPageObject;
import in.bitgo.testutils.BrowserBaseTest;

public class BlocksDashBoard extends BrowserBaseTest {

	BlocksDashboardPageObject blocksPageObject;

	@Test
	public void validateHeading() {

		try {
			blocksPageObject = new BlocksDashboardPageObject(driver);
			blocksPageObject.fetchAndValidateHeading();
		}

		catch (Exception e) {
			AssertJUnit.fail("Testcase failed, pls check exp error msg - : " + e.getMessage());
		}
	}

	@Test
	public void tnxHashMatch() {

		try {
			blocksPageObject = new BlocksDashboardPageObject(driver);
			blocksPageObject.fetchAndValidateTnxHashMatch();

		}

		catch (Exception e) {
			AssertJUnit.fail("Testcase failed, pls check exp error msg - : " + e.getMessage());
		}

	}

}
