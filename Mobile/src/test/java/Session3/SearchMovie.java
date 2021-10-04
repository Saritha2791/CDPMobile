package Session3;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.LaunchInstance;
import config.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchMovie {
	
	/*prereq before running ....> ensure appium is already started, emulator is started and apk is installed*/
public AndroidDriver<MobileElement> driver;
	
@BeforeClass
public void VerifyInstance() throws MalformedURLException, InterruptedException {

	LaunchInstance Util = new LaunchInstance();
	driver = Util.launch(Constants.deviceName, Constants.platformName, Constants.appPackage, Constants.appActivity);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    Thread.sleep(10000);
    
}
	
	@Test
	public void SearchMovieinAzam() {
		
		System.out.println("Test method started");
		
        MobileElement ele_GetStarted = driver.findElementByXPath("//android.widget.TextView[@text='Get Started']");
        ele_GetStarted.click();
       
        MobileElement ele_LangEnglish = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='English']");
        ele_LangEnglish.click();
        
        MobileElement ele_Continue = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Continue']");
        ele_Continue.click();
        
        MobileElement ele_SearchIcon = (MobileElement) driver.findElementByXPath("(//android.view.ViewGroup[1]/android.widget.TextView[@text='AZAMTV MAX']/following::android.widget.ImageView)[1]");
        ele_SearchIcon.click();
        
        MobileElement ele_Entermovie = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Search']");
        ele_Entermovie.sendKeys("keeping promises");
        
        MobileElement ele_Searchedmovie = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']");
        ele_Searchedmovie.isDisplayed();  
        ele_Searchedmovie.click();
            
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		driver.closeApp();
		//driver.quit();
	}

}
