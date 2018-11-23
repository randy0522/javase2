package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nali on 2018/9/27.
 */
public class StrategyDesignDemo2 {
	public static void main(String[] args) {
		Customer customer = new Customer(new NormalStrategy());
		customer.add(0.8, 1);
		customer.setBillingStrategy(new HappyHourStrategy());
		customer.add(1.5, 2);
		customer.printBill();
	}
}

class Customer {
	private IBillingStrategy billingStrategy;

	private List<Double> drinks;

	public Customer (final IBillingStrategy billingStrategy) {
		this.billingStrategy = billingStrategy;
		this.drinks = new ArrayList<>();
	}

	public void add(double price, int quality) {
		drinks.add(billingStrategy.getActPrice(price * quality));
	}

	public void printBill() {
		double sum = 0;
		for (double drink : drinks) {
			sum += drink;
		}
		System.out.println("bill is " + sum);
		drinks.clear();
	}

	public void setBillingStrategy(IBillingStrategy billingStrategy) {
		this.billingStrategy = billingStrategy;
	}
}

interface IBillingStrategy {
	double getActPrice(final double rawPrice);
}

class NormalStrategy implements IBillingStrategy {

	@Override
	public double getActPrice(final double rawPrice) {
		return rawPrice;
	}
}

class HappyHourStrategy implements IBillingStrategy {

	@Override
	public double getActPrice(final double rawPrice) {
		return rawPrice * 0.5;
	}
}
