package thread;

/**
 * Created by nali on 2018/7/3.
 */
public class ExeceptionThread2 implements Runnable {

	@Override
	public final void run() {
		final Thread thread = Thread.currentThread();
		System.out.println("run by " + thread.getName());
		System.out.println("eh=" + thread.getUncaughtExceptionHandler());
	//	throw new RuntimeException();
		new AbstractClass(3){

			@Override
			void print() {
				System.out.println("randy&&&&");
			}
		};
	}
}

class Test {
	public static void main(String[] args) {
		Thread thread = new Thread(new ExeceptionThread2());
		thread.start();

		Thread thread1 = new Thread(new Runnable() {
			int x = 1;
			@Override
			public void run() {
				x = 3;
			}
		});
	}
}

abstract class AbstractClass {
	AbstractClass(int x){
		System.out.println(x);
	}

	abstract void print();
}
