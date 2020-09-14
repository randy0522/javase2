package thread;

import org.apache.commons.collections.set.SynchronizedSortedSet;

/**
 * Created by randy on 2019/4/15.
 */
public class JoinDemo {
	public static void main(String[] args) {
		Sleeper sleeperA = new Sleeper("sleeperA", 1500);
		Sleeper sleeperB = new Sleeper("sleeperB", 1500);

		Joiner joinerA = new Joiner("joinerA", sleeperA);
		Joiner joinerB = new Joiner("joinerB", sleeperB);
	}
}


class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		this.duration = sleepTime;
		start();
	}

	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was Interrupt." + "isInterrupt(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " is awakened");
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper){
		super(name);
		this.sleeper = sleeper;
		start();
	}

	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		}

		System.out.println(getName() + " join completed");
	}
}
