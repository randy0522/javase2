package pattern;

/**
 * Created by nali on 2018/9/28.
 */
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		AbstractFactory factory = FactorProducer.getFactory("shape");
		Shape square = factory.getShape("square");
		square.draw();

		AbstractFactory factory1 = FactorProducer.getFactory("corlor");
		Color red = factory1.getColor("red");
		red.fill();
	}
}

interface Shape {
	void draw();
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("draw a Square");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("draw a Circle");
	}
}

interface Color {
	void fill();
}

class Red implements Color {

	@Override
	public void fill() {
		System.out.println("fill a red");
	}
}

class Bule implements Color {

	@Override
	public void fill() {
		System.out.println("fill a bule");
	}
}

abstract class AbstractFactory {
	abstract Shape getShape(String info);

	abstract Color getColor(String info);
}

class ShapeFactory extends AbstractFactory {

	@Override
	Shape getShape(String info) {
		if ("square".endsWith(info)) {
			return new Square();
		} else if ("circle".equals(info)) {
			return new Circle();
		}
		return null;
	}

	@Override
	Color getColor(String info) {
		return null;
	}
}

class CorlorFactory extends AbstractFactory {

	@Override
	Shape getShape(String info) {
		return null;
	}

	@Override
	Color getColor(String info) {
		if ("red".equals(info)) {
			return new Red();
		} else if ("bule".equals(info)) {
			return new Bule();
		}
		return null;
	}
}

class FactorProducer {
	public static AbstractFactory getFactory(String info) {
		if ("shape".equals(info)) {
			return new ShapeFactory();
		} else if ("corlor".equals(info)) {
			return new CorlorFactory();
		}
		return null;
	}
}