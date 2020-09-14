import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.collections.set.SynchronizedSortedSet;

/**
 * Created by randy on 2019-07-14.
 */

@FunctionalInterface
public interface MyFun {
	Integer getValue(Integer value);

	default void test() {
		System.out.println("randy");
	}

	@Override
	String toString();

	static void test2() {
		System.out.println("randy");
	}
}
