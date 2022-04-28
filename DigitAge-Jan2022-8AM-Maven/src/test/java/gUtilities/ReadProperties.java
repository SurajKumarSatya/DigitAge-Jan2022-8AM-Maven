package gUtilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ReadProperties
{
	FileInputStream myfile;
	Properties prop;
	String fileName;
	public ReadProperties(String fileName)
	{
		this.fileName = fileName;
	}
	public String readData(String userKey) //throws IOException
	{
		try {
			myfile = new FileInputStream(fileName);//News paper
			prop = new Properties(); //news reader
			prop.load(myfile); //give the news paper to news reader  //throw			
		} catch (IOException e) {
			// continue the execution with a default file 
			e.printStackTrace();
		}
		return prop.getProperty(userKey);
	}
	@Test
	public void readData() //throws IOException
	{
		try {
			myfile = new FileInputStream("TestData/Apsrtc.properties");//News paper
			prop = new Properties(); //news reader
			prop.load(myfile); //give the news paper to news reader  //throw
			String myurl = prop.getProperty("URL");
			System.out.println("env url :" + myurl);
			System.out.println(prop.getProperty("FromCity"));
			System.out.println(prop.getProperty("ToCity"));
			System.out.println(prop.getProperty("JDate"));
		} catch (IOException e) {
			// continue the execution with a default file 
			e.printStackTrace();
		}
	}

}