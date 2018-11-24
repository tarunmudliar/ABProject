package pageObjects;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UdioHome{

	public UdioHome(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using="//a[@id='link-login']")
	private WebElement UH_login;
	
	
	public void clickLoginButton(){
		//WebDriverWait wdw = new WebDriverWait(driver, 10);
		//wdw.until(ExpectedConditions.presenceOfElementLocated(By.id(p.data("Login_button")))).click();
		//driver.findElement(By.id(p.data("Login_button"))).click();
		UH_login.click();
	}
	
}
