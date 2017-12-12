package test;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.www.model.Teacher;

public class TestHttpClient {
	public static void main(String[] args) {
		testGet();
		
	}

	private static void testGet() {
		try {
			HttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(
					"http://127.0.0.1:8080/SpringMyBatis/test/teacherEntity2");
			request.setHeader("Content-Type", "application/json");
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(entity);
			System.out.println(mapper.readValue(entity.getContent(),
					Teacher.class));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
