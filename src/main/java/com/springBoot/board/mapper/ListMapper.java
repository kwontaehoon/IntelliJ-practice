package com.springBoot.board.mapper;

import com.springBoot.board.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Optional;

@Mapper
public interface ListMapper {

    Optional<Member> getUserId (@Param("id") Integer id);
}
