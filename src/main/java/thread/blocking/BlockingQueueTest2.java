package thread.blocking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by nali on 2018/7/10.
 */
public class BlockingQueueTest2 {
	private static final int QUEUE_SIZE = 10;
	private static final int SEARCH_THREADS = 100;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input the base search directory, like:/Users/nali/Desktop");
		String baseDir = scanner.nextLine();
		System.out.println("input the search keyword, like:randy");
		String keyword = scanner.nextLine();
		BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<File>(QUEUE_SIZE);
		new Thread(new FileEnumerate(new File(baseDir), blockingQueue)).start();
		for (int i = 0; i < SEARCH_THREADS; i++){
			new Thread(new SearchTasks(keyword, blockingQueue)).start();
		}
	}
}

class FileEnumerate implements Runnable {
	public static final File DUMMY = new File("");
	private File baseDir;
	private BlockingQueue<File> blockingQueue;

	public FileEnumerate(File baseDir, BlockingQueue<File> blockingQueue) {
		this.baseDir = baseDir;
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			enumerate(baseDir);
			blockingQueue.put(DUMMY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enumerate(File baseDir) throws InterruptedException {
		File[] files = baseDir.listFiles();
		assert files != null;
		for (File file: files){
			if (file.isDirectory()){
				enumerate(file);
			} else {
				blockingQueue.put(file);
			}
		}
	}
}

class SearchTasks implements Runnable {
	private String keyword;
	private BlockingQueue<File> blockingQueue;

	public SearchTasks(String keyword, BlockingQueue<File> blockingQueue) {
		this.keyword = keyword;
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		boolean done = false;
		while (!done){
			try {
				File file = blockingQueue.take();
				if (file == FileEnumerate.DUMMY){
					done = true;
					blockingQueue.put(FileEnumerate.DUMMY);
				} else {
					search(file);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void search(File file) {
		try(Scanner scanner = new Scanner(file)){
			int lineNumber = 0;
			while (scanner.hasNext()){
				String line = scanner.nextLine();
				lineNumber++;
				if (line.contains(keyword)){
					System.out.printf("%s:%d%s%n", file.getPath(), lineNumber, line);
				}
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
