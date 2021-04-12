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
	<c:choose>
		<c:when test="${lstSP.size() > 0}">
			<nav class="floating-menu" style="margin-top: 30px;" >
	        <ul class="main-menu" >
	        	<li> 
	        		<button id="all" class="snip1457">Tất cả</button>
	        	</li>
	        	<c:forEach var="dm" items="${lstDM}">
	            <li>             
	                 <button data-idDMSP="${dm.getIdDanhMuc()}" class="snip1457 hover HTDanhMuc">${dm.getTenDanhMuc()}</button>
	            </li>
	            </c:forEach>
	        </ul>
	        
	    </nav>
		<div class="container" style="margin: auto; margin-top: 100px">
			  <div class="SanPham">
			 <h1 align="center"> <b> DANH SÁCH SẢN PHẨM </b> </h1> 
			<hr  width="30%" size="30px" align="center" />
			
			<!-- Card-new -->
	
				<div id="sanphamall" class="row">
					<c:forEach var = "SanPham" items="${lstSP}">
	            	<div class=" col-lg-3 col-6 dssp dm${SanPham.getDanhMuc().getIdDanhMuc()}">
	            	<a style="text-decoration: none" href="http://localhost:8080/QSport/Chi-Tiet/${SanPham.getIdSanPham()}">
					<div class="card wow bounceIn">
					  <img class="card-img-top " src="http://localhost:8080/QSport/resources/images/products/${SanPham.getHinhAnh()}" alt="${SanPham.getTenSanPham()}">
					  	
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
		<nav aria-label="..." style="margin-left : 600px">
							  <ul class="pagination">
							    <c:forEach var="i" begin="1" end="${tongSoPage}">
							    	<c:choose>
							    		<c:when test="${i == 1 }">
							    			<li class="page-item active"><a class="page-link" href="#">1</a></li>
							    		</c:when>
							    		<c:otherwise>
							    			<li class="page-item"><a class="page-link" href="#">${i}</a></li>
							    		</c:otherwise>
							    	</c:choose>
							    </c:forEach>
							  </ul>
		</nav>
		</c:when>
		
		<c:otherwise>
			<p style="margin-top: 100px"> <b> Không tìm thấy sản phẩm nào </b> </p>
		</c:otherwise>
	</c:choose>
	<div id='status'></div>
	<div id='loader'></div> 
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End of footer -->
</body>
</html>