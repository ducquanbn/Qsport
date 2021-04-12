<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- Styles -->
<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/swiper.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/fontawesome-all.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/animate.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' />
<!-- Favicon  -->
    <link rel="icon" href="http://localhost:8080/QSport/resources/images/favicon.png">

<nav style="background-color :#FF8840;box-shadow: 10px 10px 5px #aaaaaa;" class="navbar navbar-expand-lg navbar-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="http://localhost:8080/QSport/"><img src="http://localhost:8080/QSport/resources/images/logo.png"></a> <button aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-target="#navbarSupportedContent" data-toggle="collapse" type="button"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<div> 
				<form action="http://localhost:8080/QSport/San-Pham/Tim-Kiem" method="get">
				<div class="input-group rounded">
				  <input name="TenSanPham" id="txtSearch" type="search" style="background-color: rgba(0, 0, 0, 0);border-radius: 25px; color: white;" class="form-control rounded" placeholder="Tìm kiếm..."
				    aria-describedby="search-addon" />
				  <input type="submit" style="background-color: rgba(0, 0, 0, 0); color: white;" class="input-group-text border-0" id="search-addon" value="Tìm">
				</div>
				</form>
			</div>
				<ul class="navbar-nav ml-auto">
				<li>
					<a  class="nav-link" href="#foot"> <b style="color: white" > Liên hệ </b> </a>
				</li>
				<li>
					<a  class="nav-link" href="http://localhost:8080/QSport/San-Pham"> <b style="color: white" >  Sản phẩm </b> </a>
				</li>
				<li>
					<a  class="nav-link" href="http://localhost:8080/QSport/San-Pham/Giam-Gia"> <b style="color: white" >  Giảm giá </b> </a>
				</li>
				<c:choose>
					<c:when test="${tenHT != null }">
						<li class="nav-item ">
							<div class="dropdown">
							  <button class="btn btn-infor dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							   <b style="color: white" > ${tenHT} </b>
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
							  <c:if test='${Quyen == "Quản trị" }'>
									<a  class="dropdown-item" href="http://localhost:8080/QSport/admin"> <b> Quản Trị</b> </a>
								</c:if>
							    <a  class="dropdown-item" href="http://localhost:8080/QSport/User"> Cá nhân </a>
							    <button id="DangXuat" class="dropdown-item" type="button">Đăng Xuất</button>
							    
							  </div>
							</div>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item ">
							<a  class="nav-link" href="http://localhost:8080/QSport/DangNhap"> <b style="color: white" >  Đăng Nhập </b> </a>
						</li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item ">
					<div class="btn-group dropleft">
					  <button role="button" type="button" class="btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    <img style="height: 30px; width: 30px;" alt="" src="http://localhost:8080/QSport/resources/images/pngegg.png"> <b id="slTrongGio" style="color: white;"> ( ${soLuongTrongGio} ) </b>
					  </button>
					  <div class="dropdown-menu" style="margin-top: 35%;">
					    
					    <c:forEach var="gh" items="${lstGioHang}">
					    <hr width="400px">
					    	<div  class="row">
						    	<div class="col-3">
						    		<img style="margin-left: 10px"  alt="" src="http://localhost:8080/QSport/resources/images/products/${gh.getHinhAnh()}" width="50px" height="50px">
						    	</div>
						    	<div class="col-6">
						    		<span style="vertical-align: middle;" > <b > ${gh.getTenSanPham()}</b> -SL: ${gh.getSoLuong()}</span>
						    	</div>
						    	<div class="col-3">
						    		<b style="vertical-align: middle; color: red" > ${gh.getGiaTien()}</b> 
						    	</div>
					    	</div>
					    </c:forEach>
					     <a href="http://localhost:8080/QSport/Gio-Hang"> <div class="btn btn-danger" style="width: 80%; margin:3% 10% " > <h6>  GIỎ HÀNG </h6> </div> </a>
					  </div>
					</div>	
				</li>
					
				</ul>
			</div>
		</div>
	</nav>
