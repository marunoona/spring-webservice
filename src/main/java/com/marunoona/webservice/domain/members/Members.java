package com.marunoona.webservice.domain.members;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String phone;

    @Builder
    public Members(String name, String email, String password, String phone){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
