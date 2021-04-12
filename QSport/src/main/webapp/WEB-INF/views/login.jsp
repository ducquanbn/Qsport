<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   	<jsp:include page="header.jsp"></jsp:include>
    <title>Bootstrap Login Form</title>
</head>

<body style="font-family: 'Poppins', sans-serif; font-size: 16px; background: #eee; color:#666;">

    <div id="log">
    	<div class="d-flex justify-content-center align-items-center login-container">
	        <div class="login-form text-center">
	            <h1 class="mb-5 font-weight-light text-uppercase">Đăng Nhập</h1>
	            
	            <div class="form-group">
	                <input id="user" name="user" type="text" class="form-control rounded-pill form-control-lg" placeholder="Tên tài khoản">
	            </div>
	            <div class="form-group">
	                <input id="pass" name="pass" type="password" class="form-control rounded-pill form-control-lg" placeholder="Mật khẩu">
	            </div>
	            <div class="forgot-link form-group d-flex justify-content-between align-items-center">
	                <div class="form-check">
	                    <input type="checkbox" class="form-check-input" id="remember">
	                    <label class="form-check-label" for="remember">Nhớ mật khẩu</label>
	                </div>
	                
	            </div>
	            <button id="btnLog" type="submit" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Đăng Nhập</button>
	           
	           
	           
	            <p class="mt-3 font-weight-normal">Chưa có tài khoản? <span><b id="clickreg">Đăng ký<b></span> </p>
	        	<b><p id="errorDangNhap" style="color: red;" class="mt-3 font-weight-normal">  </p> </b>
	        </div>
    	</div>
    </div>
    
	<div id="reg">
    	<div class="d-flex justify-content-center align-items-center login-container">
	        <div class="login-form text-center">
	            <h1 class="mb-5 font-weight-light text-uppercase">Đăng Ký</h1>
	            <div class="form-group">
	                <input id="userReg" name="userReg" type="text" class="form-control rounded-pill form-control-lg" placeholder="Tên tài khoản">
	            </div>
	            <div class="form-group">
	                <input id="passReg" name="passReg" type="password" class="form-control rounded-pill form-control-lg" placeholder="Mật khẩu">
	            </div>
	            <div class="form-group">
	                <input id="passRegA" name="passRegA" type="password" class="form-control rounded-pill form-control-lg" placeholder="Nhập lại mật khẩu">
	            </div>
	            <button id="btnReg" type="submit" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Đăng Ký</button>
	            <p class="mt-3 font-weight-normal">Đã có tài khoản? <span> <b id="clicklog">Đăng Nhập</b> </span> </p>
	            <b><p id="errorDangKy" style="color: red;" class="mt-3 font-weight-normal">  </p> </b>
	        </div>
    	</div>
    </div>

  <!-- Scripts -->
<script src='<c:url value="/resources/js/jquery.min.js" />'></script>
<script src='<c:url value="/resources/js/popper.min.js" />'> </script>
<script src='<c:url value="/resources/js/bootstrap.min.js" />'> </script>
<script src='<c:url value="/resources/js/jquery.easing.min.js" />'> </script>
<script src='<c:url value="/resources/js/scripts.js" />'> </script>
        
</body>

</html>