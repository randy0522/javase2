package core.one.generic;

/**
 * Created by nali on 2018/6/26.
 */
public class ClassAsFactory<T> {
	T t;
	public ClassAsFactory (Class<T> kind){
		try {
			t = kind.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

class Employ {}

class InstantiateGenericType {
	public static void main(String[] args) {
		ClassAsFactory<Employ> classAsFactory = new ClassAsFactory<>(Employ.class);
	}
}


