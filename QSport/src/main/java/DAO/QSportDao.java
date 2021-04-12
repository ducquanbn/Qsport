package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.QSport;
import Implements.QSportImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QSportDao implements QSportImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public QSport showQSport() {
		Session session = sessionFactory.getCurrentSession();
		QSport qSport = (QSport) session.createQuery("from QSPORT").getSingleResult();
		return qSport;
	}

	@Transactional
	public String updateQsport(QSport qsport) {
		Session session = sessionFactory.getCurrentSession();
		QSport newQ= session.get(QSport.class, 1);
		newQ.setDiaChi(qsport.getDiaChi());
		newQ.setEmail(qsport.getEmail());
		newQ.setMoTa(qsport.getMoTa());
		newQ.setSdt(qsport.getSdt());
		
		session.update(newQ);
		return null;
	}
	
}
