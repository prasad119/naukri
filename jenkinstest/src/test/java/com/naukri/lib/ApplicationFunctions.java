package com.naukri.lib;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.naukri.util.Global;
import com.naukri.util.Locators;



public class ApplicationFunctions {
	public static boolean sStatus = true;
	public static boolean openNauKri(String sURL){
		try{
			sStatus = GeneralFunc.openBrowser(sURL);
			Assert.assertEquals(sStatus, true, "Not Opened Naukri Properly");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static boolean logintoNaukri(String userName, String passWord){
		try{
			sStatus = GeneralFunc.waitForElementVisible(Locators.TextBox.nauKri_Login_userName, Global.delay5);
			Assert.assertEquals(sStatus, true, "Naukri Login button is not available");
			sStatus = GeneralFunc.inputText(Locators.TextBox.nauKri_Login_userName, userName);
			Assert.assertEquals(sStatus, true, "UserName not entered successfully");
			sStatus = GeneralFunc.inputText(Locators.TextBox.nauKri_Login_passWord, passWord);
			Assert.assertEquals(sStatus, true, "Password is not entered successfully");			
			sStatus = GeneralFunc.clickElement(Locators.Button.nauKri_Login);
			sStatus = GeneralFunc.waitForElementVisible(Locators.Links.nauKri_account_ViewProfile, Global.delay5);
			Assert.assertEquals(sStatus, true, "Not login successfully");
			return true;

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean performUpdate(String mobileNumber){
		try{
			String updateMessage = "";
			sStatus = GeneralFunc.clickElement(Locators.Links.nauKri_account_ViewProfile);
			Assert.assertEquals(sStatus, true, "Not clicked on View Profile");
			sStatus = GeneralFunc.waitForElementVisible(Locators.Links.nauKri_viewProfile_ProfileSnapShot_edit, Global.delay5);
			Assert.assertEquals(sStatus, true, "Profile Snapshot Not available in account");
			sStatus = GeneralFunc.clickElement(Locators.Links.nauKri_viewProfile_ProfileSnapShot_edit);
			Assert.assertEquals(sStatus, true, "Failed click on Profile Snapshot edit");
			sStatus = GeneralFunc.waitForElementVisible(Locators.Button.nakKri_profileSnapShot_saveChanges, Global.delay5);
			Assert.assertEquals(sStatus, true, "Save button is not available in the profile snapshot page");
			GeneralFunc.clearField(Locators.TextBox.nauKri_profileSnap_mobile);
			sStatus = GeneralFunc.inputText(Locators.TextBox.nauKri_profileSnap_mobile, mobileNumber);
			Assert.assertEquals(sStatus, true, "Mobile field is not updated in profile snap shot");
			sStatus = GeneralFunc.clickElement(Locators.Button.nakKri_profileSnapShot_saveChanges);
			Assert.assertEquals(sStatus, true, "Save operation not performed successfully");
			updateMessage = GeneralFunc.getText(Locators.Labels.nauKur_account_profileUpdateSuccessMessage);
			Assert.assertEquals(updateMessage, GeneralFunc.readTestData("message"), "Profile not updated successfully");
			return true;
		}
		catch(Exception e){
			
		}
		return false;
	}
	public static boolean logout(){
		try{
			sStatus = GeneralFunc.mouseOver(Locators.Links.nauKri_account_myNauKri);
			Assert.assertEquals(sStatus, true, "Not performed mose over on My Naukri");
			sStatus = GeneralFunc.clickElement(Locators.Links.nauKri_account_logOut);
			Assert.assertEquals(sStatus, true, "Logout not performed");			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
