package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Implementation {
	static WebDriver driver;
	static Properties prop;
	@Rule
	public ErrorCollector er = new ErrorCollector();

	@Given("^Open the browser$")
	public void open_the_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream(
				"C:\\SeleniumProject\\DemoCucumber\\src\\configuration\\ObjRep.properties");
		prop = new Properties();
		prop.load(fis);
	}

	@When("^Navigate into the CMSe application \"([^\"]*)\"$")
	public void navigate_into_the_CMSe_application(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
		driver.manage().window().maximize();
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file1, new File("C:\\Screenshot\\launch.png"));
	}

	@When("^Enter username  \"([^\"]*)\"$")
	public void enter_username(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys(arg1);
		File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file2, new File("C:\\Screenshot\\username.png"));
	}

	@When("^Enter password  \"([^\"]*)\"$")
	public void enter_password(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(arg1);
		File file3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file3, new File("C:\\Screenshot\\password.png"));
	}

	@When("^Click Login$")
	public void click_Login() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		File file4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file4, new File("C:\\Screenshot\\login.png"));
		/*
		 * String loginsuccess=driver.findElement(By.xpath(prop.getProperty(
		 * "loginsuccessful"))).getText(); if(loginsuccess!=null) {
		 * System.out.println("Login is successfull"); } else {
		 * System.out.println("Login is Failed"); }
		 */
	}

	@Then("^Validate Login Page$")
	public void validate_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String loginsuccess = driver.findElement(By.xpath(prop.getProperty("loginsuccessful"))).getText();
		String expected = "Log Out";
		String actual = loginsuccess;

		// System.out.println("login is successfull");
		try {
			Assert.assertEquals(expected, actual);

			System.out.println("Login is Success");
		} catch (Throwable e) {
			er.addError(e);
			System.out.println("Login is failed");
		}

	}

	@When("^Enter Institution ID  \"([^\"]*)\"$")
	public void enter_Institution_ID(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("InsID"))).clear();
		driver.findElement(By.xpath(prop.getProperty("InsID"))).sendKeys(arg1);
		File file5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file5, new File("C:\\Screenshot\\InsID.png"));
	}

	@When("^Click Open Card$")
	public void click_Open_Card() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("opencard"))).click();
		int i = 1;
		while (true) {
			try {
				driver.findElement(By.xpath("//*[@id='nextButton']")).click();
				WebElement a = driver.findElement(By.xpath("//td[contains(text(),'100200')]"));
				if(a.getText().isEmpty())
				{
					break;
				} else {
					a.click();
					break;
				}

			} catch (Exception e) {

			}
		
	}
		File file6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file6, new File("C:\\Screenshot\\open.png"));
	}

	@When("^Click Prefix number$")
	public void click_Prefix_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// driver.findElement(By.xpath(prop.getProperty("prefix"))).click();
		driver.findElement(By.xpath(prop.getProperty("skipprodid"))).click();
		File file7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file7, new File("C:\\Screenshot\\prefix.png"));
	}

	@When("^Click Generate Card$")
	public void click_Generate_Card() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("generatecard"))).click();
		File file8 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file8, new File("C:\\Screenshot\\generatecard.png"));

	}

	@When("^Enter Name   \"([^\"]*)\"$")
	public void enter_Name(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys(arg1);
		File file9 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file9, new File("C:\\Screenshot\\entername.png"));
	}

	@When("^Enter Address \"([^\"]*)\"$")
	public void enter_Address(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("address"))).sendKeys(arg1);
		File file10 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file10, new File("C:\\Screenshot\\adressline1.png"));
	}

	@When("^Enter City  \"([^\"]*)\"$")
	public void enter_City(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("city"))).sendKeys(arg1);
		File file11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file11, new File("C:\\Screenshot\\city.png"));
	}

	@When("^Enter State \"([^\"]*)\"$")
	public void enter_State(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("state"))).sendKeys(arg1);
		File file12 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file12, new File("C:\\Screenshot\\state.png"));
	}

	@When("^Enter ZIP  \"([^\"]*)\"$")
	public void enter_ZIP(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("zip"))).sendKeys(arg1);
		File file13 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file13, new File("C:\\Screenshot\\zip.png"));
	}

	@When("^Enter Offset \"([^\"]*)\"$")
	public void enter_Offset(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("offset"))).sendKeys(arg1);
		File file14 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file14, new File("C:\\Screenshot\\offset.png"));
	}

	@When("^Click continue button$")
	public void click_continue_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		File file15 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file15, new File("C:\\Screenshot\\continue.png"));
	}

	@When("^Click finalContinue button$")
	public void click_finalContinue_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='submit']")).click();
		File file16 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file16, new File("C:\\Screenshot\\finalContinue.png"));
	}

	@When("^Click submitFinal$")
	public void click_submitFinal() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id='submitReview']")).click();
		File file17 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file17, new File("C:\\Screenshot\\submitFinal.png"));
	}

	@Then("^Get the card number$")
	public void get_the_card_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String cardnumber = driver.findElement(By.xpath(prop.getProperty("getcard"))).getText();
		File file18 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file18, new File("C:\\Screenshot\\getcard.png"));
		System.out.println(cardnumber);
		driver.findElement(By.xpath(prop.getProperty("returntosearch"))).click();
		driver.findElement(By.xpath(prop.getProperty("entercardnumber"))).sendKeys(cardnumber);
	}

	@When("^Click Search Button$")
	public void click_Search_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("searchcard"))).click();
		File file19 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file19, new File("C:\\Screenshot\\searchcard.png"));
	}

	@When("^Click Neg File/Status$")
	public void click_Neg_File_Status() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("negfile"))).click();
		File file20 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file20, new File("C:\\Screenshot\\negfile.png"));
	}

	@When("^Click Active Check box$")
	public void click_Active_Check_box() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("activedropdown"))).click();
		File file21 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file21, new File("C:\\Screenshot\\activedropdown.png"));

	}

	@When("^Select Do not add in Exception File Update Code \"([^\"]*)\"$")
	public void select_Do_not_add_in_Exception_File_Update_Code(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("fileupdatecode"))).click();
		driver.findElement(By.xpath(prop.getProperty("fileupdatecode"))).sendKeys(arg1);
		File file22 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file22, new File("C:\\Screenshot\\fileupdatecode.png"));
	}

	@When("^Select Do not honor in Exception File Action Code \"([^\"]*)\"$")
	public void select_Do_not_honor_in_Exception_File_Action_Code(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("fileactioncode"))).click();
		driver.findElement(By.xpath(prop.getProperty("fileactioncode"))).sendKeys(arg1);
		File file23 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file23, new File("C:\\Screenshot\\fileactioncode.png"));
	}

	@When("^Enter Card status change submit$")
	public void enter_Card_status_change_submit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String dropdowntext = driver.findElement(By.xpath(prop.getProperty("activedropdownlabel"))).getText();
		System.out.println("Card Status=" + dropdowntext);
		driver.findElement(By.xpath(prop.getProperty("negfilesubmit"))).click();
		System.out.println("Card Status change is successful");
		File file24 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file24, new File("C:\\Screenshot\\negfilesubmit.png"));
	}

	@When("^Click Add Fund$")
	public void click_Add_Fund() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("prepdebit"))).click();
		driver.findElement(By.xpath(prop.getProperty("fundopt"))).click();
		driver.findElement(By.xpath(prop.getProperty("addfund"))).click();
		File file25 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file25, new File("C:\\Screenshot\\addfund.png"));
	}

	@When("^Enter Amount \"([^\"]*)\"$")
	public void enter_Amount(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("addamount"))).clear();
		driver.findElement(By.xpath(prop.getProperty("addamount"))).sendKeys(arg1);
		File file26 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file26, new File("C:\\Screenshot\\addamount.png"));

	}

	@When("^Click Add Fund Submit Button$")
	public void click_Add_Fund_Submit_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("addsubmit"))).click();
		File file27 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file27, new File("C:\\Screenshot\\addsubmit.png"));
	}

	@Then("^Validate the add fund$")
	public void validate_the_add_fund() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String addamount = driver.findElement(By.xpath(prop.getProperty("addfundsuccessful"))).getText();
		// System.out.println(addamount);
		if (addamount != null) {
			System.out.println("Add fund is successfull");
		} else {
			System.out.println("Add Fund is Failed");
		}
	}

	@When("^Click cardtocard transfer$")
	public void click_cardtocard_transfer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("prepdebit"))).click();
		driver.findElement(By.xpath(prop.getProperty("fundopt"))).click();
		driver.findElement(By.xpath(prop.getProperty("cardtocardtransfer"))).click();
		File file28 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file28, new File("C:\\Screenshot\\cardtocardtransfer.png"));
	}

	@When("^Enter Transfer Amount \"([^\"]*)\"$")
	public void enter_Transfer_Amount(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("transferamount"))).click();
		driver.findElement(By.xpath(prop.getProperty("transferamount"))).sendKeys(arg1);
		File file29 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file29, new File("C:\\Screenshot\\transferamount.png"));
	}

	/*
	 * @When("^Click radio button$") public void click_radio_button() throws
	 * Throwable { // Write code here that turns the phrase above into concrete
	 * actions
	 * driver.findElement(By.xpath(prop.getProperty("radiocardnumber"))).click()
	 * ; File file25=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * FileHandler.copy(file25, new
	 * File("C:\\Screenshot\\radiocardnumber.png")); }
	 */

	@When("^Enter funding card number \"([^\"]*)\"$")
	public void enter_funding_card_number(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("fundingcard"))).sendKeys(arg1);
		File file30 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file30, new File("C:\\Screenshot\\fundingcard.png"));
	}

	@When("^click ctoc Submit$")
	public void click_ctoc_Submit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("ctcsubmit"))).click();
		driver.findElement(By.xpath(prop.getProperty("ctcfinalsubmit"))).click();
		File file31 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file31, new File("C:\\Screenshot\\ctcfinalsubmit.png"));

	}

	@Then("^Validate card to card transfer$")
	public void validate_card_to_card_transfer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String c2cfinalmsg = driver.findElement(By.xpath(prop.getProperty("ctcmessage"))).getText();
		// System.out.println(c2cfinalmsg);
		if (c2cfinalmsg != null) {
			System.out.println("Card to Card transfer is successfull");
		} else {
			System.out.println("Card to Card transfer is failed");
		}
	}

	@When("^Click cards and pin link$")
	public void click_cards_and_pin_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardandpin"))).click();
		File file32 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file32, new File("C:\\Screenshot\\cardandpin.png"));
	}

	@When("^Click update$")
	public void click_update() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardandpinupdate"))).click();
		File file33 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file33, new File("C:\\Screenshot\\cardandpinupdate.png"));
	}

	@When("^Enter new PIN \"([^\"]*)\"$")
	public void enter_new_PIN(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("newpin"))).sendKeys(arg1);
		File file34 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file34, new File("C:\\Screenshot\\newpin.png"));
	}

	@When("^Re enter new pin \"([^\"]*)\"$")
	public void re_enter_new_pin(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("reenterpin"))).sendKeys(arg1);
		File file35 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file35, new File("C:\\Screenshot\\reenterpin.png"));
	}

	@When("^Click update pin submit$")
	public void click_update_pin_submit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("pinchangesubmit"))).click();
		File file36 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file36, new File("C:\\Screenshot\\pinchangesubmit.png"));
	}

	@Then("^Validate PIN Change$")
	public void validate_PIN_Change() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String pinchange = driver.findElement(By.xpath(prop.getProperty("pinchangesuccess"))).getText();
		// System.out.println(pinchange);
		if (pinchange != null) {
			System.out.println("PIN Change is successfull");
		} else {
			System.out.println("PIN Change is failed");
		}
	}

	@When("^Click Card information link$")
	public void click_Card_information_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardinfo"))).click();
		File file37= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file37, new File("C:\\Screenshot\\cardinfo.png"));
	}

	@When("^Click Card info update link$")
	public void click_Card_info_update_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardinfoupdate"))).click();
		File file38= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file38, new File("C:\\Screenshot\\cardinfoupdate.png"));
	}

	@When("^Update address \"([^\"]*)\"$")
	public void update_address(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("updateaddress1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("updateaddress1"))).sendKeys(arg1);
		File file39= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file39, new File("C:\\Screenshot\\updateaddress1.png"));
	}

	@When("^Click Card info Continue buuton$")
	public void click_Card_info_Continue_buuton() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardinfocontinue"))).click();
		File file40= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file40, new File("C:\\Screenshot\\cardinfocontinue.png"));
	}

	@When("^Click Card info Submit Button$")
	public void click_Card_info_Submit_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardinfosubmit"))).click();
		File file41= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file41, new File("C:\\Screenshot\\cardinfosubmit.png"));
	}

	@When("^Validate the Card info update$")
	public void validate_the_Card_info_update() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String cardinfochange = driver.findElement(By.xpath(prop.getProperty("cardinfoupdatesuccess"))).getText();
		// System.out.println(pinchange);
		if (cardinfochange != null) {
			System.out.println("Card Info Change is successfull");
		} else {
			System.out.println("Card Info Change is failed");
		}
	}

	@When("^Click product id tab$")
	public void click_product_id_tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("productid"))).click();
		File file42= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file42, new File("C:\\Screenshot\\productid.png"));
	}

	@When("^Enter instituion id in product id search  \"([^\"]*)\"$")
	public void enter_instituion_id_in_product_id_search(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("prodinsid"))).clear();
		driver.findElement(By.xpath(prop.getProperty("prodinsid"))).sendKeys(arg1);
		File file43= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file43, new File("C:\\Screenshot\\productid.png"));
	}

	@When("^Click Add product id$")
	public void click_Add_product_id() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("addproductid"))).click();
		File file44= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file44, new File("C:\\Screenshot\\addproductid.png"));
	}

	@When("^Enter the name of product id  \"([^\"]*)\"$")
	public void enter_the_name_of_product_id(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("enternewprodid"))).sendKeys(arg1);
		File file45= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file45, new File("C:\\Screenshot\\enternewprodid.png"));
	}

	@When("^Enter the product id description \"([^\"]*)\"$")
	public void enter_the_product_id_description(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("enterprodiddesc"))).sendKeys(arg1);
		File file46= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file46, new File("C:\\Screenshot\\enterprodiddesc.png"));
	}

	@When("^Click Continue button in add product id page$")
	public void click_Continue_button_in_add_product_id_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("prodidcontinue"))).click();
		File file47= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file47, new File("C:\\Screenshot\\prodidcontinue.png"));
	}

	@When("^Click Service Charge link$")
	public void click_Service_Charge_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("servicechargedropdown"))).click();
		File file48= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file48, new File("C:\\Screenshot\\servicechargedropdown.png"));
	}

	@When("^Click Network transaction$")
	public void click_Network_transaction() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("networktransaction"))).click();
		File file49= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file49, new File("C:\\Screenshot\\networktransaction.png"));
	}

	@When("^Click ATM Deposit$")
	public void click_ATM_Deposit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("atmdeposit"))).click();
		File file50= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file50, new File("C:\\Screenshot\\atmdeposit.png"));
	}

	@When("^Click No value added in Deposit ONUS$")
	public void click_No_value_added_in_Deposit_ONUS() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("depositonus"))).click();
		File file51= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file51, new File("C:\\Screenshot\\depositonus.png"));

	}

	@When("^Enter the Deposit ONUS SVC Fee  \"([^\"]*)\"$")
	public void enter_the_Deposit_ONUS_SVC_Fee(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("enterdepositonus1"))).sendKeys(arg1);
		File file52= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file52, new File("C:\\Screenshot\\enterdepositonus1.png"));
	}

	@When("^Click Plus symbol in Deposit ONUS$")
	public void click_Plus_symbol_in_Deposit_ONUS() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("plussymbol1"))).click();
		File file53= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file53, new File("C:\\Screenshot\\plussymbol1.png"));

	}

	@When("^Click No value added in Deposit Foreign$")
	public void click_No_value_added_in_Deposit_Foreign() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("depositforeign"))).click();
		File file54= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file54, new File("C:\\Screenshot\\depositforeign.png"));
	}

	@When("^Enter the Deposit Foreign SVC Fee  \"([^\"]*)\"$")
	public void enter_the_Deposit_Foreign_SVC_Fee(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("enterdepositonus2"))).sendKeys(arg1);
		File file55= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file55, new File("C:\\Screenshot\\enterdepositonus2.png"));
	}

	@When("^Click Plus symbol in Deposit Foreign$")
	public void click_Plus_symbol_in_Deposit_Foreign() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("plussymbol2"))).click();
		File file56= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file56, new File("C:\\Screenshot\\plussymbol2.png"));
		
	}

	@When("^Click Continue button in Add Product ID Page$")
	public void click_Continue_button_in_Add_Product_ID_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("productcontinuebutton"))).click();
		File file57= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file57, new File("C:\\Screenshot\\productcontinuebutton.png"));
	}

	@When("^Click Submit button in Review Product id page$")
	public void click_Submit_button_in_Review_Product_id_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("productsubmit"))).click();
		File file58= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file58, new File("C:\\Screenshot\\productsubmit.png"));
	}

	@Then("^Validate the product id creation is success$")
	public void validate_the_product_id_creation_is_success() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Product ID Creation is Successful");

	}

	@When("^Click Cardholder tab$")
	public void click_Cardholder_tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("gotoCardholder"))).click();
		File file59= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file59, new File("C:\\Screenshot\\gotoCardholder.png"));
	}

	@When("^Pass Card Number$")
	public void pass_Card_Number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// String cardnumber =
		// driver.findElement(By.xpath(prop.getProperty("getcard"))).getText();
		// driver.findElement(By.xpath(prop.getProperty("enterCardNumber"))).clear();
		driver.findElement(By.xpath(prop.getProperty("enterCardNumber"))).sendKeys("1002000000009874");
		File file60= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file60, new File("C:\\Screenshot\\enterCardNumber.png"));
	}

	@When("^Click Search button for Product id addition$")
	public void click_Search_button_for_Product_id_addition() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("cardsearchforprodid"))).click();
		File file61= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file61, new File("C:\\Screenshot\\cardsearchforprodid.png"));
	}

	@When("^Add product ID$")
	public void add_product_ID() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(prop.getProperty("productidclick"))).click();
		driver.findElement(By.xpath(prop.getProperty("productidadd"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("selectproductid"))).click();
		driver.findElement(By.xpath(prop.getProperty("addprodidsubmit"))).click();
		File file62= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file62, new File("C:\\Screenshot\\addprodidsubmit.png"));

	}

	@Then("^Validate the Product id addition is successful$")
	public void validate_the_Product_id_addition_is_successful() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Card number is successfully added to the product id");
	}
}
