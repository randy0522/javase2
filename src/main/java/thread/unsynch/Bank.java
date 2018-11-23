package thread.unsynch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nali on 2018/7/7.
 */
public class Bank {
	private final Double[] accounts;
	private Lock lock = new ReentrantLock();

	public Bank(int n, double initialBalance){
		accounts = new Double[n];
		for (int i = 0; i < n; i++){
			accounts[i] = initialBalance;
		}
	}

	public void transform(int from, int to, double amount) {
		lock.lock();
		try {
			if (accounts[from] < amount) return;
			System.out.println("current thread is " + Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("%10.2f from %d to %d, from acount left amount: %10.2f", amount, from, to, accounts[from]);
			int x = 3 / 0;
			accounts[to] += amount;
			System.out.printf("after transfrom, total amount: %10.2f", getTotalBalance());
		} finally {
			lock.unlock();
		}
	}

	public double getTotalBalance(){
		double sum = 0;
		for (double amount : accounts){
			sum += amount;
		}
		return sum;
	}

	public int size(){
		return accounts.length;
	}
}

class TransformRunnable implements Runnable {
	private Bank bank;
	private int from;
	private double maxAmount;
	private static final int DELAY = 10;

	public TransformRunnable(Bank bank, int from, double maxAmount){
		this.bank = bank;
		this.from = from;
		this.maxAmount = maxAmount;
	}

	@Override
	public void run() {
		int toAcount = (int)(bank.size() * Math.random());
		double amount = maxAmount * Math.random();
		bank.transform(from, toAcount, amount);
		try {
			Thread.sleep((int)(DELAY * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class UnsynchBankTest {
	private static final int NACCOUNTS = 100;
	private static final double INITAL_BALANCE = 1000;
	public static void main(String[] args) {
		Bank bank = new Bank(NACCOUNTS, INITAL_BALANCE);
		for (int i = 0; i < NACCOUNTS; i++){
			TransformRunnable runnable = new TransformRunnable(bank, i, INITAL_BALANCE);
			Thread thread = new Thread(runnable);
			thread.start();
		}
	}
}
