package com.christmas.domain.member;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    //회원 정보 저장
    void save(MemberRequest params);
    //회원 상세정보 조회
    MemberResponse findByLoginId(String loginId);
    //회원 정보 수정
    void update(MemberRequest params);
    //회원 정보 삭제(회원탈퇴)
    void deleteById(Long id);
    //회원 수 카운팅(ID 중복 체크)
    int countByLoginId(String loginId);
}
