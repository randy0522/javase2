package thread;

/**
 * Created by nali on 2018/7/3.
 */
public class InitiativeCatch {
	public static void threadDeal(Runnable r, Throwable t){
		System.out.println("==exception:" + t.getMessage());
	}

	static class InitiativeThread implements Runnable {

		@Override
		public void run() {
			Throwable t = null;
			try {
				System.out.println(3 / 1);
				System.out.println(3 / 0);
				System.out.println(3 / 2);
			} catch (Exception e){
				System.out.println("&&&&&&&&&&&&&&");
				t = e;
			} finally {
				threadDeal(this, t);
			}

		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new InitiativeThread());
		System.out.println(thread.getThreadGroup().getName());
		thread.start();
	}
}

class WithUncautchExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + " exception:" + e.getMessage());
	}
}


