package com.white.josh.legacytommvn.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.white.josh.legacytommvn.models.SearchResult;

public class DependancyOutput {
	public static void writeToFile(String path, List<SearchResult> results) {
		try {
			Files.write(Paths.get(path), convertToString(results).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printToConsole(List<SearchResult> results) {
		System.out.println(convertToString(results));
	}
	
	private static String convertToString(List<SearchResult> results) {
		StringBuffer sb = new StringBuffer();
		results.forEach(result -> {
			sb.append(result.getResponse().toDependancy());
		});
		return sb.toString();
	}
}
