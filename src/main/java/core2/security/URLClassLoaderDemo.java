package core2.security;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by randy on 2019-05-15.
 */
public class URLClassLoaderDemo {
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
		URL url = new URL("file:///Users/nali/Desktop/protobuf-java-2.5.0.jar");
		URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { url });
		System.out.println(urlClassLoader.getParent());
		System.out.println(String.class.getClassLoader());
		Class<?> aClass = urlClassLoader.loadClass("com.google.protobuf.AbstractMessage");
		System.out.println(aClass.getSimpleName());
		System.out.println(Thread.currentThread().getContextClassLoader());
	}

	@Test
	public void test1() throws ClassNotFoundException, MalformedURLException {
		URL url = new URL("file:///Users/nali/Desktop/protobuf-java-2.5.0.jar");
		URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { url });
	//	urlClassLoader.loadClass("com.google.protobuf.AbstractMessage");
	//	Thread thread = Thread.currentThread();
	//	thread.setContextClassLoader(urlClassLoader);
		Class<?> aClass = Class.forName("com.google.protobuf.AbstractMessage", false, urlClassLoader);
		System.out.println(aClass.getSimpleName());
	}
}

class MyObject {}

class Tests {
	public static void main(String[] args) throws CloneNotSupportedException {
		MyObject obj = new MyObject();
	//	obj.clone(); // Compile error.
		Tests tests = new Tests();
	//	Object clone = tests.clone();
	}
}
