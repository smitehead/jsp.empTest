package com.web.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //기본 세터 게터등
@AllArgsConstructor 
@NoArgsConstructor //기본 생성자 만들기
@Builder

public class Member {
	private String userId;
	private String password;
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private Date enrollDate;
	private String[] hobby;
}
