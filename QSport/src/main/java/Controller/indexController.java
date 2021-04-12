package Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.GiamGia;
import Entity.GioHang;
import Entity.SanPham;
import Entity.TaiKhoan;
import Services.DanhMucSer;
import Services.GiamGiaSer;
import Services.QSportSer;
import Services.SanPhamSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/")
public class indexController {
	
	@Autowired
	SanPhamSer sanPhamSer;
	
	@Autowired
	DanhMucSer danhMucSer;
	
	@Autowired
	QSportSer qSportSer;
	
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@Autowired
	GiamGiaSer giamGiaSer;
	@GetMapping
	@Transactional
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
		
		/* So luong trong gio hang */
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			mdMap.addAttribute("soLuongTrongGio", lstGioHangs.size());
			mdMap.addAttribute("lstGioHang", lstGioHangs);
		}else {
			mdMap.addAttribute("soLuongTrongGio", 0);
		}
		
		/* Show San Pham */
		List<SanPham> lstSanPhams = sanPhamSer.showSanPhamIndex();
		mdMap.addAttribute("lstSP",lstSanPhams);
		
		return "index";
		
	}
}
