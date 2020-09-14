package lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by randy on 2019-07-05.
 */
public class LambdaTest {

	@Test
	public void test1() {
		List<String> list = Arrays.asList(new String[] {"randy1", "randy2", "randy3"});
		List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		collect.forEach(System.out::println);

		Stream.generate(Math::random).limit(100).forEach(System.out::println);
	}
}
