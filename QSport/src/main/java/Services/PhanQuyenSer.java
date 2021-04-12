package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PhanQuyenDao;
import Entity.PhanQuyen;
import Implements.PhanQuyenImp;

@Service
public class PhanQuyenSer implements PhanQuyenImp {

	@Autowired
	PhanQuyenDao phanQuyenDao;
	
	public List<PhanQuyen> lstPQ() {
		// TODO Auto-generated method stub
		return phanQuyenDao.lstPQ();
	}

}
