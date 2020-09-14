package pattern;

import sun.text.resources.cldr.sr.FormatData_sr_Latn_ME;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by randy on 2018/12/24.
 */
interface Filter {
	void doFilter(MyRequest request, MyResponse response, FilterChain filterChain);
}

class FilterChain implements Filter {
	private List<Filter> filters = new ArrayList<>();
	private int pos = 0;

	public FilterChain add(Filter filter) {
		filters.add(filter);
		return this;
	}

	@Override
	public void doFilter(MyRequest request, MyResponse response, FilterChain filterChain) {
		if (pos == filters.size()) return;
		Filter filter = filters.get(pos);
		pos++;
		filter.doFilter(request, response, this);
	}
}

class HtmlFilter implements Filter {

	@Override
	public void doFilter(MyRequest request, MyResponse response, FilterChain filterChain) {
		String replace =
				request.getMs().replace("<", "[").replace(">", "]") + " --HTML--";
		request.setMs(replace);
		filterChain.doFilter(request, response, filterChain);
		response.setMs("--HTML--");
	}
}

class SensitiveFilter implements Filter {
	@Override
	public void doFilter(MyRequest request, MyResponse response, FilterChain filterChain) {
		String replace = request.getMs().replace("被就业", "就业").replace("卧槽", "**");
		request.setMs(replace);
		filterChain.doFilter(request, response, filterChain);
		response.setMs("--sensitive--");
	}
}

class TestMain {
	public static void main(String[] args) {
		FilterChain filterChain = new FilterChain();
		filterChain.add(new HtmlFilter()).add(new SensitiveFilter());
		String msg = "<script>, 我被就业了，卧槽";
		MyRequest request = new MyRequest();
		request.setMs(msg);
		MyResponse response = new MyResponse();
		filterChain.doFilter(request, response, filterChain);
		System.out.println(request.getMs());
		System.out.println(response.getMs());
	}
}

class MyRequest {
	private String ms;

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}
}

class MyResponse {
	private String ms;

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}
}
