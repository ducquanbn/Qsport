package Controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonId;
import Entity.ChiTietSanPham;
import Entity.GioHang;
import Entity.HoaDon;
import Entity.TaiKhoan;
import Services.ChiTietSPSer;
import Services.ChiTietHDSer;
import Services.HoaDonSer;
import Services.QSportSer;
import Services.SanPhamSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/Gio-Hang")
@SessionAttributes("GioHang")
public class GioHangController {
	@Autowired
	QSportSer qSportSer;
	
	@Autowired
	TaiKhoanSer taiKhoanSer;
	
	@Autowired
	ChiTietHDSer chiTietHDSer;
	
	@Autowired
	ChiTietSPSer chiTietSPSer;
	
	@Autowired
	HoaDonSer hoaDonSer;
	
	@GetMapping
	@Transactional
	public String Default(ModelMap mdMap, HttpSession httpSession) {
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
		
		return "giohang";
	}
	@Autowired
	SanPhamSer sanPhamSer;
	
	@GetMapping("/ThemHoaDon")
	@Transactional
	public String themHoaDon(@RequestParam String tenKhachHang, @RequestParam String sdt, @RequestParam String diaChi, 
		@RequestParam String hinhThucNhan, @RequestParam String ghiChu, HttpSession httpSession) {
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang") ;
			HoaDon HD = new HoaDon();
			if(httpSession.getAttribute("TaiKhoan") != null) {
				int idTK = (Integer) httpSession.getAttribute("idTaiKhoan");
				TaiKhoan tk = taiKhoanSer.ShowTaiKhoan(idTK);
				HD.setTaiKhoan(tk);
			}else
				HD.setTaiKhoan(null);
			
			HD.setTinhTrang(false);
			HD.setTenKhachHang(tenKhachHang);
			HD.setSdt(sdt);
			HD.setDiaChi(diaChi);
			HD.setHinhThucNhan(hinhThucNhan);
			HD.setGhiChu(ghiChu);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date dateNow = new Date();
			HD.setNgayLap(formatter.format(dateNow));
			
			if(hoaDonSer.ThemHoaDon(HD)) {
				Set<ChiTietHoaDon> lstCTHD = new HashSet<ChiTietHoaDon>();
				for (GioHang giohang : lstGioHangs) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setIdChiTietSanPham(giohang.getIdChiTietSanPham());
					chiTietHoaDonId.setIdHoaDon(HD.getIdHoaDon());
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTietHoaDon.setSoTien(giohang.getGiaTien()*giohang.getSoLuong());
					chiTietHoaDon.setSoLuong(giohang.getSoLuong());
					
					chiTietHDSer.ThemChiTietHD(chiTietHoaDon);
					chiTietSPSer.XoaSLSanPham(giohang.getIdChiTietSanPham(), giohang.getSoLuong());
					
					/* thêm số lượng sản phẩm bán */
					ChiTietSanPham ctsp = chiTietSPSer.showCTSP(giohang.getIdChiTietSanPham());
					int idsp = ctsp.getSanPham().getIdSanPham();
					sanPhamSer.updateSoLuongBan(idsp, giohang.getSoLuong());
				}
				lstGioHangs.clear();
			}
			else
				System.out.println("TB");
		}
		
		return "giohang";
	}

	@GetMapping("/themGioHang")
	@ResponseBody
	public String ThemGioHang(@ModelAttribute GioHang gioHang, HttpSession httpSession) {
		if(gioHang.getHinhAnh() == null || gioHang.getIdSize() == 0) {
			return "false";
		}else {
			if( chiTietSPSer.kiemTraSLSanPham(gioHang.getIdSanPham(), gioHang.getHinhAnh(), gioHang.getIdSize()) < 0 ) 
				return "null";
			else {
				int idCTSP = chiTietSPSer.layMaCTSP(gioHang.getIdSanPham(), gioHang.getHinhAnh(), gioHang.getIdSize());
				gioHang.setIdChiTietSanPham(idCTSP);
				if(httpSession.getAttribute("GioHang") == null) {
					List<GioHang> gioHangs = new ArrayList<GioHang>();
					gioHangs.add(gioHang);
					httpSession.setAttribute("GioHang", gioHangs);
					return "true";
				}else {
					List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang") ;
					int viTri = KiemTraSPTonTaiTrongGioHang(lstGioHangs ,gioHang.getIdSanPham(), gioHang.getHinhAnh(),gioHang.getIdSize());
					if(viTri == -1) {
						lstGioHangs.add(gioHang);
						return "true";
					}else {
						int slMoi = lstGioHangs.get(viTri).getSoLuong() + 1;
						lstGioHangs.get(viTri).setSoLuong(slMoi);
						return "true";
					}
				}
			}
		}
	}
	
	private int KiemTraSPTonTaiTrongGioHang(List<GioHang> lstGioHangs,int idSanPham, String hinhAnh, int idSize) {
		for(int i=0; i< lstGioHangs.size(); i++) {
			if(lstGioHangs.get(i).getIdSanPham() == idSanPham && lstGioHangs.get(i).getHinhAnh().trim().equals(hinhAnh) && lstGioHangs.get(i).getIdSize() == idSize)
				return i;
		}
		return -1;
	}
	
	@GetMapping("/laySoLuongGioHang")
	@ResponseBody
	public String laySoLuongGioHang(HttpSession httpSession) {
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			
			return lstGioHangs.size()+"";
		}
		return "";
	}
	
	
	@GetMapping("/ThemSLGioHang")
	@ResponseBody
	public String ThemSLGioHang(HttpSession httpSession, @RequestParam int idSanPham, @RequestParam String hinhAnh, @RequestParam int idSize) {
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			int viTri = KiemTraSPTonTaiTrongGioHang(lstGioHangs, idSanPham, hinhAnh, idSize);
			int soLuongMoi = lstGioHangs.get(viTri).getSoLuong() + 1;
			if(soLuongMoi > chiTietSPSer.kiemTraSLSanPham(idSanPham, hinhAnh, idSize)) {
				return "false";
			}else
				lstGioHangs.get(viTri).setSoLuong(soLuongMoi);
		}
		return "";
	}
	
	@GetMapping("/GiamSLGioHang")
	@ResponseBody
	public String GiamSLGioHang(HttpSession httpSession, @RequestParam int idSanPham, @RequestParam String hinhAnh, @RequestParam int idSize) {
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			int viTri = KiemTraSPTonTaiTrongGioHang(lstGioHangs, idSanPham, hinhAnh, idSize);
			int soLuongMoi = lstGioHangs.get(viTri).getSoLuong() - 1;
			lstGioHangs.get(viTri).setSoLuong(soLuongMoi);
		}
		return "";
	}

	@GetMapping("/XoaGioHang")
	@ResponseBody
	public String XoaGioHang(HttpSession httpSession, @RequestParam int idSanPham, @RequestParam String hinhAnh, @RequestParam int idSize) {
		if(httpSession.getAttribute("GioHang") != null) {
			List<GioHang> lstGioHangs = (List<GioHang>) httpSession.getAttribute("GioHang");
			int viTri = KiemTraSPTonTaiTrongGioHang(lstGioHangs, idSanPham, hinhAnh, idSize);
			lstGioHangs.remove(viTri);
		}
		return "";
	}

}
