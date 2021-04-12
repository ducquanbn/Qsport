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
									<label for="tenGiamGia"> <b style="color: black;"> Tên </b></label>
									<input id="tenGiamGia" name="tenGiamGia"  class="form-control">
									<div>
									<label for="NgayBDGG"> <b style="color: black;"> Thời gian bắt đầu </b></label> <br/>
									<input type="date" id="NgayBDGG" >
									</div>
									<div style="margin-left: 30%">
									<label for="NgayKTGG"> <b style="color: black;"> Thời gian kết thúc </b></label> <br/>
									<input type="date" id="NgayKTGG"  >
									</div>
									<label for="SoTienGiam"> <b style="color: black;"> Số tiền giảm </b></label>
									<input id="SoTienGiam" name="SoTienGiam"  class="form-control">
					        </div>					
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
					        <button id="ThemGG" type="button" class="btn btn-primary">Thêm</button>
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
			      <th scope="col">Tên</th>
			      <th scope="col">Bắt đầu</th>
			      <th scope="col">Kết thúc</th>
			      <th scope="col">Số tiền giảm</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="tong" value="0"> </c:set>
			    <c:forEach var="gg" items="${lstGiamGia}">
			    <tr>
			      	<th scope="col">${gg.getTenGiamGia()}</th>
			      	<th scope="col">${gg.getThoiGianBD()}</th>
			      	<th scope="col">${gg.getThoiGianKT()}</th>
			      	<th scope="col">${gg.getSoTienGiam()}</th>
			      	<th> <a id="UpdateGG" href="http://localhost:8080/QSport/admin/Khuyen-Mai/${gg.getIdGiamGia()}" class="btn btn-danger">Update</a> </th>
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