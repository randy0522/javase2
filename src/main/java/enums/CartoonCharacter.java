package enums;


import javax.lang.model.type.ErrorType;
import java.util.Random;

/**
 * Created by randy on 2018/12/4.
 */

public enum CartoonCharacter {
	A, B, C;
	private static Random random = new Random(47);

	public static CartoonCharacter next() {
		return values()[random.nextInt(values().length)];
	}
}

class EnumImplement {
	public static <T extends Enum<T>> void printNext() {
		System.out.println(CartoonCharacter.next());
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			printNext();
		}
	}
}

interface Food {
	enum A implements Food {
		a,b;
	}

	enum B implements Food {
		c,d;
	}

	enum C implements Food {
		e,f;
	}
}

class Enums {
	private static final Random RANDOM = new Random(47);
	public static<T extends Enum<T>> T[] random(Class<T> clazz) {
		return clazz.getEnumConstants();
	}

	public static <T> T random(T[] values) {
		return values[RANDOM.nextInt(values.length)];
	}
}

class TypeOfFood {
	public static void main(String[] args) {
		Food food1 = Food.A.a;
	}
}

enum Course {
	A(Food.A.class),
	B(Food.B.class);

	private Food[] foods;
	Course(Class<? extends Food> clazz) {
		this.foods = clazz.getEnumConstants();
	}

	private Food random() {
		return Enums.random(foods);
	}
}
