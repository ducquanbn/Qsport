package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.GiamGiaDao;
import Entity.GiamGia;
import Entity.SanPham;
import Implements.GiamGiaImp;

@Service
public class GiamGiaSer implements GiamGiaImp {


	@Autowired
	GiamGiaDao giamGiaDao;
	
	public List<GiamGia> lstGiamGia() {
		// TODO Auto-generated method stub
		return giamGiaDao.lstGiamGia();
	}

	public boolean themGiamGia(GiamGia giamgia) {
		// TODO Auto-generated method stub
		return giamGiaDao.themGiamGia(giamgia);
	}

	public GiamGia showGG(int idGiamGia) {
		// TODO Auto-generated method stub
		return giamGiaDao.showGG(idGiamGia);
	}

	public String themspgg(int idGiamGia, SanPham sp) {
		// TODO Auto-generated method stub
		return giamGiaDao.themspgg(idGiamGia, sp);
	}

	public String update(int idGiamGia, GiamGia gg) {
		// TODO Auto-generated method stub
		return giamGiaDao.update(idGiamGia, gg);
	}

	public String xoaspgg(int idGiamGia, SanPham sp) {
		// TODO Auto-generated method stub
		return giamGiaDao.xoaspgg(idGiamGia, sp);
	}
	
}
