package Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Entity.GiamGia;
import Entity.SanPham;
import Services.GiamGiaSer;
import Services.SanPhamSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/admin/Khuyen-Mai")
public class ADM_KhuyenMai {

	@Autowired
	GiamGiaSer giamGiaSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@GetMapping
	String Default ( ModelMap mdMap,HttpSession httpSession) {
		if(httpSession.getAttribute("TaiKhoan") == null) {
			return "error";
		}
		String tenHT =(String) httpSession.getAttribute("TaiKhoan");
		mdMap.addAttribute("tenHT", tenHT);
		int idTK =  (Integer) httpSession.getAttribute("idTaiKhoan");
		if(!taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen().equals("Quản trị")) {
			return "error";
		}
		
		mdMap.addAttribute("lstGiamGia", giamGiaSer.lstGiamGia());
		return "ADM_KhuyenMai";
	}
	
	@GetMapping("/them")
	@ResponseBody
	String them(@RequestParam String tenGG, @RequestParam String NgayBD, @RequestParam String NgayKT, @RequestParam int soTien ) {
		GiamGia gg = new GiamGia();
		gg.setSoTienGiam(soTien);
		gg.setTenGiamGia(tenGG);
		gg.setThoiGianBD(NgayBD);
		gg.setThoiGianKT(NgayKT);
		giamGiaSer.themGiamGia(gg);
		return "";
	}
	@Autowired
	SanPhamSer sanPhamSer;
	@GetMapping("/{idGiamGia}")
	String update(@PathVariable int idGiamGia, ModelMap mdMap) {
		GiamGia giamGia = giamGiaSer.showGG(idGiamGia);
		mdMap.addAttribute("giamgia", giamGia);
		mdMap.addAttribute("lstsp", sanPhamSer.showSanPham());
		for (SanPham sp : giamGia.getListSanPham()) {
			
		}
		return "ADM_ChiTietKM";
	}
	
	@GetMapping("/themsp")
	@ResponseBody
	String themsp(@RequestParam int idGiamGia, @RequestParam int idsp) {	
		SanPham sp = sanPhamSer.LayChiTietSP(idsp);
		giamGiaSer.themspgg(idGiamGia, sp);
		return "";
	}
	
	@GetMapping("/xoasp")
	@ResponseBody
	String xoasp(@RequestParam int idGiamGia, @RequestParam int idSanPham) {	
		SanPham sp = sanPhamSer.LayChiTietSP(idSanPham);
		giamGiaSer.xoaspgg(idGiamGia, sp);
		return "";
	}
	
	@GetMapping("/update")
	@ResponseBody
	String update(@RequestParam int idGiamGia, @RequestParam String tenGiamGia, @RequestParam int soTienGiam, @RequestParam String thoiGianBD, @RequestParam String thoiGianKT) {	
		GiamGia giamgia = new GiamGia();
		giamgia.setTenGiamGia(tenGiamGia);
		giamgia.setSoTienGiam(soTienGiam);
		giamgia.setThoiGianBD(thoiGianBD);
		giamgia.setThoiGianKT(thoiGianKT);
		giamGiaSer.update(idGiamGia, giamgia);
		return "";
	}
}
