<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${contextPath }/index.jsp"> Flower Garden </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${contextPath }/Main.me">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath }/About.do">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath }/ProductList.do">Flowers</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath }/OrderForm.do">Order</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../center/reviewList.jsp">Review</a>
          </li>
<!--           <li class="nav-item"> -->
<!--              <a class="nav-link" href="../center/sendMail.jsp">Contact</a> -->
<!--            </li>  -->
           <%if(session.getAttribute("id")!=null){ %>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath }/MyPage.me">My Page</a>
          </li>
          <%}%>
          <li class="nav-item">
            <a class="nav-link" 
            <%if(session.getAttribute("id")==null){ %>
            href="${contextPath }/MemberLogin.me">Login
            <%
            }else{
            %>
            href="${contextPath }/MemberLogout.me">Logout
            <%}%></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>