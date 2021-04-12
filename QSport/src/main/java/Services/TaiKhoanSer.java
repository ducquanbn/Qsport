package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.TaiKhoanDao;
import Entity.TaiKhoan;
import Implements.TaiKhoanImp;

@Service
public class TaiKhoanSer implements TaiKhoanImp {
	@Autowired
	TaiKhoanDao taiKhoanDao;
	
	
	public int KiemTraDangNhap(String user, String pass) {		
		return taiKhoanDao.KiemTraDangNhap(user.trim(), pass.trim());
	}


	public boolean KiemTraDangKy(String user, String pass, int idQuyen) {
		return taiKhoanDao.KiemTraDangKy(user, pass, idQuyen);
	}


	public TaiKhoan ShowTaiKhoan(int idTaiKhoan) {
		return taiKhoanDao.ShowTaiKhoan(idTaiKhoan);
	}


	public List<TaiKhoan> lstTK() {
		// TODO Auto-generated method stub
		return taiKhoanDao.lstTK();
	}


	public int ShowTaiKhoanUser(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		return taiKhoanDao.ShowTaiKhoanUser(tenTaiKhoan);
	}


	public String update(TaiKhoan tk, int idTaiKhoan) {
		// TODO Auto-generated method stub
		return taiKhoanDao.update(tk, idTaiKhoan);
	}


	public boolean checkTrangThai(String user) {
		// TODO Auto-generated method stub
		return taiKhoanDao.checkTrangThai(user);
	}


	public String updateTrangThai(int idTaiKhoan, String trangThai) {
		// TODO Auto-generated method stub
		return taiKhoanDao.updateTrangThai(idTaiKhoan, trangThai);
	}

}
