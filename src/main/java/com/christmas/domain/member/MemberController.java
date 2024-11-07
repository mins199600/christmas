package com.christmas.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //로그인 페이지
    @GetMapping("/")
    public String openLogin(){
        return "member/login";
    }
    //회원 정보 저장(회원가입)
    @PostMapping("/members")
    @ResponseBody
    public Long saveMember(@RequestBody final MemberRequest params){
        return memberService.saveMember(params);
    }
    // 회원 상세정보 조회
    @GetMapping("/members/{loginId}")
    @ResponseBody
    public MemberResponse findMemberByLoginId(@PathVariable final String loginId) {
        return memberService.findMemberByLoginId(loginId);
    }
    //회원 정보 수정
    @PatchMapping("/members/{id}")
    @ResponseBody
    public Long updateMember(@PathVariable final Long id, @RequestBody final MemberRequest params){
        return memberService.updateMember(params);
    }
    //회원 정보 삭제(회원 탈퇴)
    @DeleteMapping("/members/{id}")
    @ResponseBody
    public Long deleteMemberById(final Long id) {
        return memberService.deleteMemberById(id);
    }
    //회원 수 카운팅 (ID 중복 체크)
    @GetMapping("/member-count")
    @ResponseBody
    public int countMemberByLoginId(@RequestParam final String loginId) {
        log.info("아이디 중복체크 시작");
        return memberService.countMemberByLoginId(loginId);
    }
}
