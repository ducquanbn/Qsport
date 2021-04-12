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
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="http://localhost:8080/QSport/admin/Hoa-Don">
                                    <p>Hoá Đơn</p>
                                </a>
                            </li>
                            
                           <li class="nav-item active">
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
					        	<div class="col-6">
					        		<label for="tenGiamGiaSua"> <b class="idGG" data-idGG="${giamgia.getIdGiamGia()}" style="color: black;"> Tên </b></label>
									<input id="tenGiamGiaSua" name="tenGiamGiaSua"  class="form-control" value="${giamgia.getTenGiamGia() }">
					        	</div>
					        	<div class="col-6">
									<label for="SoTienGiamSua"> <b style="color: black;"> Số tiền giảm </b></label>
									<input id="SoTienGiamSua" name="SoTienGiamSua"  class="form-control" value="${giamgia.getSoTienGiam()}">
					        	</div>	
					        	<div class="col-3">
									<label for="NgayBDGGSua"> <b style="color: black;"> Thời gian bắt đầu </b></label> <br/>
									<input type="date" id="NgayBDGGSua">
								</div>
								<div class="col-3">
									<label for="NgayKTGGSua"> <b style="color: black;"> Thời gian kết thúc </b></label> <br/>
									<input type="date" id="NgayKTGGSua" >
								</div>			
					      <div class="modal-footer">
					        <button id="SuaGG" type="button" class="btn btn-primary">Sửa</button>
					      </div>
					    </div>
         	</div>
        </div>
            <div class="card">
                <div class="card-body">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					  Thêm mới
					</button>
			   <!-- Modal Thêm -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel" style="text-align: center;"> Thêm Mới</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <div>
					        <div class="row">
								<label for="idSPGG"> <b style="color: black;"> Chọn sản phẩm </b> </label>
								<select id="idSPGG" name="idSPGG" class="browser-default custom-select">
								<c:forEach var="sp" items="${lstsp }">
									<option value="${sp.getIdSanPham()}"> [${sp.getIdSanPham()}] ${sp.getTenSanPham()}</option>
								</c:forEach>							    
							  	</select>
					        </div>					
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
					        <button id="ThemSPGG" type="button" class="btn btn-primary">Thêm</button>
					      </div>
					    </div>
					  </div>
					</div>
					</div>
				</div>		
					<!-- End of Modal Them -->
         <div class="row">
		<div class="col-md-12">
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Tên sản phẩm</th>
			      <th scope="col">Hình ảnh</th>
			      <th scope="col">Giá tiền</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="tong" value="0"> </c:set>
			    <c:forEach var="sp" items="${giamgia.getListSanPham()}">
			    <tr>
			      	<th scope="col" class="idspgg" data-id="${sp.getIdSanPham()}">${sp.getTenSanPham()}</th>
			      	<th scope="col"><img class="hinhAnhSP" data-hinhAnh="${sp.getHinhAnh()}" style="width: 100px; height: 100px;" alt="${sp.getTenSanPham()}" src="http://localhost:8080/QSport/resources/images/products/${sp.getHinhAnh()}"></th>
			      	<th scope="col">${sp.getGia()}</th>
			      	<th> <button type="button" class="btn btn-danger XoaGG">Xoá</button> </th>
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