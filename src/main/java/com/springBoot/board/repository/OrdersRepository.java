package com.springBoot.board.repository;

import com.springBoot.board.domain.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o join Member m on o.userId = m.userId where o.orderId = :orderId")
    List<Orders> sqlPractice(@Param("orderId") Integer orderId);
}
