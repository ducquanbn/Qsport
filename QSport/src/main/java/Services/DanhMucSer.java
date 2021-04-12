package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.DanhMucDao;
import Entity.DanhMuc;

import org.springframework.stereotype.Service;

import Implements.DanhMucImp;

@Service
public class DanhMucSer implements DanhMucImp {

	@Autowired
	DanhMucDao danhMucDao;

	public List<DanhMuc> ShowDanhMuc() {
		
		return danhMucDao.ShowDanhMuc();
	}

	public DanhMuc HTDanhMuc(int idDanhMuc) {
		// TODO Auto-generated method stub
		return danhMucDao.HTDanhMuc(idDanhMuc);
	}

	public String themDanhMuc(DanhMuc danhMuc) {
		danhMucDao.themDanhMuc(danhMuc);
		return null;
	}

	public String updateDanhMuc(int idDanhMuc, String tenDanhMuc) {
		// TODO Auto-generated method stub
		return danhMucDao.updateDanhMuc(idDanhMuc, tenDanhMuc);
	}
	
	
	
}
