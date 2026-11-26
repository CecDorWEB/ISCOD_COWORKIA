package com.iscod.coworkia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iscod.coworkia.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
