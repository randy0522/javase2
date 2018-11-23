package com.ximalaya;

import javax.lang.model.type.ErrorType;

/**
 * Created by nali on 2018/3/15.
 */
public class HashTableCloneTest implements Cloneable {
	private Entry[] entries;

	private static class Entry {
		final Object key;
		Object value;
		Entry next;

		Entry(Object key, Object value, Entry next){
			this.key = key;
			this.value = value;
			this.next = next;
		}

/*		public Entry deepClone(){
			return new Entry(key, value, next == null ? null : deepClone());
		}*/

		public Entry deepClone(){
			Entry entry = new Entry(key, value, next);
			for (Entry p = entry; p.next != null; p = p.next){
				p.next = new Entry(p.next.key, p.next.value, p.next.next);
			}
			return entry;
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		HashTableCloneTest clone = (HashTableCloneTest)super.clone();
		clone.entries = new Entry[entries.length];
		for (int i = 0; i < entries.length; i++){
			if (entries[i] != null){
				clone.entries[i] = entries[i].deepClone();
			}
		}
		return clone;
	}
}
