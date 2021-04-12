<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>QSport - Tài Khoản</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<!-- Page Content -->
<div class="container" style="margin: auto">
  <div style="background-color :#f7e6ff;box-shadow: 10px 10px 5px #aaaaaa;margin-top: 8%; margin-bottom: 20px">
  <div class="row">
  	<div class="col-4" >
  		<label for="HoTenUser"><b style="color: black;"> Họ tên: </b> </label>
		<input id="HoTenUser" name="HoTenUser" value="${user.getHoTen() }" class="form-control">
  	</div>
  	<div class="col-3">
  	<label for="GioiTinh"><b style="color: black;"> Giới tính: </b> </label>
  		<select id="GioiTinh" name="GioiTinh" class="browser-default custom-select">
  			<c:choose>
  				<c:when test="${user.getGioiTinh() == 'Nam' }">
  					
					<option value="Nam" selected="selected">Nam</option>
					<option value="Nữ">Nữ</option>
  				</c:when>
  				<c:when test="${user.getGioiTinh() == 'Nữ' }">
  					<option value="Nam">Nam</option>
  					<option value="Nữ" selected="selected">Nữ</option>
					
  				</c:when>
  				<c:otherwise>
  					<option value="Nam">Nam</option>
  					<option value="Nữ">Nữ</option>
  				</c:otherwise>			
  			</c:choose>													    
		</select> 
  	</div>
  	<div class="col-3">
  		<label for="SDTUser"><b style="color: black;"> SĐT: </b> </label>
		<input id="SDTUser" name="SDTUser" value="${user.getSdt() }" class="form-control">
  	</div>
  	</div>
  	<div class="row">
  	<div class="col-4">
  		<label for="EmailUser"><b style="color: black;"> Email: </b> </label>
		<input id="EmailUser" name="EmailUser" value="${user.getEmail() }" class="form-control">
  	</div>
  	</div>
  	<div class="row">
  	<div class="col-6" >
  		<label for="DiaChiUser"><b style="color: black;"> Địa chỉ </b> </label>
		<input id="DiaChiUser" name="DiaChiUser" value="${user.getDiaChi()}" class="form-control">
  	</div>
  	</div>
  	<div class="row">
  	<div class="col-6" >
  		<label for="MatKhauUser"><b style="color: black;"> Mật khẩu </b> </label>
		<input id="MatKhauUser" type="password" name="MatKhauUser" value="${user.getMatKhau()}" class="form-control">
  	</div>
  	</div>
  	<div class="modal-footer">
		<button type="button" class="btn btn-secondary" onclick="history.back()" > Huỷ </button>
		<button id="updateUser" type="button" class="btn btn-primary">Cập nhật</button>
	</div>
  </div>
</div>
<!-- /.container -->

	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>