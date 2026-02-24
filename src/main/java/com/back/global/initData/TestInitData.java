package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Profile("test")
public class TestInitData {



    private final PostService postService;

    @Bean
    ApplicationRunner testInitDataRunner(){
        return args -> {
            work1();
            work2();
            work3();
        };
    }
    @Transactional
    void work1(){
        if(postService.count() > 0) {
            return;
        }

        postService.write("테스트 제목1", "테스트 내용1");

        postService.write("테스트 제목2", "테스트 내용2");
    }

    void work2(){

        postService.findById(1);
    }

    @Transactional
    void work3(){
        Post post= postService.findById(1).get();
        postService.modify(post,"테스트제목 1-1","테스트 제목1-1");
    }


}
