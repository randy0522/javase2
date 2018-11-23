package core2.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by nali on 2018/8/24.
 */
public class InputStreamReaderTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		System.out.println(line);
	}

	@Test
	public void test1() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		int read = -1;

		while ((read = inputStreamReader.read()) != -1) {
			System.out.println(read);
		}
	}

	@Test
	public void test2(){
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		System.out.println(line);
	}

	@Test
	public void testOutputStreamWriter() throws IOException {
		char c = 200;
		System.out.println("->" + c + "<-");
		int x = 300;
		System.out.println(Charset.defaultCharset().displayName(Locale.JAPAN));
		System.out.println("->" + (char)x + "<-");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("/Users/nali/Desktop/run(1).sh", true));
		outputStreamWriter.write(11);
		outputStreamWriter.write("\n");
		outputStreamWriter.write("randy", 0, "randy".length());
/*		outputStreamWriter.write(new char[]{'1', '2'}, 0, 2);
		outputStreamWriter.write(new char[]{'1', '2'});*/
		outputStreamWriter.flush();
		outputStreamWriter.close();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/nali/Desktop/run(1).sh"))));
		String line = null;
		while ((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
	}
}
