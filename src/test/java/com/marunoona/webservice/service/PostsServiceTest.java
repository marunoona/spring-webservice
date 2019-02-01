package com.marunoona.webservice.service;

import com.marunoona.webservice.domain.posts.Posts;
import com.marunoona.webservice.domain.posts.PostsRepository;
import com.marunoona.webservice.dto.posts.PostsSaveRequestDto;
import com.marunoona.webservice.dto.posts.PostsMainResponseDto;
import com.marunoona.webservice.webservice.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsService postsService;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void dtoDataSaveIntoPosts(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("타이틀1")
                .content("내용1")
                .build();

        //when
        postsService.savePosts(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
    }

    @Test
    public void findOneById(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("타이틀1")
                .content("내용1")
                .build();
        postsService.savePosts(dto);

        //when
        PostsMainResponseDto posts = postsService.findOneById(1);

        //then
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void updatePosts(){
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("타이틀1")
                .content("내용1")
                .build();
        postsService.savePosts(dto);
        PostsMainResponseDto responseDto = postsService.findOneById(1);
        //when
        dto.setId(responseDto.getId());
        dto.setTitle("타이틀1");
        dto.setContent("내용이바뀌었다.");
        postsService.updatePost(dto);

        //when
        PostsMainResponseDto posts = postsService.findOneById(1);
        assertThat(posts.getId()).isEqualTo(dto.getId());
        assertThat(posts.getTitle()).isEqualTo("타이틀1");
        assertThat(posts.getContent()).isEqualTo("내용이바뀌었다.");
    }
}
