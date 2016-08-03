package com.naukri.util;

public class Locators {

	public static class Button{
		public static String nauKri_Login = "//input[@name='Login' and @id='sbtLog']";
		public static String nakKri_profileSnapShot_saveChanges = "//button[@value='Save Changes']";
	}
	
	public static class TextBox{
		public static String nauKri_Login_userName = "//input[@id='emailTxt']";
		public static String nauKri_Login_passWord = "//input[@id='pwd1']";
		public static String nauKri_profileSnap_mobile = "//input[@id='mobile']";
	}
	public static class Links{
		public static String nauKri_account_ViewProfile = "//a[contains(text(),'View Profile')]";
		public static String nauKri_account_dashBoard = "//a[text()='My Naukri Home']";
		public static String nauKri_viewProfile_ProfileSnapShot_edit = "//strong[contains(text(),'Snapshot')]/following-sibling::a[text()='Edit']";
		public static String nauKri_account_myNauKri = "//div[text()='My Naukri']";
		public static String nauKri_account_logOut = "//a[@class='logout']";
	}
	
	public static class Labels{
		public static String nauKri_logOut_successMessage = "//a[contains(text(),'Login Again')]/parent::span";
		public static String nauKur_account_profileUpdateSuccessMessage = "//span[@id='confirmMessage']";
	}
}
