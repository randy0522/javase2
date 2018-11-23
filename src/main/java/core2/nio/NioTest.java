package core2.nio;

import org.junit.Test;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nali on 2018/9/17.
 */
public class NioTest {

	public static void main(String[] args) {
/*		Integer[] x = { 1, 2};
		Object[] objects = { new Object() };
		System.out.println(System.getProperty("sun.java.command"));
		System.out.println(FileSystems.getDefault().provider());
		System.out.println("-->" + System.in + "<--");*/
		ClassLoader classLoader = Integer.class.getClassLoader();
		System.out.println(NioTest.class.getClassLoader());
	}

	@Test
	public void testPaths(){
		Path randyssss = Paths.get("/");
		System.out.println(randyssss.getFileName());
		System.out.println(System.getProperty("sun.java.command"));
	}
}
