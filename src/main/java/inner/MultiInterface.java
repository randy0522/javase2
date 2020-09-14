package inner;

/**
 * Created by randy on 2019-12-12.
 */
public class MultiInterface {
	private static void takeA(A a) {}
	private static void takeB(B b) {}

	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		takeA(x);
		takeA(y);

	//	takeB(x);
		takeB(y.makeB());
	}
}

abstract class A {
}

abstract class B {
}

class X extends A {
}

class Y extends A {
	B makeB() {
		return new B() {
		};
	}
}
