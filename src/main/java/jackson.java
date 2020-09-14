import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by randy on 2019/3/8.
 */
public class jackson {
	@org.junit.Test
	public void test() throws IOException {
		Friend friend = new Friend("randy", 1);
		ObjectMapper objectMapper = new ObjectMapper();
		String text = objectMapper.writeValueAsString(friend);
		objectMapper.writeValue(new File("a.json"), friend);
		byte[] bytes = objectMapper.writeValueAsBytes(friend);
		System.out.println(text + ", bytes length:" + bytes.length);

		Friend friend1 = objectMapper.readValue(text, Friend.class);
//		System.out.println(friend1);
		friend1 = objectMapper.readValue(bytes, Friend.class);
		friend1 = objectMapper.readValue(new File("a.json"), Friend.class);
		System.out.println(", friend1->" + friend1);
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Friend {
	private String name;
	private int age;
}

