package pattern;

/**
 * Created by nali on 2018/9/27.
 */
public class StrategyDesignDemo3 {
}

interface IBrakeBehavior {
	void brake();
}

class Brake implements IBrakeBehavior {
	@Override
	public void brake() {
		System.out.println("simple brake");
	}
}

class ABSBrake implements IBrakeBehavior {
	@Override
	public void brake() {
		System.out.println("use ABS brake");
	}
}

abstract class Car {
	protected IBrakeBehavior brakeBehavior;

	void applyBrake(){
		brakeBehavior.brake();
	}
}
