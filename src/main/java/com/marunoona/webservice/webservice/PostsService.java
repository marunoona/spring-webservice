package com.marunoona.webservice.webservice;

import com.marunoona.webservice.domain.posts.Posts;
import com.marunoona.webservice.domain.posts.PostsRepository;
import com.marunoona.webservice.dto.posts.PostsRequestDto;
import com.marunoona.webservice.dto.posts.PostsResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long savePosts(PostsRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<PostsResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().map(PostsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Posts> findById(long id){
        return postsRepository.findById(id);
    }

    @Transactional
    public PostsResponseDto findOneById(long id){
        return postsRepository.findOneById(id);
    }

    public Long updatePost(PostsRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
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

