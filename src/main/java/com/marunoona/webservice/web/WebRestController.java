package com.marunoona.webservice.web;

import com.marunoona.webservice.domain.members.MembersRepository;
import com.marunoona.webservice.domain.posts.Posts;
import com.marunoona.webservice.dto.members.MembersSaveRequestDto;
import com.marunoona.webservice.dto.posts.PostsRequestDto;
import com.marunoona.webservice.dto.posts.PostsResponseDto;
import com.marunoona.webservice.webservice.MembersService;
import com.marunoona.webservice.webservice.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class WebRestController {

    private MembersRepository membersRepository;

    private MembersService membersService;
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/signMember")
    public Long saveMembers(@RequestBody MembersSaveRequestDto dto) {

        return membersService.sign(dto);
    }

    @PostMapping("/savePost")
    public Long savePosts(@RequestBody PostsRequestDto dto){
        return postsService.savePosts(dto);
    }

    @GetMapping("/viewPost/{id}")
    public ResponseEntity<Object> getPost(@PathVariable long id){
        return ResponseEntity.ok().body(postsService.findById(id));
    }

    @PutMapping("/updatePost/{id}")
    public Long updatePosts(@PathVariable long id, @RequestBody PostsRequestDto dto){
        PostsResponseDto resDto = postsService.findOneById(id);
        dto.setId(resDto.getId());
        return postsService.savePosts(dto);
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Object> deletePosts(@PathVariable long id){
        int result = postsService.deleteById(id);
        if(result <= 0){
            return ResponseEntity.ok().body(new String("NOT FOUND"));
        }
        return ResponseEntity.ok().body(new String("DELETE SUCCESSFULLY"));
    }
}
