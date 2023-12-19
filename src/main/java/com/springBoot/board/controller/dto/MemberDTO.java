package com.springBoot.board.controller.dto;

import lombok.Data;

@Data
public class MemberDTO {

    private Integer id;

    private String name;

    private Short age;

    private String phoneNumber;

    private String address;

    private String addressDetails;
}
