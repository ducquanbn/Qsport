package Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Entity.GioHang;
import Entity.TaiKhoan;
import Services.DanhMucSer;
import Services.QSportSer;
import Services.SanPhamSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/User")
public class TaiKhoanComtroller {
	
	@Autowired
	SanPhamSer sanPhamSer;
	
	@Autowired
	DanhMucSer danhMucSer;
	
	@Autowired
	QSportSer qSportSer;
	
	@Autowired
	TaiKhoanSer taiKhoanSer;
	
	@GetMapping
	public String Default(ModelMap mdMap,  HttpSession httpSession) {
		/* Show ten tai khoan */
		if(httpSession.getAttribute("TaiKhoan") != null) {
			String tenHT =(String) httpSession.getAttribute("TaiKhoan");
			int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
			mdMap.addAttribute("user",taiKhoanSer.ShowTaiKhoan(idTK));
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
		
		return "user";
	}
	

	@GetMapping("/Update")
	@ResponseBody
	String update(HttpSession httpSession, @RequestParam String hoTen, @RequestParam String GioiTinh,@RequestParam String sdt, @RequestParam String diachi, @RequestParam String email, @RequestParam String matkhau){
		int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
		TaiKhoan tk = new TaiKhoan();
		tk.setHoTen(hoTen);
		tk.setGioiTinh(GioiTinh);
		tk.setSdt(sdt);
		tk.setEmail(email);
		tk.setDiaChi(diachi);
		tk.setMatKhau(matkhau);
		
		taiKhoanSer.update(tk, idTK);
		return "";
	}
	@GetMapping("/updateTrangThai")
	@ResponseBody
	String updateTrangThai(@RequestParam int idTaiKhoan, @RequestParam String trangthai) {
		taiKhoanSer.updateTrangThai(idTaiKhoan, trangthai);
		return "";
	}
}
