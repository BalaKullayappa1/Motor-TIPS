/*
 * package Registerd_Vechile;
 * 
 * import java.lang.reflect.Method; import java.util.Hashtable;
 * 
 * import org.testng.annotations.Test;
 * 
 * import Utilities.RegCarXLData; import Z_Base.Base_Agent;
 * 
 * public class Private_car extends Base_Agent { private int rowNum = 1;
 * 
 * @Test(dataProviderClass = RegCarXLData.class, dataProvider = "dp") public
 * void RegisteredCar(Hashtable<String, String> data, Method m) throws
 * InterruptedException {
 * 
 * // QMS Tile Thread.sleep(5000); Baseclick("QMSTile_XPATH");
 * output("Qms Tile Click successfully"); Thread.sleep(5000);
 * 
 * // Dash board Baseclick("NewQute_XPATH");
 * output("New Quote Button clicked successfully");
 * 
 * // Select New Business Insurance Type Thread.sleep(5000);
 * Baseclick("MotorTile_XPATH"); output("Motor Tile clicked successfully");
 * Thread.sleep(5000); Baseclick("RegVechl_XPATH");
 * output("Registerd Vechile Selected Successfully"); Thread.sleep(5000);
 * Baseclick("nxtbtn_XPATH"); output("Next Button Clicked successfully");
 * 
 * // Motor Coverage(s) Screen // Vehicle Search and Vehicle Details tab
 * Thread.sleep(5000); Enter("VeclregNo_XPATH", data.get("Vechcle Reg"));
 * output("Vechile Number Enterd successfully"); Thread.sleep(5000);
 * click("POUDrpDon_XPATH");
 * output("Place Of Use Drop Down Clicked successfully"); Thread.sleep(5000);
 * Enter("StateEntr_XPATH", data.get("Place Of Use"));
 * output("state Enterd successfully"); Thread.sleep(5000);
 * click("Statesel_XPATH"); output("Place Of Use selected successfully");
 * Thread.sleep(5000); click("VeclsrcBtn_XPATH");
 * output("Vechile search button clicked successfully");
 * output("Vechile Data retrived from IRBM successfully");
 * 
 * // Coverage Details Tab Thread.sleep(5000); click("CovTpeDrpDon_XPATH");
 * output("Coverage Type Drop Down Clicked successfully"); Thread.sleep(5000);
 * Enter("CovrvaleEntr_XPATH", data.get("Coverage Type"));
 * output("Coverage Type Given successfully"); Thread.sleep(5000);
 * click("CovrTypSel_XPATH"); output("Coverage Type clicked successfully");
 * Thread.sleep(5000); Enter("PHID_XPATH", data.get("PH ID"));
 * output("Policy Holder id Given successfully"); Thread.sleep(5000);
 * Enter("nmeofID_XPATH", data.get("Name As Per ID"));
 * output("Policy Holder name Given successfully"); Thread.sleep(5000);
 * click("VldOnrISMBtn_XPATH");
 * output("Validate as per Ownor button clicked successfullsy");
 * Thread.sleep(5000); click("SaveBtn_XPATH");
 * output("Save Button clicked successfully");
 * 
 * // Motor Additional Information // Additional Details of Proposer
 * Thread.sleep(5000); click("DrvExpDrpDwn_XPATH");
 * output("Driving Experience DropDown clicked successfully");
 * Thread.sleep(5000); Enter("DrvExpGvn_XPATH", data.get("Driving Experience"));
 * output("Driving Experience Given clicked successfully"); Thread.sleep(5000);
 * click("DrvExpDrpDwnSel_XPATH");
 * output("Driving Experience selected successfully");
 * 
 * // Rebate Thread.sleep(5000); click("Rebate_id"); // PIAM Analysis Code //
 * Garage Type Thread.sleep(5000); click("GrgTypDrpdwn_XPATH");
 * output("Garage Type Drop Down was Click successfully"); Thread.sleep(5000);
 * Enter("GrgTypGivn_XPATH", data.get("Garage Type"));
 * output("Garage Type Given successfully"); Thread.sleep(5000);
 * click("GrgTypSect_XPATH");
 * output("Garage Type Drop Down was selected successfully"); // Anti Theft
 * Thread.sleep(5000); click("AntThtDrpdwn_XPATH");
 * output("Anti Theft Drop Down was Click successfully"); Thread.sleep(5000);
 * Enter("AntThtGivn_XPATH", data.get("Anti Theft"));
 * output("Anti Theft Given successfully"); Thread.sleep(5000);
 * click("AntThtSect_XPATH");
 * output("Anti Theft Drop Down was selected successfully"); // Safety Features
 * Thread.sleep(5000); click("SafFeuDrpdwn_XPATH");
 * output("Safety Features Drop Down was Click successfully");
 * Thread.sleep(5000); Enter("SafFeuGivn_XPATH", data.get("Safety Features"));
 * output("Safety Features Given successfully"); Thread.sleep(5000);
 * click("SafFeuSect_XPATH");
 * output("Safety Features Drop Down was selected successfully");
 * 
 * // Policy Issuance Thread.sleep(15000); click("PolicyBtn_XPATH");
 * output("Proceed to Policy Issuance Button Clicked successfully");
 * Thread.sleep(15000); click("IssPolicy_XPATH");
 * output("Issue Policy Button Clicked successfully");
 * output("Policy was Issued successfully");
 * 
 * // Print Thread.sleep(5000); String QuoteNumber = print("QuoteNumber_XPATH");
 * output(QuoteNumber); write(QuoteNumber, m, 12, rowNum); rowNum++;
 * 
 * // Navigating to Home Screen Thread.sleep(10000); Baseclick("Home_XPATH");
 * output("home Button clicked successfully");
 * 
 * }
 * 
 * }
 */