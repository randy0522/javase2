package thread;


import org.apache.commons.collections.set.SynchronizedSortedSet;

import java.io.IOException;

/**
 * Created by randy on 2019/4/15.
 */
public class ResponsiveUI extends  Thread {
	private static volatile double d = 1;

	public ResponsiveUI() {
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		while (true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}

	public static void main(String[] args) throws IOException {
		new ResponsiveUI();
		int read = System.in.read();
		System.out.println("read:" + read);
		System.out.println(d);
	}
}
