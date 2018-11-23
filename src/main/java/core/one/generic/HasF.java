package core.one.generic;

/**
 * Created by nali on 2018/6/25.
 */
public class HasF {
	public void f(){
		System.out.println("hasF.instanceOf()");
	}
}

class Manipulator<T extends HasF>{
	private T obj;
	public Manipulator(T obj){
		this.obj = obj;
	}

	public void manipulate(){
		obj.f();
	}

	public static void main(String[] args) {
		Manipulator<HasF> hasFManipulator = new Manipulator<>(new HasF());
		hasFManipulator.manipulate();
	}
}

interface InterfaceA{
	void a();
	void b();
}

class InterfaceAImple implements InterfaceA {

	@Override
	public void a() {
		System.out.println("in a");
	}

	@Override
	public void b() {
		System.out.println("in b");
	}

	public static <T extends InterfaceA> void c(T t){
		t.a();
	}

	public static void main(String[] args) {
		InterfaceAImple interfaceAImple = new InterfaceAImple();
		c(interfaceAImple);
	}
}
