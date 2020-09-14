package pattern;

/**
 * Created by randy on 2018/11/25.
 */
public class FactoryPattern {
	public static Shape getShape(String shapeName) {
		int x = 10;
		switch (shapeName) {
			case "Circle":
				return new Shape() {
					@Override
					public void draw() {
						System.out.println("" + x);
					}
				};
			default: throw new IllegalArgumentException("");
		}
	}

	private interface Shape {
		void draw();
	}

	private class Circle implements Shape {
		@Override
		public void draw() {
			System.out.println("draw a circle");
		}
	}

	public static void main(String[] args) {
		System.out.println(getShape("Circle"));
	}
}
