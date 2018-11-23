package core.one.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nali on 2018/6/25.
 */
public class ClasTypeCapture<T> {
	Map<String, Class<?>> classMap;
	private ClasTypeCapture(Map<String, Class<?>> classMap){
		this.classMap = classMap;
	}

	public void addType(String typeName, Class<?> kind){
		classMap.put(typeName, kind);
	}

	@SuppressWarnings("unchecked")
	public T createNew(String typeName) throws IllegalAccessException, InstantiationException {
		Class<?> tClass = classMap.get(typeName);
		if (tClass != null)
			return (T)tClass.newInstance();
		else return null;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ClasTypeCapture<Building> clasTypeCapture = new ClasTypeCapture<>(new HashMap<>());
		clasTypeCapture.addType("house", House.class);
		clasTypeCapture.addType("building", Building.class);
		clasTypeCapture.addType("string", String.class);
		System.out.println("888" + clasTypeCapture.createNew("string"));
	}
}

class Building {}

class House extends Building {}


