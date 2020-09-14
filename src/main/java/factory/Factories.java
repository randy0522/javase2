package factory;

/**
 * Created by randy on 2019-12-10.
 */
public class Factories {
	public static void main(String[] args) {
		serviceConsumer(Implement1.serviceFatory);
	}

	private static void serviceConsumer(ServiceFatory fatory) {
		Service service = fatory.getService();
		service.method1();
		service.method2();
	}
}

interface Service {
	void method1();
	void method2();
}

interface ServiceFatory {
	Service getService();
}

class Implement1 implements Service {
	private Implement1(){}

	public static ServiceFatory serviceFatory = new ServiceFatory() {
		@Override
		public Service getService() {
			return new Implement1();
		}
	};
	@Override
	public void method1() {
		System.out.println("Implement1 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implement1 method2");
	}
}
