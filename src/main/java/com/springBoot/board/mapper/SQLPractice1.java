package com.springBoot.board.mapper;

import com.springBoot.board.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SQLPractice1 {

    List<Orders> test1 (@Param("userId") String userId);

    List<Orders> test2 (@Param("userId") String userId);
}
