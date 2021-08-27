package com.model2.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* People DB 에서 값을 받아 저장하고, View 에 던져주는 매개체 역할을 합니다. */

@Getter
@Setter
@ToString
@AllArgsConstructor // 멤버변수를 사용하는 생성자
@NoArgsConstructor  // 기본 생성자 
public class Vo_People {
	
	private String id;
	private String name;
	private String age;
	private String dati;

	}
