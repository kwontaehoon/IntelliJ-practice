package com.springBoot.board.service;
import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.domain.Member;
import com.springBoot.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void write(Member member) {
        memberRepository.save(member);
    }

    /**
     * 회원가입
     * 
     * @params memberDTO
     * @return responseEntity
     **/
    public ResponseEntity<MessageDTO> signup(MemberDTO memberDTO) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setStatus("success");
        messageDTO.setMessage("권태훈");
        messageDTO.setData(memberDTO);
        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * MemberService
     *
     * @params id
     * @return reseponseEntity
     **/
    public String idCheck(Integer id) {
        System.out.println(id);
        return "123";
    }

}
