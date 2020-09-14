package cto;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by randy on 2020/6/4.
 */
public class CountDownLatchTest1 {
	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		new Thread(() -> {
			System.out.println("wait to count down to zero");
			try {
				countDownLatch.await(1, TimeUnit.SECONDS);
				System.out.println("t2 stop");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2").start();

		new Thread(() -> {
			System.out.println("wait to count down to zero");
			try {
				countDownLatch.await();
				System.out.println("t3 stop");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t3").start();

		new Thread(() -> {
			try {
				Thread.sleep(3000L);
				System.out.println("countDownLatch count down to 2");
				countDownLatch.countDown();
				System.out.println("countDownLatch count down to 1");
				countDownLatch.countDown();
				System.out.println("countDownLatch count down to 0");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1").start();
	}
}
