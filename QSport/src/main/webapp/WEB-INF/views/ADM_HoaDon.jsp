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
                            <li class="nav-item ">
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
                            <li class="nav-item active">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Hoa-Don">
                                    
                                    <p>Hoá Đơn</p>
                                </a>
                            </li>
                            
                           <li class="nav-item ">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Khuyen-Mai">
                                    
                                    <p>Khuyến mãi</p>
                                </a>
                            </li>
                            <li class="nav-item ">
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
                    <div class="row">
           <div class="col-md-12">
           		 <table class="table">
			  <tbody>
			     <tr>
			      <td> <input type="text" class="timKiemUser" placeholder="tên tài khoản">
				       <input type="text" class="timKiemSDT" placeholder="số điện thoại">
				       <input type="button" class="btn btn-danger" id="TimKiemnHoaDon" value="Lọc"> 
			       </td>
			      <td> <input type="date" id="NgayBD"  > <input type="date" id="NgayKT" > <input type="button" class="btn btn-danger" id="TimKiemnHoaDonDate" value="Lọc"> </td>
			      
			     </tr>
			  </tbody>
			</table>
           </div>
		<div class="col-md-12">
			<table class="table" id="table-hoadon"  >
			  <thead class="thead-light">
			    <tr style="text-align: center; font-weight: bold;">
			      <th scope="col">Tài khoản</th>
			      <th scope="col">Tên khách</th>
			      <th scope="col">Số ĐT</th>
			      <th scope="col">Địa chỉ</th>
			      <th scope="col">Ngày lập</th>
			      <th scope="col">Hình thức nhận</th>
			      <th scope="col">G.Hàng</th>
			      <th scope="col">Ghi chú</th>		      
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="HD" items="${lstHD}">
			    <tr>
			      <th class="idHoaDon" data-idHD="${HD.getIdHoaDon()}" style="vertical-align: middle;" scope="row" "> ${HD.getTaiKhoan().getTenTaiKhoan()} </th>
			      <td> <a href="http://localhost:8080/QSport/admin/Hoa-Don/CTHD/${HD.getIdHoaDon()}">  ${HD.getTenKhachHang()} </a> </td>
			      <td> ${HD.getSdt()}</td>
			      <td> ${HD.getDiaChi()} </td>
			      <td> ${HD.getNgayLap()} </td>
			      <td> ${HD.getHinhThucNhan()} </td>
			      <td> 
			      	<c:choose>
			      		<c:when test="${HD.getTinhTrang() == true}">
						    <input style="margin-left: 20px;" type="checkbox" class="form-check-input checkTinhTrang" value="" checked="checked">
			      		</c:when>
			      		<c:otherwise>
							<input style="margin-left: 20px;" type="checkbox" class="form-check-input checkTinhTrang" value="" >
			      		</c:otherwise>
			      	</c:choose>
			      </td>
			      <td> ${HD.getGhiChu()} </td>
			    </tr>
			    </c:forEach>
			    
			  </tbody>
			</table>
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