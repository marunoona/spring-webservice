package com.marunoona.webservice.web;

import com.marunoona.webservice.domain.members.MembersRepository;
import com.marunoona.webservice.dto.members.MembersSaveRequestDto;
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

    @PostMapping("/posts/modify")


    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Object> deletePosts(@PathVariable long id){
        int result = postsService.deleteById(id);
        if(result <= 0){
            return ResponseEntity.ok().body(new String("NOT FOUND"));
        }
        return ResponseEntity.ok().body(new String("DELETE SUCCESSFULLY"));
    }
}
