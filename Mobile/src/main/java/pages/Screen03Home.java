package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.CommonUIFunctn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen03Home extends CommonUIFunctn{

	public Screen03Home(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@FindBy(xpath = "//android.widget.Button[@index='3']")
	private MobileElement ele_MovieIcon_icon ;
	
	@FindBy(xpath = "//android.widget.Button[@index='5']")
	private MobileElement ele_3dots_icon ;
	
	@FindBy(xpath = "(//android.widget.TextView[@text='AZAMTV MAX']/following::android.widget.ImageView)[1]")
	private MobileElement ele_Search_icon ;
	
	public void tapOnMovieIcon() {
		click(ele_MovieIcon_icon);
		log("tap on movie icon successful");
	}
	
	public void tapOn3DotIcon() {
		click(ele_3dots_icon);
		log("tap on 3 dots icon successful");
	}
	
	public void tapOnSearchIcon() {
		click(ele_Search_icon);
		log("tap on 3 dots icon successful");
	}
}
