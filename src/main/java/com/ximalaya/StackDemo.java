package com.ximalaya;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by nali on 2018/2/26.
 */
public class StackDemo<T> implements Cloneable{
	private T[] elements;
	private int size = 0;

	private static final int DEFALUT_INIT_CAPACITY = 12;

	@SuppressWarnings("unchecked")
	public StackDemo(){
		elements = (T[]) new Object[DEFALUT_INIT_CAPACITY];
	}

	public void push(T e){
		ensureCapacity();
		elements[size++] = e;
	}

	public T pop(){
		if (size == 0){
			throw new EmptyStackException();
		}
		T element = elements[--size];
		elements[size] = null;
		return element;
	}

	private void ensureCapacity(){
		if (elements.length == size){
			elements = Arrays.copyOf(elements, size * 2 + 1);
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		StackDemo result = (StackDemo)super.clone();
		result.elements = this.elements.clone();
		return result;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		StackDemo<String> stackDemo = new StackDemo();
		stackDemo.push("randy1");
		stackDemo.push("randy2");
		stackDemo.push("randy3");
	//	System.out.println(stackDemo.pop());
		StackDemo clone = (StackDemo) stackDemo.clone();
	//	System.out.println(stackDemo == clone);
		System.out.println(stackDemo.size == clone.size);
		System.out.println(stackDemo.elements == clone.elements);


		stackDemo.push("randy4");
		for (Object element : clone.elements) {
			System.out.println(element);
		}
	}
}
