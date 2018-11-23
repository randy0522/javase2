package core.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nali on 2018/6/20.
 */
public class Test {
	@org.junit.Test
	public void test(){
		char ch = '刘';

		CharSequence charSequence = new CharSequence() {
			@Override
			public int length() {
				return 0;
			}

			@Override
			public char charAt(int index) {
				return 0;
			}

			@Override
			public CharSequence subSequence(int start, int end) {
				return null;
			}

			@Override
			public String toString() {
				return null;
			}
		};
		System.out.println(charSequence.length());
		List<? extends Comparable<?>> list = new ArrayList<>();
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
	}
}
