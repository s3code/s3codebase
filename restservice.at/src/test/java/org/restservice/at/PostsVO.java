package org.restservice.at;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostsVO {
	
	private int userId;
	private int id;
	private String title;
	private String body;
	
	private void setUserId(int userId) {
		this.userId = userId;
		
	}
	
	public int getUserId() {
		return userId;
	}

	private void setId(int id) {
		this.id = id;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setTitle( String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	private void setBody(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}

}
