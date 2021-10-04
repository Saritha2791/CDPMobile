package Session4;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.base;
import Util.LaunchInstance;
import config.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.Screen01Login;
import pages.Screen02LangSelect;
import pages.Screen03Home;
import pages.Screen04Search;
import pages.Screen05Register;
import pages.Screen06Movie;

public class registertoApp extends base {
	
	public AndroidDriver<MobileElement> driver;
	protected String deviceName = Constants.deviceName;
	protected String platformName = Constants.platformName;
	protected String appPackage = Constants.appPackage;
	protected String appActivity = Constants.appActivity;
	protected int port = Constants.port;
	protected String emulatorName = Constants.emulatorName;
	protected String appName = Constants.appName;
	
	@BeforeSuite
	public void PreCheck() throws InterruptedException {
		log("PreCheck Started ....-> Start Server; StartEmulator; InstallApk");
		startServer(Constants.port);
		StartEmulator(Constants.emulatorName);	
		Thread.sleep(20000);
		InstallApk(Constants.deviceName, Constants.appName);
		Thread.sleep(10000);
	}

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		LaunchInstance Util = new LaunchInstance();
		driver = Util.launch(Constants.deviceName, Constants.platformName, Constants.appPackage, Constants.appActivity);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(5000);
        
        Screen01Login login = new Screen01Login(driver);
        Screen02LangSelect LangSelect = new Screen02LangSelect(driver);
        Screen03Home Home = new Screen03Home(driver);
        Screen04Search Search = new Screen04Search(driver);
        Screen05Register Register = new Screen05Register(driver);
        Screen06Movie Movie = new Screen06Movie(driver);
        
        log("Launch and navigate to ....->Home");
        login.TapgetStarted();
        LangSelect.SelectEnglishLang();
        LangSelect.TapContinue();
        
		log(" Navigate to Registration....->proceed with registration");
		Home.tapOn3DotIcon();
		Register.TapRegister();
		Thread.sleep(10);
		Register.EnterMobileNo("7600000585");
		Thread.sleep(20);
		LangSelect.TapContinue();
		Thread.sleep(20);
		Register.EnterdefaultOTP(6, "0");
		Thread.sleep(20);
		LangSelect.TapContinue();
		Thread.sleep(30);
		Register.TapDismiss();
		Register.ExitFromRegistratn();
		Register.TapYes();

	}
	
	@AfterSuite
	public void PostCheck() {
		log("Close app....");
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
		log("PostCheck Started ....-> UnInstallApk; CloseEmulator; stopServer");
		UnInstallApk(Constants.appPackage);
		CloseEmulator(Constants.deviceName);
		stopServer();
	}
}
