package anno.innerclass;

import org.apache.commons.collections.set.SynchronizedSortedSet;

import java.lang.reflect.Field;

/**
 * Created by nali on 2018/7/7.
 */
public interface AnnoInner {
	int addXyz();
}

class OuterClass {
	public AnnoInner getAnnoInner(final int x){
		final int y = 100;
		return new AnnoInner(){
			int z = 100;
			@Override
			public int addXyz() {
				return x + y + z;
			}

			public void changeZ(){
				z += 1;
			}
		};
	}
}

class SomeExample {

	public static void main(String[] args) throws Exception{
		Object myObj = new SomeDerivedClass(1234);
		Class myClass = myObj.getClass();
		Field myField = getField(myClass, "value");
		myField.setAccessible(true); //required if field is not normally accessible
		System.out.println("value: " + myField.get(myObj));
	}

	private static Field getField(Class clazz, String fieldName)
			throws NoSuchFieldException {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			System.out.println("in the catch");
			Class superClass = clazz.getSuperclass();
			if (superClass == null) {
				throw e;
			} else {
				return getField(superClass, fieldName);
			}
		}
	}
}

class SomeBaseClass {
	private Integer value;

	SomeBaseClass(Integer value) {
		this.value = value;
	}
}

class SomeDerivedClass extends SomeBaseClass {
	SomeDerivedClass(Integer value) {
		super(value);
	}
}
