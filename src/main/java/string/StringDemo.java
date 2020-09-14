package string;

import org.junit.Test;

/**
 * Created by randy on 2019-06-27.
 */
public class StringDemo {

	@Test
	public void testStringFormat() {
		String s = "我：%c";
		System.out.println(String.format(s, 'd'));
	}
}
