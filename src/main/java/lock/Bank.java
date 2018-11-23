package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nali on 2018/7/5.
 */
public class Bank {
	private Lock lock = new ReentrantLock();

	public void transform(double amount, int from, int to){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName());
		} catch (Exception e){
			lock.unlock();
		}
	}
}
