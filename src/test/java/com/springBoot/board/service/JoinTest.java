package com.springBoot.board.service;

import com.springBoot.board.domain.Member;
import com.springBoot.board.domain.Orders;
import com.springBoot.board.repository.MemberRepository;
import com.springBoot.board.repository.OrdersRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JoinTest {

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    public void test () {

        List<Orders> orders = ordersRepository.findAll();

    }
}
