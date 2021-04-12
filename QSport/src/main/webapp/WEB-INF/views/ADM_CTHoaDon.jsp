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
                	<div class="row" style="font-size: 20px;"> 
	                	
	                	<div class="col-12" style="margin-bottom: 30px;"> 
	                		<h3 style="text-align: center"> HOÁ ĐƠN </h3> 
	                	</div>
	                	<div class="col-4" style="margin-bottom: 10px;">
	                		<span> <b>Tên khách hàng:</b> ${HoaDon.getTenKhachHang()}</span>
	                	</div>
	                	<div class="col-4">
	                		<span> <b>Số điện thoại:</b> ${HoaDon.getSdt()}</span>
	                	</div>
	                	<div class="col-4">
	                		<span> <b>Địa chỉ:</b> ${HoaDon.getDiaChi()}</span>
	                	</div>
	                	<div class="col-4">
	                		<span> <b>Ngày Đặt:</b> ${HoaDon.getNgayLap()}</span>
	                	</div>
	                	<div class="col-4">
	                		<span> <b>Hình thức nhận:</b> ${HoaDon.getHinhThucNhan()}</span>
	                	</div>
	                	<div class="col-4" style="margin-bottom: 10px;">
	                		<span> <b>Tình trạng:</b> 
	                			<c:choose>
	                				<c:when test="${HoaDon.getTinhTrang() == 'true'}">
	                					Đã Giao
	                				</c:when>
	                				<c:otherwise>
	                					Chưa Giao
	                				</c:otherwise>
	                			</c:choose>
	                		</span>
	                	</div>
	                	<div>
	                		<div class="row" style="margin-top: 20px">
	                			<div class="col-6">
	                				<b>Tên Sản phẩm </b>
	                			</div>
	                			<div class="col-3">
	                				<b>Số lượng</b>
	                			</div>
	                			<div class="col-3">
	                				<b>Thành tiền</b>
	                			</div>
	                			<c:set var="tong" value="0">  </c:set>
	                			<c:forEach var="ctsp" items="${lstCTSP}">
	                				<div class="col-6">
	                					<p>[ID: ${ctsp.getIdChiTietSanPham()}] ${ctsp.getSanPham().getTenSanPham()} (${ctsp.getMauSac().getTenMau()}-${ctsp.getSize().getTenSize()}) </p>
		                			</div>
		                			<c:set var="tien" value="true">  </c:set>
		                			<div class="col-3">
		                				<c:if test="${tien==true}">
		                				<c:forEach var="cthd" items="${lstCTHD}">
		                					<c:if test="${ctsp.getIdChiTietSanPham()== cthd.getChiTietHoaDonId().getIdChiTietSanPham()}">
		                						<c:set var="tien" value="false">  </c:set>
		                						<p>${cthd.getSoLuong()}</p>
		                					</c:if>
		                				</c:forEach>
		                				</c:if>
		                			</div>
		                			<c:set var="ttien" value="true">  </c:set>
		                			<div class="col-3">
		                				<c:if test="${ttien==true}">
		                				<c:forEach var="cthd" items="${lstCTHD}">
		                					<c:if test="${ctsp.getIdChiTietSanPham()== cthd.getChiTietHoaDonId().getIdChiTietSanPham()}">
		                						<c:set var="tien" value="false">  </c:set>
		                						<c:set var="tong" value="${tong + cthd.getSoTien()}"> </c:set>
		                						<p>${cthd.getSoTien()}</p>
		                					</c:if>
		                				</c:forEach>
		                				</c:if>
		                			</div>
	                			</c:forEach>
	                			 <div> <p style="margin-left: 20px; color: red;"> Tổng : <c:out value="${tong}"></c:out> </p></div>
	                		</div>
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