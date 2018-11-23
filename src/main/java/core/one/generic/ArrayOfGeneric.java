package core.one.generic;

/**
 * Created by nali on 2018/6/26.
 */
public class ArrayOfGeneric {
	private static int size = 100;
	static Generic<Integer>[] generics;

//	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	//	generics = new Generic<Integer>[size];
		generics = (Generic<Integer>[]) new Generic[size];
		System.out.println(generics.getClass().getSimpleName());
		generics[0] = new Generic<>();
	}
}

class Generic<T> {}
