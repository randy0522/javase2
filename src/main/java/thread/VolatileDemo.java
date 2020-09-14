package thread;


/**
 * Created by randy on 2019-06-26.
 */
public class VolatileDemo {
	public static void main(String[] args) {
		Volatile v = new Volatile();
		new Thread(v).start();
	}
}


class Volatile implements Runnable {
	private int  i = 0;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		i++;
		System.out.println("i=" + i);
	}

	public int isFlag() {
		return i;
	}
}


class IncreDecre {
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i < 100; i++) {
		//	j = i++;
			j += 1;
		}
		System.out.println(j);
	}
}
