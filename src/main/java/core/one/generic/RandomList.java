package core.one.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by nali on 2018/6/23.
 */
public class RandomList<T> {
	private List<T> list = new ArrayList<>();
	private Random random = new Random(47);

	public void add(T item){
		list.add(item);
	}
	public T select(){
		return list.get(random.nextInt(list.size()));
	}

	public static void main(String[] args) {
		RandomList<String> randomList = new RandomList<>();
		for (String s : "randy i love you li ling".split(" ")){
			randomList.add(s);
		}

		for (int i = 0; i < 11; i++){
			System.out.println(randomList.select());
		}
	}
}
