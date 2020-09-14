package io;


import java.io.*;

/**
 * Created by randy on 2019/4/15.
 */
public class InputStreamDeml extends InputStream {
	private static char c;

	@Override
	public int read() throws IOException {
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("path.separator"));
		System.out.println(System.getProperty("java.home"));

		File file = new File("randy");
	}

}

