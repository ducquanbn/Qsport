package Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Entity.DanhMuc;
import Entity.GiamGia;
import Entity.GioHang;
import Entity.SanPham;
import Services.DanhMucSer;
import Services.GiamGiaSer;
import Services.QSportSer;
import Services.SanPhamSer;
import Services.TaiKhoanSer;
import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
@RequestMapping("/San-Pham")
public class SanPhamController {
	@Autowired
	GiamGiaSer giamGiaSer; 
	@Autowired
	DanhMucSer danhMucSer;
	@Autowired
	SanPhamSer sanPhamSer;
	@Autowired
	QSportSer qSportSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@GetMapping
	public String Default(ModelMap mdMap, HttpSession httpSession) {
		/* Show ten tai khoan */
		if(httpSession.getAttribute("TaiKhoan") != null) {
			String tenHT =(String) httpSession.getAttribute("TaiKhoan");
			int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
			mdMap.addAttribute("Quyen", taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen());
			mdMap.addAttribute("tenHT", tenHT);
		}
		
		/* show thong tin QSport*/
		mdMap.addAttribute("QSport",qSportSer.showQSport());
		
		/* So luong trong gio hang */
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			mdMap.addAttribute("soLuongTrongGio", lstGioHangs.size());
			mdMap.addAttribute("lstGioHang", lstGioHangs);
		}else {
			mdMap.addAttribute("soLuongTrongGio", 0);
		}
		
		/* show GiamGia*/
		GiamGia giamGia = new GiamGia();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateNow = new Date();
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" ).withResolverStyle(ResolverStyle.LENIENT);
		LocalDate today = LocalDate.parse( formatter.format(dateNow) , f );
		List<GiamGia> lstGiamGiaCheck = giamGiaSer.lstGiamGia();
		
		for (GiamGia gg : lstGiamGiaCheck) {
			LocalDate start = LocalDate.parse( gg.getThoiGianBD() , f );
			LocalDate stop = LocalDate.parse( gg.getThoiGianKT() , f );
			if(today.isBefore( stop ) && today.isAfter(start)){
				giamGia = gg;
			}
		}
		mdMap.addAttribute("GG", giamGia);
		for (SanPham sp : giamGia.getListSanPham()) {	
		}
		mdMap.addAttribute("lstDM", danhMucSer.ShowDanhMuc());
		
		/* Show San Pham */
		List<SanPham> lstSanPhams = sanPhamSer.showSanPhamLimt(0);
		mdMap.addAttribute("lstSP",lstSanPhams);
		
		
		List<SanPham> lstAllSanPhams = sanPhamSer.showSanPham();
		mdMap.addAttribute("lstSPAll",lstAllSanPhams);
		double tongSoPage = Math.ceil(((double) lstAllSanPhams.size()/10 ));
		mdMap.addAttribute("tongSoPage", tongSoPage);
		return "San-Pham";
	}

	@GetMapping(path="/laySanPhamLimit" , produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String laySanPhamLimit(@RequestParam int soBatDau, ModelMap mdMap, HttpSession httpSession) {
		/* Show ten tai khoan */
		if(httpSession.getAttribute("TaiKhoan") != null) {
			String tenHT =(String) httpSession.getAttribute("TaiKhoan");
			int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
			mdMap.addAttribute("Quyen", taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen());
			mdMap.addAttribute("tenHT", tenHT);
		}
		
		/* show GiamGia*/
		GiamGia giamGia = new GiamGia();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateNow = new Date();
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" ).withResolverStyle(ResolverStyle.LENIENT);
		LocalDate today = LocalDate.parse( formatter.format(dateNow) , f );
		List<GiamGia> lstGiamGiaCheck = giamGiaSer.lstGiamGia();
		
		for (GiamGia gg : lstGiamGiaCheck) {
			LocalDate start = LocalDate.parse( gg.getThoiGianBD() , f );
			LocalDate stop = LocalDate.parse( gg.getThoiGianKT() , f );
			if(today.isBefore( stop ) && today.isAfter(start)){
				giamGia = gg;
			}
		}
		for (SanPham sp : giamGia.getListSanPham()) {	
		}
		List<SanPham> lstSPLimit = sanPhamSer.showSanPhamLimt(soBatDau);
		String html="";
		for (SanPham sanpham : lstSPLimit) {
			html+= 	"	            	<div class='col-lg-3 col-6 dssp dm"+sanpham.getDanhMuc().getIdDanhMuc()+"'>" + 
					"	            	<a style='text-decoration: none' href='http://localhost:8080/QSport/Chi-Tiet/"+sanpham.getIdSanPham()+"''>" + 
					"					<div class='card wow bounceIn'>" + 
					"					  <img class='card-img-top' src='http://localhost:8080/QSport/resources/images/products/"+sanpham.getHinhAnh()+"' alt='"+sanpham.getTenSanPham()+"'>" + 
					"					  	\r\n" + 
					"					  <div class='card-body'>" + 
					"					    <h5 align='center'>"+ sanpham.getTenSanPham()+" </h5>";	
		String test= "true";
		if(test=="true") {
			for (SanPham sanPham2 : giamGia.getListSanPham()) {
				if(sanpham.getIdSanPham()==sanPham2.getIdSanPham()) {
					int tien = sanpham.getGia() - giamGia.getSoTienGiam();
					html+=	"<span> <del class='HTGiaTienGiam' data-Gia='"+sanpham.getGia()+"' style='font-size: 15px; color: black;' >"+ sanpham.getGia() +"</del> <b align='center' data-Gia='"+tien+"' class='HTGiaTien card-text'>"+tien+" </b> </span>";
					test= "false";
				}
			}
		}
		if(test=="true") {
			html+= 	"<p align='center' data-Gia='"+sanpham.getGia()+"' class='HTGiaTien card-text'>"+sanpham.getGia()+"</p>\r\n" ;

		}
			html+=  "					  </div>" + 
					"					</div>" + 
					"					</a>" + 
					"					</div>" + 
					"					</div>";
		}
		return html;
	}
	
	@GetMapping("/Tim-Kiem")
	public String TimKiem(@RequestParam("TenSanPham") String tenSanPham,ModelMap mdMap, HttpSession httpSession) {
		/* Show ten tai khoan */
		if(httpSession.getAttribute("TaiKhoan") != null) {
			String tenHT =(String) httpSession.getAttribute("TaiKhoan");
			int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
			mdMap.addAttribute("Quyen", taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen());
			mdMap.addAttribute("tenHT", tenHT);
		}
		
		/* show thong tin QSport*/
		mdMap.addAttribute("QSport",qSportSer.showQSport());
		
		/* So luong trong gio hang */
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			mdMap.addAttribute("soLuongTrongGio", lstGioHangs.size());
			mdMap.addAttribute("lstGioHang", lstGioHangs);
		}else {
			mdMap.addAttribute("soLuongTrongGio", 0);
		}
		
		mdMap.addAttribute("lstSP", sanPhamSer.TimKiem(tenSanPham));
		
		mdMap.addAttribute("lstDM", danhMucSer.ShowDanhMuc());
		return "San-Pham";
	}
	
	@GetMapping("/Giam-Gia")
	public String GiamGia( ModelMap mdMap, HttpSession httpSession ) {
		/* Show ten tai khoan */
		if(httpSession.getAttribute("TaiKhoan") != null) {
			String tenHT =(String) httpSession.getAttribute("TaiKhoan");
			int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
			mdMap.addAttribute("Quyen", taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen());
			mdMap.addAttribute("tenHT", tenHT);
		}
		/* show thong tin QSport*/
		mdMap.addAttribute("QSport",qSportSer.showQSport());
		
		/* So luong trong gio hang */
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			mdMap.addAttribute("soLuongTrongGio", lstGioHangs.size());
			mdMap.addAttribute("lstGioHang", lstGioHangs);
		}else {
			mdMap.addAttribute("soLuongTrongGio", 0);
		}
		/* show DanhMuc*/
		mdMap.addAttribute("lstDM",danhMucSer.ShowDanhMuc());
		
		/* show GiamGia*/
		GiamGia giamGia = new GiamGia();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateNow = new Date();
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" ).withResolverStyle(ResolverStyle.LENIENT);
		LocalDate today = LocalDate.parse( formatter.format(dateNow) , f );
		List<GiamGia> lstGiamGiaCheck = giamGiaSer.lstGiamGia();
		
		for (GiamGia gg : lstGiamGiaCheck) {
			LocalDate start = LocalDate.parse( gg.getThoiGianBD() , f );
			LocalDate stop = LocalDate.parse( gg.getThoiGianKT() , f );
			if(today.isBefore( stop ) && today.isAfter(start)){
				giamGia = gg;
			}
		}
		mdMap.addAttribute("GG", giamGia);
		for (SanPham sp : giamGia.getListSanPham()) {
			
		}
		return "San-Pham-GG";
	}
}
