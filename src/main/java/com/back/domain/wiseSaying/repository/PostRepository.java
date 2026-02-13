package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> { // Integer primary key 타입
}
