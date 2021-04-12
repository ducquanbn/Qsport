package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.ChiTietHoaDonDao;
import Entity.ChiTietHoaDon;
import Implements.ChiTietHoaDonImp;

@Service
public class ChiTietHDSer implements ChiTietHoaDonImp {

	@Autowired
	ChiTietHoaDonDao chiTietHDDao;
	
	public boolean ThemChiTietHD(ChiTietHoaDon CTHD) {
		// TODO Auto-generated method stub
		return chiTietHDDao.ThemChiTietHD(CTHD);
	}

	public List<ChiTietHoaDon> lstCTHD(int idHoaDon) {
		// TODO Auto-generated method stub
		return chiTietHDDao.lstCTHD(idHoaDon);
	}
	
}
