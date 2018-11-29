package managers;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerManager {
	public Logger Log = Logger.getLogger(LoggerManager.class.getName());
	
	public LoggerManager(){
	DOMConfigurator.configure("configs/log4j.xml");
	}
	

}
