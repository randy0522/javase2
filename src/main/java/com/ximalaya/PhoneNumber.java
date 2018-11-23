package com.ximalaya;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nali on 2018/3/7.
 */
public final class PhoneNumber {
	private final short area;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(short area, short prefix, short lineNumber){
		checkRange(area, "area code");
		checkRange(prefix, "prefix");
		checkRange(lineNumber, "lineNumber");

		this.area = area;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	private static void checkRange(int arg, String name){
		if (arg < 0 || arg > 999){
			throw new IllegalArgumentException(name + ":" + arg);
		}
	}

	@Override
	public boolean equals(Object object){
		if (object == this){
			return true;
		}
		if (object instanceof PhoneNumber){
			PhoneNumber pn = (PhoneNumber) object;
			return pn.area == this.area && pn.prefix == this.prefix && pn.lineNumber == this.lineNumber;
		}
		return false;
	}

	@Override
	public int hashCode(){
		return area * 1000000 + prefix * 1000 + lineNumber;
	}

	@Override
	public String toString(){
		return String.format("(%03d) %03d-%04d", area, prefix, lineNumber);
	}

	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<>();
		map.put(new PhoneNumber((short) 123, (short)123, (short)123), "randy");
		PhoneNumber phoneNumber = new PhoneNumber((short) 123, (short)123, (short)123);
		System.out.println(map.get(phoneNumber));
		System.out.println(phoneNumber);
	}
}
