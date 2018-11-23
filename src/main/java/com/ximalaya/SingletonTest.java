package com.ximalaya;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by nali on 2018/2/25.
 */
public class SingletonTest {
	private String name;
	public static final SingletonTest INSTANCE = new SingletonTest();

	private SingletonTest() {}

	private SingletonTest(String name){
		this.name = name;
		System.out.println("name=" + name);
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Class clazz = SingletonTest.class;
		Constructor constructors = clazz.getDeclaredConstructor();
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
		declaredConstructor.setAccessible(true);
		constructors.setAccessible(true);
		System.out.println(constructors.newInstance().equals(SingletonTest.INSTANCE));
		System.out.println(declaredConstructor.newInstance("randy").equals(SingletonTest.INSTANCE));
	}
}

class RelectTest {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
/*		Method[] declaredMethods = SingletonTest.class.getMethods();
		System.out.println(declaredMethods.length);

		for (Method method : declaredMethods){
			method.setAccessible(true);
			System.out.println(method.getName());

		}*/

		Class clazz = SingletonTest.class;
		Constructor constructors = clazz.getDeclaredConstructor();
		constructors.setAccessible(true);
		System.out.println(clazz.newInstance().equals(SingletonTest.INSTANCE));
	}
}
