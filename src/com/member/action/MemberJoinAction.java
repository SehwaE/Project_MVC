package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : MemberJoinAction_execute() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		MemberBean mb = new MemberBean();
		mb.setEmail(request.getParameter("email"));
		mb.setId(request.getParameter("id"));
		mb.setName(request.getParameter("name"));
		mb.setPhone(request.getParameter("phone"));
		mb.setPw(request.getParameter("pw"));
		
		System.out.println("M : 전달받은 회원정보  -> "+mb);

		MemberDAO mdao = new MemberDAO();
		int result = mdao.InsertMember(mb);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(result == -1){
			out.print("<script>");
			out.print("alert('회원가입에 실패했습니다 관리자에게 문의하세요');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
		}else{
			out.print("<script>");
			out.print("alert('회원가입에 성공했습니다');");
			out.print("location.href='./MemberLogin.me';");
			out.print("</script>");
			out.close();
			
			return null;
		}
		
	}

}
