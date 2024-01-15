package com.springBoot.board.mapper;

import com.springBoot.board.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface ListMapper {

//    @Select("SELECT * FROM Member m WHERE m.id = #{id}")
    Optional<Member> getUserId (@Param("id") Integer id);
}
