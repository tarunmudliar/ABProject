package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpenUdio {
	
	WebDriver driver;
	public OpenUdio(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getUdio(){
		
		driver.get("http://www.udio.in/");
		driver.manage().window().maximize();
	}
	
}
