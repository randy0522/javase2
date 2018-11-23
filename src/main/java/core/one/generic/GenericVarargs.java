package core.one.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nali on 2018/6/23.
 */
public class GenericVarargs {
	public static <T> List<T> makeList(T... args){
		List<T> list = new ArrayList<>();
		Collections.addAll(list, args);
		return list;
	}

	public static void main(String[] args) {
		makeList("randy", "randy2", "randy3");
		makeList(1, 2, 3);
	}
}
