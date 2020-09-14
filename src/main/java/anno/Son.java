package anno;

import adapter.Parent;

/**
 * Created by randy on 2019-12-04.
 */
public class Son extends Parent {
	public Son(String name) {
		super(name);
	}

	private void test(Son son) {
		System.out.println(son.name);
	}

	public static void main(String[] args) {
		Son son = new Son("randy");
		son.test(new Son("randy"));
	//	son.test(new Son("randy"));
	}
}

class B implements Cloneable {
	private String name = "randy";

	public static void main(String[] args) throws CloneNotSupportedException {
		B b = new B();
		B clone = (B)b.clone();
		System.out.println(clone.name);
	}
}
