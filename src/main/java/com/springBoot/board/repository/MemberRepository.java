package com.springBoot.board.repository;
import com.springBoot.board.controller.dto.LoginDTO;
import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    boolean existsByUserId(String userId);

    Optional<MemberDTO> findByUserId(String userId);
}
