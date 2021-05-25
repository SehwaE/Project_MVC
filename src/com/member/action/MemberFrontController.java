package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController : doProcess() 호출!");
		/* 1. 가상주소 계산 */
		System.out.println("\n\n\n         1. 가상주소 계산");
		
		String requestURI = request.getRequestURI();
			//requestURI : /Project_MVC/*.me
		System.out.println("requestURI : "+requestURI);
		//URL : http://localhost:8080/Project_MVC/*.me
//		System.out.println("URL : "+request.getRequestURL());
		
		String contextPath = request.getContextPath();
		//contextPath : /Project_MVC
//		System.out.println("contextPath : "+contextPath);
		
		//command : /*.me
		String command  = requestURI.substring(contextPath.length());
		System.out.println("command : "+command);
		
		System.out.println("\n\n\n         1. 가상주소 계산");
		/* 1. 가상주소 계산 *
		
		
		/* 2. 가상주소 매핑(연결) */
		System.out.println("\n\n\n       2. 가상주소 매핑(연결)");
		
		Action action = null;
		ActionForward forward = null;
		
		 if(command.equals("/Main.me")){
			System.out.println("C : /Main.me 호출");
			
			forward = new ActionForward();
			forward.setPath("./main/main.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/MemberLogin.me")){
			System.out.println("C : /MemberLogin.me 호출");
			
			forward = new ActionForward();
			forward.setPath("./member/login.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/MemberJoin.me")){
			System.out.println("C : /MemberJoin.me 호출");
			
			forward = new ActionForward();
			forward.setPath("./member/signup.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/MemberJoinAction.me")){
			System.out.println("C : /MemberJoinAction.me 호출");
			
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/MemberLoginAction.me")){
			System.out.println("C : /MemberLoginAction.me 호출");
			
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/MemberLogout.me")){
			System.out.println("C : /MemberLogout.me 호출");
			
			action = new MemberLogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MyPage.me")){
			System.out.println("C: /MyPage.me 호출");
			
			forward = new ActionForward();
			forward.setPath("./member/info.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/Delete.me")){
			System.out.println("C : /Delete.me 호출");
			
			forward = new ActionForward();
			forward.setPath("./member/deleteId.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/DeleteAction.me")){
			System.out.println("C : /DeleteAction.me 호출");
			
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		System.out.println("\n\n\n       2. 가상주소 매핑(연결)");
		/* 2. 가상주소 매핑(연결) */
		
		
		/* 3. 가상주소 페이지 이동 */
		System.out.println("\n\n\n       3. 가상주소 페이지 이동");
		
		if(forward != null){ //이동정보가 있을 경우 페이지 이동
			if(forward.isRedirect()){
				//true
				System.out.println("C : sendRedirect 이동 -> "+forward.getPath());
				response.sendRedirect(forward.getPath());
			}else{
				//false
				System.out.println("C : forward 이동 -> "+forward.getPath());
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		
		System.out.println("\n\n\n       3. 가상주소 페이지 이동");
		/* 3. 가상주소 페이지 이동 */
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController : doGet() 호출!");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController : doPost() 호출!");
		doProcess(request, response);
	}
	
	
}
