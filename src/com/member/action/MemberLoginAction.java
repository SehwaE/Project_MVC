package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberLoginAction_execute() 호출");
		
		MemberBean mb = new MemberBean();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO mdao = new MemberDAO();
		int result = mdao.idCheck(id, pw);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(result == 0){
			out.print("<script>");
			out.print("alert('아이디나 비밀번호를 확인하세요');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
			
		}else if(result == -1){
			out.print("<script>");
			out.print("alert('회원정보가 없습니다');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
		}else{
			System.out.println("M : 로그인 성공! 메인페이지로 이동합니다");
			HttpSession session  = request.getSession();
			session.setAttribute("id", id);
			System.out.println("userId -> "+id);
			
			ActionForward forward = new ActionForward();
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			
			return forward;
		}
		
	}

}
