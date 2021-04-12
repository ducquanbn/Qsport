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
import Entity.Size;
import Implements.SizeImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeDao implements SizeImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Size> lstSize() {
		Session session = sessionFactory.getCurrentSession();
		List<Size> DsSize = (List<Size>) session.createQuery("from SIZE").getResultList();
		return DsSize;
	}

	@Transactional
	public Size showSize(int idSize) {
		Session session = sessionFactory.getCurrentSession();
		Size size = (Size) session.createQuery("from SIZE where idSize='"+idSize+"'").uniqueResult();
		return size;
	}

	@Transactional
	public String themSize(Size size) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(size);
		return null;
	}

	@Transactional
	public String updateSize(int idSize, String tenSize) {
		Session session = sessionFactory.getCurrentSession();
		Size size = session.get(Size.class, idSize);
		size.setTenSize(tenSize);
		session.update(size);
		return null;
	}

}
