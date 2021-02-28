package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PropertyFileUtil 
{
	public static String getValueOfKey(String key)throws Throwable
	{
		Properties configProperties=new Properties();
		configProperties.load(new FileInputStream("G:\\anujava\\Demoqa\\PropertyFile\\Project.properties"));
		return configProperties.getProperty(key);
	}
}
