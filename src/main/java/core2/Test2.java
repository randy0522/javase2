package core2;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * Created by nali on 2018/7/30.
 */
public class Test2 {
	@Test
	public void testSystemIn(){
		InputStream in = System.in;
		System.out.println(System.getProperty("user.dir"));
		Properties properties = System.getProperties();
		System.out.println(File.separator);
	}

	@Test
	public void tesrtInputStream() throws IOException {
		FileInputStream fileIs = new FileInputStream("");
		int available = fileIs.available();
		if (available > 0){
			int read = fileIs.read(new byte[available]);
		}
	}

	@Test
	public void testFloat(){
		float f = 1111111111.49F;
		System.out.println(f);
	}

}
