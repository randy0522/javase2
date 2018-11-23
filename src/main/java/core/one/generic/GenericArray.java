package core.one.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by nali on 2018/6/20.
 */
public class GenericArray {
	public static void main(String[] args) {
		Pair[] pairs = new Pair[2];

		pairs[0] = new Pair<String>();
		System.out.println(pairs[0].getValue());

	}

	@SafeVarargs
	public static <E> void addAll(Collection<E> collection, E... array){
		Collections.addAll(collection, array);
	}
}

class Pair<T> {
	public T getValue() {
		return value;
	}

	public  void setValue(T value) {
		this.value = value;
	}

	private T value;
}

class Singleton {
	public static String singlen;

	private static <T> T getSinglen(T name){
		return name;
	}

	public static void main(String[] args) {
	//	System.out.println(getSinglen("randy"));
	//	System.out.println(getSinglen(1));

		int[] a = {1,3,3,3, 3};

		a = new int[]{3,3,3};

		int[] b= new int[0];
		b[0] = 1;
		System.out.println(b[0]);
	}
}

class Holer3<T>{
	private T name;
	private T name2;
	private T name3;

	public Holer3(T name, T name2, T name3){
		this.name = name;
		this.name2 = name2;
		this.name3 = name3;
	}

	public void setName(T name){
		this.name = name;
	}
	public void setName2(T name2){
		this.name2 = name;
	}
	public void setName3(T name3){
		this.name3 = name;
	}

	public T getName(){
		return name;
	}
	public T getName2(){
		return name2;
	}
	public T getName3(){
		return name3;
	}
}

class TwoTuple<T, S>{
	public final T first;
	public final S second;

	public TwoTuple(T first, S second){
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
}

class ThreeTuple<T, S, V> extends TwoTuple<T, S>{
	public final V third;
	public ThreeTuple(T first, S second, V third) {
		super(first, second);
		this.third = third;
	}

	@Override
	public String toString(){
		return "(" + first + "," + second + "," + third + ")";
	}
}

class FourTuple<T, S, V, K> extends ThreeTuple<T, S, V>{
	public final K four;
	public FourTuple(T first, S second, V third, K four){
		super(first, second, third);
		this.four = four;
	}

	@Override
	public String toString(){
		return "(" + first + "," + second + "," + third + "," + four + ")";
	}
}

// base utils class
class Tuple {
	public static <A, B> TwoTuple<A,B> tuple(A a, B b){
		return new TwoTuple<>(a, b);
	}

	public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c){
		return new ThreeTuple<>(a, b, c);
	}

	public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d){
		return new FourTuple<>(a, b, c, d);
	}

	public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e){
		return new FiveTuple<>(a, b, c, d, e);
	}

	// test
	public static void main(String[] args) {
		System.out.println(tuple("randy", 2));
	}
}

class FiveTuple<T, S, V, K, F> extends FourTuple<T, S, V, K>{
	public final F five;
	public FiveTuple(T first, S second, V third, K four, F five){
		super(first, second, third, four);
		this.five = five;
	}

	@Override
	public String toString(){
		return "(" + first + "," + second + "," + third + "," + four + "," + five + ")";
	}
}

class TupleTest{
	public static void main(String[] args) {
		TwoTuple<String, Integer> twoTuple = new TwoTuple<>("randy", 1);
		System.out.println();
	}
}

class LinkStack<T>{
	private static class Node<U>{
		U item;
		Node<U> next;
		Node(){
			item = null;
			next = null;
		}
		Node(U item, Node<U> next){
			this.item = item;
			this.next = next;
		}

		boolean end(){
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<>();
	public void push(T item){
		top = new Node<>(item, top);
	}

}

class Box<T> {
	private T name;
	public void set(T name){
		this.name = name;
	}

	public T get(){
		return name;
	}

	public static void main(String[] args) {
		Box<String> box = new Box<>();
		Box rawBox = box;
		rawBox.set(8);
		String value = (String)rawBox.get();

		System.out.println(value);

		List<String>[] list = new ArrayList[10];
		list[0] = new ArrayList<>();
		list[0].add("randy");
		list[0].add("randy2");
		list[0].add("randy3");
		Object[] objects = list;
		objects[0] = new ArrayList<Integer>(1);
		objects[1] = new ArrayList<String>(1);
	}
}