package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.CommonUIFunctn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen05Register extends CommonUIFunctn{

	public Screen05Register(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Register']")
	private MobileElement ele_Register_btn ;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Your mobile number']")
	private MobileElement ele_Entermobileno_input ;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Invalid OTP!']")
	private MobileElement ele_InvalidOTP_header ;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Dismiss']")
	private MobileElement ele_Dismiss_btn ;
	
	@FindBy(xpath = "//android.widget.Button[@text='YES']")
	private MobileElement ele_YES_btn ;
	
	
	public void TapRegister(){
		click(ele_Register_btn);
		log("click register successful");
	}
	
	public void EnterMobileNo(String phoneno){
		sendkeys(ele_Entermobileno_input, phoneno);
		log("Mobile no enter successful");
	}


	public void EnterdefaultOTP(int oTPDigits, String val) {
		for (int i =2 ; i<= oTPDigits;i++)
		{
			sendkeys(driver.findElementByXPath("//android.view.ViewGroup["+i+"]/android.widget.EditText"), val);
			if (i == 6) {
				sendkeys(driver.findElementByXPath("//android.view.ViewGroup[1]/android.widget.EditText"), val);
			}
			log("OTP box->"+i+" value entered->"+val+"");
		}
		log("Entered OTP Succesfully");
		
	}
	
	public void TapDismiss(){
		isDisplayed(ele_InvalidOTP_header);
		click(ele_Dismiss_btn);
		log("click dismiss successful");
	}
	
	public void ExitFromRegistratn(){
		navigateback();
	}
	
	
	public void TapYes(){
		click(ele_YES_btn);
		log("YES exit button");
	}

}
