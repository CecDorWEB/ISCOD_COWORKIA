package com.iscod.coworkia.services;

import org.springframework.stereotype.Service;

import com.iscod.coworkia.entities.Post;
import com.iscod.coworkia.repositories.PostRepository;

@Service
public class PostService extends BaseService<Post, Long> {
	public PostService(PostRepository repository) {
        super(repository);
    }
}
