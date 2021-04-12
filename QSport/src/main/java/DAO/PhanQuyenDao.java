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
import Implements.PhanQuyenImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PhanQuyenDao implements PhanQuyenImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<PhanQuyen> lstPQ() {
		Session session = sessionFactory.getCurrentSession();
		List<PhanQuyen> lstPQ = session.createQuery("from PHANQUYEN").getResultList();
		return lstPQ;
	}

	
}
