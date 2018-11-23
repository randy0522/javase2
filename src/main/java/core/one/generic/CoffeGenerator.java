package core.one.generic;

import java.util.*;

/**
 * Created by nali on 2018/6/23.
 */
public class CoffeGenerator implements Generator<Coffe>, Iterable<Coffe>{
	private Class[] types =
			new Class[]{Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

	private int size = 0;
	CoffeGenerator(){}

	CoffeGenerator(int size){
		this.size = size;
	}

	private Random random = new Random(47);
	@Override
	public Coffe next() {
		try {
			return (Coffe) types[random.nextInt(types.length)].newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	class CoffeIterator implements Iterator<Coffe>{
		int count = size;
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffe next() {
			count--;
			return CoffeGenerator.this.next();
		}
	}

	@Override
	public Iterator<Coffe> iterator() {
		return new CoffeIterator();
	}

	public static void main(String[] args) {
		CoffeGenerator coffeGenerator = new CoffeGenerator();
		System.out.println(coffeGenerator.next());

		for (Coffe coffe : new CoffeGenerator(5)){
			System.out.println(coffe);
		}
	}
}

class Generators {
	public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n){
		for (int i = 0; i < n; i++){
			collection.add(generator.next());
		}
		return collection;
	}
	public static <T> List<T> fill(List<T> list, Generator<T> generator, int n){
		System.out.println("666");
		for (int i = 0; i < n; i++){
			list.add(generator.next());
		}
		return list;
	}

	public static void main(String[] args) {
		Collection<Coffe> fill = fill(new ArrayList<Coffe>(), new CoffeGenerator(), 3);

		for (Coffe coffe : fill){
			System.out.println(coffe);
		}
	}
}

interface Generator<T>{
	T next();
}

class Coffe{
	private static int counter = 0;
	private final long id = counter++;

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " " + id;
	}
}

class Latte extends Coffe{}
class Mocha extends Coffe{}
class Cappuccino extends Coffe{}
class Americano extends Coffe{}
class Breve extends Coffe{}