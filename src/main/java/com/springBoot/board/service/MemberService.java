package com.springBoot.board.service;
import com.springBoot.board.domain.Member;
import com.springBoot.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원 가입
    public void write(Member member) {
        memberRepository.save(member);
    }

}
