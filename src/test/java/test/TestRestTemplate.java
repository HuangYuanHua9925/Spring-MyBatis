package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yuan.www.model.Teacher;

public class TestRestTemplate {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		//testGet(restTemplate);
		Map<String,String> params= new HashMap<String, String>();
		params.put("id", "1");
		restTemplate.put("http://127.0.0.1:8080/SpringMyBatis/test/putTeacher/{id}", new Teacher(),params);
	}

	private static void testGet(RestTemplate restTemplate) {
		ResponseEntity<Teacher> entity = restTemplate.getForEntity(
				"http://localhost:8080/SpringMyBatis/test/teacher/1",
				Teacher.class);
		HttpHeaders headers = entity.getHeaders();
		List<MediaType> accept = headers.getAccept();
		for (MediaType mediaType : accept) {
			System.out.println(mediaType);
		}
		MediaType contentType = headers.getContentType();
		System.out.println(contentType);
		System.out.println(entity);
	}

}
