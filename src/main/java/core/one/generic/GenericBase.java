package core.one.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nali on 2018/6/26.
 */
public class GenericBase<T> {
	private T element;
	public void set(T element){
		this.element = element;
	}
	public T getElement(){
		return element;
	}

	public static void main(String[] args) {
		Base2 base2 = new Base2();
		Object element = base2.getElement();
		base2.set(element);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		print(list);
	}

	public static void print(List<? extends Number> list) {
		for (Number n : list)
			System.out.print(n + " ");
		System.out.println();
	}
}

class Base1<T, K> extends GenericBase<T> {}

class Base2 extends GenericBase {}
