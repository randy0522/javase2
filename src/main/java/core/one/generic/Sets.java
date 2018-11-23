package core.one.generic;

import java.util.*;

/**
 * Created by nali on 2018/6/23.
 */
public class Sets {
	public static <T> Set<T> union(Collection<T> a, Collection<T> b){
		Set<T> results = new HashSet<>(a);
		results.addAll(b);
		return results;
	}

	public static <T> Set<T> intersection(Set<T> a, Set<T> b){
		Set<T> results = new HashSet<>(a);
		results.retainAll(b);
		return results;
	}

	public static <T> Set<T> different(Set<T> a, Set<T> b){
		Set<T> results = new HashSet<>(a);
		results.removeAll(b);
		return results;
	}

	public static <T> Set<T> complement(Set<T> a, Set<T> b){
		return different(union(a, b), intersection(a, b));
	}

	public static void main(String[] args) {
		Set<Integer> a = new HashSet<>();
		a.add(1);
		a.add(2);
		a.add(3);

		Set<Integer> b = new HashSet<>();
	//	b.add(3);
		b.add(4);
		b.add(5);

		System.out.println(union(a, b));
		System.out.println(intersection(a, b));
		System.out.println(different(a, b));
		System.out.println(complement(a, b));
		List<?>[] lists = new ArrayList<?>[1];
		List<String>[] lists2 = new ArrayList[1];
	}
}
