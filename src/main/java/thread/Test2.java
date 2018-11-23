package thread;

/**
 * Created by nali on 2018/7/16.
 */
public class Test2 {
	public static void main(String[] args) {
		RunnableTest runnableTest = new RunnableTest();
		for (int i = 0; i < 100; i++){
			new Thread(runnableTest).start();
		}
	}
}

class RunnableTest implements Runnable {

	@Override
	public void run() {
		int i = 0;
		i++;
		System.out.println(i);
	}
}
