package com.ximalaya;

/**
 * Created by nali on 2018/3/13.
 */
public class SingletoneTest2 implements Cloneable {
	public static final SingletoneTest2 instance = new SingletoneTest2();

	private SingletoneTest2(){}

	public static SingletoneTest2 getInstance(){
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (SingletoneTest2) super.clone();
	}
}

class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletoneTest2 singletonTest = SingletoneTest2.getInstance();
		SingletoneTest2 clone = (SingletoneTest2)singletonTest.clone();
		System.out.println(singletonTest == clone);

	}
}
