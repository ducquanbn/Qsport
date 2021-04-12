package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.SanPham;
import Implements.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> showSanPham() {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> lstSP = (List<SanPham>) session.createQuery("from SANPHAM order by idSanPham desc").getResultList();
		return lstSP;
	}
	
	@Transactional
	public SanPham LayChiTietSP(int idSanPham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham SP = (SanPham) session.createQuery("from SANPHAM where idSanPham='"+idSanPham+"'").getSingleResult();
		return SP;
	}
	

	@Transactional
	public boolean XoaSanPham(int idSanPham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanpham = session.get(SanPham.class, idSanPham);
		session.delete(sanpham);
		return false;
	}

	@Transactional
	public List<SanPham> showSanPhamLimt(int soBatDau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> lstSP = (List<SanPham>) session.createQuery("from SANPHAM order by idSanPham desc").setFirstResult(soBatDau).setMaxResults(10).getResultList();
		return lstSP;
	}

	@Transactional
	public boolean ThemSanPham(SanPham sp) {
		Session session = sessionFactory.getCurrentSession();
		session.save(sp);
		return true;
	}

	@Transactional
	public boolean SuaSanPham(SanPham sp) {
		Session session = sessionFactory.getCurrentSession();
		SanPham SPupdate = session.get(SanPham.class, sp.getIdSanPham());
		SPupdate.setTenSanPham(sp.getTenSanPham());
		SPupdate.setChatLieu(sp.getChatLieu());
		SPupdate.setChatLuong(sp.getChatLuong());
		SPupdate.setDanhMuc(sp.getDanhMuc());
		SPupdate.setGia(sp.getGia());
		SPupdate.setHinhAnh(sp.getHinhAnh());
		SPupdate.setKieuDang(sp.getKieuDang());
		SPupdate.setMauSacGiay(sp.getMauSacGiay());
		
		
		session.update(SPupdate);
		return true;
	}

	@Transactional
	public List<SanPham> showSanPhamIndex() {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> lstSP = (List<SanPham>) session.createQuery("from SANPHAM order by idSanPham desc").setFirstResult(0).setMaxResults(16).getResultList();
		return lstSP;
	}

	@Transactional
	public List<SanPham> TimKiem(String tenSanPham) {
		try {
			Session session = sessionFactory.getCurrentSession();
			List<SanPham> lstSP = (List<SanPham>) session.createQuery("from SANPHAM where tenSanPham like '%"+ tenSanPham +"%' order by idSanPham desc").getResultList();
			return lstSP;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Transactional
	public String updateSoLuongBan(int idSanPham, int sl) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		SanPham sp = session.get(SanPham.class, idSanPham);
		int slmoi = sp.getSoLuongBan()+sl;
		sp.setSoLuongBan(slmoi);
		session.update(sp);
		return null;
	}

	@Transactional
	public List<SanPham> showSanPhamBanChay() {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> lstSP = (List<SanPham>) session.createQuery("from SANPHAM order by soLuongBan desc").setFirstResult(0).setMaxResults(4).getResultList();
		return lstSP;
	}


	
}
