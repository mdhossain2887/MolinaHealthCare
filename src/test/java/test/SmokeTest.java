package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.FirstPage;

public class SmokeTest extends BaseTest{

	@Test
	public void FirstpageTest() {
	FirstPage fp=new FirstPage(driver);
	fp.numberOfLinksInThePage();
	fp.numberOfFrames();
	fp.handleWindow();
	fp.getCookies();
	fp.verifyLogo();
	fp.mouseOverOnAboutMolina();
	fp.clickOnWhyMolina();
	fp.clickOnBecomeAMember();
	fp.clickOnArrowButton1();
	fp.selectCity();
	fp.clickOnArrowButton2();
	fp.selectLanguage();
	fp.clickOnSubmit();
	}
}
