package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.PhanQuyen;
import Entity.TaiKhoan;
import Implements.TaiKhoanImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TaiKhoanDao implements TaiKhoanImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public int KiemTraDangNhap(String user, String pass) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TaiKhoan taikhoan = (TaiKhoan) session.createQuery("from TAIKHOAN where tenTaiKhoan='"+user+"' and matKhau='"+pass+"'").getSingleResult();
			if(taikhoan != null)
				return taikhoan.getIdTaiKhoan();
		}catch (Exception e) {
			return 0;
		}
		return 0;
	}

	@Transactional
	public boolean KiemTraDangKy(String user, String pass, int idQuyen) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TaiKhoan taikhoan = (TaiKhoan) session.createQuery("from TAIKHOAN where tenTaiKhoan='"+user+"'").uniqueResult();
			if(taikhoan == null) {
				TaiKhoan newTK = new TaiKhoan();
				newTK.setTenTaiKhoan(user);
				newTK.setMatKhau(pass);
				newTK.setTinhTrang("Mở");
				PhanQuyen pqNew = session.get(PhanQuyen.class, idQuyen);
				newTK.setPhanQuyen(pqNew);
				session.save(newTK);
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

	
	@Transactional
	public TaiKhoan ShowTaiKhoan(int idTaiKhoan) {
		Session session = sessionFactory.getCurrentSession();
		TaiKhoan tk = (TaiKhoan) session.createQuery("from TAIKHOAN where idTaiKhoan='"+idTaiKhoan+"'").uniqueResult();
		return tk;
	}

	@Transactional
	public List<TaiKhoan> lstTK() {
		Session session = sessionFactory.getCurrentSession();
		List<TaiKhoan> lstTK = session.createQuery("from TAIKHOAN").getResultList();
		return lstTK;
	}

	@Transactional
	public int ShowTaiKhoanUser(String tenTaiKhoan) {
		Session session = sessionFactory.getCurrentSession();
		TaiKhoan tk = (TaiKhoan) session.createQuery("from TAIKHOAN where tenTaiKhoan='"+tenTaiKhoan+"'").uniqueResult();
		return tk.getIdTaiKhoan();
	}

	@Transactional
	public String update(TaiKhoan tk, int idTaiKhoan) {
		Session session = sessionFactory.getCurrentSession();
		TaiKhoan user = session.get(TaiKhoan.class, idTaiKhoan);
		user.setHoTen(tk.getHoTen());
		user.setGioiTinh(tk.getGioiTinh());
		user.setSdt(tk.getSdt());
		user.setEmail(tk.getEmail());
		user.setDiaChi(tk.getDiaChi());
		user.setMatKhau(tk.getMatKhau());
		
		session.update(user);
		return null;
	}

	@Transactional
	public boolean checkTrangThai(String user) {
		Session session = sessionFactory.getCurrentSession();
		TaiKhoan tk = (TaiKhoan) session.createQuery("from TAIKHOAN where tenTaiKhoan='"+user+"'").uniqueResult();
		if(tk.getTinhTrang().equals("Mở")) {
			return true;
		}
		return false;
	}

	@Transactional
	public String updateTrangThai(int idTaiKhoan, String trangThai) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		TaiKhoan tk = session.get(TaiKhoan.class, idTaiKhoan);
		tk.setTinhTrang(trangThai);
		return null;
	}


}
