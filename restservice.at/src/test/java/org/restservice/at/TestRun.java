package org.restservice.at;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class TestRun {
	

	@Test
	public void testRun() throws JsonParseException, JsonMappingException, IOException {
		
		String str =given().get("https://jsonplaceholder.typicode.com/posts/").asString();
		
	ObjectMapper obj = new ObjectMapper();
	
	PostsVO[] post =  obj.readValue(str, PostsVO[].class);
	
for(int i=0; i<post.length;i++) {
		
		System.out.println("id : " + post[i].getId());
		System.out.println("userId : "+post[i].getUserId());
		System.out.println("title : "+post[i].getTitle());
		System.out.println("body : "+post[i].getBody());
	}
	}
	
	@Test
	public void test2() {
	
		
	}
	
}
