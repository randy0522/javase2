package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nali on 2018/7/3.
 */
public class NoCatchThread {
	public static void main(String[] args) {
		try {
			ExecutorService executorService = Executors.newCachedThreadPool();
			executorService.execute(new Task());
		} catch (Exception e){
			System.out.println("== Exception:" + e.getMessage());
		}

		System.out.println("end.....");
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println(3 / 1);
			System.out.println(3 / 0);
			System.out.println(3 / 2);
		} catch (Exception e){
			try {
				throw new Exception("");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + "*****exception:" + e.getMessage());
	}
}
