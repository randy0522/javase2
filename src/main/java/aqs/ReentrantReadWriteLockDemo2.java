package aqs;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by randy on 2020/7/7.
 */
public class ReentrantReadWriteLockDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
		final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
		final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				writeLock.lock();
			}
		}, "t1");


		Thread t2 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				Thread.sleep(3000L);
				writeLock.lock();
			}
		}, "t2");


		Thread t3 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				Thread.sleep(3000L);
				readLock.lock();
			}
		}, "t3");

		// 不同的线程写写互斥
		t1.start();
		t2.start();

		// 不同的线程写读互斥
/*		t1.start();
		t3.start();*/
	}
}
