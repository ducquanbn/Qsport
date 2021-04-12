(function($) {
	/* Login click */
	$("#clicklog").click(function(){
    	$("#log").show();
    	$("#errorDangNhap").text("");
    	$("#reg").hide();
    });
    
    /* Reg click */
    $("#clickreg").click(function(){
    	$("#log").hide();
    	$("#reg").show();
    });
    
    /* Thay đổi ảnh sản phẩm trong page chi tiết */
     $(".radioMauSac").click(function(){
    	var src = $(this).attr("data-src");
    	var srcNew = "http://localhost:8080/QSport/resources/images/products/"+src;
    	$(".anhSP").attr("src", srcNew);
    });
    
    /* Ajax Dang Nhap */
    $("#btnLog").click(function(){
    		var user =$("#user").val();
    		var pass = $("#pass").val();
			$.ajax({
			    url: "/QSport/DangNhap/kiemTraDangNhap",
			    type: "GET",
			    data:{
			    	user : user,
			    	pass : pass  
				    },
			    success: function(value){
			    	if ($.trim(user) == '' || $.trim(pass) == ''){
		      			 $("#errorDangNhap").text("Không được bỏ trống!!");
		    		}
				    else{
						    if(value == "true"){
						    duongdanHienTai = window.location.href;
						    duongdan = duongdanHienTai.replace("DangNhap","");
						    window.location = duongdan;
						    }
						    if(value == "khoa"){
					    		$("#errorDangNhap").text("Tài khoản đã bị khoá!!");
					    	}
					    	if(value == "false"){
					    		$("#errorDangNhap").text("Tài khoản hoặc mật khẩu không đúng!!");
					    	}
					}    	
				    
			    }
			})
    });
	
	
	/* Ajax Dang Ky */
    $("#btnReg").click(function(){
    	var userReg =$("#userReg").val();
    	var passReg = $("#passReg").val();
    	var passRegA = $("#passRegA").val();
			$.ajax({
			    url: "/QSport/DangNhap/kiemTraDangKy",
			    type: "GET",
			    data:{
			    	userReg : userReg,
			    	passReg : passReg,
			    	passRegA : passRegA 
				    },
			    success: function(value){
			    	if ($.trim(userReg) == '' || $.trim(passReg) == '' || $.trim(passRegA) == '' ){
		      			 $("#errorDangKy").text("Không được bỏ trống!!");
		    		}
				    else{
				    	if($.trim(passReg) != $.trim(passRegA)){
				    		$("#errorDangKy").text("Mật khẩu phải trùng nhau !!");
				    	}
				    	else{
					    	if(value == "true"){
					    		alert('Đăng kí thành công, mời bạn đăng nhập');
					    		window.location = window.location.href;
						    }		    	
						    else
						    	$("#errorDangKy").text("Tên tài khoản đã được sử dụng!!");
						    }    	
				    }
			    }
			})
    });
	
	
	/* Btn Products */
	$(".hover").mouseleave(
	  function () {
	    $(this).removeClass("hover");
	  }
	);
	
	/* Show all sản phẩm index */
	$("#all").click(function(){
		$(".dssp").show();
	});
	/* show sản phẩm theo danh mục */
	$(".HTDanhMuc").click(function(){
		var id = $(this).attr("data-idDMSP");
		$(".dssp").hide();
		$(".dm"+id).show();
	});
	
	/* BTN Them vao gio hang */
	$("#btnThemVaoGio").click(function(){
		 var idSanPham = $("#maSp").attr("data-maSP");
		 var tenSanPham = $("#tenSp").attr("data-tenSP");
		 var hinhAnh = $("input[name='dsMau']:checked").val();
		 var idSize = $("input[name='dsSize']:checked").attr("data-maSize");
		 var tenSize = $("input[name='dsSize']:checked").val();
		 var soLuong = 1;
		 var giaTien = $("#Gia").attr("data-Gia");
		 
		    
         $.ajax({
			    url: "/QSport/Gio-Hang/themGioHang",
			    type: "GET",
			    data:{
			    	 idSanPham : idSanPham ,
					 tenSanPham :tenSanPham,
					 hinhAnh : hinhAnh,
					 idSize : idSize,
					 tenSize : tenSize,
					 soLuong : soLuong,
					 giaTien : giaTien
				    },
			    success: function(value){
			    	   	if(value == "true"){
			    	   		$.ajax({
						    url: "/QSport/Gio-Hang/laySoLuongGioHang",
						    type: "GET",
						    data:{
						    	 
							    },
						    success: function(value){
								$("#slTrongGio").html("( "+ value+ " )");
								window.location.reload();
							}
							})
			    	   	}else{
			    	   		if(value == "null")
			    	   			alert("Sản phẩm đã hết hàng");
			    	   		else
			    	   			alert("Bạn chưa chọn màu, size");
			    	   		
			    	   	}
			    }
			})
	});
	
	var tongtien = $(".tongTienMua").attr("data-tong");
	GanTongTien();
	
	function GanTongTien(){
		$(".tongTienMua").each(function(){
			var format = parseInt(tongtien).toLocaleString();
			$(".tongTienMua").html(format+"");
		});
	}
	
	/* định dạng tiền tệ */
	$(".HTGiaTien").each(function(){
			var tien = $(this).attr("data-Gia");
			var format = parseInt(tien).toLocaleString();
			$(this).html(format+" VNĐ");
	});
	
	/* định dạng tiền tệ giảm */
	$(".HTGiaTienGiam").each(function(){
			var tien = $(this).attr("data-Gia");
			var format = parseInt(tien).toLocaleString();
			$(this).html(format);
	});
	
	
	/* Tang so luong gio hang */
	$(".ThemSoLuong-GioHang").click(function(){
		var soluongCu = $(this).closest("tr").find(".soLuong-GioHang").val();
		var soluongMoi = parseInt(soluongCu) + 1 ;
		var ShowSL = $(this).closest("tr").find(".soLuong-GioHang");
		var giatien = $(this).closest("tr").find(".Tien").attr("data-money");
		var thanhtien = parseInt(soluongMoi*giatien);
		var ShowThanhTien = $(this).closest("tr").find(".thanhTien");
		
		
		var idSanPham = $(this).closest("tr").find(".nameSP").attr("data-idSP");
		var hinhAnh = $(this).closest("tr").find(".hinhAnhSP").attr("data-hinhAnh");
		var idSize = $(this).closest("tr").find(".maSize").attr("data-idSize");
			$.ajax({
			    url: "/QSport/Gio-Hang/ThemSLGioHang",
			    type: "GET",
			    data:{
			    	idSanPham : idSanPham,
			    	hinhAnh : hinhAnh,
			    	idSize : idSize  
				    },
			    success: function(value){
			    	if(value == "false"){
			    		alert("Số lượng sản phẩm chỉ còn " + soluongCu);
			    	}else{
			    		ShowSL.val(soluongMoi);
			    		ShowThanhTien.html(thanhtien);
			    		tongtien = parseInt(tongtien) + parseInt(giatien);
						GanTongTien();
			    	}
			    }
			})
		
	});
	
	/* Giam so luong gio hang */
	$(".GiamSoLuong-GioHang").click(function(){
		var soluongCu = $(this).closest("tr").find(".soLuong-GioHang").val();
		if( parseInt(soluongCu) >= 2){	
			var soluongCu = $(this).closest("tr").find(".soLuong-GioHang").val();
			var soluongMoi = parseInt(soluongCu) -1 ;
			$(this).closest("tr").find(".soLuong-GioHang").val(soluongMoi);
			var giatien = $(this).closest("tr").find(".Tien").attr("data-money");
			var thanhtien = parseInt(soluongMoi*giatien); 	
			$(this).closest("tr").find(".thanhTien").html(thanhtien);
			
			tongtien = parseInt(tongtien) - parseInt(giatien);
			GanTongTien();
			
			
			var idSanPham = $(this).closest("tr").find(".nameSP").attr("data-idSP");
			var hinhAnh = $(this).closest("tr").find(".hinhAnhSP").attr("data-hinhAnh");
			var idSize = $(this).closest("tr").find(".maSize").attr("data-idSize");
			$.ajax({
			    url: "/QSport/Gio-Hang/GiamSLGioHang",
			    type: "GET",
			    data:{
			    	idSanPham : idSanPham,
			    	hinhAnh : hinhAnh,
			    	idSize : idSize 
				    },
			    success: function(value){
			    }
			})
		}else{
			alert("Số lượng không nhỏ hơn 1");
			$(this).closest("tr").find(".soLuong-GioHang").val(soluongCu);
		}
	});
	
	
	/* Xoa san pham trong gio */
	$(".xoaGioHang").click(function(){
		var self = $(this);
		var idSanPham = $(this).closest("tr").find(".nameSP").attr("data-idSP");
		var hinhAnh = $(this).closest("tr").find(".hinhAnhSP").attr("data-hinhAnh");
		var idSize = $(this).closest("tr").find(".maSize").attr("data-idSize");
		
		$.ajax({
			    url: "/QSport/Gio-Hang/XoaGioHang",
			    type: "GET",
			    data:{
			    	idSanPham : idSanPham,
			    	hinhAnh : hinhAnh,
			    	idSize : idSize  
				    },
			    success: function(value){
			    	var tien =  self.closest("tr").find(".thanhTien").text();
			    	tongtien = parseInt(tongtien) - parseInt(tien);
			    	var format = parseInt(tongtien).toLocaleString();
					$(".tongTienMua").html(format+"");
			    	self.closest("tr").remove();
			    }
		})
	});
	
	
	/* ADMIN - Sua ảnh sản phẩm */
	var fileSua= [];
	$("#hinhAnhSua").change(function(event){
		fileSua = event.target.files;
		forms = new FormData();
		forms.append("file", fileSua[0]);
		$.ajax({
			    url: "/QSport/admin/San-Pham/UploadFile",
			    type: "POST",
			    data:forms,
			    contentType: false,
				processData : false,
				enctype : "multipart/form-data",
			    success: function(value){
			    	var srcNew = "http://localhost:8080/QSport/resources/images/products/"+value;
			    	$(".HASua").attr("Data-HA", value);
			    	$(".HASua").attr("src", srcNew);
			    }
		});
	});
	
	/* ADMIN - Sua san pham */
	$("#SuaSP").click(function(){
		var idSanPham = $("#tenSanPhamSua").attr("data-idSPSua");
		var tenSanPham = $("#tenSanPhamSua").val();
		var chatLieu = $("#ChatLieuSua").val();
		var kieuDang = $("#KieuDangSua").val();
		var mauSacGiay = $("#MauSacGiaySua").val();
		var chatLuong = $("#ChatLuongSua").val();
		var Gia =  $("#GiaTienSPSua").val();
		var idDanhMuc = $("#idDanhMucSua").val();
		var hinhAnh = $(".HASua").attr("Data-HA");
		$.ajax({
			    url: "/QSport/admin/San-Pham/SuaSanPham",
			    type: "GET",
			    data:{
			    		idSanPham : idSanPham,
			    		tenSanPham : tenSanPham,
						chatLieu : chatLieu,
						kieuDang : kieuDang,
						mauSacGiay : mauSacGiay,
						chatLuong : chatLuong,
						Gia : parseInt(Gia),
						idDanhMuc : idDanhMuc,
						hinhAnh : hinhAnh
				    },
			    success: function(value){
			    	alert("Sửa sản phẩm thành công!!");
			    }
		})
	});
	
	/* đặt hàng btn */
	$(".DatHang").click(function(){
    	var tenKhachHang = $("#tenKhachHang").val();
    	var sdt = $("#sdt").val();
    	var diaChi = $("#diaChi").val();
    	var ghiChu = $("#ghiChu").val();
    	var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
    	var hinhThucNhan = $("input[name='hinhThucNhan']:checked").val();
    	if(tenKhachHang !="" && sdt !="" && diaChi != "" && vnf_regex.test(sdt) != false){
    			$.ajax({
			    url: "/QSport/Gio-Hang/ThemHoaDon",
			    type: "GET",
			    data:{
			    	tenKhachHang : tenKhachHang,
			    	sdt : sdt,
			    	diaChi : diaChi,
			    	ghiChu :  ghiChu,
			    	hinhThucNhan : hinhThucNhan
				    },
			    success: function(value){
			    	var tbodyGH =  $("#table-GioHang").find("tbody");
			    	tbodyGH.empty();
			    	tongtien = 0;
					$(".tongTienMua").html(tongtien+"");
			    }
				});
    	}else
    		alert("Bạn hãy nhập đầy đủ và đúng thông tin trước khi đặt hàng!!")
    	
    });

	/* phân trang page ADM sản phẩm */
	$("body").on("click",".page-item",function(){
		$(".page-item").removeClass("active");
		$(this).addClass("active");
		var sotrang = $(this).text();
		var soBatDau = parseInt((sotrang - 1)*10) ;
		
		$.ajax({
			    url: "/QSport/admin/San-Pham/laySanPhamLimit",
			    type: "GET",
			    data:{
			    	soBatDau : soBatDau
				    },
			    success: function(value){
			    	var tbodySP =  $("#table-sanpham").find("tbody");
			    	tbodySP.empty();
			    	tbodySP.append(value);
			    }
		});
	})
	
	/* thêm ảnh - thêm sản phẩm */
	var files= [];
	$("#hinhAnh").change(function(event){
		files = event.target.files;
		forms = new FormData();
		forms.append("file", files[0]);
		$.ajax({
			    url: "/QSport/admin/San-Pham/UploadFile",
			    type: "POST",
			    data:forms,
			    contentType: false,
				processData : false,
				enctype : "multipart/form-data",
			    success: function(value){
			    	
			    }
		});
	});
	
	/* Thêm sản phẩm */
	$("#ThemSanPham").click(function(){
		var tenSanPham = $("#tenSanPham").val();
		var chatLieu = $("#ChatLieu").val();
		var kieuDang = $("#KieuDang").val();
		var mauSacGiay = $("#MauSacGiay").val();
		var chatLuong = $("#ChatLuong").val();
		var Gia =  $("#GiaTienSP").val();
		var idDanhMuc = $("#idDanhMuc").val();
		var idMau = $("#idMauSacSP").val();
		var idSize = $("#idSizeSP").val();
		var soLuong = $("#soLuongSP").val();
		if(tenSanPham == ""){
			alert("Tên sản phẩm không được để trống");
		}else{
			if(Gia == ""){
				alert("Giá tiền không được để trống");
			}else{
				$.ajax({
			    url: "/QSport/admin/San-Pham/ThemSanPham",
			    type: "GET",
			    data:{
			    		tenSanPham : tenSanPham,
						chatLieu : chatLieu,
						kieuDang : kieuDang,
						mauSacGiay : mauSacGiay,
						chatLuong : chatLuong,
						Gia : parseInt(Gia),
						idDanhMuc : idDanhMuc,
						idMau : idMau,
						idSize : idSize,
						soLuong : parseInt(soLuong)
				    },
			    success: function(value){
			    	alert("Thêm sản phẩm thành công!!");
			    }
		})
			}
		}
	});
	
	/* thêm danh mục*/
	$("#ThemDM").click(function(){
		var tenDM = $("#tenDanhMuc").val();
		if(tenDM != ""){
			$.ajax({
			    url: "/QSport/admin/Danh-Muc/themDanhMuc",
			    type: "GET",
			    data:{
			    	tenDM : tenDM
			    },
			    success: function(value){
			    	alert("Thêm danh mục thành công!!");
			    }
			});
		}else{
			alert("Tên danh mục không được để trống");
		}
	});
	
	/* sửa danh mục*/
	$(".txtSuaDM").change(function(){
		var idDanhMuc = $(this).closest("div").attr("data-idDM");
		var tenDanhMuc = $(this).val();
		if(tenDanhMuc!= ""){
			$.ajax({
			    url: "/QSport/admin/Danh-Muc/suaDanhMuc",
			    type: "GET",
			    data:{
			    	idDanhMuc : idDanhMuc,
			    	tenDanhMuc : tenDanhMuc
			    },
			    success: function(value){
			    	alert("Sửa danh mục thành công!!");
			    }
			});
		}else{
			alert("Tên danh mục không được để trống");
		}
  	});
	
	/* thêm màu */
	$("#ThemMau").click(function(){
		var tenMau = $("#tenMau").val();
		if(tenMau != ""){
			$.ajax({
			    url: "/QSport/admin/Danh-Muc/themMau",
			    type: "GET",
			    data:{
			    	tenMau : tenMau
			    },
			    success: function(value){
			    	alert("Thêm màu thành công!!");
			    }
			});
		}else{
			alert("Tên màu không được để trống");
		}
	});	
	
	/* sửa Màu*/
	$(".txtSuaMau").change(function(){
		var idMauSac = $(this).closest("div").attr("data-idMau");
		var tenMau = $(this).val();
		if(tenMau != ""){
			$.ajax({
			    url: "/QSport/admin/Danh-Muc/suaMau",
			    type: "GET",
			    data:{
			    	idMauSac : idMauSac,
			    	tenMau : tenMau
			    },
			    success: function(value){
			    	alert("Sửa tên màu thành công!!");
			    }
			});
		}else{
			alert("Tên màu không được để trống");
		}
  	});
	
	/* thêm size */
	$("#ThemSize").click(function(){
		var tenSize = $("#tenSizeThem").val();
		if(tenSize != ""){
			$.ajax({
			    url: "/QSport/admin/Danh-Muc/themSize",
			    type: "GET",
			    data:{
			    	tenSize : tenSize
			    },
			    success: function(value){
			    	alert("Thêm size thành công!!");
			    }
			});
		}else{
			alert("Tên size không được để trống");
		}
	});
	
	/* sửa Size*/
	$(".txtSuaSize").change(function(){
		var idSize = $(this).closest("div").attr("data-idSize");
		var tenSize = $(this).val();
		if(tenSize != ""){
			$.ajax({
			    url: "/QSport/admin/Danh-Muc/suaSize",
			    type: "GET",
			    data:{
			    	idSize : idSize,
			    	tenSize : tenSize
			    },
			    success: function(value){
			    	alert("Sửa Size thành công!!");
			    }
			});
		}else{
			alert("Tên size không được để trống");
		}
  	});
	
	/* sửa thong tin Qsport */
	$("#SuaQSport").click(function(){
		var sdt = $("#SDTQ").val();
		var email = $("#EmailQ").val();
		var diachi = $("#DiaChiQ").val();
		var mota = $("#MoTaQ").val();
		if(sdt == "" || email == "" || diachi == "" || mota ==""){
			alert("Không được để trống");
			
		}else{
				$.ajax({
			    url: "/QSport/admin/Qsport/Sua",
			    type: "GET",
			    data:{
			    	sdt : sdt,
			    	email : email,
			    	diachi : diachi,
			    	mota : mota
			    },
			    success: function(value){
			    	alert("Sửa thành công!!");
			    }
			});
		}
	});
	
	/* thêm tài khoản - ADM tài khoản*/
	$("#ThemTK").click(function(){
		var tenTK = $("#tenTK").val();
		var MK = $("#TaoMatKhau").val();
		var idCV = $("#idChucVu").val();
		if(tenTK == ""){
			alert("Tên tài khoản hông được bỏ trống");
		}else{
			if(MK == ""){
				alert("Mật khẩu hông được bỏ trống");
			}else{
				$.ajax({
				    url: "/QSport/admin/ThemTK",
				    type: "GET",
				    data:{
				    	tenTK : tenTK,
				    	MK : MK,
				    	idCV : parseInt(idCV)
				    },
				    success: function(value){
				    	if(value == "true"){
				    		alert("Thêm thành công!!");
				    	}else{
				    		alert("Tài khoản đã tồn tại!!");
				    	}
				    }
				});
		}
	}
	});
	
	/* thêm ảnh - chi tiết sản phẩm */
	var filesNew= [];
	$("#ThemHinhAnhCTSP").change(function(event){
		filesNew = event.target.files;
		forms = new FormData();
		forms.append("file", filesNew[0]);
		$.ajax({
			    url: "/QSport/admin/San-Pham/Chi-Tiet/UploadFile",
			    type: "POST",
			    data:forms,
			    contentType: false,
				processData : false,
				enctype : "multipart/form-data",
			    success: function(value){
			    	
			    }
		});
	});
	
	/* thêm chi tiết sản phẩm*/
	$("#ThemCTSP").click(function(){
		var idMau = $("#idMauSacSP").val();
		var idSize = $("#idSizeSPThem").val();
		var soLuong = $("#soLuongSPThem").val();
		var idSP = $(".thongTin").attr("data-idSP");
		
		$.ajax({
			    url: "/QSport/admin/San-Pham/Chi-Tiet/ThemCTSP",
			    type: "GET",
			    data:{
			    	idMau : idMau,
			    	idSize : idSize,
			    	soLuong : soLuong,
			    	idSP : idSP
			    },
			    success: function(value){
			    	alert("Thêm thành công!!");
			    }
		});
	});
	
	/* Sua so luong CTSP */
	$(".showSL").change(function(){
		var soLuong = $(this).val();
		var idCTSP = $(this).closest("tr").find(".CTSPidCTSP").attr("data-idCTSP");
		var vnf_regex = /(([1-9])+([0-9])\b)/g;
    	if(vnf_regex.test(soLuong) == false){
    		alert("Số lượng không thể là chữ cái");
    	}else{
    		$.ajax({
			    url: "/QSport/admin/San-Pham/Chi-Tiet/UpdateSL",
			    type: "GET",
			    data:{
			    	soLuong : soLuong,
			    	idCTSP : idCTSP,
			    },
			    success: function(value){
			    	
			    }
			});
			alert("Cập nhật số lượng thành công");
    	}
  	});
	
	/* Đăng xuất */
	$("#DangXuat").click(function(){
			$.ajax({
			    url: "/QSport/DangNhap/DangXuat",
			    type: "GET",
			    data:{ 
				    },
			    success: function(value){
			    		window.location.reload();
			    }
			})
	});
	
	$("#HTGH").click(function(){
		$("#showGH").show();
	});
	
	/* Tìm Kiếm hoá đơn */
	$("#TimKiemnHoaDon").click(function(){
		var sdt = $(".timKiemSDT").val();
		var tenTaiKhoan = $(".timKiemUser").val();
		
		var date = $('#NgayBD').val().split("-");
  		day = date[2];
  		month = date[1];
  		year = date[0];
  		NgayBD = day+"-"+month+"-"+year;

		
		var date2 = $('#NgayKT').val().split("-");
  		day2 = date2[2];
  		month2 = date2[1];
  		year2 = date2[0];
  		NgayKT = day2+"-"+month2+"-"+year2;
		
		$.ajax({
			    url: "/QSport/admin/Hoa-Don/TimKiem",
			    type: "GET",
			    data:{ 
			    		tenTaiKhoan : tenTaiKhoan,
			    		sdt : sdt,
			    		NgayBD : NgayBD,
			    		NgayKT : NgayKT,
				    },
			    success: function(value){
			    	var tbodySP =  $("#table-hoadon").find("tbody");
			    	tbodySP.empty();
			    	tbodySP.append(value);
			    }
			})
	});
	
	/* Tìm Kiếm hoá đơn theo ngày */
	$("#TimKiemnHoaDonDate").click(function(){	
		var date = $('#NgayBD').val().split("-");
  		day = date[2];
  		month = date[1];
  		year = date[0];
  		NgayBD = day+"-"+month+"-"+year;

		var date2 = $('#NgayKT').val().split("-");
  		day2 = date2[2];
  		month2 = date2[1];
  		year2 = date2[0];
  		NgayKT = day2+"-"+month2+"-"+year2;
		
		$.ajax({
			    url: "/QSport/admin/Hoa-Don/TimKiemDate",
			    type: "GET",
			    data:{
			    		NgayBD : NgayBD,
			    		NgayKT : NgayKT,
				    },
			    success: function(value){
			    	var tbodySP =  $("#table-hoadon").find("tbody");
			    	tbodySP.empty();
			    	tbodySP.append(value);
			    }
			})
	});
	$(".checkTinhTrang").change(function(){
		var TinhTrang = "";
		var idHoaDon = $(this).closest("tr").find(".idHoaDon").attr("data-idHD");
		if (this.checked) {
        	TinhTrang = "true";
   		}else{
   			TinhTrang = "false";
   		}
   		$.ajax({
			    url: "/QSport/admin/Hoa-Don/UpdateTinhTrang",
			    type: "GET",
			    data:{
			    		idHoaDon : idHoaDon,
			    		TinhTrang : TinhTrang,
				    },
			    success: function(value){
			    	
			    }
		})
	})
	
	/*Cap nhat thong tin user*/
	$("#updateUser").click(function(){
		var hoTen = $("#HoTenUser").val();
		var GioiTinh = $("#GioiTinh").val();;
		var sdt = $("#SDTUser").val();
		var email = $("#EmailUser").val();;
		var diachi = $("#DiaChiUser").val();
		var matkhau = $("#MatKhauUser").val();
		if(matkhau==""){
			alert("Mật khẩu không được để trống!!")
		}else{
			$.ajax({
			    url: "/QSport/User/Update",
			    type: "GET",
			    data:{
			    		hoTen : hoTen,
			    		GioiTinh : GioiTinh,
			    		sdt : sdt,
			    		email : email,
			    		diachi : diachi,
			    		matkhau : matkhau,
				    },
			    success: function(value){
			    	alert("Cập nhật thành công!!")
			    }
			});
		}
		
	});
	
	$("#ThemGG").click(function(){
		var tenGG = $("#tenGiamGia").val();
		
		var date = $('#NgayBDGG').val().split("-");
  		day = date[2];
  		month = date[1];
  		year = date[0];
  		NgayBD = day+"-"+month+"-"+year;

		var date2 = $('#NgayKTGG').val().split("-");
  		day2 = date2[2];
  		month2 = date2[1];
  		year2 = date2[0];
  		NgayKT = day2+"-"+month2+"-"+year2;
  		
  		var soTien = $("#SoTienGiam").val();
  		if(tenGG==""){
  			alert("Tên không được bỏ trống!!")
  		}else{
  			if(soTien==""){
  				alert("Số tiền giảm không được bỏ trống!!")
  			}else{
  				$.ajax({
			    url: "/QSport//admin/Khuyen-Mai/them",
			    type: "GET",
			    data:{
			    		tenGG : tenGG,
			    		NgayBD : NgayBD,
			    		NgayKT : NgayKT,
			    		soTien : soTien,
				    },
			    success: function(value){
			    	alert("Thêm thành công!!")
			    }
			});
  			}
  		}		
	});
	
	$("#ThemSPGG").click(function(){
		var idGiamGia = $(".idGG").attr("data-idGG");
		var idsp = $("#idSPGG").val();
		$.ajax({
			    url: "/QSport/admin/Khuyen-Mai/themsp",
			    type: "GET",
			    data:{
			    		idGiamGia : idGiamGia,
			    		idsp : idsp,
				    },
			    success: function(value){
			    	alert("Thêm thành công!!")
			    }
			});
	});
	
	$("#SuaGG").click(function(){
		var idGiamGia = $(".idGG").attr("data-idGG");
		var tenGiamGia = $("#tenGiamGiaSua").val();
		var soTienGiam = $("#SoTienGiamSua").val();
		
		var date = $('#NgayBDGGSua').val().split("-");
  		day = date[2];
  		month = date[1];
  		year = date[0];
  		var thoiGianBD = day+"-"+month+"-"+year;

		var date2 = $('#NgayKTGGSua').val().split("-");
  		day2 = date2[2];
  		month2 = date2[1];
  		year2 = date2[0];
  		var thoiGianKT = day2+"-"+month2+"-"+year2;
		$.ajax({
			    url: "/QSport/admin/Khuyen-Mai/update",
			    type: "GET",
			    data:{
			    		idGiamGia : idGiamGia,
			    		tenGiamGia : tenGiamGia,
			    		soTienGiam : soTienGiam,
			    		thoiGianBD : thoiGianBD,
			    		thoiGianKT : thoiGianKT
				    },
			    success: function(value){
			    	alert("Sửa thành công!!")
			    }
			});
	});
	/* phân trang page sản phẩm */
	$("body").on("click",".page-item",function(){
		$(".page-item").removeClass("active");
		$(this).addClass("active");
		var sotrang = $(this).text();
		var soBatDau = parseInt((sotrang - 1)*10) ;
		
		$.ajax({
			    url: "/QSport/San-Pham/laySanPhamLimit",
			    type: "GET",
			    data:{
			    	soBatDau : soBatDau
				    },
			    success: function(value){
			    	var tbodySP =  $("#sanphamall");
			    	tbodySP.empty();
			    	tbodySP.append(value);
			    }
		});
	});
	
	$('.trangThaiTK').change(function() {
		var idTaiKhoan = $(this).closest("tr").find(".idUser").attr("data-id");
     	var trangthai = $(this).val();
     	$.ajax({
			    url: "/QSport/User/updateTrangThai",
			    type: "GET",
			    data:{
			    	idTaiKhoan : idTaiKhoan,
			    	trangthai : trangthai,
				    },
			    success: function(value){
			    	alert("Cập nhật thành công!!");
			    }
		});
     	
	});
	
	$(".XoaGG").click(function(){
		var idGiamGia = $(".idGG").attr("data-idGG");
		var idSanPham = $(this).closest("tr").find(".idspgg").attr("data-id");
		var tr =  $(this);
		$.ajax({
			    url: "/QSport/admin/Khuyen-Mai/xoasp",
			    type: "GET",
			    data:{
			    		idGiamGia : idGiamGia,
			    		idSanPham : idSanPham,
				    },
			    success: function(value){
			    	tr.closest("tr").remove();
			    }
			});
	})
	
})(jQuery);