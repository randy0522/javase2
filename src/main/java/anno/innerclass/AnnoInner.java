package anno.innerclass;

/**
 * Created by nali on 2018/7/7.
 */
public interface AnnoInner {
	int addXyz();
}

class OuterClass {
	public AnnoInner getAnnoInner(final int x){
		final int y = 100;
		return new AnnoInner(){
			int z = 100;
			@Override
			public int addXyz() {
				return x + y + z;
			}

			public void changeZ(){
				z += 1;
			}
		};
	}
}
