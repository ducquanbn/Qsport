<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="vi">
<head>
<meta charset="ISO-8859-1">

<title>QSport - Quản Trị </title>
<link rel="stylesheet" href='<c:url value="/resources/css/material-dashboard.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/swiper.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/fontawesome-all.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/animate.css" />' />
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' />
<!-- Favicon  -->
	
    <link rel="icon" href="http://localhost:8080/QSport/resources/images/favicon.png">
</head>
<body>
	
	<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3 col-md-3">
            <div class="wrapper ">
                <div class="sidebar" data-color="purple" data-background-color="white">
                    <div class="logo"><a href="http://localhost:8080/QSport/" class="simple-text logo-normal">
                        QSport
                    </a></div>
                    <div class="sidebar-wrapper">
                        <ul class="nav">
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin">
                                    <p>Tài khoản</p>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/San-Pham">
                                    <p>Sản phẩm</p>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Danh-Muc">
                                   
                                    <p>Danh Mục</p>
                                </a>
                            </li>
                            
                            <li class="nav-item ">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Hoa-Don">
                                    
                                    <p>Hoá Đơn</p>
                                </a>
                            </li>
                            
                           <li class="nav-item ">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Khuyen-Mai">
                                    
                                    <p>Khuyến mãi</p>
                                </a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Qsport">
                                    
                                    <p>QSport</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>

        <div class="col-lg-9 col-md-9">
            <div class="card">
                <div class="card-body">
                    <label for="SDTQ"> <b style="color: black;"> Số điện thoại </b> </label>
					<input id="SDTQ" name="SDTQ" value="${Q.getSdt()}" class="form-control">
					
                    <label for="EmailQ"> <b style="color: black;"> Email </b> </label>
					<input id="EmailQ" name="EmailQ" value="${Q.getEmail() }" class="form-control">
					
					<label for="DiaChiQ"> <b style="color: black;"> Địa chỉ</b> </label>
					<input id="DiaChiQ" name="DiaChiQ" value="${Q.getDiaChi() }" class="form-control">
					
					<label for="MoTaQ"> <b style="color: black;"> Mô tả</b> </label>
					<textarea rows="4" id="MoTaQ" name="MoTaQ" class="form-control" > ${Q.getMoTa()} </textarea>
                    
			<div class="modal-footer">
					        <button type="button" class="btn btn-secondary" onclick="history.back()" > Huỷ </button>
					        <button id="SuaQSport" class="btn btn-primary">Sửa</button>
			</div>
            </div>
            </div>
        </div>

    </div>
</div>

<a href="#" id="back-to-top" class="backtop show1" title="Lên đầu trang"></a>
	
 <!-- Scripts -->
<script src='<c:url value="/resources/js/jquery.min.js" />'></script>
<script src='<c:url value="/resources/js/popper.min.js" />'> </script>
<script src='<c:url value="/resources/js/bootstrap.min.js" />'> </script>
<script src='<c:url value="/resources/js/jquery.easing.min.js" />'> </script>
<script src='<c:url value="/resources/js/swiper.min.js" />'> </script>
<script src='<c:url value="/resources/js/wow.min.js" />'> </script>
<script src='<c:url value="/resources/js/scripts.js" />'> </script>
</body>
</html>