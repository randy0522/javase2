package aqs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by randy on 2020/7/30.
 */

public class ConditionDemo {
	private static final Log LOG = LogFactory.getLog(ConditionDemo.class);

	ReentrantLock lock = new ReentrantLock();
	final Condition condition = lock.newCondition();

	@Test
	public void test1() throws InterruptedException {
		new Consumer().start();
		Thread.sleep(3000L);
		new Producer().start();
	}

	class Consumer extends Thread {
		@Override
		public void run() {
			consumer();
		}

		private void consumer() {
			lock.lock();
			try {
				LOG.info("消费线程：" + Thread.currentThread().getName() + " 等待被唤醒");
				condition.await();
				LOG.info("消费线程：" + Thread.currentThread().getName() + " 已经被唤醒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				LOG.info("消费线程：" + Thread.currentThread().getName() + " 释放锁");
			}
		}
	}

	class Producer extends Thread {
		@Override
		public void run() {
			produce();
		}

		private void produce() {
			lock.lock();
			try {
				LOG.info("生产线程：" + Thread.currentThread().getName() + " 获取锁");
				condition.signal();
				LOG.info("生产线程：" + Thread.currentThread().getName() + " 唤醒等待的消费线程");
			} finally {
				lock.unlock();
				LOG.info("生产线程：" + Thread.currentThread().getName() + " 释放锁");
			}
		}
	}
}
