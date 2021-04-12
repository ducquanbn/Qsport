package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import DAO.PhanQuyenDao;
import Services.PhanQuyenSer;
import Services.TaiKhoanSer;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	TaiKhoanSer taiKhoanSer;
	
	@Autowired
	PhanQuyenSer phanQuyenSer;
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap mdMap) {
		if(httpSession.getAttribute("TaiKhoan") == null) {
			return "error";
		}
		String tenHT =(String) httpSession.getAttribute("TaiKhoan");
		mdMap.addAttribute("tenHT", tenHT);
		int idTK =  (Integer) httpSession.getAttribute("idTaiKhoan");
		if(!taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen().equals("Quản trị")) {
			return "error";
		}
		
		mdMap.addAttribute("lstPQ", phanQuyenSer.lstPQ());
		mdMap.addAttribute("lstTK", taiKhoanSer.lstTK());
		return "admin";
	}
	
	@GetMapping("/ThemTK")
	@ResponseBody
	String ThemTaiKhoan(@RequestParam String tenTK, @RequestParam String MK, @RequestParam int idCV) {
		if(taiKhoanSer.KiemTraDangKy(tenTK, MK, idCV)) {
			return "true";
		}
		return "";
	}
	
	
	
}
