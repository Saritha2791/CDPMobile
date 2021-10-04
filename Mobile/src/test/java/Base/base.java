package Base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import config.Constants;
import Util.CheckAppiumServer;
import Util.LaunchInstance;

public class base extends CheckAppiumServer{

	protected LaunchInstance launch;
	protected File classPathRoot = new File(System.getProperty("user.dir"));
	protected File resourcesRoot = new File(classPathRoot,"src/test/resources");
	protected String appPackage = Constants.appPackage;
	protected String appActivity = Constants.appActivity;
	protected String URL = Constants.appiumDefaultPort;
	protected String appName = Constants.appName;
	protected String deviceName = Constants.deviceName;
	
	public void log(String logMsg) {
		System.out.println(logMsg);
	}
	
	public URL geturl(String appiumDefaultPort) throws MalformedURLException {
		return new URL(appiumDefaultPort);
		
	}
	
	public void StartEmulator(String emulatorName) {
		
		String userdirname = System.getProperty("user.name")+".RENTAL-054";
		System.out.println(userdirname);
		
		try {
			Runtime.getRuntime().exec("cmd /K \"emulator -avd "+emulatorName+"\"", null, new File("C:\\Users\\"+userdirname+"\\AppData\\Local\\Android\\Sdk\\emulator"));
			System.out.println("EMULATOR ->"+emulatorName+"...Starting");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void InstallApk(String deviceName, String appName) {
		
		String userdirname = System.getProperty("user.name")+".RENTAL-054";
		
		try {
			UnInstallApk(appPackage);
			Runtime.getRuntime().exec("cmd /K \"adb -s "+deviceName+" install C:\\Users\\"+userdirname+"\\eclipse-workspace\\Mobile\\src\\test\\resources\\"+appName+"\"");
			System.out.println("Installed apk with name ->"+appName+"...on device->"+deviceName);
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
	}
	
	public void UnInstallApk(String appPackage) {
		
		try {
			Runtime.getRuntime().exec("cmd /K \"adb shell pm uninstall --user 0 "+appPackage+"\"");
			System.out.println("UnInstalled apk with package name ->"+appPackage);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void CloseEmulator(String deviceName) {
		
		try {
			Runtime.getRuntime().exec("cmd /K \"adb -s "+deviceName+" emu kill\"");
			System.out.println("EMULATOR with devicename ->"+deviceName+"...CLOSED");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
