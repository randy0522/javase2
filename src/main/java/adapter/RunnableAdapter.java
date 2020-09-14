package adapter;

import java.util.concurrent.Callable;

/**
 * Created by randy on 2019-06-28.
 */
public class RunnableAdapter<T> implements Callable<T> {
	private final T result;
	private final Runnable runnable;

	/**
	 *  {@code Runnalbe}
	 * @param result
	 * @param runnable
	 */
	public RunnableAdapter(T result, Runnable runnable) {
		this.result = result;
		this.runnable = runnable;
	}

	@Override
	public T call() throws Exception {
		runnable.run();
		return result;
	}
}
