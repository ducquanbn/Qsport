package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.SanPhamDao;
import Entity.SanPham;
import Implements.SanPhamImp;

@Service
public class SanPhamSer implements SanPhamImp{

	@Autowired
	SanPhamDao sanPhamDAO;
	
	public List<SanPham> showSanPham() {
		
		return sanPhamDAO.showSanPham();
	}

	public SanPham LayChiTietSP(int idSanPham) {
		
		return sanPhamDAO.LayChiTietSP(idSanPham);
	}


	public boolean XoaSanPham(int idSanPham) {
		sanPhamDAO.XoaSanPham(idSanPham);
		return false;
	}

	public List<SanPham> showSanPhamLimt(int soBatDau) {
		
		return sanPhamDAO.showSanPhamLimt(soBatDau);
	}

	public boolean ThemSanPham(SanPham sp) {
		
		return sanPhamDAO.ThemSanPham(sp);
	}

	public boolean SuaSanPham(SanPham sp) {
		// TODO Auto-generated method stub
		return sanPhamDAO.SuaSanPham(sp);
	}

	public List<SanPham> showSanPhamIndex() {
		// TODO Auto-generated method stub
		return sanPhamDAO.showSanPhamIndex();
	}

	public List<SanPham> TimKiem(String tenSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.TimKiem(tenSanPham);
	}

	public String updateSoLuongBan(int idSanPham, int sl) {
		// TODO Auto-generated method stub
		return sanPhamDAO.updateSoLuongBan(idSanPham, sl);
	}

	public List<SanPham> showSanPhamBanChay() {
		// TODO Auto-generated method stub
		return sanPhamDAO.showSanPhamBanChay();
	}
	
	
}
