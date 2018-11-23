package thread.blocking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by nali on 2018/7/10.
 */
public class BlockingQueueTest {
	private static final int FILE_QUEUE_SIZE = 10;
	private static final int SEARCH_THREADS = 100;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter the base directory, eg: /Users/nali/Desktop");
		String baseDirectory = in.nextLine();
		System.out.println("enter the key word, eg:randy");
		String keyword = in.nextLine();

		BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		new Thread(new FileEnumerationTask(new File(baseDirectory), blockingQueue)).start();
		for (int i = 0; i < SEARCH_THREADS; i++){
			new Thread(new SearchTask(blockingQueue, keyword)).start();
		}
	}
}

class FileEnumerationTask implements Runnable {
	public static final File DUMMY = new File("");

	private File startDirectory;
	private BlockingQueue<File> blockingQueue;

	public FileEnumerationTask(File startDirectory, BlockingQueue<File> blockingQueue){
		this.startDirectory = startDirectory;
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			enumerate(startDirectory);
			blockingQueue.put(DUMMY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void enumerate(File startDirectory) throws InterruptedException {
		File[] files = startDirectory.listFiles();
		assert files != null;
		for (File file : files){
			if (file.isDirectory()) {
				enumerate(file);
			} else {
				blockingQueue.put(file);
			}
		}
	}
}

class SearchTask implements Runnable {
	private BlockingQueue<File> blockingQueue;
	private String keyword;

	public SearchTask(BlockingQueue<File> blockingQueue, String keyword){
		this.blockingQueue = blockingQueue;
		this.keyword = keyword;
	}

	@Override
	public void run() {
		boolean done = false;
		while (!done){
			try {
				File file = blockingQueue.take();
				if (file == FileEnumerationTask.DUMMY){
					blockingQueue.put(FileEnumerationTask.DUMMY);
					done = true;
				} else {
					search(file);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void search(File file) {
		try (Scanner in = new Scanner(file)) {
			int lineNumber = 0;
			while (in.hasNext()){
				String line = in.nextLine();
				lineNumber++;
				if (line.contains(keyword)){
					System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}


