package com.white.josh.legacytommvn.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class JarHandler {

	public static List<String> getHashesForFolder(String folderURL, String extension) {
		List<String> fileHashes = new ArrayList<String>();
		for (File file : getJarsinFolder(folderURL, extension)) {
			fileHashes.add(shaTheFile(file));
		}
		return fileHashes;
	}

	private static List<File> getJarsinFolder(String folderURL, String extension) {
		File dir = new File(folderURL);
		File[] files = dir.listFiles((d, name) -> name.endsWith("." + extension));
		return Arrays.asList(files);
	}

	private static String shaTheFile(final File file) {

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
		try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
			final byte[] buffer = new byte[1024];
			for (int read = 0; (read = is.read(buffer)) != -1;) {
				messageDigest.update(buffer, 0, read);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		// Convert the byte to hex format
		try (Formatter formatter = new Formatter()) {
			for (final byte b : messageDigest.digest()) {
				formatter.format("%02x", b);
			}
			return formatter.toString();
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
}
