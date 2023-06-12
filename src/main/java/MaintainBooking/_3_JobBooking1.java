package MaintainBooking;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Browser;

public class _3_JobBooking1 extends Browser {

	@FindBy(xpath = "//input[@title='Username']")
	private WebElement username;
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement pass;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//i[@class='nav-icon fa fa-forward']")
	private WebElement IFFBtn;
	@FindBy(xpath = "//span[text()='IFF Sales']")
	private WebElement salesBtn;
	@FindBy(xpath = "//span[text()='Maintain Booking']")
	private WebElement bookingBtn;

	public _3_JobBooking1() {
		PageFactory.initElements(driver, this);
	}

	public void verifyLoginApp() throws Exception {
		username.sendKeys(readExcelFileFinal(3, 2));
		pass.sendKeys(readExcelFileFinal(3, 3));
		Thread.sleep(1000);
		loginBtn.click();

	}

	public void verifyIFFBtn() throws Exception {
		try {
			Thread.sleep(1000);
		IFFBtn.click();}
		catch(NoSuchElementException e) {
		}
	}

	public void verifySalesBtn() throws Exception {
		Thread.sleep(500);
		salesBtn.click();
	}

	public void verifyBookingBtn() throws Exception {
		bookingBtn.click();
	}

}
