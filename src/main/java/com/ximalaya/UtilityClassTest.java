package com.ximalaya;

import com.randy.Test;

/**
 * Created by nali on 2018/2/25.
 */
public class UtilityClassTest extends Test {
	int x = Integer.MAX_VALUE;

	{
		System.out.println("before constructor !");
		x = 888;
		System.out.println(x);
	}
	private UtilityClassTest (){
		x = 666;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		UtilityClassTest utilityClassTest = new UtilityClassTest();
		String name = utilityClassTest.name;
		utilityClassTest.print();
		System.out.println(utilityClassTest.x);
		//
		Test test = new Test();

		Test222 test222 = new Test222();
		test222.clone();
	//	test.print();

		System.out.print("->>>>" + "\r\n" + "-\t-");
		System.out.println("^^^^^^");
	}
}

class Test222 {
	@Override
	protected Object clone(){
		return null;
	}
}

class Aa {}

class Bb extends Aa{
	public static void main(String[] args) {
		Bb[] bbs = new Bb[3];
		Aa[] aas = bbs;
		aas[0] = new Aa();
		System.out.println("randy");
	}
}

abstract class KK {
	public void test(){
		System.out.println("randy");
	}
}
