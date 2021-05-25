package com.member.action;

public class ActionForward {
	// 페이지의 이동정보를 저장하는 객체
	// 페이지 이동시 항상 정보를 저장(주소, 이동방식)
	
	private String path; //주소저장
	private boolean isRedirect; //이동방식 저장 - 2가지 (true, false)
	//true - sendRedirect() 방식으로 이동 (페이지 이동식 주소, 화면 모두 변경됨)
	//false - forward() 방식으로 이동(주소변경X, 화면만 변경O)
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
