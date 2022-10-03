package com.vicky.imooc.utility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
	public Properties prop;
	public String filePath;
	public ProUtil(String filePath) {
		this.filePath = filePath;
		this.prop = readProperties();
		
	}
	
	/*** read properties by filepath ***/
	private Properties readProperties() {
		Properties properties = new Properties();
		try {
			FileInputStream inputstream = new FileInputStream(filePath);
			BufferedInputStream bufferedinput = new BufferedInputStream(inputstream);
			properties.load(bufferedinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	/*** get properties by key ***/
	public String getPro(String key) {
		String result = " ";
		if(prop.containsKey(key)) {
			result = prop.getProperty(key);
			
		}else {
			System.out.println(key + "is not exist!!");
		}
		return result;
	}
	
	/*** write into the properties file ***/
	public void writePro(String key, String value) {
		Properties properties = new Properties();
		try {
			FileOutputStream file = new FileOutputStream(filePath);
			properties.setProperty(key,value);
			properties.store(file, key);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main (String[] args) {
		ProUtil pro = new ProUtil("element.properties");
		System.out.println(pro.getPro("courseName"));
		
	}
	
}
