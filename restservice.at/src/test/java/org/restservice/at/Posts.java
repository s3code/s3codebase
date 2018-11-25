package org.restservice.at;

import java.util.ArrayList;
import java.util.List;

public class Posts {
	
	private List<PostsVO> posts = new ArrayList<PostsVO>();
	
	
	private void setPosts(List<PostsVO> posts) {
		this.posts = posts;
	}
	
	public List<PostsVO> getPosts(){
		return posts;
	}

}
