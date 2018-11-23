package core.one.generic;

/**
 * Created by nali on 2018/6/23.
 */
public class GenericMethod {
	public static <T> void f(T value){
		System.out.println(value.getClass().getName());
	}

	public static <T, S, U> void f(T value1, S value2, U value3){
		System.out.println("value1=" + value1.getClass().getSimpleName() + ", value2=" + value2.getClass().getSimpleName() + ", value3=" + value3.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		f("randy");
		f(1);
		f(1L);
		f(new Object());
	}
}
