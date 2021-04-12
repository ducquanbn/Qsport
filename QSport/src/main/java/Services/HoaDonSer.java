package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.HoaDonDao;
import Entity.HoaDon;
import Implements.HoaDonImp;

@Service
public class HoaDonSer implements HoaDonImp{

	@Autowired
	HoaDonDao hoaDonDao;
	public boolean ThemHoaDon(HoaDon hoaDon) {
		return hoaDonDao.ThemHoaDon(hoaDon);
	}
	public List<HoaDon> lstHoaDon() {
		// TODO Auto-generated method stub
		return hoaDonDao.lstHoaDon();
	}
	public List<HoaDon> TimKiemTheoUser(int idTaiKhoan) {
		// TODO Auto-generated method stub
		return hoaDonDao.TimKiemTheoUser(idTaiKhoan);
	}

	public List<HoaDon> TimKiemTheoSDT(String sdt) {
		// TODO Auto-generated method stub
		return hoaDonDao.TimKiemTheoSDT(sdt);
	}
	public List<HoaDon> TimKiemTheoNgayDat(String ngayBD, String ngayKT) {
		// TODO Auto-generated method stub
		return hoaDonDao.TimKiemTheoNgayDat(ngayBD, ngayKT);
	}
	public HoaDon showHD(int idHoaDon) {
		// TODO Auto-generated method stub
		return hoaDonDao.showHD(idHoaDon);
	}
	public String updateHD(int idHoaDon, Boolean TinhTrang) {
		// TODO Auto-generated method stub
		return hoaDonDao.updateHD(idHoaDon, TinhTrang);
	}

}
