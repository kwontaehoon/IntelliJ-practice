package com.springBoot.board.mapper;

import com.springBoot.board.domain.Orders;
import com.springBoot.board.domain.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SQLPractice1 {

    List<Team> test1 ();

    List<Orders> test2 ();
}
