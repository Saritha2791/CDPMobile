package Util;

import java.io.IOException;
import java.net.ServerSocket;

import config.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CheckAppiumServer {
	
	protected AppiumDriver<MobileElement> driver;
	
	protected int port = Constants.port;
	public boolean startServer(int PORT) {
		
		Runtime runtime = Runtime.getRuntime();
		try {
			if(!checkIfServerIsRunnning(port)) {
				stopServer();
				runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
		        Thread.sleep(10000);
		        System.out.println("Appium Server Started on ->"+port);
			} else {
				System.out.println("Appium Server already running on Port - " + port);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		

	public void stopServer() {
		
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("taskkill /F /IM node.exe");
	        runtime.exec("taskkill /F /IM cmd.exe");
	       System.out.println("Appium Server STOP->...sessions killed");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}	
	
}
