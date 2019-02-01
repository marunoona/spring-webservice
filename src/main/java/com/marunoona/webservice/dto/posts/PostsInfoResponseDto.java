package com.marunoona.webservice.dto.posts;

import com.marunoona.webservice.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsInfoResponseDto {
    private Long id;
    private String title;
    private String content;

    public PostsInfoResponseDto(Posts entity){
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
    }
}
