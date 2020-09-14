/**
 * Created by randy on 2018/11/23.
 */
public class PointDemo {
	private Point[] points;

	public PointDemo (int length) {
		points = new Point[length];
		for (int i = 0; i < length; i++) {
			points[i] = new Point(i, i);
		}
	}

	public void showPoint() {
		for (int i = 0; i < points.length; i++) {
			System.out.printf("points[%d], x=%d, y=%d%n", i, points[i].getX(), points[i].getY());
		}
	}

	private class Point {
		private int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	public static class A {

	}

	public static void main(String[] args) {
		PointDemo pointDemo = new PointDemo(5);
		pointDemo.showPoint();

		PointDemo.A a = new PointDemo.A();
	}
}
