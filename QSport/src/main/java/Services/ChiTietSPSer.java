package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.ChiTietSPDao;
import Entity.ChiTietSanPham;
import Implements.ChiTietSPImp;

@Service
public class ChiTietSPSer implements ChiTietSPImp {

	@Autowired
	ChiTietSPDao chiTietSPDao;
	
	public List<String> DsMau(int idSanPham) {	
		return chiTietSPDao.DsMau(idSanPham);
	}

	public int kiemTraSLSanPham(int idSanPham, String hinhAnh, int idSize) {
		
		return chiTietSPDao.kiemTraSLSanPham(idSanPham, hinhAnh, idSize);
	}

	public int layMaCTSP(int idSanPham, String hinhAnh, int idSize) {
		return chiTietSPDao.layMaCTSP(idSanPham, hinhAnh, idSize);
	}

	public String XoaSLSanPham(int idChiTietSanPham, int SoLuong) {
		chiTietSPDao.XoaSLSanPham(idChiTietSanPham,SoLuong);
		return "";
	}

	public String ThemCTSP(ChiTietSanPham chiTietSanPham) {
		chiTietSPDao.ThemCTSP(chiTietSanPham);
		return null;
	}

	public List<ChiTietSanPham> layCTSPTheoIdSP(int idSanPham) {
		// TODO Auto-generated method stub
		return chiTietSPDao.layCTSPTheoIdSP(idSanPham);
	}

	public int getMaCTSP(int idSanPham, int idMauSac, int idSize) {
		// TODO Auto-generated method stub
		return chiTietSPDao.getMaCTSP(idSanPham, idMauSac, idSize);
	}

	public String updateSoLuong(int idChiTietSanPham, int SoLuong) {
		// TODO Auto-generated method stub
		return chiTietSPDao.updateSoLuong(idChiTietSanPham, SoLuong);
	}

	public String kiemTraSanPham(int idSanPham, int idMauSac) {
		// TODO Auto-generated method stub
		return chiTietSPDao.kiemTraSanPham(idSanPham, idMauSac);
	}

	public ChiTietSanPham showCTSP(int idChiTietSanPham) {
		// TODO Auto-generated method stub
		return chiTietSPDao.showCTSP(idChiTietSanPham);
	}


}
