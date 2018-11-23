package com.ximalaya;

/**
 * Created by nali on 2018/2/25.
 */
public class AutoBoxingTest {
	public static void main(String[] args) {
		Long sum = 0L;
		long start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE; i++){
			sum += i;
		}
		long end = System.currentTimeMillis();
		System.out.println("elaspe=" + (end - start) + ",sum=" + sum);
	}
}

class Test110 {

}
