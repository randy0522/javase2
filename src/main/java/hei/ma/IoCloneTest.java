package hei.ma;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * Created by randy on 2019-06-02.
 */
public class IoCloneTest {
	@Test
	public void test1() {
		User user = new User();
		user.setName("randy");
		user.setAge(28);
		User clone = user.clone();
		System.out.println("clone:" + clone);
	}

	@Test
	public void test2() {
		Person[] persons = new Person[2];
		persons[0] = new Person();
		persons[0].setName("randy1");
		persons[0].setAge(28);

		persons[1] = new Person();
		persons[1].setName("randy2");
		persons[1].setAge(29);

		Person[] clone = persons.clone();


		System.out.println("person:" + Arrays.toString(persons) + ",hashcode:" + persons.hashCode());
		System.out.println("clone:" + Arrays.toString(clone) + ",hashcode:" + clone.hashCode());
	}
}

class User implements Serializable {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 *   custom stream to deep clone
	 * @return
	 */
	@Override
	public User clone() {
		return SerializationUtils.clone(this);
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

class Person/* implements Cloneable*/ {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person)super.clone();
	}
}
