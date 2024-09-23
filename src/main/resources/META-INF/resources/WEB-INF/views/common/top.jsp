<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="border-bottom border-light border-5">
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-expand-lg">
                
                <!-- 로그인 안된 상태 -->
                <c:if test="${empty login}">
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="main">
                                    <img src="images/main.png" style="width: 180px; height: 80px;">
                                </a>
                            </li>
                        </ul>
                    </div>
                </c:if>
                
                <!-- 로그인 된 상태 -->
                <c:if test="${!empty login}">
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <!-- 로그인한 아이디가 admin인지 확인 -->
                                <c:choose>
                                    <c:when test="${login.getEmp_id() == 'admin'}">
                                        <a class="nav-link" href="adminMenu">
                                            <img src="images/main.png" style="width: 180px; height: 80px;">
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="nav-link" href="menu">
                                            <img src="images/main.png" style="width: 180px; height: 80px;">
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                        </ul>
                    </div>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="logout">logout</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="mypage">mypage</a>
                        </li>
                    </ul>
                </c:if>
                
            </nav>
        </div>
    </div>
</header>
