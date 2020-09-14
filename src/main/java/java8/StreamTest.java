package java8;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by randy on 2019-07-17.
 */
public class StreamTest {
	@Test
	public void test1() {
		List<String> list = Arrays.asList("1", "2");
		Stream<String> stream = list.stream();

		Stream<String> stream1 = Arrays.stream(new String[]{"1", "2"});

		Stream<String> aa = Stream.of("aa", "bb");
	//	aa.skip(1).forEach(System.out::println);

		// 无限流
		Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
	//	iterate.limit(10).forEach(System.out::println);
		//Stream.generate(() -> Math.random()).limit(10).filter(value -> value > 0.1).forEach(System.out::println);

		Stream<String> stringStream = Stream.of("a", "b", "c");
		stringStream.map(String::toUpperCase).forEach(System.out::println);
		Stream.generate(Math::random).forEach(System.out::println);
	}

	@Test
	public void test2() {
		Stream<String> aa = Stream.of("aa", "bb", "cc");
		aa.flatMap(StreamTest::filter).forEach(System.out::println);
	}

	private static Stream<Character> filter(String str) {
		List<Character> characters = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			characters.add(character);
		}
		return characters.stream();
	}

	@Test
	public void test3() {
		Stream<String> aa = Stream.of("kk","kka","aa", "bb", "cc");
		aa.sorted().forEach(System.out::println);
	}

	@Test
	public void test4() {
		Stream.iterate("2019-07-01", seed -> LocalDate.parse(seed).plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE)).
				limit(10).
				forEach(System.out::println);
	}

	@Test
	public void test5() {
		System.out.println("3_" + null);
	}

}
