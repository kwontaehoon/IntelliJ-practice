package com.springBoot.board.service;
import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.domain.Member;
import com.springBoot.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<MessageDTO> signup(MemberDTO memberDTO) {
        MessageDTO messageDTO = new MessageDTO();
        Member member = Member.builder()
                .userId(memberDTO.getUserId())
                .password(memberDTO.getPassword())
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .build();
        memberRepository.save(member);
        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * 중복 아이디 찾기
     *
     * @params userId
     * @return reseponseEntity
     **/
    public ResponseEntity<MessageDTO> idCheck(String userId) {
        MessageDTO messageDTO = new MessageDTO();

        if(memberRepository.existsByUserId(userId)){
            messageDTO.setStatus("error");
            messageDTO.setMessage("중복된 아이디가 있습니다.");
        }else {
            messageDTO.setStatus("success");
            messageDTO.setMessage("중복된 아이디가 없습니다.");
        }
        return ResponseEntity.ok().body(messageDTO);
    }
}
