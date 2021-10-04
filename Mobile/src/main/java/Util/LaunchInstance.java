package Util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import config.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import Util.LaunchInstance;

public class LaunchInstance extends CheckAppiumServer{
	
	private AppiumDriver<MobileElement> mobileDriver;
	
	protected File classPathRoot = new File(System.getProperty("user.dir"));
	protected File resourcesRoot = new File(classPathRoot,"src/test/resources");
	protected String deviceName = Constants.deviceName;
	protected String platformName = Constants.platformName;
	protected String appPackage = Constants.appPackage;
	protected String appActivity = Constants.appActivity;
	protected String emulatorName = Constants.emulatorName;
	protected String appName = Constants.appName;
	protected String appiumDefaultPort = Constants.appiumDefaultPort;
	
	
	public AppiumDriver<MobileElement> getDriverInstance() {
		return this.mobileDriver;
	}
	

	public AndroidDriver<MobileElement> launch(String deviceName, String platformName, String appPackage, String appActivity) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        
        return new AndroidDriver<MobileElement>(geturl(appiumDefaultPort), capabilities);   

	}
	
	public URL geturl(String appiumDefaultPort) throws MalformedURLException {
		return new URL(appiumDefaultPort);
		
	}
	
	public String getAppPath(String appName){
		File app= new File(resourcesRoot,"/APK/"+ Constants.appName);
		return app.getAbsolutePath();
	}
	
}