package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

/**
 * Created by nali on 2018/7/9.
 */
public class UniqueThreadIdGenerator implements Runnable {
	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(10);

	private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return ATOMIC_INTEGER.getAndIncrement();
		}
	};

	public int getCurrentThreadId(){
		return THREAD_LOCAL.get();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " unique id " + getCurrentThreadId());
	}
}

class TesX {
	public static void main(String[] args) {
		UniqueThreadIdGenerator uniqueThreadIdGenerator = new UniqueThreadIdGenerator();
		for (int i = 0; i < 10; i++){
			Thread thread = new Thread(uniqueThreadIdGenerator);
			thread.start();
		}

		IntBinaryOperator binaryOperator = (x, y) -> x + y;
		System.out.println(binaryOperator.applyAsInt(3, 3));
	}
}
