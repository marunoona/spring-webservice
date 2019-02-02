package com.marunoona.webservice.web;

import com.marunoona.webservice.domain.members.MembersRepository;
import com.marunoona.webservice.dto.members.MembersSaveRequestDto;
import com.marunoona.webservice.dto.posts.PostsModifyRequestDto;
import com.marunoona.webservice.dto.posts.PostsSaveRequestDto;
import com.marunoona.webservice.dto.posts.PostsMainResponseDto;
import com.marunoona.webservice.webservice.MembersService;
import com.marunoona.webservice.webservice.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.savePosts(dto);
    }

    @PutMapping("/posts/modify")
    public Long modifyPosts(@RequestBody PostsModifyRequestDto dto){
        return postsService.modify(dto);
    }

    @DeleteMapping("/posts/delete")
    public Long deletePosts(@RequestBody Long id){
        return postsService.delete(id);
    }
}
