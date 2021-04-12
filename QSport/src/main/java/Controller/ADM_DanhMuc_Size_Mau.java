package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Entity.DanhMuc;
import Entity.MauSac;
import Entity.Size;
import Services.DanhMucSer;
import Services.MauSacSer;
import Services.SizeSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/admin/Danh-Muc")
public class ADM_DanhMuc_Size_Mau {
	
	@Autowired
	DanhMucSer danhMucSer;
	@Autowired
	MauSacSer mauSacSer;
	@Autowired
	SizeSer sizeSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@GetMapping
	String Default(HttpSession httpSession,ModelMap mdMap) {
		if(httpSession.getAttribute("TaiKhoan") == null) {
			return "error";
		}
		String tenHT =(String) httpSession.getAttribute("TaiKhoan");
		mdMap.addAttribute("tenHT", tenHT);
		int idTK =  (Integer) httpSession.getAttribute("idTaiKhoan");
		if(!taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen().equals("Quản trị")) {
			return "error";
		}
		mdMap.addAttribute("lstSize", sizeSer.lstSize());
		mdMap.addAttribute("lstMau", mauSacSer.showDSMau());
		mdMap.addAttribute("lstDM", danhMucSer.ShowDanhMuc());
		return "ADM_DanhMuc";
	}
	
	@GetMapping("/themDanhMuc")
	@ResponseBody
	public String themDanhMuc(@RequestParam String tenDM) {		
		DanhMuc dm = new DanhMuc();
		dm.setTenDanhMuc(tenDM);
		danhMucSer.themDanhMuc(dm);
		return "";
	}
	
	@GetMapping("/themMau")
	@ResponseBody
	public String ThemMau(@RequestParam String tenMau) {		
		MauSac mau =  new MauSac();
		mau.setTenMau(tenMau);
		mauSacSer.themMau(mau);
		return "";
	}
	
	@GetMapping("/themSize")
	@ResponseBody
	public String ThemSize(@RequestParam String tenSize) {		
		Size size= new Size();
		size.setTenSize(tenSize);
		sizeSer.themSize(size);
		return " ";
	}
	
	@GetMapping("/suaDanhMuc")
	@ResponseBody
	public String SuaDanhMuc(@RequestParam int idDanhMuc, @RequestParam String tenDanhMuc) {		
		danhMucSer.updateDanhMuc(idDanhMuc, tenDanhMuc);
		return "";
	}
	
	@GetMapping("/suaMau")
	@ResponseBody
	public String SuaMau(@RequestParam int idMauSac, @RequestParam String tenMau) {		
		mauSacSer.updateMau(idMauSac, tenMau);
		return "";
	}
	
	@GetMapping("/suaSize")
	@ResponseBody
	public String SuaSize(@RequestParam int idSize, @RequestParam String tenSize) {		
		sizeSer.updateSize(idSize, tenSize);
		return "";
	}
}
