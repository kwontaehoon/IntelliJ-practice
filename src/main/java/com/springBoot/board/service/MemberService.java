package com.springBoot.board.service;
import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.domain.Member;
import com.springBoot.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * 회원가입
     * 
     * @params memberDTO
     * @return responseEntity
     **/
    public ResponseEntity<MessageDTO> signup(Member member) {
        MessageDTO messageDTO = new MessageDTO();
//        Member member = Member.builder()
//                .userId(memberDTO.getUserId())
//                .password(memberDTO.getPassword())
//                .name(memberDTO.getName())
//                .email(memberDTO.getEmail())
//                .build();
        memberRepository.save(member);
//        messageDTO.setStatus(200);
//        messageDTO.setMessage("권태훈");
//        messageDTO.setData(memberDTO);
        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * MemberService
     *
     * @params id
     * @return reseponseEntity
     **/
    public ResponseEntity<MessageDTO> idCheck(Integer id) {
        System.out.println("id: " + id);
        List<Member> findMembers = memberRepository.findAll();
        System.out.println("bb: " + findMembers);
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setStatus(200);
        messageDTO.setMessage("태훈");
        messageDTO.setData(findMembers);
        return ResponseEntity.ok().body(messageDTO);
    }

    public List<Member> findAll () {
        return memberRepository.findAll();
    }

}
