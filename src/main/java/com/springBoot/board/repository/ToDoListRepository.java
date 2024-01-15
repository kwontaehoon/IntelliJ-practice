package com.springBoot.board.repository;
import com.springBoot.board.domain.Member;
import com.springBoot.board.domain.ToDoList;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {

    @Query("SELECT m FROM ToDoList m WHERE m.userId = :userId")
    List<ToDoList> findByUserId(@Param("userId") String userId);
}
