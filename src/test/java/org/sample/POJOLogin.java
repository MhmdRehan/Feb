package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class POJOLogin extends BaseClass {
	
	//Step-1
	public POJOLogin() {
		PageFactory.initElements(driver, this);
	}
	//@FindBys()   ---------Act as a And operator
	//@FindAll()	--------Act as a OR operator
	
	@FindAll({@FindBy(id="email"),
				@FindBy(name="email")})
	private WebElement emailTxt;
	
	
	@FindAll({@FindBy(name="pass")})
	private WebElement passWrd;
	
	@FindAll({@FindBy(name="login"),@FindBy(xpath="//a[name='create']")})
	private WebElement lgnBtn;

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPassWrd() {
		return passWrd;
	}

	public WebElement getLgnBtn() {
		return lgnBtn;
	}
	
	
	
	

}
