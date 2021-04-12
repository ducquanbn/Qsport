package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonId;
import Implements.ChiTietHoaDonImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean ThemChiTietHD(ChiTietHoaDon CTHD) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietHoaDonId id = (ChiTietHoaDonId) session.save(CTHD);
		if(id != null)
			return true;
		return false;
	}

	@Transactional
	public List<ChiTietHoaDon> lstCTHD(int idHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		List<ChiTietHoaDon> lstCTHD = session.createQuery("FROM CHITIETHOADON where idHoaDon='"+idHoaDon+"'").getResultList();
		return lstCTHD;
	}


}
