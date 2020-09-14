import org.apache.commons.validator.routines.InetAddressValidator;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.*;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.*;

/**
 * Created by nali on 2018/5/28.
 */
public class Test {
	@org.junit.Test
	public void testAutoCloseable() {
		try (Scanner scanner = new Scanner(new FileInputStream(new File("a.txt"))); PrintWriter printWriter = new PrintWriter("")) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void testStackTrace() throws FileNotFoundException {
		Throwable t = new Throwable();

	//	t.printStackTrace(new PrintWriter("~/Desktop/index(5).html"));
		Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
		for (Thread thread : allStackTraces.keySet()){
			StackTraceElement[] stackTraceElements = allStackTraces.get(thread);
			for (StackTraceElement stackTraceElement : stackTraceElements){
				System.out.println(stackTraceElement);
			}
			System.out.println("%%%%%%%%%%%%%%%%%%");
		}
	}

	@org.junit.Test
	public void testThreadInterruptFunc() throws InterruptedException {
		if (!Thread.currentThread().isInterrupted()){
			System.out.println(Thread.currentThread().getName());
		}
	}

	@org.junit.Test
	public void testJoin() throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread.currentThread().getName() before sleep !");
					Thread.yield();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("print randy, Thread=" + Thread.currentThread().getName() + ", state="+ Thread.currentThread().getState());
			}
		};
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		System.out.println("thread state=" + thread.getState());
//		thread.join();
//		thread.join(3000);
		Thread.sleep(3000);
		System.out.println("current thread=" + Thread.currentThread().getName() + ", state=" + Thread.currentThread().getState());
		System.out.println("after join");
		System.out.println("thread state=" + thread.getState());
	}

	@org.junit.Test
	public void testCollectionToArray(){
		List<String> list = new ArrayList<>();
		list.add("randy1");
		list.add("randy2");
		list.add("randy3");
		list.add("randy4");
		Object[] objects = list.toArray();
		System.out.println(Arrays.toString(objects));
		String[] strings = list.toArray(new String[1]);
		System.out.println(Arrays.toString(strings));

	/*	for (Iterator i = list.iterator(); i.hasNext();){
			System.out.println(i.next());
		}*/

		final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
		System.out.println(DEFAULTCAPACITY_EMPTY_ELEMENTDATA);
	}

	@org.junit.Test
	public void testCompared(){
		int[] bytes = new int[10];
		Random random = new Random(47);
		for (int i = 0; i < bytes.length; i++){
			bytes[i] = random.nextInt(10);
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(0);
	//	list.add(null);
		list.sort(Collections.reverseOrder().reversed());

		System.out.println(list);
	}

	@org.junit.Test
	public void test4(){
	//	boolean valid = InetAddressValidator.getInstance().isValid("999.999.999.999");
		long zero = System.currentTimeMillis() / (1000 * 3600 * 24) * 86400000 - TimeZone.getDefault().getRawOffset();
		System.out.println(zero);
	}

	@org.junit.Test
	public void test22() throws ParseException {
		String x = "2018-42-00";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = dateFormat.parse(x);
		System.out.println(parse);
	}

	private static int[] get(){
		return new int[0];
	}


	@org.junit.Test
	public void testSimpleDatFormat() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 11, 30);
	//	calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-w");
		String format = simpleDateFormat.format(calendar.getTime());
		System.out.println(calendar.isWeekDateSupported());
		System.out.println(format);
	}

	@org.junit.Test
	public void testHash() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		byteBuffer.putInt(3);

	}

	@org.junit.Test
	public void test2s2() {
		Integer opertaion = opertaion(100, x -> x);
		System.out.println(opertaion);

		Arrays.asList(
				1, 2
		);
	}

	private Integer opertaion(Integer num, MyFun myFun) {
		return myFun.getValue(num);
	}

	@org.junit.Test
	public void test223() {
		List<Integer> numbers = getNumbers(10, () -> (int) (Math.random() * 100));
		numbers.forEach(System.out::println);
	}


	public static List<Integer> getNumbers(int numCount, Supplier<Integer> supplier) {
		List<Integer> numbers = new ArrayList<>(numCount);
		for (int i = 0; i < numCount; i++) {
			numbers.add(supplier.get());
		}
		return numbers;
	}

	@org.junit.Test
	public void test224() {
		consume(100, monney -> System.out.println("消费金额" + monney));
	}

	public static void consume(double b, Consumer<Double> consumer) {
		consumer.accept(b);
	}

	@org.junit.Test
	public void test225() {
		String randy = strHandler("randy", String::toUpperCase);
		System.out.println(randy);
	}

	public String strHandler(String str, Function<String, String> function) {
		return function.apply(str);
	}

	@org.junit.Test
	public void test226() {
		List<String> list = Arrays.asList("1AAAAdddd", "333ddd3", "111");
		List<String> filter = filter(list, value -> value.length() > 3);
		filter.forEach(System.out::println);
	}

	public List<String> filter(List<String> list, Predicate<String> predicate) {
		List<String> list1 = new ArrayList<>();
		for (String s : list) {
			if (predicate.test(s)) {
				list1.add(s);
			}
		}
		return list1;
	}

	@org.junit.Test
	public void test227() {
		Consumer consumer = x -> System.out.println(x);
		PrintStream out = System.out;
		Consumer consumer1 = out::println;
		consumer1.accept(3);

	}

	@org.junit.Test
	public void test228(){
		BiPredicate<String, String> b1 = (x, y) -> x.equals(y);

		BiPredicate<String, String> b2 = String::equals;

		Function<Integer, String[]> function = String[]::new;
	}

	@org.junit.Test
	public void test229() {
		Arrays.stream(Test.class.getMethods()).forEach(method -> {
			if (Void.TYPE.equals(method.getReturnType())){
				System.out.println(method.getName());
			}
		});
	}

	Void function(int a, int b) {
		HashMap hashMap = new HashMap();
		hashMap.entrySet();
		Future<Void> submit = Executors.newCachedThreadPool().submit(() -> {
			System.out.println("sss"); return null;
		});


		return null;
	}
}
