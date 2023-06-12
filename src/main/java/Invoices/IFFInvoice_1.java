package Invoices;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Browser;

public class IFFInvoice_1 extends Browser{
	
	
	@FindBy(xpath = "//input[@title='Username']")
	private WebElement username;
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement pass;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//i[@class='nav-icon fa fa-forward']")
	private WebElement IFFBtn;
	@FindBy(xpath = "//span[text()='IFF Financials']")
	private WebElement financeBtn;
	@FindBy(xpath = "//span[text()='IFF Invoice (Single Job)']")
	private WebElement singleJob;

	public IFFInvoice_1() {
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
		financeBtn.click();
	}

	public void verifyBookingBtn() throws Exception {
		singleJob.click();
	}

}
