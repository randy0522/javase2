package com.randy;

import sun.jvm.hotspot.debugger.cdbg.AccessControl;
import sun.security.action.GetPropertyAction;

import java.security.AccessController;

/**
 * Created by nali on 2018/8/1.
 */
public class Test2 {
	public static void main(String[] args) {
		Test test = new Test();
		String name = test.name;
		test.print();

		String s = AccessController.doPrivileged(new GetPropertyAction("file.encoding"));

		System.out.println(s);
	}
}
