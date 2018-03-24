package com.white.josh.legacytommvn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.white.josh.legacytommvn.models.AppConfig;

public class LoadProperties {
	private final List<String> propertyNames;

	public LoadProperties() {
		propertyNames = new LinkedList<String>();
		propertyNames.add("proxy.rproxy.prefix");
		propertyNames.add("proxy.url");
		propertyNames.add("proxy.username");
		propertyNames.add("proxy.password");
		propertyNames.add("proxy.port");
		propertyNames.add("outadd.schema");
		propertyNames.add("outadd.toConsole");
		propertyNames.add("outadd.toFile");
		
	}

	public AppConfig createConfig(){
		Properties properties = readProperties();
		return AppConfig.builder()
		.rProxyPrefix(properties.getProperty("proxy.rproxy.prefix"))
		.proxyHost(properties.getProperty("proxy.url"))
		.proxyPort(Integer.parseInt(properties.getProperty("proxy.port")))
		.proxyUsername(properties.getProperty("proxy.username"))
		.proxyPassword(properties.getProperty("proxy.password"))
		.outputSchema(properties.getProperty("outadd.schema"))
		.build();
		
	}
	public Properties readProperties() {
		String homeFolder = System.getProperty("user.home");
		File propsFile = new File(homeFolder, ".lmvnrc");
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(propsFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String,String> propertyWVals = getPropertyValues(properties);
		
		
		return null;

	}

	private Map<String,String> getPropertyValues(Properties properties) {
		Map<String,String> existingProperties = new LinkedHashMap<String,String>();
		propertyNames.forEach((property)->{
			String propValue = properties.getProperty(property);
			if(propValue != null) {
				existingProperties.put(property, propValue);
			}
			
		});
		return existingProperties;
	}

}
