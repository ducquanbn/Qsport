package Controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Entity.GioHang;
import Entity.TaiKhoan;
import Services.QSportSer;
import Services.TaiKhoanSer;



@Controller
@RequestMapping("/DangNhap")
@SessionAttributes({"TaiKhoan","idTaiKhoan"})
public class DangNhapController {

	@Autowired
	QSportSer qSportSer;
	
	@Autowired
	TaiKhoanSer taiKhoanSer;
	
	
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap mdMap) {
		/* So luong trong gio hang */
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			mdMap.addAttribute("soLuongTrongGio", lstGioHangs.size());
			mdMap.addAttribute("lstGioHang", lstGioHangs);
		}else {
			mdMap.addAttribute("soLuongTrongGio", 0);
		}
		
		/* Kiem tra xem dang nhap chua, dang nhap roi thi khong cho truy cap*/
		mdMap.addAttribute("QSport",qSportSer.showQSport());
		if(httpSession.getAttribute("TaiKhoan") != null) {
			return "error";
		}
		
		return "login";
	}
	@GetMapping("/kiemTraDangNhap")
	@ResponseBody
	public String kiemTraDangNhap(@RequestParam String user,@RequestParam String pass, ModelMap mdMap) {		
		if(taiKhoanSer.KiemTraDangNhap(user, pass) > 0) {
			if(taiKhoanSer.checkTrangThai(user)) {
				mdMap.addAttribute("TaiKhoan", user);
				mdMap.addAttribute("idTaiKhoan", taiKhoanSer.KiemTraDangNhap(user, pass));
				return "true";
			}else {
				return "khoa";
			}
		}
		return "false";
	}
	
	@GetMapping("/kiemTraDangKy")
	@ResponseBody
	public String kiemTraDangKy(@RequestParam String userReg,@RequestParam String passReg, @RequestParam String passRegA) {
		return taiKhoanSer.KiemTraDangKy(userReg, passReg,2)+"";
	}
	
	@GetMapping("DangXuat")
	@ResponseBody
	public String DangXuat(HttpSession httpSession) {
		httpSession.invalidate();
		return "";
	}
}
