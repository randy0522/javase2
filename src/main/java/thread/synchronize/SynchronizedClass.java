package thread.synchronize;

/**
 * Created by nali on 2018/7/20.
 */
public class SynchronizedClass {
	public static void main(String[] args) {
		Foo2 foo2 = new Foo2();
		new Thread(foo2, "A").start();
		new Thread(foo2, "B").start();
	}
}

class Foo2 implements Runnable {
	private int i;
	private byte[] lock = new byte[0];

	@Override
	public void run() {
		i += 1;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " i=" + i);
	}

	public void run2(){

	}
}

class Foo3 {

}


