package com.christmas.domain.member;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemberResponse {
    //회원 데이터 조회에 사용될 응답 클래스
    private Long id;
    private String LoginId;
    private String password;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Boolean deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public void clearPassword(){
        this.password = "";
    }
}
