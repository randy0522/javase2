package com.ximalaya;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nali on 2018/2/25.
 */
public class PersonTest1 {
	private final Date birthday;

	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(1946, Calendar.JANUARY, 1, 0, 0);
		BOOM_START = calendar.getTime();
		calendar.set(1964, Calendar.JANUARY, 1, 0, 0);
		BOOM_END = calendar.getTime();
	}

	public PersonTest1 (Date date) {
		this.birthday = date;
	}

	public boolean isBabyBoomer(){
		return birthday.compareTo(BOOM_START) >= 0 && birthday.compareTo(BOOM_END) <=0;
	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, Calendar.JANUARY, 1, 0, 0);
		Date birthday = calendar.getTime();
		PersonTest1 personTest1 = new PersonTest1(birthday);
		System.out.println(personTest1.isBabyBoomer());
	}
}
