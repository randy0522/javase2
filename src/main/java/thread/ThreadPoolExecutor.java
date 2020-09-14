package thread;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by randy on 2019-12-04.
 */
public class ThreadPoolExecutor {
	private final static Set<ThreadTask> ThreadTasks = new HashSet<>();

	private static Runnable getUserTask() {
		return () -> System.out.println("aaaa");
	}

	public static class ThreadTask implements Runnable {
		private Thread thread;
		private Runnable userTask;

		private ThreadTask(Runnable userTask) {
			this.thread = new Thread(this);
			this.userTask = userTask;
		}

		@Override
		public void run() {
			while (userTask != null || (userTask = getUserTask()) != null) {
				userTask.run();
			}
		}
	}

	public static void main(String[] args) {
		Runnable userTask = () -> System.out.println("bbb");
		ThreadTask threadTask = new ThreadTask(userTask);
		threadTask.thread.start();
		ThreadTasks.add(threadTask);
	}
}
