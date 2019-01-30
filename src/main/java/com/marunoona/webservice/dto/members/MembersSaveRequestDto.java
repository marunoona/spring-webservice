package com.marunoona.webservice.dto.members;

import com.marunoona.webservice.domain.members.Members;
import lombok.Builder;
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

    @Builder
    public MembersSaveRequestDto(String name, String email, String phone, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .build();
    }
}
