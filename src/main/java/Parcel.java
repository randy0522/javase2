/**
 * Created by randy on 2019-12-09.
 */

interface Contentes {
	int value();
}

interface Destination {
	String readLabel();
}

public class Parcel {
	private class PContents implements Contentes {
		private int i = 11;

		@Override
		public int value() {
			return i;
		}
	}

	protected class PDestination implements Destination {
		private String label;
		private PDestination(String label) {
			this.label = label;
		}

		@Override
		public String readLabel() {
			return label;
		}
	}

	public Contentes contentes() {
		return new PContents();
	}

	public Destination destination(String label) {
		return new PDestination(label);
	}

	public static void main(String[] args) {
		Parcel parcel = new Parcel();
		parcel.contentes();
	}
}
