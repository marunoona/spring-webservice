package com.marunoona.webservice.dto.members;

import com.marunoona.webservice.domain.members.Members;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MembersSaveRequestDto {

    private String name;
    private String email;
    private String password;
    private String phone;

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .build();
    }
}
