package Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Entity.ChiTietSanPham;
import Entity.DanhMuc;
import Entity.MauSac;
import Entity.SanPham;
import Entity.Size;
import Services.ChiTietSPSer;
import Services.MauSacSer;
import Services.SanPhamSer;
import Services.SizeSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/admin/San-Pham/Chi-Tiet")
public class ADM_ChiTietSanPham {

	@Autowired
	ChiTietSPSer chiTietSPSer;
	
	@Autowired
	MauSacSer mauSacSer;
	
	@Autowired
	SanPhamSer sanPhamSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@Autowired
	SizeSer sizeSer;
	
	@GetMapping("/{idSanPham}")
	public String UpdateSanPham(@PathVariable int idSanPham,ModelMap mdMap,HttpSession httpSession) {
		if(httpSession.getAttribute("TaiKhoan") == null) {
			return "error";
		}
		String tenHT =(String) httpSession.getAttribute("TaiKhoan");
		mdMap.addAttribute("tenHT", tenHT);
		int idTK =  (Integer) httpSession.getAttribute("idTaiKhoan");
		if(!taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen().equals("Quản trị")) {
			return "error";
		}
		
		/* show DS Mau*/
		List<MauSac> lstMS = mauSacSer.showDSMau();
		mdMap.addAttribute("lstMS", lstMS);
		
		/* show DS Size*/
		List<Size> lstSize = sizeSer.lstSize();
		mdMap.addAttribute("lstSize", lstSize);
		
		mdMap.addAttribute("SP", sanPhamSer.LayChiTietSP(idSanPham));
		mdMap.addAttribute("lstMau", chiTietSPSer.DsMau(idSanPham));
		mdMap.addAttribute("lstCTSP", chiTietSPSer.layCTSPTheoIdSP(idSanPham));
		return "ADM_ChiTietSanPham";
	}
	
	@Autowired
	ServletContext context;
	
	String tenHinhAnh;
	@PostMapping("/UploadFile")
	@ResponseBody
	public String UploadFile(MultipartHttpServletRequest request) {
		String path_save_file = context.getRealPath("/resources/images/products/");
		Iterator<String> lstName = request.getFileNames();
		MultipartFile mpf = request.getFile(lstName.next());
		File file_save = new File(path_save_file+mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
			tenHinhAnh = mpf.getOriginalFilename();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return mpf.getOriginalFilename();
	}
	
	
	@GetMapping("/ThemCTSP")
	@ResponseBody
	String themCTSP(@RequestParam int idMau, @RequestParam int idSize, @RequestParam int soLuong, @RequestParam int idSP) {
		if(chiTietSPSer.getMaCTSP(idSP, idMau, idSize) > 0) {
			int idChiTietSP = chiTietSPSer.getMaCTSP(idSP, idMau, idSize);
			chiTietSPSer.updateSoLuong(idChiTietSP, soLuong);
		}else {
			if(!chiTietSPSer.kiemTraSanPham(idSP, idMau).equals("")) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				chiTietSanPham.setSanPham(sanPhamSer.LayChiTietSP(idSP));
				Size size = sizeSer.showSize(idSize);
				chiTietSanPham.setSize(size);
				MauSac mausac = mauSacSer.ShowMS(idMau);
				chiTietSanPham.setMauSac(mausac);
				chiTietSanPham.setHinhAnh(chiTietSPSer.kiemTraSanPham(idSP, idMau));
				chiTietSanPham.setSoLuongCon(soLuong);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
				Date dateNow = new Date();
				chiTietSanPham.setNgayNhap(formatter.format(dateNow));
				chiTietSPSer.ThemCTSP(chiTietSanPham);
			}else {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				chiTietSanPham.setSanPham(sanPhamSer.LayChiTietSP(idSP));
				Size size = sizeSer.showSize(idSize);
				chiTietSanPham.setSize(size);
				MauSac mausac = mauSacSer.ShowMS(idMau);
				chiTietSanPham.setMauSac(mausac);
				chiTietSanPham.setHinhAnh(tenHinhAnh);
				chiTietSanPham.setSoLuongCon(soLuong);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
				Date dateNow = new Date();
				chiTietSanPham.setNgayNhap(formatter.format(dateNow));
				chiTietSPSer.ThemCTSP(chiTietSanPham);
			}
		}
		return "";
	}
	
	@GetMapping("/UpdateSL")
	@ResponseBody
	String UpdateSL( @RequestParam int soLuong, @RequestParam int idCTSP) {
		chiTietSPSer.updateSoLuong(idCTSP, soLuong);
		return "";
	}
}
