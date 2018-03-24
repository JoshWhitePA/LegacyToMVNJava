package com.white.josh.legacytommvn.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AppConfig {
	String rProxyPrefix;
	String proxyUsername;
	String proxyPassword;
	String proxyHost;
	Integer proxyPort;
	String outputSchema;
	String outputLocation;
	
}
