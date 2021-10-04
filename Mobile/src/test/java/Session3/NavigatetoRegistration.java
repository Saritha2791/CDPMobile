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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NavigatetoRegistration {
	
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
	public void RegisterinAzam() throws InterruptedException {
		
		System.out.println("Test method started");
		
        MobileElement ele_GetStarted = driver.findElementByXPath("//android.widget.TextView[@text='Get Started']");
        ele_GetStarted.click();
       
        MobileElement ele_LangEnglish = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='English']");
        ele_LangEnglish.click();
        
        MobileElement ele_Continue = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Continue']");
        ele_Continue.click();
        
        MobileElement ele_3dotsIcon = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='5']");
        ele_3dotsIcon.click();
        
        MobileElement ele_Register = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Register']");
        ele_Register.click();
        
        MobileElement ele_Entermobileno = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Your mobile number']");
        ele_Entermobileno.sendKeys("7607777585");

        ele_Continue.click();
        
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        


        MobileElement ele_MobileField1 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[2]/android.widget.EditText");
        ele_MobileField1.sendKeys("0");
        
        MobileElement ele_MobileField2 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[3]/android.widget.EditText");
        ele_MobileField2.sendKeys("0");
        
        MobileElement ele_MobileField3 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[4]/android.widget.EditText");
        ele_MobileField3.sendKeys("0");
        
        MobileElement ele_MobileField4 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[5]/android.widget.EditText");
        ele_MobileField4.sendKeys("0");
        
        MobileElement ele_MobileField5 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[6]/android.widget.EditText");
        ele_MobileField5.sendKeys("0");
        
        MobileElement ele_MobileField0 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[1]/android.widget.EditText");
        ele_MobileField0.isDisplayed();
        ele_MobileField0.sendKeys("0");
        
        ele_Continue.click();
        
        MobileElement ele_InvalidOTP = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Invalid OTP!']");
        ele_InvalidOTP.isDisplayed();
        
        MobileElement ele_Dismiss = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Dismiss']");
        ele_Dismiss.click();
        Thread.sleep(30);
        
        //driver.pressKeyCode(AndroidKeyCode.BACK);
        
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        
        MobileElement ele_YES = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='YES']");
        ele_YES.click();
        
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		driver.closeApp();
		//driver.quit();
	}

}
