import sun.reflect.Reflection;

/**
 * Created by randy on 2019-04-29.
 */
public class UnSafeDemo {
	public static void main(String[] args) {
		Class<?> callerClass = Reflection.getCallerClass();
		System.out.println(callerClass.getName());
	}
}
