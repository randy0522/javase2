package util;

import org.junit.Test;

import java.util.*;

/**
 * Created by nali on 2018/7/12.
 */
public class RandomAccessTest {
	private static final int SIZE = 100;
	@Test
	public void testTraverse(){
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		init(arrayList);
		init(linkedList);

		System.out.println("invoke method:implRandomAccess");
		System.out.println("arrayList cost timestamp:" + implRandomAccess(arrayList) + "ms");
		System.out.println("linkedList cost timestamp:" + implRandomAccess(linkedList) + "ms");

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("invoke method:noimplRandomAccess");
		System.out.println("arrayList cost timestamp:" + noImplRandomAccess(arrayList) + "ms");
		System.out.println("linkedList cost timestamp:" + noImplRandomAccess(linkedList) + "ms");
	}

	private static void init(List<Integer> list){
		for (int i = 0; i < SIZE; i++){
			list.add(i);
		}
	}

	private long startStamp;
	private long endStamp;

	private long implRandomAccess(List<Integer> list){
		startStamp = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				list.get(j);
			}
		}
		endStamp = System.currentTimeMillis();
		return endStamp - startStamp;
	}

	private long noImplRandomAccess(List<Integer> list){
		startStamp = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++){
			for (Iterator iterator = list.iterator(); iterator.hasNext();){
				iterator.next();
			}
		}
		endStamp = System.currentTimeMillis();
		return endStamp - startStamp;
	}

	private void thePrinciple(List<Integer> list){
		if (list instanceof RandomAccess){
			for (int i = 0; i < list.size(); i++){
				list.get(i);
			}
		} else {
			for (Iterator iterator = list.iterator(); iterator.hasNext();){
				iterator.next();
			}
		}
	}
}
