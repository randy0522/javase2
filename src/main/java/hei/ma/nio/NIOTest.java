package hei.ma.nio;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Created by randy on 2019-06-02.
 */
public class NIOTest {

	@Test
	public void test1() {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		System.out.println("------------ allocate -------------");
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		System.out.println("------------ put ----------------");
		String s = "abcde";
		buf.put(s.getBytes());
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		System.out.println("------------ flip ----------------");
		buf.flip();
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		System.out.println("------------ read ----------------");
		byte[] bytes = new byte[5];
		buf.get(bytes);
		System.out.println("read:" + new String(bytes));
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());


		System.out.println("------------ rewind ----------------");
		buf.rewind();
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		System.out.println("------------ clear ----------------");
		buf.clear();
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());
	}

	@Test
	public void testMark() {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		String s = "adcde";
		buf.put(s.getBytes());
		buf.flip();
		byte[] bytes = new byte[2];
		buf.get(bytes);
		buf.mark();
		System.out.println(new String(bytes, 0, 2));
		buf.get(bytes);
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		buf.reset();
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		if (buf.hasRemaining()) {
			System.out.println(buf.remaining());
		}

		buf.rewind();
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());

		buf.clear();
		System.out.println("position:" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("position:" + buf.capacity());
	}

	@Test
	public void test3() {
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		System.out.println("isDirect:" + buffer.isDirect() + ", isReadOnly:" + buffer.isReadOnly());
	}

	@Test
	public void test4() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("/Users/nali/Desktop/settings.xml"), StandardOpenOption.READ);
		MappedByteBuffer inMapperByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());

		FileChannel outChannel = FileChannel.open(Paths.get("/Users/nali/Desktop/settings2.xml"),
				StandardOpenOption.WRITE,
				StandardOpenOption.READ,
				StandardOpenOption.CREATE);
		MappedByteBuffer outMapperByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
		byte[] bytes = new byte[inMapperByteBuffer.limit()];
		inMapperByteBuffer.get(bytes);
		outMapperByteBuffer.put(bytes);
	}

	@Test
	public void test5() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("/Users/nali/Desktop/SpringBoot2.x开发实战.zip"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("/Users/nali/Desktop/SpringBoot3.x开发实战.zip"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		inChannel.transferTo(0, inChannel.size(), outChannel);
		inChannel.close();
		outChannel.close();
	}

	@Test
	public void test6() throws IOException {
		FileInputStream fis = new FileInputStream("/Users/nali/Desktop/SpringBoot2.x开发实战.zip");
		FileChannel inChannel = fis.getChannel();

		FileOutputStream fos = new FileOutputStream("/Users/nali/Desktop/SpringBoot4.x开发实战.zip");
		FileChannel outChannel = fos.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (inChannel.read(buffer) != -1) {
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
		outChannel.close();
		fos.close();
		inChannel.close();
		fis.close();
	}

	@Test
	public void test7() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("/Users/nali/Desktop/SpringBoot2.x开发实战.zip"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("/Users/nali/Desktop/SpringBoot5.x开发实战.zip"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		MappedByteBuffer in = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer out = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
/*		byte[] bytes = new byte[map.limit()];
		ByteBuffer byteBuffer = map.get(bytes, 0, bytes.length);
		outChannel.write(byteBuffer);

		outChannel.close();*/
	}

	@Test
	public void test8() throws IOException {
		System.getProperty("java.nio.file.spi.DefaultFileSystemProvider");
		SeekableByteChannel seekableByteChannel = Files.newByteChannel(Paths.get("/Users/nali/Desktop/SpringBoot2.x开发实战.zip"), StandardOpenOption.READ);
		ByteBuffer byteBuffer = ByteBuffer.allocate((int)seekableByteChannel.size());
		seekableByteChannel.read(byteBuffer);
	}

	@Test
	public void test9() throws IOException {
		Socket socket = new Socket("localhost", 3306);
		InputStream inputStream = socket.getInputStream();
		Scanner scanner = new Scanner(inputStream, "UTF8");
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			System.out.println(s);
		}
	}

}
