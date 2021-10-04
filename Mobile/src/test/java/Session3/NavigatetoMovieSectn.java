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



public class NavigatetoMovieSectn {
	
	public AndroidDriver<MobileElement> driver;
	
	/*prereq before running ....> ensure appium is already started, emulator is started and apk is installed*/
	@BeforeClass
	public void VerifyInstance() throws MalformedURLException, InterruptedException {

		LaunchInstance Util = new LaunchInstance();
		driver = Util.launch(Constants.deviceName, Constants.platformName, Constants.appPackage, Constants.appActivity);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(10000);
        
	}
	
	@Test
	public void NavigatetoScreens() {
		
		System.out.println("Test method started");
		
        MobileElement ele_GetStarted = driver.findElementByXPath("//android.widget.TextView[@text='Get Started']");
        ele_GetStarted.click();
       
        MobileElement ele_LangEnglish = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='English']");
        ele_LangEnglish.click();
        
        MobileElement ele_Continue = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Continue']");
        ele_Continue.click();
        
        MobileElement ele_MovieIcon = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='3']");
        ele_MovieIcon.click();
        
        MobileElement ele_headerBongoMovie = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Bongo Movies']");
        ele_headerBongoMovie.isDisplayed();
        
        MobileElement ele_FirstMovie = (MobileElement) driver.findElementByXPath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[@index='1']");
        ele_FirstMovie.isDisplayed();
        ele_FirstMovie.click();
        
		
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		driver.closeApp();
		driver.quit();
	}
}
	
