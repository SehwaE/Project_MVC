package com.bbs.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.do")
public class BbsFrontController extends HttpServlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController : doProcess() 호출!");
		/* 1. 가상주소 계산 */
		System.out.println("\n\n\n         1. 가상주소 계산");
		
		String requestURI = request.getRequestURI();
			//requestURI : /Project_MVC/*.do
		System.out.println("requestURI : "+requestURI);
		//URL : http://localhost:8080/Project_MVC/*.do
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
		
		 if(command.equals("/About.do")){
			System.out.println("/About.do 호출");
			
			forward = new ActionForward();
			forward.setPath("./bbs/about.jsp");
			forward.setRedirect(false);
		 
		}else if(command.equals("/ProductList.do")){
			System.out.println("C : /ProductList.do 호출");
			
			forward = new ActionForward();
			forward.setPath("./bbs/productList.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/Order.do")){
			System.out.println("C : /Order.do 호출");
			
			forward = new ActionForward();
			forward.setPath("./bbs/howtoorder.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/OrderForm.do")){
			System.out.println("C : /OrderForm.do 호출");
			
			forward = new ActionForward();
			forward.setPath("./bbs/writeForm.jsp");
			forward.setRedirect(false);
			
		}else if(command.equals("/BoardList.do")){
			System.out.println("C : /BoardList.do");
			
			forward = new ActionForward();
			forward.setPath("./bbs/boardList.jsp");
			forward.setRedirect(false);
			
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
