package core;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.*;

/**
 * Created by randy on 2019-05-27.
 */
public class Base64Demo {

	@Test
	public void testBasic() {
		Base64.Encoder encoder = Base64.getEncoder();
		// encode4
		String s = encoder.encodeToString("打扰了，我的居住证积分有效期已经到期了,居住证有效时间已经续办到了2020/5/25,麻烦帮忙在后台提交下积分申请哈，谢谢啦".getBytes());
		System.out.println(s); // cmFuZHk=

		// decoder
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode("66666=");
		System.out.println(new String(decode));
	}

	@Test
	public void testURL() {
		Base64.Encoder urlEncoder = Base64.getUrlEncoder();
		String s = urlEncoder.encodeToString("http://www.baidu.com".getBytes());
		System.out.println(s);
	}

	@Test
	public void testGCD() {
		System.out.println(gcd(8, 4));
	}

	private static int gcd(int p, int q) {
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

	@Test
	public void testDouble() {
		int compare = Double.compare(-0.0, 0.0);
		System.out.println(compare);
	}

	@Test
	public void test3() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");


		List<String> list2 = new ArrayList<>();
		list2.add("2");
		list2.add("4");
		list2.add("2");
		list1.removeAll(list2);

	//	list1.retainAll(list2);
		System.out.println(list1);
	}

	@Test
	public void test4() {
		Instant instant = Instant.now();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
		System.out.println(zonedDateTime.toInstant().toEpochMilli());

//		Duration.between(LocalDate.now(), LocalDate.now());
		int months = Period.ofDays(3).getMonths();
//		System.out.println(months);

		LocalDate of = LocalDate.of(2019, 7, 23);
		LocalDate of2 = LocalDate.of(2019, 7, 24);
		int days = of.until(of2).getDays();
		int days1 = Period.between(of, of2).getDays();
		System.out.println(days + "," + days1);
	}

	@Test
	public void test5() {
		LocalDate now = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 5);
		System.out.println(now);
		LocalDate nextWorkingDate = now.with(a -> {
			LocalDate localDate = (LocalDate) a;
			int i = localDate.get(ChronoField.DAY_OF_WEEK);
			switch (i) {
				case 5:
					return localDate.plusDays(3);
				case 6:
					return localDate.plusDays(2);
				default:
					return localDate.plusDays(1);
			}
		});
		System.out.println(nextWorkingDate);
	}

	@Test
	public void test6() {
		List<String> list = Arrays.asList("1", "2");
		list.remove("1");
	}

	@Test
	public void test7() {
		testPerson(null);
	}

	@Test
	public void test8() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator<Integer> iterator = list.iterator();

		list.forEach(System.out::println);

		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (next == 3) {
				list.add(3);
			}
		}
		System.out.println(list);
	}


	@Test
	public void test1() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			int i = 0;
			@Override
			public void run() {
				System.out.println("i=" + ++i);
			}
		}, 1L, 1000L* 3);
	}


	public static void testPerson(Person person) {
		Optional<Person> opt = Optional.ofNullable(person);
		Person getOrDefault = opt.orElseGet(() -> new Person());
		System.out.println("age:" + getOrDefault.age + ", name:" + getOrDefault.name);
	}

	static class Person {
		private String name;
		private int age;
	}
}
