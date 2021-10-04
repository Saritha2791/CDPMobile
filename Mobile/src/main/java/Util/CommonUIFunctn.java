package Util;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class CommonUIFunctn {
	
	protected AppiumDriver<MobileElement> driver;


	public void Util(AppiumDriver<MobileElement> driver) {
		this.driver=driver;
	}
	
	public void log(String logMsg) {
		System.out.println(logMsg);
	}
	
	public void navigateback() {
		//driver.navigate().back();
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("Tap on mobile BACK button successful");
	}
	
	public void wait(int val) throws InterruptedException {
		Thread.sleep(val);
	}
	
	public void click(MobileElement ele) {
			ele.click();
	}
	
	public void sendkeys(MobileElement ele, String val) {
		ele.sendKeys(val);
	}
	
	public boolean isDisplayed(MobileElement ele) {
		return ele.isDisplayed();
	}
	
	public boolean isEnabled(MobileElement ele) {
		return ele.isEnabled();
	}
	
	public boolean isSelected(MobileElement ele) {
		return ele.isSelected();
	}
	
	public String getText(MobileElement ele) {
		String objRunval = ele.getText();
		return objRunval;
	}
	

}
