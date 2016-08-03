package com.naukri.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.naukri.lib.ApplicationFunctions;
import com.naukri.lib.GeneralFunc;
import com.naukri.util.Global;

public class TC1 {
public static boolean sStstus;
	@Test
	public static  void l(){
		sStstus = ApplicationFunctions.openNauKri(Global.sUrl);
		Assert.assertEquals(sStstus, true, "Naukri is not opened successfully");
		sStstus = ApplicationFunctions.logintoNaukri(GeneralFunc.readTestData("UserName"), GeneralFunc.readTestData("Password"));
		Assert.assertEquals(sStstus, true, "Login not performed successfully");
		sStstus = ApplicationFunctions.performUpdate(GeneralFunc.readTestData("phone"));
		Assert.assertEquals(sStstus, true, "Update operation failed");
		sStstus = ApplicationFunctions.logout();
		Assert.assertEquals(sStstus, true, "Logout failed");
	}
	@AfterTest
	public static void close(){
		GeneralFunc.closeBrowser();
	}
}
