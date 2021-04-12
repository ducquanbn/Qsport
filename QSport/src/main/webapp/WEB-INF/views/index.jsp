<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Website Title -->
    <title>QSport - Giày thể thao nam nữ </title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body >
 	<div class="container" style="margin: auto">
 	<!-- Slide -->
		<div style="height: 50%; margin-top: 10%" class="slide">
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		  </ol>
	  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="resources/images/1.jpg" alt="First slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="resources/images/3.jpg" alt="Second slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="resources/images/2.jpg" alt="Third slide">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		</div>
 	<!-- End Slide -->
 	
 	<div class="container">
 		<div class="row">
 			<div class="col-lg-3 col-6">
 				<div class="infor">
 					<img src="resources/images/iconfinder_truck_1291768-1.png">
 					<p> GIAO HÀNG TOÀN QUỐC </p>
 				</div>
 			</div>
 			
 			<div class="col-lg-3 col-6">
 				<div class="infor">
 					<img src="resources/images/iconfinder_payment_1954199-3.png">
 					<p> THANH TOÁN TẠI NHÀ </p>
 				</div>
 			</div>
 			
 			<div class="col-lg-3 col-6">
 				<div class="infor">
 					<img src="resources/images/iconfinder_service_repair_phone_mobile_wrench_screw_driver_4014703-1.png">
 					<p> BẢO HÀNH 60 NGÀY </p>
 				</div>
 			</div>
 			
 			<div class="col-lg-3 col-6">
 				<div class="infor">
 					<img src="resources/images/iconfinder_refresh_3017918-1.png">
 					<p> ĐỔI TRẢ DỄ DÀNG </p>
 				</div>
 			</div>
 		</div>
 	
 	</div>
 	
 	<div class="container">
 		
 	</div>
 	
 	<!-- NEW -->
 		<div class="SanPham">
		 <h1 align="center"> <b> SẢN PHẨM MỚI NHẤT </b> </h1> 
		<hr  width="30%" size="30px" align="center" />
		<div class="selectedProducts" align="center" >
		<button id="all" class="snip1457">Tất cả</button>
		<c:forEach var="dm" items="${lstDM}">
			<button data-idDMSP="${dm.getIdDanhMuc()}" class="snip1457 hover HTDanhMuc">${dm.getTenDanhMuc()}</button>
		</c:forEach>
			
		</div>
		<!-- Card-new -->

			<div class="row">
				<c:forEach var = "SanPham" items="${lstSP}">
            	<div class=" col-lg-3 col-6 dssp dm${SanPham.getDanhMuc().getIdDanhMuc()}">
            	<a style="text-decoration: none" href="Chi-Tiet/${SanPham.getIdSanPham()}">
				<div class="card wow bounceIn">
				  <img class="card-img-top " src="resources/images/products/${SanPham.getHinhAnh()}" alt="${SanPham.getTenSanPham()}">
				  	
				  <div class="card-body">
				    <h5 align="center"> ${SanPham.getTenSanPham()} </h5>
				    <c:set var="test" value="true"> </c:set>
				    <c:forEach var="sp" items="${GG.getListSanPham()}">
				    	<c:if test="${test == 'true' }">
				    		<c:if test="${sp.getIdSanPham() == SanPham.getIdSanPham()}">
				    		<span> <del class="HTGiaTienGiam" data-Gia="${SanPham.getGia()}" style="font-size: 15px; color: black;" > ${SanPham.getGia()}</del> <b align="center" data-Gia="${SanPham.getGia() - GG.getSoTienGiam()}" class="HTGiaTien card-text"> ${SanPham.getGia() - GG.getSoTienGiam()} </b> </span>
				    		<c:set var="test" value="false"> </c:set>
				    		</c:if>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${test == 'true' }">
				    	<p align="center" data-Gia="${SanPham.getGia()}" class="HTGiaTien card-text">${SanPham.getGia()}</p>
				    </c:if>
				  </div>
				</div>
				</a>
				</div>
            </c:forEach>
		</div>
		</div>
		
		
	</div>
	<!-- end Card New -->
 	<!-- end NEW -->
	
	
	
 	<div id='status'></div>
	<div id='loader'></div> 
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End of footer -->
</body>
</html>