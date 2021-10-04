package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.CommonUIFunctn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen06Movie extends CommonUIFunctn{

	public Screen06Movie(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Bongo Movies']")
	private MobileElement ele_BongoMovie_header ;
	
	@FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[@index='1']")
	private MobileElement ele_FirstMovie_link ;	

	
	public void tapfirstMovie() {
		click(ele_FirstMovie_link);
		log("clicked first movie successful");
	}

	public void verifyMovieHeader() {
		isDisplayed(ele_BongoMovie_header);
		log("header exists");
		
	}
}	
