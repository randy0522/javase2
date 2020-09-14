package redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.xml.crypto.Data;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;

/**
 * Created by randy on 2019/3/18.
 */
public class RedisApiSimpleDemo {
	private Jedis jedis;
	private static final int DATE = 20190325;
	private static final long USERID_MAX = 5500000;
	private long startMillis;

	@Before
	public void initJedis() {
		startMillis = System.currentTimeMillis();
		jedis = new Jedis("localhost", 6379);
	}

	@After
	public void closeJedis() {
		long endMillis = System.currentTimeMillis();
		System.out.println("elaspe:" + (endMillis - startMillis));
		jedis.close();
	}

	@Test
	public void testWriteAsByteArray() {
		for (long i = 0; i < USERID_MAX; i++) {
			byte[] key = getByteArrayKey(DATE, i);
			int duration = (int) (i + 1);
			byte[] value = ByteUtils.intToBytes(duration);
			jedis.set(key, value); // 5500000 key, used memeory byte: 508151984(484.61M)
		}
	}

	@Test
	public void writeSingleByteArrayKey() {
		byte[] key = getByteArrayKey(DATE, USERID_MAX);
		byte[] value = getByteArrayValue((int) USERID_MAX);
		jedis.set(key, value);
	}

	@Test
	public void testWriteAsString() {
		for (long i = 0; i < USERID_MAX; i++) {
			String key = DATE + ":" + i;
			String value = String.valueOf((int) (i + 1));
			jedis.set(key, value);// 5500000 key, used memory byte:661340880(630.70M)
		}
	}

	@Test
	public void testGetStringKeyElaspe() {
		final String STRING_KEY = DATE + ":" + USERID_MAX;
		jedis.get(STRING_KEY);
	}

	@Test
	public void testGetByteArrayKeyElaspe() {
		final byte[] BYTE_KEY = getByteArrayKey(DATE, USERID_MAX);
		byte[] bytes = jedis.get(BYTE_KEY);
	}


	private static final class ByteUtils {
		private static byte[] intToBytes(int v) {
			byte[] array = new byte[4];
			for (int i = 0; i < 4; i++) {
				array[i] = (byte) ((v >> (8 * (3 - i))) & 0xFF);
			}
			return array;
		}

		private static byte[] longToBytes(long v) {
			byte[] array = new byte[8];
			for (int i = 0; i < 8; i++) {
				array[i] = (byte) ((v >> (8 * (7 - i))) & 0xFF);
			}
			return array;
		}
	}

	private static byte[] getByteArrayKey(int date, long userId) {
		byte[] key = new byte[12];
		byte[] idBytes = ByteUtils.longToBytes(userId);
		byte[] dateBytes = ByteUtils.intToBytes(date);
		System.arraycopy(idBytes, 0, key, 0, idBytes.length);
		System.arraycopy(dateBytes, 0, key, idBytes.length, dateBytes.length);
		return key;
	}

	private static byte[] getByteArrayValue(int value) {
		return ByteUtils.intToBytes(value);
	}
}


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
class Person implements Serializable {
	private int id;
	private String name;
}

class SerializeUtils {
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos;
		ByteArrayOutputStream bos;

/*		bos = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(bos);*/
		return null;

	}
}
