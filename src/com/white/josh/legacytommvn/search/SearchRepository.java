package com.white.josh.legacytommvn.search;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.white.josh.legacytommvn.models.SearchResult;

public class SearchRepository {
	private Gson gson;
	private String repoURL = "search.maven.org/solrsearch/select?q=1:%%22%s%%22&rows=20&wt=json";
	HttpHost proxy;
	private boolean isRProxyied = false;
	Executor executor = Executor.newInstance();

	private String getRepoURL() {
		if (isRProxyied) {
			return repoURL;
		} else {
			return "http://" + repoURL;
		}
	}

	public SearchRepository() {
		this.gson = new Gson();
	}

	public SearchRepository(String host, String uName, String password, Integer port) {
		this();
		executor = Executor.newInstance().auth(new HttpHost(host, port), uName, password);
	}

	public SearchRepository(String rProxyPrefix) {
		this();
		repoURL = rProxyPrefix + "http/" + repoURL;
		isRProxyied = true;
	}

	public List<SearchResult> searchHashes(List<String> jarSHAs) {
		List<SearchResult> results = new ArrayList<SearchResult>();
		for (String sha : jarSHAs) {
			SearchResult result = searchRepo(sha);
			System.out.println(result);
			if (result != null) {
				results.add(result);
			}
		}

		return results;
	}

	private String getUrlWithHash(String hash) {
		return String.format(getRepoURL(), hash);
	}

	private SearchResult searchRepo(String hash) {
		try (Reader reader = new InputStreamReader(executor
				.execute(Request.Get(repoURL).addHeader("accept", "application/json")).returnContent().asStream())) {
			return gson.fromJson(reader, SearchResult.class);
		} catch (IOException e) {
			System.err.println(e);
		}

		return null;
	}

}
