package core;

import core.testprotected.ProtectedDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;
import java.util.Date;

/**
 * Created by randy on 2019-05-28.
 */
class ProtetectSub extends ProtectedDemo {
/*	@Override
	public void test() {
		System.out.println(super.age);
		age = 10;
		System.out.println(age);
	}*/

	public void print(ProtetectSub protetectSub) {
		System.out.println(protetectSub.age);
		test();
	}

	public static void main(String[] args) {
		ProtetectSub protetectSub = new ProtetectSub();
		protetectSub.test();

		ProtectedDemo protectedDemo = new ProtectedDemo();
	}
}


class Test {
	public static void main(String[] args) {
		ProtetectSub protetectSub = new ProtetectSub();
		//protetectSub.age;
	}
}

class InnerClassTest {
	public static void main(String[] args) {
		TalkClock talkClock = new TalkClock(10000, true);
		TalkClock.TimePrinter timePrinter = talkClock.new TimePrinter();
		talkClock.start();
		JOptionPane.showMessageDialog(null, "QUIT ?");
		System.exit(0);

	}
}

class TalkClock {
	private int interval;
	private boolean beep;

	TalkClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	void start() {
		ActionListener actionListener = new TimePrinter();
		Timer timer = new Timer(interval, actionListener);
		timer.start();
	}

	class TimePrinter implements ActionListener  {
		TimePrinter(){}

		@Override
		public void actionPerformed(ActionEvent e) {
			Date date = new Date();
			System.out.println("at this tone, now time is:" + date);
			if (TalkClock.this.beep) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}


