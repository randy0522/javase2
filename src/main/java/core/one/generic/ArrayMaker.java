package core.one.generic;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nali on 2018/6/25.
 */
public class ArrayMaker<T> {
	private Class<T> clazz;

	public ArrayMaker(Class<T> clazz){
		this.clazz = clazz;
	}

//	@SuppressWarnings("unchecked")
	public T[] create(int size){
		return (T[])Array.newInstance(clazz, size);
	}

	public static void main(String[] args) {
		ArrayMaker<String> arrayMaker = new ArrayMaker<>(String.class);
		String[] strings = arrayMaker.create(10);
		System.out.println(Arrays.toString(strings));
	}
}

class ListMaker<T> {
	List<T> create(){
		return new ArrayList<T>();
	}

	public static void main(String[] args) {
		ListMaker<String> listMaker = new ListMaker<>();
		listMaker.create();
	}
}

class FilledListMaker<T> {
	List<T> create(T t, int size){
		List<T> results = new ArrayList<>(size);
		for (int i = 0; i < size; i++){
			results.add(t);
		}
		return results;
	}

	public static void main(String[] args) {
		FilledListMaker<String> filledListMaker = new FilledListMaker<>();
		List<String> randys = filledListMaker.create("randy", 4);
		System.out.println(randys);
	}
}

class Erased<T>{
	private final int size = 100;
	public void f(Object arg){
	//	if (arg instanceof T){}
	//	T var = new T();
	//	T[] vars = new T[2];
	}
}
