package com.white.josh.legacytommvn;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.white.josh.legacytommvn.files.DependancyOutput;
import com.white.josh.legacytommvn.files.JarHandler;
import com.white.josh.legacytommvn.models.SearchResult;
import com.white.josh.legacytommvn.search.SearchRepository;

public class Main {

	public static void main(String[] args) {
		 Options options = buildArgs();
		 CommandLineParser parser = new DefaultParser();
		 CommandLine cmd = null;
		 try {
			cmd = parser.parse( options, args);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 if(isProxied(cmd)) {
			 
		 }
		SearchRepository searchRepo = new SearchRepository();
		List<SearchResult> results = searchRepo.searchHashes(JarHandler.getHashesForFolder(cmd.getOptionValue("path", "./"), "jar"));
		DependancyOutput.printToConsole(results);
	}

	private static boolean isProxied(CommandLine cmd) {
		return cmd.hasOption("proxyhost");
	}
	
	private static Options buildArgs() {
		// create Options object
		Options options = new Options();
		options.addOption("path", false, "Path to forlder of jars");
		options.addOption("outputfile", false, "Path and file name of output file name");
		options.addOption("rproxy", false, "Prefix of reverse proxy");
		options.addOption("proxyhost", false, "URL of proxy");
		options.addOption("proxyu", false, "Proxy username");
		options.addOption("proxyp", false, "Proxy password");
		options.addOption("sha", false, "The sha1 of a file you would like to search");
		options.addOption("toFile", false, "Saves output to file");
		return options;
	}

}
