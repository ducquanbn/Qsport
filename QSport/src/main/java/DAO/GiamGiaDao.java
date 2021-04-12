package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.GiamGia;
import Entity.SanPham;
import Implements.GiamGiaImp;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GiamGiaDao implements GiamGiaImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<GiamGia> lstGiamGia() {
		Session sesison = sessionFactory.getCurrentSession();
		List<GiamGia> lstGiamGia = sesison.createQuery("from GIAMGIA order by idGiamGia desc").getResultList();
		return lstGiamGia;
	}

	@Transactional
	public boolean themGiamGia(GiamGia giamgia) {
		Session sesison = sessionFactory.getCurrentSession();
		sesison.save(giamgia);
		return true;
	}

	@Transactional
	public GiamGia showGG(int idGiamGia) {
		Session sesison = sessionFactory.getCurrentSession();
		GiamGia gg = (GiamGia) sesison.createQuery("from GIAMGIA where idGiamGia='"+idGiamGia+"'").uniqueResult();
		return gg;
	}

	@Transactional
	public String themspgg(int idGiamGia, SanPham sp) {
		Session sesison = sessionFactory.getCurrentSession();
		GiamGia gg = sesison.get(GiamGia.class, idGiamGia);
		gg.getListSanPham().add(sp);
		sesison.update(gg);
		return null;
	}

	@Transactional
	public String update(int idGiamGia, GiamGia gg) {
		Session sesison = sessionFactory.getCurrentSession();
		GiamGia giamgia = sesison.get(GiamGia.class, idGiamGia);
		giamgia.setTenGiamGia(gg.getTenGiamGia());
		giamgia.setSoTienGiam(gg.getSoTienGiam());
		giamgia.setThoiGianBD(gg.getThoiGianBD());
		giamgia.setThoiGianKT(gg.getThoiGianKT());
		sesison.update(giamgia);
		return null;
	}

	@Transactional
	public String xoaspgg(int idGiamGia, SanPham sp) {
		Session sesison = sessionFactory.getCurrentSession();
		GiamGia gg = sesison.get(GiamGia.class, idGiamGia);
		gg.getListSanPham().remove(sp);
		sesison.update(gg);
		return null;
	}


}
