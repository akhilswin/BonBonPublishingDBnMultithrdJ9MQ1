package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testCalculateAdvertisementCharge() throws Exception {
		int advertisementId;
		String priority;
		int noOfDays;
		String clientName;
		float result = 0.0f;
		advertisementId = 101;
		priority = "high";
		noOfDays = 10;
		clientName = "ABC Ltd";
		String str = "video";
		if (str.equals("video")) {
			int duration = 5;
			Advertisement obj = new VideoAdvertisement(advertisementId, priority, noOfDays, clientName, duration);
			float baseCost = 500;
			result = obj.calculateAdvertisementCharge(baseCost);
		}
		yakshaAssert(currentTest(), (result == 28500.0 ? "true" : "false"), businessTestFile);
	}
}
