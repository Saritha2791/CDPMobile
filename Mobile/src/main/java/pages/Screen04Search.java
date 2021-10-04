package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.CommonUIFunctn;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen04Search extends CommonUIFunctn{

	public Screen04Search(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@FindBy(xpath = "//android.widget.EditText[@text='Search']")
	private MobileElement ele_Entermovie_input ;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']")
	private MobileElement ele_Searchedmovie ;	

	
	public void SearchMovie(String Movie) {
		sendkeys(ele_Entermovie_input, Movie);
		log("move entered successful");
	}
	
	public void VerifySearchedMovie() {
		click(ele_Searchedmovie);
		log("click searched movie successful");
	}

}
