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
import org.springframework.web.bind.annotation.SessionAttributes;

import Entity.GiamGia;
import Entity.GioHang;
import Entity.SanPham;
import Services.ChiTietSPSer;
import Services.GiamGiaSer;
import Services.QSportSer;
import Services.SanPhamSer;
import Services.SizeSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/Chi-Tiet")
@SessionAttributes("GioHang")
public class chiTietController {
	
	@Autowired
	SanPhamSer sanPhamSer;
	
	@Autowired
	ChiTietSPSer chiTietSPSer;
	@Autowired
	GiamGiaSer giamGiaSer;
	@Autowired
	SizeSer sizeSer;
	@Autowired
	QSportSer qSportSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	
	@GetMapping("/{idSanPham}")
	public String Default(@PathVariable int idSanPham, ModelMap mdMap,HttpSession httpSession) {
		/* Show ten tai khoan */
		if(httpSession.getAttribute("TaiKhoan") != null) {
			String tenHT =(String) httpSession.getAttribute("TaiKhoan");
			int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
			mdMap.addAttribute("Quyen", taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen());
			mdMap.addAttribute("tenHT", tenHT);
		}
		
		/* show thong tin QSport*/
		mdMap.addAttribute("QSport",qSportSer.showQSport());
		
		/* Lay chi tiet san pham*/
		SanPham sanPham = sanPhamSer.LayChiTietSP(idSanPham);
		mdMap.addAttribute("SanPham", sanPham);
		mdMap.addAttribute("lstMau" , chiTietSPSer.DsMau(idSanPham));
		mdMap.addAttribute("lstSize", sizeSer.lstSize());
		
		
		/* Show San Pham ban chay */
		List<SanPham> lstSanPhambc = sanPhamSer.showSanPhamBanChay();
		mdMap.addAttribute("lstSPBC",lstSanPhambc);
		
		
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
		
		return "chitiet";
	}
	
}
