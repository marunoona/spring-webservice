package com.marunoona.webservice.webservice;

import com.marunoona.webservice.domain.members.MembersRepository;
import com.marunoona.webservice.dto.members.MembersSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class MembersService {

    private MembersRepository membersRepository;

    @Transactional
    public Long sign(MembersSaveRequestDto dto){
        return membersRepository.save(dto.toEntity()).getId();
    }
}
