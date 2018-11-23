package pattern;

/**
 * Created by nali on 2018/9/26.
 */

interface Dog {
	void speek();
}

class SmallDog implements Dog {

	@Override
	public void speek() {
		System.out.println("small dog is speeking !");
	}
}

class BigDog implements Dog {

	@Override
	public void speek() {
		System.out.println("big dog is speeking !");
	}
}

class UglyDog implements Dog {

	@Override
	public void speek() {
		System.out.println("ugly dog is speeking !");
	}
}

class DogFactory {
	public static Dog get(String decription) {
		if ("small".equals(decription)) {
			return new SmallDog();
		} else if ("big".equals(decription)) {
			return new BigDog();
		} else if ("ugly".equals(decription)) {
			return new UglyDog();
		} else {
			throw new IllegalArgumentException("decription dog not support !");
		}
	}
}

public class FactoryPatterDemo {
	public static void main(String[] args) {
		Dog dog = DogFactory.get("small");
		dog.speek();
		dog = DogFactory.get("big");
		dog.speek();
		dog = DogFactory.get("ugly");
		dog.speek();
	}
}
