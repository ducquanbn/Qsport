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
                            <li class="nav-item active">
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
                <c:if test="${tenHT=='admin'}">
                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					  Thêm tài khoản
					</button>
                
                
			   <!-- Modal Thêm -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel" style="text-align: center;"> Thêm tài khoản</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <div>
								<label for="tenTK"> <b style="color: black;"> Tên tài khoản </b></label>
								<input id="tenTK" name="tenTK"  class="form-control">
								
								<label for="TaoMatKhau"> <b style="color: black;"> Mật khẩu </b> </label>
								<input type="password" id="TaoMatKhau" name="TaoMatKhau" class="form-control">
								
								
								<label for="idChucVu"> <b style="color: black;"> Chức vụ </b> </label>
								<select id="idChucVu" name="idChucVu" class="browser-default custom-select">
									<c:forEach var="pq" items="${lstPQ}">
										<option value="${pq.getIdPhanQuyen()}">${pq.getTenQuyen()}</option>
									</c:forEach>					    
							  	</select>
							</div>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
					        <button id="ThemTK" type="button" class="btn btn-primary">Thêm</button>
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
			    <th scope="col">Họ tên</th>
			      <th scope="col">Tên tài khoản</th>
			      <th scope="col"> Mật khẩu </th>
			      <th scope="col">Giới tính</th>
			      <th scope="col">Địa chỉ</th>
			      <th scope="col">Sđt</th>
			      <th scope="col">Email</th>
			      <th scope="col">Chức Vụ</th>
			      <th> </th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="tk" items="${lstTK}">
			  	<tr>
			  		<td class="idUser" data-id="${tk.getIdTaiKhoan()}"> ${tk.getHoTen()} </td>
			  		<td> ${tk.getTenTaiKhoan()} </td>
				  	<td> ${tk.getMatKhau()}</td>
				  	<td> ${tk.getGioiTinh() }</td>
				  	<td> ${tk.getDiaChi() }</td>
				  	<td> ${tk.getSdt() }</td>
				  	<td> ${tk.getEmail() }</td>
				  	<td> ${tk.getPhanQuyen().getTenQuyen() }</td>
				  	<td>
				  		<select name="TrangThai" class="browser-default custom-select trangThaiTK">
				  		<c:choose>
				  			<c:when test="${tk.getTinhTrang() =='Mở' }">
				  				<option value="Mở" selected="selected">Mở</option>
				  				<option value="Khoá">Khoá</option>
				  			</c:when>
				  			<c:when test="${tk.getTinhTrang() =='Khoá' }">
				  				<option value="Mở">Mở</option>
				  				<option value="Khoá" selected="selected">Khoá</option>
				  			</c:when>
				  		</c:choose>				    
						</select>
				  	</td>
			  	</tr>
			  </c:forEach>
			  	
			  </tbody>
			</table>
		</div>
	</div>
	</c:if>
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