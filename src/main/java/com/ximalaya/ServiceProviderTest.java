package com.ximalaya;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nali on 2018/2/24.
 */
public class ServiceProviderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.ximalaya.InlandSaltProvider");
		Salt salt = SaltManager.getSalt("inlandSalt");
		salt.addIodine();
	}
}

interface Salt {
	void addIodine();
}

class InlandSalt implements Salt {

	public void addIodine() {
		System.out.println("InlandSalt add iodine");
	}
}

class BaySalt implements Salt {
	public void addIodine() {
		System.out.println("BaySalt add iodine");
	}
}

interface SaltProvider {
	Salt getSalt();
}

class InlandSaltProvider implements SaltProvider {
	static {
		SaltManager.register("inlandSalt", new InlandSaltProvider());
	}

	public Salt getSalt() {
		return new InlandSalt();
	}
}

class BaySaltProvider implements SaltProvider {
	static {
		SaltManager.register("BaySalt", new BaySaltProvider());
	}

	public Salt getSalt() {
		return new BaySalt();
	}
}

class SaltManager {
	private static ConcurrentHashMap<String,SaltProvider> providerMap = new ConcurrentHashMap<String, SaltProvider>();

	static void register(String name, SaltProvider provider){
		providerMap.put(name, provider);
	}

	static Salt getSalt(String name){
		SaltProvider saltProvider = providerMap.get(name);
		if (saltProvider == null){
			throw new Error("No such salt " + name);
		}
		return saltProvider.getSalt();
	}
}
