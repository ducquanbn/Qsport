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
                            <li class="nav-item active">
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
								<div class="col-9">
									<label for="tenDanhMuc"> <b style="color: black;"> Tên Thương Hiệu </b></label>
									<input id="tenDanhMuc" name="tenDanhMuc"  class="form-control">
								</div>
					        	<div class="col-3">
					        		<button id="ThemDM" style="margin-top: 30px;"  type="button" class="btn btn-primary">Thêm</button>
					        	</div>
					        </div>		
					        
					        <div class="row">
								<div class="col-9">
									<label for="tenMau"> <b style="color: black;"> Tên Màu </b></label>
									<input id="tenMau" name="tenMau"  class="form-control">
								</div>
					        	<div class="col-3">
					        		<button style="margin-top: 30px;" id="ThemMau" type="button" class="btn btn-primary">Thêm</button>
					        	</div>
					        </div>	
					        
					        <div class="row">
								<div class="col-9">
									<label for="tenSizeThem"> <b style="color: black;"> Tên Size </b></label>
									<input id="tenSizeThem" name="tenSizeThem"  class="form-control">
								</div>
					        	<div class="col-3">
					        		<button style="margin-top: 30px;" id="ThemSize" type="button" class="btn btn-primary">Thêm</button>
					        	</div>
					        </div>					
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
					      </div>
					    </div>
					  </div>
					</div>
					</div>
				</div>		
					<!-- End of Modal Them -->
                    <div class="row">
		
		
		<div class="col-12" style="margin-bottom: 50px;">
			<div style="width: 100%; background-color: #ccccff; padding: 10px 10px;" > <b><h5> Màu Sắc </h5></b> </div>
			<div class="row">
			<c:forEach var="mau" items="${lstMau}">
				<div class="col-1" data-idMau="${mau.getIdMauSac()}">
					<input class="txtSuaMau" type="text" style="width: 100px" value="${mau.getTenMau()}">
				</div>
			</c:forEach>
				
			</div>
		</div>
		
		<div class="col-12" style="margin-bottom: 50px;">
			<div style="width: 100%; background-color: #ccccff;padding: 10px 10px;" > <b> <h5>Size</h5> </b> </div>
			<div class="row">
			<c:forEach var="size" items="${lstSize}">
				<div class="col-1" data-idSize="${size.getIdSize()}">
					<input class="txtSuaSize" type="text" style="width: 100px" value="${size.getTenSize()}">
				</div>
			</c:forEach>
			</div>
		</div>
		
		<div class="col-12"style="margin-bottom: 50px;" >
			<div style="width: 100%; background-color: #ccccff;padding: 10px 10px;" > <b> <h5>Thương hiệu</h5> </b> </div>
			<div class="row">
			<c:forEach var="DM" items="${lstDM}">
				<div class="col-1" data-idDM="${DM.getIdDanhMuc()}" >
					<input class="txtSuaDM" type="text" style="width: 100px" value="${DM.getTenDanhMuc()}">
				</div>
			</c:forEach>
				
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