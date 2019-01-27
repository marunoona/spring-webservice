package com.marunoona.webservice.web;

import com.marunoona.webservice.domain.members.MembersRepository;
import com.marunoona.webservice.dto.members.MembersSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private MembersRepository membersRepository;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/members")
    public void saveMembers(@RequestBody MembersSaveRequestDto dto){
        membersRepository.save(dto.toEntity());
    }
}
