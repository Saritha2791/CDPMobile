package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.CommonUIFunctn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen01Login extends CommonUIFunctn{

	public Screen01Login(AppiumDriver<MobileElement> driver) {           
        this.driver = driver; 
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Get Started']")
	private MobileElement ele_GetStarted_btn ;
	
	public void TapgetStarted() {
		click(ele_GetStarted_btn);
		log("Clicked on GetStarted button");
	}

}
