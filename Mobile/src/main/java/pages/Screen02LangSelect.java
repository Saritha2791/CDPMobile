package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.CommonUIFunctn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen02LangSelect extends CommonUIFunctn{

	public Screen02LangSelect(AppiumDriver<MobileElement> driver) {           
        this.driver = driver; 
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@FindBy(xpath = "//android.widget.TextView[@text='English']")
	private MobileElement ele_LangEnglish_link ;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private MobileElement ele_Continue_btn ;
	
	
	public void SelectEnglishLang() {
		click(ele_LangEnglish_link);
		log("Lang Selected successfully");
	}
	
	public void TapContinue() {
		click(ele_Continue_btn);
		log("Tap on Continue successful");
	}

}
