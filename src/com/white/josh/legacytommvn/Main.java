package com.white.josh.legacytommvn;

import java.util.List;

import org.apache.commons.cli.Options;
import org.apache.http.HttpHost;

import com.white.josh.legacytommvn.files.JarHandler;
import com.white.josh.legacytommvn.models.SearchResult;
import com.white.josh.legacytommvn.search.SearchRepository;

public class Main {

	public static void main(String[] args) {
		// Options options = buildArgs();
		String jarFolderURL = "/Users/josh/Code/jars";
		SearchRepository searchRepo = new SearchRepository();
		List<SearchResult> results = searchRepo.searchHashes(JarHandler.getHashesForFolder(jarFolderURL, "jar"));
		StringBuffer sb = new StringBuffer();
		results.forEach(result -> {
			sb.append(result.getResponse().toDependancy());
		});
		System.out.println(sb);
	}

	private static Options buildArgs() {
		// create Options object
		Options options = new Options();
		options.addOption("path", false, "Path to forlder of jars");
		options.addOption("rproxy", false, "Prefix of reverse proxy");
		options.addOption("proxyhost", false, "URL of proxy");
		options.addOption("proxyu", false, "Proxy username");
		options.addOption("proxyp", false, "Proxy password");
		options.addOption("sha", false, "The sha1 of a file you would like to search");
		options.addOption("toFile", false, "Saves output to file");
		return options;
	}

}
