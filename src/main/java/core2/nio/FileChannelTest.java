package core2.nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by nali on 2018/9/18.
 */
public class FileChannelTest {
	public static void main(String[] args) {

	}

	@Test
	public void test1() throws IOException {
		RandomAccessFile accessFile = new RandomAccessFile("/Users/nali/Desktop/176451986.mp4", "rw");
		FileChannel channel = accessFile.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(48);
		while ((channel.read(buffer)) != -1){
			buffer.flip();
			if (buffer.hasRemaining()){
				System.out.println(buffer.getChar());
			}
			buffer.clear();
		}
		channel.close();
	}
}
