package com.model2.spring.di.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* People DB 에서 값을 받아 저장하고, View 에 던져주는 매개체 역할을 합니다. */

@Getter
@Setter
@ToString
public class People_lombok {
	
	private String strID;
	private String strName;
	private String strAge;
	private String strDati;
	
	@Builder
	public People_lombok(String strID, String strName, String strAge, String strDati) {
		this.strID = strID;
		this.strName = strName;
		this.strAge = strAge;
		this.strDati = strDati;
	}	
	
}
