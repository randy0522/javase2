package core.one.generic;

/**
 * Created by nali on 2018/6/26.
 */
public class FactoryConstraint {
	public static void main(String[] args) {
		new Foo<>(new IntegerFactory(), 1);
		new Foo<>(new Weight.Factory(), new Weight());
	}
}

interface FacctoryI<T> {
	T create(T t);
}

class Foo<T> {
	<F extends FacctoryI<T>> Foo(F factory, T t){
		factory.create(t);
	}
}

class IntegerFactory implements FacctoryI<Integer> {

	@Override
	public Integer create(Integer integer) {
		return integer;
	}
}

class Weight {
	static class Factory implements FacctoryI<Weight> {
		@Override
		public Weight create(Weight weight) {
			return weight;
		}
	}
}

