package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.MauSac;
import Implements.MauSacImp;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSacDao implements MauSacImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public MauSac ShowMS(int idMau) {
		Session session = sessionFactory.getCurrentSession();
		MauSac mausac = (MauSac) session.createQuery("from MAUSAC where idMauSac='"+idMau+"'").uniqueResult();
		return mausac;
	}

	@Transactional
	public List<MauSac> showDSMau() {
		Session session = sessionFactory.getCurrentSession();
		List<MauSac> lstmausac = (List<MauSac>) session.createQuery("from MAUSAC").getResultList();
		return lstmausac;
	}

	@Transactional
	public String themMau(MauSac mau) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mau);
		return null;
	}

	@Transactional
	public String updateMau(int idMauSac, String tenMau) {
		Session session = sessionFactory.getCurrentSession();
		MauSac mausac = session.get(MauSac.class, idMauSac);
		mausac.setTenMau(tenMau);
		session.update(mausac);
		return null;
	}

}
