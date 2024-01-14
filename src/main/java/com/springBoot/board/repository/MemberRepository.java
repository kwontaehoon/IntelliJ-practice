package com.springBoot.board.repository;
import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    boolean existsByUserId(String userId);

    @Query("SELECT m FROM Member m WHERE m.userId = :userId") // JPQL
//    @Query(nativeQuery=true, value="SELECT * FROM member WHERE user_id = :userId") // nativeQuery
    Optional<Member> findByUserId(@Param("userId") String userId); // JPQL
//    Optional<Member> findByUserId(@Param("user_id") String userId); // nativeQuery

    @Query(value = "SELECT m FROM Member m WHERE m.email = :email") // JPQL
    Optional<MemberDTO> findByEmail(@Param("email") String email);

}
