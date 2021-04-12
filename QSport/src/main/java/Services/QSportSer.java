package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.QSportDao;
import Entity.QSport;
import Implements.QSportImp;

@Service
public class QSportSer implements QSportImp{
	@Autowired
	QSportDao qSportDao;
	public QSport showQSport() {
		// TODO Auto-generated method stub
		return qSportDao.showQSport();
	}
	public String updateQsport(QSport qsport) {
		// TODO Auto-generated method stub
		qSportDao.updateQsport(qsport);
		return null;
	}
	
}
