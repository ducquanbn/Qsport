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
					  Cập nhật
					</button>
			   <!-- Modal Thêm -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title thongTin" data-idSP="${SP.getIdSanPham() }" id="exampleModalLabel" style="text-align: center;">${SP.getTenSanPham() }</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <div>
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
								  	<label for="idSizeSPThem"> <b style="color: black;"> Size </b> </label>
									<select id="idSizeSPThem" name="idSizeSPThem" class="browser-default custom-select">
									<c:forEach var="lstSize" items="${lstSize }">
										<option value="${lstSize.getIdSize()}">${lstSize.getTenSize()}</option>
									</c:forEach>
									</select>	
									</div>
									
									<div class="col-4"> 
									<label for="soLuongSPThem"> <b style="color: black;"> Số lượng </b> </label>
									<input id="soLuongSPThem" name="soLuongSPThem" class="form-control">						    
							  		
							  		</div>
								 </div>
								
								<div>
							    <label for="ThemHinhAnhCTSP"><b style="color: black;"> Ảnh minh hoạ </b></label>
							    <input type="file" class="form-control-file" id="ThemHinhAnhCTSP">
							  </div>
							</div>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
					        <button id="ThemCTSP" type="button" class="btn btn-primary">Thêm</button>
					      </div>
					    </div>
					  </div>
					</div>
					<!-- End of Modal Them -->
        

        <div class="row">
		<c:forEach var="anh" items="${lstMau}">
		<div class="col-4">
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th  class="anh" data-anh="${anh}" scope="col" colspan="2" style="text-align: center;" > <img height="150px"; width="150px;" alt="" src="http://localhost:8080/QSport/resources/images/products/${anh}" > </th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="ctsp" items="${lstCTSP}">
			  	<c:if test="${ctsp.getHinhAnh() == anh}">
			  	<tr> 
			  		<td style="width: 50%" class="CTSPidCTSP" data-idCTSP="${ctsp.getIdChiTietSanPham()}"><b> ${ctsp.getMauSac().getTenMau() } </b>  Size: ${ctsp.getSize().getTenSize()} </td>
			  		<td> Số lượng: <input class="showSL" type="text" value="${ctsp.getSoLuongCon()}" style="width: 40%;">  </td>
			  	</tr>
			  	</c:if>
			  </c:forEach>
			  </tbody>
			</table>
			</div>
		</c:forEach>
		
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