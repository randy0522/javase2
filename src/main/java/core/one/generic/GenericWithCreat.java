package core.one.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by nali on 2018/6/26.
 */
abstract class GenericWithCreat<T> {
	T element;
	GenericWithCreat(){
		element = create();
	}
	abstract T create();
}

class X {}

class Creator extends GenericWithCreat<X> {
	@Override
	X create() {
		return new X();
	}

	public void f(){
		System.out.println(element.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		new Creator().f();
	}
}
class A {
	String name;

	A (String name){
		this.name = name;
	}

	public A create(){
		return new A(name);
	}
}

class Test1<T> {
	public Constructor<T> getConstructor(Class<T> clazz) throws NoSuchMethodException {
		return clazz.getDeclaredConstructor(String.class);
	}

	public T getInstant(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		return getConstructor(clazz).newInstance("String");
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Test1<A> test = new Test1<>();
		A instant = test.getInstant(A.class);
		System.out.println(instant.name);

	}
}
