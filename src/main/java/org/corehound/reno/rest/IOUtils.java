package org.corehound.reno.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

	public static final String toString(InputStream is) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line = null;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

}
