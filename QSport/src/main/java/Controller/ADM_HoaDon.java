package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
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

import Entity.ChiTietHoaDon;
import Entity.ChiTietSanPham;
import Entity.HoaDon;
import Services.ChiTietHDSer;
import Services.ChiTietSPSer;
import Services.HoaDonSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/admin/Hoa-Don")
public class ADM_HoaDon {
	
	@Autowired
	HoaDonSer hoaDonSer;
	
	@GetMapping
	String Default(ModelMap mdMap, HttpSession httpSession) {
		if(httpSession.getAttribute("TaiKhoan") == null) {
			return "error";
		}
		String tenHT =(String) httpSession.getAttribute("TaiKhoan");
		mdMap.addAttribute("tenHT", tenHT);
		int idTK =  (Integer) httpSession.getAttribute("idTaiKhoan");
		if(!taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen().equals("Quản trị")) {
			return "error";
		}
		mdMap.addAttribute("lstHD", hoaDonSer.lstHoaDon());
		return "ADM_HoaDon";
	}
	
	@GetMapping(path="/TimKiem" , produces = "text/plain; charset=utf-8")
	@ResponseBody
	String TimKiem(@RequestParam String sdt, @RequestParam String tenTaiKhoan, @RequestParam String NgayBD, @RequestParam String NgayKT) {	
		
		String html = "";
		if(tenTaiKhoan.equals("")) {
			html+= TimKiemTheoSDT(sdt);
		}else {
			if(sdt.equals("")) {
				html+=TimKiemTheoTenTaiKhoan(tenTaiKhoan);
			}
		}
		return html;
	}
	@GetMapping(path="/TimKiemDate" , produces = "text/plain; charset=utf-8")
	@ResponseBody
	String TimKiemDate(@RequestParam String NgayBD, @RequestParam String NgayKT) {	
		
		String html = "";
		html+=TimKiemTheoNgayDat(NgayBD, NgayKT);
		return html;
	}
	String TimKiemTheoSDT(String sdt) {
		List<HoaDon> lstHDSDT = hoaDonSer.TimKiemTheoSDT(sdt);
		String html = "";
		for (HoaDon hoaDon : lstHDSDT) {
			html+= "<tr>";
			html+="<th  style='vertical-align: middle;' scope='row' '> "+ hoaDon.getTaiKhoan().getTenTaiKhoan() +"</th>" + 
					"<td> <a href='http://localhost:8080/QSport/admin/Hoa-Don/CTHD/"+hoaDon.getIdHoaDon()+"'>"+ hoaDon.getTenKhachHang() +"</a></td>\r\n" + 
					"<td>"+ hoaDon.getSdt() +"</td>\r\n" + 
					"<td>"+ hoaDon.getDiaChi() +"</td>\r\n" + 
					"<td>"+ hoaDon.getNgayLap()+"</td>\r\n" + 
					"<td> "+hoaDon.getHinhThucNhan()+"</td>\r\n" + 
					"<td>";
					if(hoaDon.getTinhTrang()==true) {
						html+="<input style='margin-left: 20px;' type='checkbox' class='form-check-input' value='' checked='checked'>\r\n";
					}
					else {
						html+= "<input style='margin-left: 20px;' type='checkbox' class='form-check-input' value='' >\r\n";
					}
			html+= "</td>\r\n" + 
			       "<td>" + hoaDon.getGhiChu()+"</td>";
			html+= "<tr>";
		}
		
		return html;
	}
	
	@Autowired
	TaiKhoanSer taiKhoanSer;
	String TimKiemTheoTenTaiKhoan(String tenTaiKhoan) {
		int idTaiKhoan = taiKhoanSer.ShowTaiKhoanUser(tenTaiKhoan);
		List<HoaDon> lstHDSDT = hoaDonSer.TimKiemTheoUser(idTaiKhoan);
		String html = "";
		for (HoaDon hoaDon : lstHDSDT) {
			html+= "<tr>";
			html+="<th  style='vertical-align: middle;' scope='row' '> "+ hoaDon.getTaiKhoan().getTenTaiKhoan() +" </th>" + 
					"<td> <a href='http://localhost:8080/QSport/admin/Hoa-Don/CTHD/"+hoaDon.getIdHoaDon()+"'>"+ hoaDon.getTenKhachHang() +"</a></td>\r\n" + 
					"<td>"+ hoaDon.getSdt() +"</td>\r\n" + 
					"<td>"+ hoaDon.getDiaChi() +"</td>\r\n" + 
					"<td>"+ hoaDon.getNgayLap()+"</td>\r\n" + 
					"<td> "+hoaDon.getHinhThucNhan()+"</td>\r\n" + 
					"<td>";
					if(hoaDon.getTinhTrang()==true) {
						html+="<input style='margin-left: 20px;' type='checkbox' class='form-check-input' value='' checked='checked'>\r\n";
					}
					else {
						html+= "<input style='margin-left: 20px;' type='checkbox' class='form-check-input' value='' >\r\n";
					}
			html+= "</td>\r\n" + 
			       "<td>" + hoaDon.getGhiChu()+"</td>";
			html+= "<tr>";
		}
		
		return html;
	}
	String TimKiemTheoNgayDat(String NgayBD, String NgayKT) {
		List<HoaDon> lstHDSDT = hoaDonSer.lstHoaDon();
		String html = "";
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" ).withResolverStyle(ResolverStyle.LENIENT);
		LocalDate start = LocalDate.parse( NgayBD , f );
		LocalDate stop = LocalDate.parse( NgayKT , f );
		for (HoaDon hoaDon : lstHDSDT) {
			LocalDate today = LocalDate.parse( hoaDon.getNgayLap() , f );
			if(( today.isBefore( stop ) ) && today.isAfter(start)){
				html+= "<tr>";
				html+="<th  style='vertical-align: middle;' scope='row' '>"+ hoaDon.getTaiKhoan().getTenTaiKhoan() +"</th>" + 
						"<td> <a href='http://localhost:8080/QSport/admin/Hoa-Don/CTHD/"+hoaDon.getIdHoaDon()+"'>"+ hoaDon.getTenKhachHang() +"</a></td>\r\n" + 
						"<td>"+ hoaDon.getSdt() +"</td>\r\n" + 
						"<td>"+ hoaDon.getDiaChi() +"</td>\r\n" + 
						"<td>"+ hoaDon.getNgayLap()+"</td>\r\n" + 
						"<td> "+hoaDon.getHinhThucNhan()+"</td>\r\n" + 
						"<td>";
						if(hoaDon.getTinhTrang()==true) {
							html+="<input style='margin-left:20px;' type='checkbox' class='form-check-input' value='' checked='checked'>\r\n";
						}
						else {
							html+= "<input style='margin-left: 20px;' type='checkbox' class='form-check-input' value='' >\r\n";
						}
				html+= "</td>" + 
				       "<td>" + hoaDon.getGhiChu()+"</td>";
				html+= "<tr>";
			}
			
		}
		
		return html;
	}
	
	
	@Autowired
	ChiTietHDSer chiTietHoaDonSer;
	@Autowired
	ChiTietSPSer chiTietSPSer;
	
	@GetMapping("/CTHD/{idHoaDon}")
	String CTHoaDon(@PathVariable int idHoaDon, ModelMap mdMap) {
		List<ChiTietHoaDon> lstcthd = chiTietHoaDonSer.lstCTHD(idHoaDon);
		mdMap.addAttribute("HoaDon", hoaDonSer.showHD(idHoaDon));
		List<ChiTietSanPham> lstCT = new ArrayList<ChiTietSanPham>();
		
		for (ChiTietHoaDon cthd : lstcthd) {
			ChiTietSanPham ctsp = chiTietSPSer.showCTSP(cthd.getChiTietHoaDonId().getIdChiTietSanPham());
			lstCT.add(ctsp);
		}
		mdMap.addAttribute("lstCTHD", lstcthd);
		mdMap.addAttribute("lstCTSP", lstCT);
		return "ADM_CTHoaDon";
	}
	
	@GetMapping("/UpdateTinhTrang")
	@ResponseBody
	String UpdateTinhTtrang(@RequestParam int idHoaDon, @RequestParam Boolean TinhTrang) {	
		hoaDonSer.updateHD(idHoaDon, TinhTrang);
		return "";
	}
}
