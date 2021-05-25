package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberDeleteAction_execute() 호출");
		
		// 로그인 세션 제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = new ActionForward();
		if(id == null){
			System.out.println("삭제 페이지 -> 로그인 페이지");
			forward.setPath("/MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 삭제할 계정정보를 받아서 처리
		// 파라미터값이 입력없이 전달될 경우 "" 공백문자로 입력
		String pw = request.getParameter("pw");
		System.out.println("pw: "+ pw);
		
		// DAO 객체 생성 - deleteMember(id,pw);
		MemberDAO mdao = new MemberDAO();
		
		int check = mdao.deleteMember(id,pw);
		
		// 처리 결과를 저장해서 페이지 이동
		// 삭제 완료 -> 1 , 비밀번호 오류 -> 0, 아이디 없음 -> -1
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(check == 1){
			// 로그인 정보를 삭제
			session.invalidate();
			out.println("<script>");
			out.println("alert('회원탈퇴 완료되었습니다. 이용해주셔서 감사합니다.');");
			out.println("location.href='./Main.me';");
			out.println("</script>");
			out.close();
			
			return null;
		}else if(check == 0){
			out.println("<script>");
			out.println("alert('비밀번호를 확인하세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
			return null;
		}else{ //check =-1
			out.println("<script>");
			out.println("alert('회원정보가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
	}

}
