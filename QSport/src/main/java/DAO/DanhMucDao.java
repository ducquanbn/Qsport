package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.DanhMuc;
import Implements.DanhMucImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDao implements DanhMucImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<DanhMuc> ShowDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		List<DanhMuc> lstDanhMuc = (List<DanhMuc>)session.createQuery("from DANHMUC").getResultList();
		return lstDanhMuc;
	}

	@Transactional
	public DanhMuc HTDanhMuc(int idDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		DanhMuc DanhMuc = (Entity.DanhMuc) session.createQuery("from DANHMUC where idDanhMuc='"+idDanhMuc+"'").uniqueResult();
		return DanhMuc;
	}

	@Transactional
	public String themDanhMuc(DanhMuc danhMuc) {
		Session session = sessionFactory.getCurrentSession();
		session.save(danhMuc);
		return null;
	}

	@Transactional
	public String updateDanhMuc(int idDanhMuc, String tenDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		DanhMuc danhmuc = session.get(DanhMuc.class, idDanhMuc);
		danhmuc.setTenDanhMuc(tenDanhMuc);
		session.update(danhmuc);
		return null;
	}

	
}
