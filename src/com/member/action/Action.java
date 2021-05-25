package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 인터페이스 안의 모든 메서드는 추상메서드, 추상메서드를 포함하기 때문에 객체 생성 부락
	// 추상메서드 body가 없음 (실행되는 것이 없기때문에 행위 불가)
	
	//추상메서드 (바디없이 ;로만 선언된것을 보고 추상메서드임을 알 수 있음)
	//다형성을 위해 사용, 강제성을 부여(무조건 추상메서드 구현해야 사용가능)
	public ActionForward execute(HttpServletRequest request,
						HttpServletResponse response) throws Exception;
	
}
