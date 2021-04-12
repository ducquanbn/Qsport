<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>QSport - ${SanPham.getTenSanPham()}</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<!-- Page Content -->
<div class="container" style="margin: auto">

  <!-- Portfolio Item Heading -->
  <div style="background-color :#f7e6ff;box-shadow: 10px 10px 5px #aaaaaa;margin-top: 8%;">
  <h1 style="text-align: center;" id="maSp" data-maSP="${SanPham.getIdSanPham()}" class="my-4">[${SanPham.getDanhMuc().getTenDanhMuc()}] 
    <small id="tenSp" data-tenSP="${SanPham.getTenSanPham()}"> ${SanPham.getTenSanPham()}</small>
  </h1>
	<hr class="style2" width="60%">
  <!-- Portfolio Item Row -->
  <div class="row">

    <div class="col-md-7">
      <img style="margin-left:5%; width: 90%; height:90%" class="rounded-circle border border-primary anhSP img-fluid" src="../resources/images/products/${SanPham.getHinhAnh()}" alt="${SanPham.getTenSanPham()}">
    </div>

    <div class="col-md-5">
      <h3 class="my-3">Mô tả</h3>
      <ul>
        <li><b> Chất liệu: </b> ${SanPham.getChatLieu()} </li>
        <li><b>Kiểu dáng:</b> ${SanPham.getKieuDang()}</li>
        <li><b>Màu sắc:</b> ${SanPham.getMauSacGiay()} </li>
        <li><b>Chất lượng:</b> ${SanPham.getChatLuong()}</li>
      </ul>
      <c:set var="test" value="true"> </c:set>
				    <c:forEach var="sp" items="${GG.getListSanPham()}">
				    	<c:if test="${test == 'true' }">
				    		<c:if test="${sp.getIdSanPham() == SanPham.getIdSanPham()}">
				    		<span> <del class="HTGiaTienGiam" data-Gia="${SanPham.getGia()}" style="font-size: 20px; color: black;" > ${SanPham.getGia()}</del> <b style="font-size: 30px" id="Gia" data-Gia="${SanPham.getGia() - GG.getSoTienGiam()}" class="HTGiaTien card-text"> ${SanPham.getGia() - GG.getSoTienGiam()} </b> </span>
				    		<c:set var="test" value="false"> </c:set>
				    		</c:if>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${test == 'true' }">
				    	<h3 id="Gia"  data-Gia="${SanPham.getGia()}" class="HTGiaTien card-text">${SanPham.getGia()}</h3>
				    </c:if>
      <h3 class="my-3">Màu sắc</h3>
      <div class="row">
      	
      	<c:forEach var = "DsMau" items="${lstMau}">
		<input type="radio" value="${DsMau}" name="dsMau" id="${DsMau}" />
		<label for="${DsMau}" > <img class="radioMauSac" data-src="${DsMau}" style="width: 100px; height: 100px;" src="../resources/images/products/${DsMau}"></label>
		 </c:forEach>
		
      
      </div>
      <h3 class="my-3">Size:</h3>
      <div class="row" >
      <c:forEach var = "DsSize" items="${lstSize}">
      
      	<div class="col-2" style="text-align:center; border: 1px solid black;border-radius: 5px;margin: 2% 2%;">
      	<input data-maSize="${DsSize.getIdSize()}" type="radio" value="${DsSize.getTenSize()}" name="dsSize" id="${DsSize.getTenSize()}" />
      		<label for="${DsSize.getTenSize()}" >${DsSize.getTenSize()} </label>
      	</div> 
      	</c:forEach>
      	
      </div>
      <button id="btnThemVaoGio" type="button" class="btn btn-danger" style="width: 90%; margin-right: 10%; margin-bottom: 5%" ><h4> THÊM VÀO GIỎ </h4></button>
    </div>

  </div>
  </div>
  <!-- /.row -->

  <!-- Related Projects Row -->
  <h3 class="my-4">Sản phẩm bán chạy</h3>
	<div class="row">
				<c:forEach var = "SanPham" items="${lstSPBC}">
            	<div class=" col-lg-3 col-6 dssp dm${SanPham.getDanhMuc().getIdDanhMuc()}">
            	<a style="text-decoration: none" href="http://localhost:8080/QSport/Chi-Tiet/${SanPham.getIdSanPham()}">
				<div class="card wow bounceIn">
				  <img class="card-img-top " src="../resources/images/products/${SanPham.getHinhAnh()}" alt="${SanPham.getTenSanPham()}">
				</div>
				</a>
				</div>
            </c:forEach>
		</div>


</div>
<!-- /.container -->

	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>