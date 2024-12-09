package Registered_Private_car;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Hashtable;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.MonitoringMail;
import Utilities.RegCarXLData;
import Utilities.TestConfig;
import Z_Base.Base_Agent;

public class Private_car extends Base_Agent {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	private int rowNum = 1;
	static String messageBody;

	@BeforeTest
	public void setReport() {

		htmlReporter = new ExtentSparkReporter("./reports/Motorextent.html");

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Motor 4W Automation Reports");
		htmlReporter.config().setReportName("Motor 4W Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Automation Tester", "Bala Kullayappa");
		extent.setSystemInfo("Orgainzation", "Serole Technologies");
	}

	@Test(dataProviderClass = RegCarXLData.class, dataProvider = "dp")
	public void RegisteredCar(Hashtable<String, String> data, Method m) throws InterruptedException {
		test = extent.createTest("Registered Car Test");
		// QMS Tile
		Thread.sleep(5000);
		Baseclick("QMSTile_XPATH");
		output("Qms Tile Click successfully");
		Thread.sleep(5000);

		// Dash board
		Baseclick("NewQute_XPATH");
		output("New Quote Button clicked successfully");

		// Select New Business Insurance Type
		Thread.sleep(5000);
		Baseclick("MotorTile_XPATH");
		output("Motor Tile clicked successfully");
		Thread.sleep(5000);
		Baseclick("RegVechl_XPATH");
		output("Registerd Vechile Selected Successfully");
		Thread.sleep(5000);
		Baseclick("nxtbtn_XPATH");
		output("Next Button Clicked successfully");

		// Motor Coverage(s) Screen
		// Vehicle Search and Vehicle Details tab
		Thread.sleep(5000);
		Enter("VeclregNo_XPATH", data.get("Vechcle Reg"));
		output("Vechile Number Enterd successfully");
		Thread.sleep(5000);
		click("POUDrpDon_XPATH");
		output("Place Of Use Drop Down Clicked successfully");
		Thread.sleep(5000);
		if(data.get("Place Of Use").equalsIgnoreCase("Johor")) {
			click("Johor_XPATH");
		} else if(data.get("Place Of Use").equalsIgnoreCase("Kedah")){
			click("Kedah_XPATH");
		} 
		output("Place Of Use selected successfully");
		Thread.sleep(5000);
		click("VeclsrcBtn_XPATH");
		output("Vechile search button clicked successfully");
		output("Vechile Data retrived from IRBM successfully");

		// Coverage Details Tab
		Thread.sleep(5000);
		click("CovTpeDrpDon_XPATH");
		output("Coverage Type Drop Down Clicked successfully");
		Thread.sleep(5000);
		if(data.get("Coverage Type").equalsIgnoreCase("Comprehensive")){
			click("Comprehensive_XPATH");
		} else if(data.get("Coverage Type").equalsIgnoreCase("Third Party")){
			click("ThirdParty_XPATH");
		}
		Thread.sleep(5000);
		output("Coverage Type clicked successfully");
		Thread.sleep(5000);
		Enter("PHID_XPATH", data.get("PH ID"));
		output("Policy Holder id Given successfully");
		Thread.sleep(5000);
		Enter("nmeofID_XPATH", data.get("Name As Per ID"));
		output("Policy Holder name Given successfully");
		Thread.sleep(5000);
		click("VldOnrISMBtn_XPATH");
		output("Validate as per Ownor button clicked successfullsy");
		Thread.sleep(5000);
		click("SaveBtn_XPATH");
		output("Save Button clicked successfully");

		// Motor Additional Information
		// Additional Details of Proposer
		Thread.sleep(5000);
		click("DrvExpDrpDwn_XPATH");
		output("Driving Experience DropDown clicked successfully");
		Thread.sleep(5000);
		if(data.get("Driving Experience").equalsIgnoreCase("2 - 5 years")){
			click("DrvExp2to5y_XPATH");
		}else if(data.get("Driving Experience").equalsIgnoreCase("6 - 10 years")){
			click("DrvExp6to10y_XPATH");
		}
		Thread.sleep(5000);
		output("Driving Experience selected successfully");

		// Proceed to Policy Issuance
		Thread.sleep(5000);
		click("PolicyIssue_XPATH");
		// Policy Issuance
		Thread.sleep(15000);
		click("IssPolicy_XPATH");
		output("Issue Policy Button Clicked successfully");
		output("Policy was Issued successfully");

		// Print
		Thread.sleep(5000);
		String QuoteNumber = driver.findElement(By.xpath(loc.getProperty("QuoteNumber_XPATH"))).getText();
		output(QuoteNumber);
		write(QuoteNumber, m, 9, rowNum);
		Thread.sleep(5000);
		String QuoteStatus = driver.findElement(By.xpath(loc.getProperty("QuoteStatus_XPATH"))).getText();
		output(QuoteStatus);
		write(QuoteStatus, m, 10, rowNum);
		Thread.sleep(5000);
		String PloicyNumber = driver.findElement(By.xpath(loc.getProperty("PloicyNumber_XPATH"))).getText();
		output(PloicyNumber);
		write(PloicyNumber, m, 11, rowNum);
		Thread.sleep(5000);
		String VehicleSumInsured = driver.findElement(By.xpath(loc.getProperty("VehicleSumInsured_XPATH"))).getText();
		output(VehicleSumInsured);
		write(VehicleSumInsured, m, 12, rowNum);
		Thread.sleep(5000);
		String ActPremium = driver.findElement(By.xpath(loc.getProperty("ActPremium_XPATH"))).getText();
		output(ActPremium);
		write(ActPremium, m, 13, rowNum);
		Thread.sleep(5000);
		String BasicPremium = driver.findElement(By.xpath(loc.getProperty("BasicPremium_XPATH"))).getText();
		output(BasicPremium);
		write(BasicPremium, m, 14, rowNum);
		Thread.sleep(5000);
		String NCD = driver.findElement(By.xpath(loc.getProperty("NCD_XPATH"))).getText();
		output(NCD);
		write(NCD, m, 15, rowNum);
		Thread.sleep(5000);
		String PremiumafterNCD = driver.findElement(By.xpath(loc.getProperty("PremiumafterNCD_XPATH"))).getText();
		output(PremiumafterNCD);
		write(PremiumafterNCD, m, 16, rowNum);
		Thread.sleep(5000);
		String ExtraBenefitsTotal = driver.findElement(By.xpath(loc.getProperty("ExtraBenefitsTotal_XPATH"))).getText();
		output(ExtraBenefitsTotal);
		write(ExtraBenefitsTotal, m, 17, rowNum);
		Thread.sleep(5000);
		String GrossPremium = driver.findElement(By.xpath(loc.getProperty("GrossPremium_XPATH"))).getText();
		output(GrossPremium);
		write(GrossPremium, m, 18, rowNum);
		Thread.sleep(5000);
		String Rebate = driver.findElement(By.xpath(loc.getProperty("Rebate_XPATH"))).getText();
		output(Rebate);
		write(Rebate, m, 19, rowNum);
		Thread.sleep(5000);
		String SST = driver.findElement(By.xpath(loc.getProperty("SST_XPATH"))).getText();
		output(SST);
		write(SST, m, 20, rowNum);
		Thread.sleep(5000);
		String StampDuty = driver.findElement(By.xpath(loc.getProperty("StampDuty_XPATH"))).getText();
		output(StampDuty);
		write(StampDuty, m, 21, rowNum);
		Thread.sleep(5000);
		String TotalPayablePremium = driver.findElement(By.xpath(loc.getProperty("TotalPayablePremium_XPATH")))
				.getText();
		output(TotalPayablePremium);
		write(TotalPayablePremium, m, 22, rowNum);
		rowNum++;

		// Navigating to Home Screen
		Thread.sleep(15000);
		Baseclick("Home_XPATH");
		output("home Button clicked successfully");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");

			try {

				RegCarXLData.captureScreenshot();
				test.fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(RegCarXLData.screenshotName).build());
			} catch (IOException e) {

			}
			String failureLogg = "TEST CASE FAILED";
			Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
			test.log(Status.FAIL, m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  SKIPPED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.skip(m);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);

		}
	}

	@AfterTest
	public void endReport() {
		MonitoringMail mail = new MonitoringMail();

		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/Motor%20TIPS/Extent_20Reports/";
			;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();
	}

}
