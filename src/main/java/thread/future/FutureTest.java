package thread.future;

import java.util.concurrent.*;

/**
 * Created by nali on 2018/7/11.
 */
public class FutureTest {
	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
	private static ArchiveSearcher archiveSearcher = new ArchiveSearcherImpl();

	private static Future<String> showSearch(){
		return EXECUTOR_SERVICE.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return archiveSearcher.search("randy");
			}
		});
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Future<String> stringFuture = showSearch();
		while (true){
			stringFuture.cancel(true);
			if (stringFuture.isDone()){
				System.out.println(stringFuture.get() + " " + stringFuture.cancel(false) + ", " + stringFuture.isCancelled());
				EXECUTOR_SERVICE.shutdown();
				break;
			} else {
				System.out.println("Not finish yet");
			}
		}
	}
}

interface ArchiveSearcher {
	String search(String target);
}

class ArchiveSearcherImpl implements ArchiveSearcher {
	@Override
	public String search(String target) {
		return target;
	}
}
