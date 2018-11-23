package com.ximalaya;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * Created by nali on 2018/2/24.
 */
public class EnumSetTest {
	public static void main(String[] args) {
		EnumSet<Session> sessions = EnumSet.allOf(Session.class);
//		sessions.clear();
	//	System.out.println(sessions);

//		System.out.println(EnumSet.complementOf(sessions));
//		System.out.println(EnumSet.copyOf(sessions));
		Collection<Session> collection = new HashSet();
		collection.add(Session.FAIL);
		System.out.println(EnumSet.copyOf(collection));
	//	System.out.println(EnumSet.range());

	}
}

enum Session {
	SPRING, SUMMER, FAIL, WINTER
}
