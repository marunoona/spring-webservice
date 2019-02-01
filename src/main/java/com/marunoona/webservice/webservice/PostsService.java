package com.marunoona.webservice.webservice;

import com.marunoona.webservice.domain.posts.Posts;
import com.marunoona.webservice.domain.posts.PostsRepository;
import com.marunoona.webservice.dto.posts.PostsInfoResponseDto;
import com.marunoona.webservice.dto.posts.PostsSaveRequestDto;
import com.marunoona.webservice.dto.posts.PostsMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long savePosts(PostsSaveRequestDto dto){

        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostsInfoResponseDto findPosts(Long id){
        return postsRepository.findById(id).map(PostsInfoResponseDto::new).get();
    }

    @Transactional
    public Long updatePost(PostsSaveRequestDto dto){
        //return postsRepository.save(dto.toEntity()).getId();
        return savePosts(dto);
    }

    @Transactional
    public int deleteById(long id){
        if(postsRepository.findById(id) == null){
            return -1;
        }else {
            postsRepository.deleteById(id);
            return 1;
        }
    }
}

