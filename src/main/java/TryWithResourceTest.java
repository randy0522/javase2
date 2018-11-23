/**
 * Created by nali on 2018/6/27.
 */
public class TryWithResourceTest {
	public static void main(String[] args) {
		try (AutoCloseable autoCloseable = new AutoCloseableImpl()) {
			System.out.println(autoCloseable.getClass().getSimpleName());
			System.out.println("--try--");
		} catch (Exception e) {
			System.out.println("--catch--");
			e.printStackTrace();
		}
	}
}

class AutoCloseableImpl implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("--close--");
	}
}
