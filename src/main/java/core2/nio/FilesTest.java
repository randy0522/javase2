package core2.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by nali on 2018/9/19.
 */
public class FilesTest {
	public static void main(String[] args) {

	}

	@Test
	public void test1() throws IOException {
		Path path = Files.walkFileTree(Paths.get("/Users/nali/Desktop/"), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName());
				return FileVisitResult.CONTINUE;
			}
		});

		System.out.println("*******");
		System.out.println(path);
	}
}
