<!doctype html>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="vi">
<head>
<meta charset="ISO-8859-1">

<title>QSport - Quản Trị - ${sp.getTenSanPham()} </title>
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
			<table>
				<tr>
					<td rowspan="4">
					<div >
						<img class="HASua" style="margin:40px 40px; height: 200px; width: 200px;" Data-HA="${sp.getHinhAnh()}" alt="${sp.getTenSanPham()}" src="http://localhost:8080/QSport/resources/images/products/${sp.getHinhAnh()}">
					</div>
					</td>
					<td> 
						<label for="tenSanPhamSua"> <b style="color: black;"> Tên sản phẩm </b></label>
						<input id="tenSanPhamSua" name="tenSanPhamSua" data-idSPSua="${sp.getIdSanPham()}" class="form-control" value="${sp.getTenSanPham()}">
					 </td>
					<td>
						<label for="GiaTienSPSua"> <b style="color: black;"> Giá </b> </label>
						<input id="GiaTienSPSua" name="GiaTienSPSua" class="form-control" value="${sp.getGia()}">
					</td>
				</tr>
				<tr>
					<td>
						<label for="idDanhMucSua"> <b style="color: black;"> Thương hiệu </b> </label>
								<select id="idDanhMucSua" name="idDanhMucSua" class="browser-default custom-select">
								<c:forEach var="lstDM" items="${lstDM }">
									<c:choose>
										<c:when test="${lstDM.getIdDanhMuc() == sp.getDanhMuc().getIdDanhMuc()}">
											<option value="${lstDM.getIdDanhMuc()}" selected="selected">${lstDM.getTenDanhMuc()}</option>
										</c:when>
										<c:otherwise>
											<option value="${lstDM.getIdDanhMuc()}">${lstDM.getTenDanhMuc()}</option>									
										</c:otherwise>
									</c:choose>
								</c:forEach>							    
							  	</select> 
					</td>
					<td>
						<label for="hinhAnhSua"><b style="color: black;"> Ảnh minh hoạ </b></label>
						<input type="file" class="form-control-file" id="hinhAnhSua">
					</td>
				</tr>
				<tr>
					<td>
						<label for="ChatLieuSua"> <b style="color: black;"> Chất liệu </b> </label>
						<input id="ChatLieuSua" name="ChatLieuSua" value="${sp.getChatLieu() }" class="form-control">
						
					</td>
					<td>
						<label for="KieuDangSua"> <b style="color: black;"> Kiểu Dáng </b> </label>
						<input id="KieuDangSua" name="KieuDangSua" value="${sp.getKieuDang() }" class="form-control">
						
					</td>
				</tr>
				<tr>
					<td>
						<label for="MauSacGiaySua"> <b style="color: black;"> Màu sắc </b> </label>
						<input id="MauSacGiaySua" name="MauSacGiaySua" class="form-control" value="${sp.getMauSacGiay() }">
					</td>
					<td>
						<label for="ChatLuongSua"><b style="color: black;"> Chất lượng </b> </label>
						<input id="ChatLuongSua" name="ChatLuongSua" value="${sp.getChatLuong() }" class="form-control">							
					</td>
				</tr>
			</table>
			<div class="modal-footer">
					        <button type="button" class="btn btn-secondary" onclick="history.back()" > Huỷ </button>
					        <button id="SuaSP" type="button" class="btn btn-primary">Sửa</button>
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