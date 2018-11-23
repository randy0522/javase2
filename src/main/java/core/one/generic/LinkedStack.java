package core.one.generic;

import javax.xml.stream.events.EndDocument;

/**
 * Created by nali on 2018/6/23.
 */
public class LinkedStack<T> {
	class Node {
		private T item;
		private Node next;

		Node() {
			item = null;
			next = null;
		}

		Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node top = new Node();
	public void push(T item){
		top = new Node(item, top);
	}

	public T pop(){
		T result = top.item;
		if (!top.end()){
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<>();
		for (String s : "I Love You".split(" ")) {
			stack.push(s);
		}
		String item;

		while ((item = stack.pop()) != null) {
			System.out.println(item);
		}
	}
}
