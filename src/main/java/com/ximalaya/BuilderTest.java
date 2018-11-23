package com.ximalaya;

/**
 * Created by nali on 2018/2/24.
 */
public class BuilderTest {
	public static void main(String[] args) {
		JavaBean javaBean = new JavaBean.Builder(1, 2).c(1).d(2).e(3).build();
		System.out.println(javaBean);
	}
}

class JavaBean {
	private final int a;
	private final int b;
	private final int c;
	private final int d;
	private final int e;

	static class Builder {
		private final int a;
		private final int b;
		private  int c;
		private  int d;
		private  int e;

		public Builder (int a, int b){
			this.a = a;
			this.b = b;
		}

		public Builder c (int c){
			this.c = c;
			return this;
		}
		public Builder d (int d){
			this.d = d;
			return this;
		}
		public Builder e (int e){
			this.e = e;
			return this;
		}

		public JavaBean build(){
			return new JavaBean(this);
		}
	}

	JavaBean(Builder builder){
		this.a = builder.a;
		this.b = builder.b;
		this.c = builder.c;
		this.d = builder.d;
		this.e = builder.e;
	}


}
