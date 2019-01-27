package com.marunoona.webservice.domain.members;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @After
    public void cleanup(){
        /**
         * 이후 테스트 코드에 영향을 끼치지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체 비우는 코드
        */
        membersRepository.deleteAll();
    }

    @Test
    public void save_load(){
        //given : 테스트 기반 환경을 구축하는 단계
        membersRepository.save(Members.builder()
        .name("예진")
        .email("ye_jin92@naver.com")
        .password("pwd123")
        .phone("010-1234-5678")
        .build());

        //when : 테스트 하고자 하는 행위 선언
        List<Members> memberList = membersRepository.findAll();

        //then : 테스트 결과 검증
        Members members = memberList.get(0);
        assertThat(members.getEmail(), is("ye_jin92@naver.com"));
        assertThat(members.getName(), is("예진"));
    }
}
