package aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by randy on 2020/6/10.
 */
public class AQSDemo {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock r1 = new ReentrantLock();
		Condition condition = r1.newCondition();
		System.out.println(Thread.currentThread().getName() + " start r1.lock");
		r1.lock();
		r1.lock();

		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " strat r1.lock");
				r1.lock();
			}
		});
		th.start();
		condition.await();
		System.out.println(Thread.currentThread().getName() + " start r1.unlock");
		r1.unlock();
		r1.unlock();
		System.out.println("main thread over");
	}
}
