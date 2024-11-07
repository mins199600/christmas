package com.christmas.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    //회원정보 저장 - @param params - 회원 정보
    // @return PK
    @Transactional
    public Long saveMember(final MemberRequest params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.save(params);
        return params.getId();
    }
    //회원 상세 정보 조회
    public MemberResponse findMemberByLoginId(final String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    //회원 정보 수정 - @param params - 회원 정보
    // @return PK
    @Transactional
    public Long updateMember(final MemberRequest params){
        params.encodingPassword(passwordEncoder);
        memberMapper.update(params);
        return params.getId();
    }
    //회원 정보 삭제 - @param id - PK
    // @return PK
    @Transactional
    public Long deleteMemberById(final Long id){
        memberMapper.deleteById(id);
        return id;
    }

    //회원 수 카운팅(ID 중복체크)
    // @param loginId - UK
    // @return 회원 수
    public int countMemberByLoginId(final String loginId){
        log.info("countMemberByLoginId: {} 실행됐다.", loginId);
        int result = memberMapper.countByLoginId(loginId);
        log.info("조회 결과: {}", result);
        return result;
    }
}

