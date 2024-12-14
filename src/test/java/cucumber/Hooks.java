package cucumber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driverhelper;
import utilities.Eventhelper;

public class Hooks {

	private static final Logger logger = LogManager.getLogger(Eventhelper.class);

	@Before
	public void setup() {
		logger.info("Scenario started.");
		Driverhelper.getDriver();
	}

	@After
	public void teardown() {
		Driverhelper.quitDriver();
		logger.info("Scenario end and driver quit");
	}
}
