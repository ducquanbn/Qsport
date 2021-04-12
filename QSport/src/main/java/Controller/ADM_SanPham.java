package Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
import Services.DanhMucSer;
import Services.MauSacSer;
import Services.SanPhamSer;
import Services.SizeSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/admin/San-Pham")
public class ADM_SanPham {
	
	@Autowired
	SanPhamSer sanPhamSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@Autowired
	DanhMucSer danhMucSer;
	@Autowired
	MauSacSer mauSacSer;
	@Autowired
	SizeSer sizeSer;
	@Autowired
	ChiTietSPSer chiTietSPSer;
	
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
		/* Show Danh Muc */
		List<DanhMuc> lstSDanhMuc = danhMucSer.ShowDanhMuc();
		mdMap.addAttribute("lstDM",lstSDanhMuc);
		
		/* Show San Pham */
		List<SanPham> lstSanPhams = sanPhamSer.showSanPhamLimt(0);
		mdMap.addAttribute("lstSP",lstSanPhams);
		
		/* show DS Mau*/
		List<MauSac> lstMS = mauSacSer.showDSMau();
		mdMap.addAttribute("lstMS", lstMS);
		
		/* show DS Size*/
		List<Size> lstSize = sizeSer.lstSize();
		mdMap.addAttribute("lstSize", lstSize);
		
		
		List<SanPham> lstAllSanPhams = sanPhamSer.showSanPham();
		mdMap.addAttribute("lstSPAll",lstAllSanPhams);
		double tongSoPage = Math.ceil(((double) lstAllSanPhams.size()/10 ));
		mdMap.addAttribute("tongSoPage", tongSoPage);
		
		return "ADM_SanPham";
	}
	
	@GetMapping("/{idSanPham}")
	public String UpdateSanPham(@PathVariable int idSanPham,ModelMap mdMap) {
		/* Show Danh Muc */
		List<DanhMuc> lstSDanhMuc = danhMucSer.ShowDanhMuc();
		mdMap.addAttribute("lstDM",lstSDanhMuc);
		SanPham sp = sanPhamSer.LayChiTietSP(idSanPham);
		mdMap.addAttribute("sp", sp);
		return "ADM_suachitietsp";
	}
	
	@GetMapping(path="/laySanPhamLimit" , produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String laySanPhamLimit(@RequestParam int soBatDau) {

		List<SanPham> lstSPLimit = sanPhamSer.showSanPhamLimt(soBatDau);
		String html="";
		for (SanPham sanpham : lstSPLimit) {
			html += "<tr>";
			html += "<th class='nameSP' style='vertical-align: middle;' scope='row' data-idSP='"+sanpham.getIdSanPham()+"'> <a style='color: black;text-decoration: none;' href='http://localhost:8080/QSport/Chi-Tiet/"+sanpham.getIdSanPham()+"'> Giày thể thao "+ sanpham.getTenSanPham()+"</a> </th>";
			html+= "<td> <img class='hinhAnhSP' data-hinhAnh='"+sanpham.getHinhAnh()+"' style='width: 100px; height: 100px;' alt='"+sanpham.getTenSanPham()+"' src='../resources/images/products/"+sanpham.getHinhAnh()+"'> </td>\r\n" + 
					"						      <td class='Tien' data-money='"+sanpham.getGia()+"' class='' style='vertical-align: middle; text-align: center; '>"+sanpham.getGia()+"</td>\r\n" + 
					"						      <td  style='vertical-align: middle;text-align: center; '>"+ sanpham.getDanhMuc().getTenDanhMuc()+"</td>\r\n" + 
					"						      <td style='margin-top: 40px;' class='btn btn-danger'> <a style='color: white;text-decoration: none;' href='http://localhost:8080/QSport/admin/San-Pham/"+sanpham.getIdSanPham()+"'> Sửa </a> </td>\r\n" + 
					"						      <td style='margin-top: 40px;' class='btn btn-danger'> <a style='color: white;text-decoration: none;' href='http://localhost:8080/QSport/admin/San-Pham/Chi-Tiet/"+sanpham.getIdSanPham()+"'> Cập nhật </a> </td>";
			
			html += "<tr>";
		}
		return html;
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
	

	@GetMapping("/ThemSanPham")
	@ResponseBody
	public String ThemSanPham(@RequestParam String tenSanPham, @RequestParam String chatLieu,
			@RequestParam String kieuDang, @RequestParam String mauSacGiay, @RequestParam String chatLuong, @RequestParam int Gia, 
			@RequestParam int idDanhMuc, @RequestParam int idMau, @RequestParam int idSize, @RequestParam int soLuong) {
		
		SanPham sp = new SanPham();
		sp.setTenSanPham(tenSanPham);
		sp.setChatLieu(chatLieu);
		sp.setChatLuong(chatLuong);
		sp.setKieuDang(kieuDang);
		sp.setMauSacGiay(mauSacGiay);
		sp.setGia(Gia);
		sp.setHinhAnh(tenHinhAnh);
		sp.setDanhMuc(danhMucSer.HTDanhMuc(idDanhMuc));
		
		if(sanPhamSer.ThemSanPham(sp)) {
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			chiTietSanPham.setSanPham(sanPhamSer.LayChiTietSP(sp.getIdSanPham()));
			Size size = sizeSer.showSize(idSize);
			chiTietSanPham.setSize(size);
			MauSac mauSac = mauSacSer.ShowMS(idMau);
			chiTietSanPham.setMauSac(mauSac);
			chiTietSanPham.setHinhAnh(tenHinhAnh);
			chiTietSanPham.setSoLuongCon(soLuong);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
			Date dateNow = new Date();
			chiTietSanPham.setNgayNhap(formatter.format(dateNow));
			chiTietSPSer.ThemCTSP(chiTietSanPham);
		}
		
		return "";
	}
	
	@GetMapping("/SuaSanPham")
	@ResponseBody
	public String SuaSanPham(@RequestParam int idSanPham,@RequestParam String tenSanPham, @RequestParam String chatLieu, @RequestParam String kieuDang, @RequestParam String mauSacGiay, @RequestParam String chatLuong, @RequestParam int Gia, 
			@RequestParam int idDanhMuc,@RequestParam String hinhAnh) {
		
		SanPham sp = new SanPham();
		sp.setIdSanPham(idSanPham);
		sp.setTenSanPham(tenSanPham);
		sp.setChatLieu(chatLieu);
		sp.setChatLuong(chatLuong);
		sp.setKieuDang(kieuDang);
		sp.setMauSacGiay(mauSacGiay);
		sp.setGia(Gia);
		sp.setHinhAnh(hinhAnh);
		sp.setDanhMuc(danhMucSer.HTDanhMuc(idDanhMuc));
		
		sanPhamSer.SuaSanPham(sp);
		
		
		return "";
	}
}
