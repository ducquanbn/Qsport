<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
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
                            <li class="nav-item active">
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
			       <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					  Thêm sản phẩm
					</button>
			   <!-- Modal Thêm -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel" style="text-align: center;"> Thêm sản phẩm</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <div>
								<label for="tenSanPham"> <b style="color: black;"> Tên sản phẩm </b></label>
								<input id="tenSanPham" name="tenSanPham"  class="form-control">
								
								<label for="GiaTienSP"> <b style="color: black;"> Giá </b> </label>
								<input id="GiaTienSP" name="GiaTienSP" class="form-control">
								
								<label for="idDanhMuc"> <b style="color: black;"> Thương hiệu </b> </label>
								<select id="idDanhMuc" name="idDanhMuc" class="browser-default custom-select">
								<c:forEach var="lstDM" items="${lstDM }">
									<option value="${lstDM.getIdDanhMuc()}">${lstDM.getTenDanhMuc()}</option>
								</c:forEach>							    
							  	</select>
							  	
								<label for="ChatLieu"> <b style="color: black;"> Chất liệu </b> </label>
								<input id="ChatLieu" name="ChatLieu" class="form-control">
								
								<label for="KieuDang"> <b style="color: black;"> Kiểu Dáng </b> </label>
								<input id="KieuDang" name="KieuDang" class="form-control">
								
								<label for="MauSacGiay"> <b style="color: black;"> Màu sắc </b> </label>
								<input id="MauSacGiay" name="MauSacGiay" class="form-control">
								
								<label for="ChatLuong"><b style="color: black;"> Chất lượng </b> </label>
								<input id="ChatLuong" name="ChatLuong" class="form-control">
								
								<div class="row"> 
									<div class="col-4">  
									<label for="idMauSacSP"> <b style="color: black;"> Màu Sắc </b> </label>
									<select id="idMauSacSP" name="idMauSacSP" class="browser-default custom-select">
									<c:forEach var="lstMS" items="${lstMS }">
										<option value="${lstMS.getIdMauSac()}">${lstMS.getTenMau()}</option>
									</c:forEach>							    
								  	</select>
								  	</div>
								  	
								  	<div class="col-4"> 
								  	<label for="idSizeSP"> <b style="color: black;"> Size </b> </label>
									<select id="idSizeSP" name="idSizeSP" class="browser-default custom-select">
									<c:forEach var="lstSize" items="${lstSize }">
										<option value="${lstSize.getIdSize()}">${lstSize.getTenSize()}</option>
									</c:forEach>
									</select>	
									</div>
									
									<div class="col-4"> 
									<label for="soLuongSP"> <b style="color: black;"> Số lượng </b> </label>
									<input id="soLuongSP" name="soLuongSP" class="form-control">						    
							  		
							  		</div>
								 </div>
								
								<div>
							    <label for="hinhAnh"><b style="color: black;"> Ảnh minh hoạ </b></label>
							    <input type="file" class="form-control-file" id="hinhAnh">
							  </div>
							</div>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
					        <button id="ThemSanPham" type="button" class="btn btn-primary">Thêm</button>
					      </div>
					    </div>
					  </div>
					</div>
					<!-- End of Modal Them -->
					
			        <div class="row">
					<div class="col-md-12">
						<table style="width: 100%" id="table-sanpham" class="table ">
						  <thead class="thead-light">
						    <tr>
						      <th scope="col">Tên sản phẩm</th>
						      <th scope="col">Hình ảnh</th>
						      <th scope="col">Giá</th>
						      <th scope="col">Thương hiệu</th>
						      <th> </th>
						    </tr>
						  </thead>
						  <tbody>
						  <c:forEach var="sanpham" items="${lstSP}">
						  	<tr>
						      <th class="nameSP" style="vertical-align: middle;" scope="row" data-idSP="${sanpham.getIdSanPham()}"> <a style="color: black;text-decoration: none;" href="http://localhost:8080/QSport/Chi-Tiet/${sanpham.getIdSanPham()}"> Giày thể thao ${sanpham.getTenSanPham()} </a> </th>
						      <td> <img class="hinhAnhSP" data-hinhAnh="${sanpham.getHinhAnh()}" style="width: 100px; height: 100px;" alt="${sanpham.getTenSanPham()}" src="../resources/images/products/${sanpham.getHinhAnh()}"> </td>
						      <td class="Tien" data-money="${sanpham.getGia() }" class="" style="vertical-align: middle; text-align: center; ">${sanpham.getGia()}</td>
						      <td class="tenDMSP" data-idDMSP="${ sanpham.getDanhMuc().getIdDanhMuc()}"  style="vertical-align: middle;text-align: center;text-transform: uppercase; "> <b> ${sanpham.getDanhMuc().getTenDanhMuc()} <b> </td>
						      <td style="margin-top: 40px;" class="btn btn-danger"><a style="color: white;text-decoration: none;" href="http://localhost:8080/QSport/admin/San-Pham/${sanpham.getIdSanPham()}"> Sửa </a> </td>
						      
						      <td style="margin-top: 40px;" class="btn btn-danger"><a style="color: white;text-decoration: none;" href="http://localhost:8080/QSport/admin/San-Pham/Chi-Tiet/${sanpham.getIdSanPham()}"> Cập nhật </a> </td>
						    </tr>
						  </c:forEach>  
						  </tbody>
						</table>
						
							<nav aria-label="...">
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