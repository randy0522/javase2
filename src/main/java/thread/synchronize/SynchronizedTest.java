package thread.synchronize;

/**
 * Created by nali on 2018/7/20.
 */
public class SynchronizedTest {
	public static void main(String[] args) {
/*		RunnableImpl runnable = new RunnableImpl();
		Thread thread1 = new Thread(runnable, "A");
		Thread thread2 = new Thread(runnable, "B");
		thread1.start();
		thread2.start();*/

		Foo foo = new Foo();
		new Thread(new Runnable() {
			@Override
			public void run() {
				foo.method1();
			}
		}, "A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				foo.method2();
			}
		}, "B").start();
	}
}

class RunnableImpl implements Runnable {
	@Override
	public void run() {
		synchronized (this){
			for (int i = 0; i < 10; i++){
				System.out.println(Thread.currentThread().getName() + " in loop run " + i);
			}
		}
	}

	private void run2(){
		for (int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName() + " in loop run2 " + i);
		}
	}
}

class Foo {
	void method1(){
		synchronized (this){
			for (int i = 0; i < 10; i++){
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " in loop run " + i);
			}
		}
	}

	void method2() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " in loop run " + i);
			}
		}
	}
}

class Thread3 {
	class Inner {
		private void m4t1() {
			int i = 5;
			while(i-- > 0) {
				System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
				try {
					Thread.sleep(500);
				} catch(InterruptedException ie) {
				}
			}
		}
		private void m4t2() {
			int i = 5;
			while(i-- > 0) {
				System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
				try {
					Thread.sleep(500);
				} catch(InterruptedException ie) {
				}
			}
		}
	}
	private void m4t1(Inner inner) {
		synchronized (inner) { //使用对象锁
			inner.m4t1();
		}
	}
	private void m4t2(Inner inner) {
		synchronized (inner){
			inner.m4t2();
		}
	}
	public static void main(String[] args) {
		final Thread3 myt3 = new Thread3();
		final Inner inner = myt3.new Inner();
		Thread t1 = new Thread( new Runnable() {public void run() { myt3.m4t1(inner);} }, "t1");
		Thread t2 = new Thread( new Runnable() {public void run() { myt3.m4t2(inner);} }, "t2");
		t1.start();
		t2.start();
	}
}
