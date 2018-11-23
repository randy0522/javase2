package pattern;

/**
 * Created by nali on 2018/9/26.
 */

class Context {
	private Strategy strategy;

	public Context() {
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void performance() {
		strategy.execute();
	}
}

interface Strategy {
	void execute();
}

class StrategyA implements Strategy {

	@Override
	public void execute() {
		System.out.println("execute StrategyA !");
	}
}

class StrategyB implements Strategy {

	@Override
	public void execute() {
		System.out.println("execute StrategyB !");
	}
}

public class StrategyDesignDemo {
	public static void main(String[] args) {
		Context context = new Context();
		context.setStrategy(new StrategyA());
		context.performance();

		context.setStrategy(new StrategyB());
		context.performance();
	}
}
