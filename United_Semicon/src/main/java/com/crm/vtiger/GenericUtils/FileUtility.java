package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/*
 * this class contains reading data from external resources
 * 
 */
public class FileUtility {
	/*
	 * this method is for reading data from property file
	 * @param key
	 * @return value
	 * @throws 
	 */
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);				
	}
	public String getDataFromJSON(String jsonKey) throws Throwable {
		FileReader read=new FileReader(IPathConstant.JSON_FILEPATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(read);
		JSONObject jsonObject =(JSONObject) object;
		String value=jsonObject.get(jsonKey).toString();
		return value;		
	}	
}

