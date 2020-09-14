package aqs;

import com.sun.javafx.scene.control.skin.TableColumnHeader;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * Created by randy on 2020/6/17.
 */
public class SemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		Thread t1 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				semaphore.acquire();
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				semaphore.acquire();
			}
		}, "t2");

		Thread t3 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				semaphore.acquire();
			}
		}, "t3");

		Thread t4 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				Thread.sleep(3000L);
				semaphore.release();
			}
		}, "t4");


		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(1000L);
		t4.start();
	}
}
