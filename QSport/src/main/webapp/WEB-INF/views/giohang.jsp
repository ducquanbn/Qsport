<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport'/>
<title>Qsport - Giỏ hàng</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

<div class="container" style="margin: auto">
	<h2 style="margin-top: 8%">Giỏ hàng của bạn</h2>
	<div class="container">
	<div class="row">
		<div class="col-md-12">
			<table class="table" id="table-GioHang">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Sản Phẩm</th>
			      <th scope="col"></th>
			      <th scope="col">Đơn giá</th>
			      <th scope="col">Số lượng</th>
			      <th scope="col">Thành Tiền</th>
			      <th> </th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="tong" value="0"> </c:set>
			    <c:forEach var="sanpham" items="${GioHang}">
			    <tr>
			      <th class="nameSP" style="vertical-align: middle;" scope="row" data-idSP="${sanpham.getIdSanPham()}"> <h6 class="idCTSP" data-idCTSP="${sanpham.getIdChiTietSanPham()}">[ID sản phẩm: ${sanpham.getIdChiTietSanPham()} ]</h6> ${sanpham.getTenSanPham()} - <b class="maSize" data-idSize="${sanpham.getIdSize()}"> Size: ${sanpham.getTenSize()} </b> </th>
			      <td> <img class="hinhAnhSP" data-hinhAnh="${sanpham.getHinhAnh()}" style="width: 100px; height: 100px;" alt="${sanpham.getTenSanPham()}" src="resources/images/products/${sanpham.getHinhAnh()}"> </td>
			      <td class="Tien" data-money="${sanpham.getGiaTien() }" class="" style="vertical-align: middle;">${sanpham.getGiaTien()}</td>
			      <td width="50px" style="vertical-align: middle;"> 
					
					<div class="row" >
					<div class="col-12">
							<input class="ThemSoLuong-GioHang"  style="align-items: center; width: 80px" type="button" value="+"> 
					</div>
					
					<div class="col-12">
						<input disabled="disabled" style=" text-align:center; width: 80px;" min="1" class="soLuong-GioHang" type="number" value="${sanpham.getSoLuong()}"> 
					</div>
					<div  class="col-12">
							<input class="GiamSoLuong-GioHang" style="align-items: center; width: 80px" type="button" value="- "> 
					</div>
					</div>
			      

			      </td>
			      <c:set var="tien" value="${sanpham.getGiaTien() }">  </c:set>
			      <c:set var="soLuong" value="${sanpham.getSoLuong()}">  </c:set>
			      
			      <c:set var="tong" value="${tong + (tien*soLuong )}"> </c:set>
			      <td class="thanhTien" style="vertical-align: middle;"> <c:out value="${tien*soLuong }"></c:out> </td>
			      <td style="margin-top: 40px;" class="xoaGioHang btn btn-danger"> Xoá</td>
			    </tr>
			    </c:forEach>
			    
			  </tbody>
			</table>
		</div>
	</div>
	</div>
	<div>
		<h2> Thông tin đặt hàng </h2>
		<div class="container">
		
			<div class="row">
				<div class="col-6">
					<div class=form-group>
					
					<c:choose>
						<c:when test="${user != null}">
							<label for="tenKhachHang"> Tên người đặt hàng (*) </label>
							<input type="text" id="tenKhachHang" name="tenKhachHang"  class="form-control" required="required" value="${user.getHoTen()}"> 
							<label for="sdt"> Số điện thoại (*) </label>
							<input type="text" id="sdt" name="sdt" class="form-control" required="required" value="${user.getSdt() }">
							<label for="diaChi"> Địa chỉ nhận hàng (*) </label>
							<input type="text" id="diaChi" name="diaChi" class="form-control" required="required" value="${user.getDiaChi()}">
						</c:when>
						<c:otherwise>
							<label for="tenKhachHang"> Tên người đặt hàng (*) </label>
							<input type="text" id="tenKhachHang" name="tenKhachHang"  class="form-control" required="required"> 
							<label for="sdt"> Số điện thoại (*) </label>
							<input type="text" id="sdt" name="sdt" class="form-control" required="required">
							<label for="diaChi"> Địa chỉ nhận hàng (*) </label>
							<input type="text" id="diaChi" name="diaChi" class="form-control" required="required">
						</c:otherwise>
					</c:choose>	
					<label for="ghiChu"> Ghi chú </label>
					<textarea id="ghiChu" name="ghiChu" rows="3" class="form-control"> </textarea>
				</div>
			</div>
			<div class="col-6">
				<h5>Hình thức thanh toán</h5>
				<div class="radio">
					<label> <input type="radio" value="Tại nhà" name="hinhThucNhan" checked="checked"> Tại nhà </label>
				</div>
				<div class="radio">
					<label> <input type="radio" value="Tại cửa hàng" name="hinhThucNhan"> Tại cửa hàng</label>
				</div>
				<h5 style="color: red; text-align: center;margin-top: 5%"> Tổng tiền : <b class="tongTienMua" data-tong="${tong }" > ${tong } </b> VNĐ </h5>
				<input style="width: 100%; background-color:#0040ff; font-weight: bold;" type="submit" class="DatHang btn btn-primary" value="ĐẶT HÀNG" >
			</div>
		</div>
		</div>
	</div>

</div>
<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- End of footer -->
</body>
</html>