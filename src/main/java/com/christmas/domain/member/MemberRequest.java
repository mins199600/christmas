package com.christmas.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberRequest {
    //회원가입, 회원정보 수정에 사용되는 클래스
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private Gender gender;
    private LocalDate birthday;

    public void encodingPassword(PasswordEncoder passwordEncoder){
        if(StringUtils.isEmpty(password)){
            return;
        }
        this.password = passwordEncoder.encode(password);
    }
}
