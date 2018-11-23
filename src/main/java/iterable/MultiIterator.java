package iterable;

import java.util.*;

/**
 * Created by nali on 2018/7/10.
 */
public class MultiIterator implements Iterable<String> {
	private static final String[] words = "may i have your attention please".split(" ");

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}
		};
	}

	public Iterable<String> reverseIterator(){
		return () -> new Iterator<String>() {
			int index = words.length - 1;
			@Override
			public boolean hasNext() {
				return index > - 1;
			}

			@Override
			public String next() {
				return words[index--];
			}
		};
	}

	public Iterable<String> randomized(){
		return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				List<String> list = Arrays.asList(words);
				Collections.shuffle(list, new Random(47));
				return list.iterator();
			}
		};
	}

	public static void main(String[] args) {
		MultiIterator multiIterator = new MultiIterator();
		for (String s : multiIterator){
			System.out.print(s);
		}

		System.out.println("^^^^^^^^^");
		for (String s : multiIterator.reverseIterator()){
			System.out.print(s);
		}

		System.out.println("^^^^^^^");
		for (String s : multiIterator.randomized()){
			System.out.print(s);
		}

		System.out.println(1000_0);
	}
}
