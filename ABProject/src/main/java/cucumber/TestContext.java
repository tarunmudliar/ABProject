package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	private WebDriverManager wdm;
	private PageObjectManager pom;
	public ScenarioContext sct;
	
	public TestContext(){
		wdm = new WebDriverManager();
		pom = new PageObjectManager(wdm.getDriver());
		sct = new ScenarioContext(); 
	}
	
	public  WebDriverManager getWebDriverManager(){
		
		return wdm;
	}
	public PageObjectManager getPageObjectManager(){
		
		return pom;
	}
	
	public ScenarioContext getScenarioContext(){
		
		return sct;
	}
	
}
