package com.marunoona.webservice.domain.posts;

import com.marunoona.webservice.dto.posts.PostsMainResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_posts_load(){
        //given
        postsRepository.save(Posts.builder()
        .title("타이틀1")
        .content("내용1")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("타이틀1"));
        assertThat(posts.getContent(), is("내용1"));
    }


    @Test
    public void view_post(){
        //given
        postsRepository.save(Posts.builder()
                .title("타이틀1")
                .content("내용1")
                .build());

        //when
        PostsMainResponseDto dto = postsRepository.findOneById(1);

        //then
        assertThat(dto.getTitle(), is("타이틀1"));
    }
}
