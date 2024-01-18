package com.springBoot.board.domain.test;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
public class CategoryTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @ManyToMany
    @JoinTable(name = "categoryTestItem", joinColumns = @JoinColumn(name = "categoryId"), inverseJoinColumns = @JoinColumn(name = "itemId"))
    private List<ItemTest> items = new ArrayList<ItemTest>();

    private String name;
}
