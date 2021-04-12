package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.MauSacDao;
import Entity.MauSac;
import Implements.MauSacImp;

@Service
public class MauSacSer implements MauSacImp {
	@Autowired
	MauSacDao mauSacDao;

	public MauSac ShowMS(int idMau) {
		// TODO Auto-generated method stub
		return mauSacDao.ShowMS(idMau);
	}

	public List<MauSac> showDSMau() {
		// TODO Auto-generated method stub
		return mauSacDao.showDSMau();
	}

	public String themMau(MauSac mau) {
		// TODO Auto-generated method stub
		mauSacDao.themMau(mau);
		return null;
	}

	public String updateMau(int idMauSac, String tenMau) {
		// TODO Auto-generated method stub
		return mauSacDao.updateMau(idMauSac, tenMau);
	}
	
}
