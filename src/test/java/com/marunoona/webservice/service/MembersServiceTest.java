package com.marunoona.webservice.service;

import com.marunoona.webservice.domain.members.Members;
import com.marunoona.webservice.domain.members.MembersRepository;
import com.marunoona.webservice.dto.members.MembersSaveRequestDto;
import com.marunoona.webservice.webservice.MembersService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersServiceTest {

    @Autowired
    private MembersService membersService;

    @Autowired
    private MembersRepository membersRepository;

    @After
    public void cleanup(){
        membersRepository.deleteAll();
    }

    @Test
    public void dtoDataSaveIntoMembers(){
        //given
        MembersSaveRequestDto dto = MembersSaveRequestDto.builder()
                .name("마루")
                .email("maru@naver.com")
                .phone("010-1235-7846")
                .password("maru123")
                .build();
        //when
        membersService.sign(dto);

        //then
        Members members = membersRepository.findAll().get(0);
        assertThat(members.getEmail()).isEqualTo(dto.getEmail());
        assertThat(members.getName()).isEqualTo(dto.getName());
        assertThat(members.getPhone()).isEqualTo(dto.getPhone());

    }
}
