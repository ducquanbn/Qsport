package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.HoaDon;
import Implements.HoaDonImp;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDao implements HoaDonImp {

	@Autowired
	SessionFactory sessioFactory;
	
	@Transactional
	public boolean ThemHoaDon(HoaDon hoaDon) {
		Session session = sessioFactory.getCurrentSession();
		int check = (Integer) session.save(hoaDon);
		if(check > 0)
			return true;
		return false;
	}

	@Transactional
	public List<HoaDon> lstHoaDon() {
		// TODO Auto-generated method stub
		Session session = sessioFactory.getCurrentSession();
		List<HoaDon> lstHoaDon = session.createQuery("from HOADON order by idHoaDon desc").getResultList();
		return lstHoaDon;
	}

	@Transactional
	public List<HoaDon> TimKiemTheoUser(int idTaiKhoan) {
		Session session = sessioFactory.getCurrentSession();
		try {
			List<HoaDon> lstHoaDon = session.createQuery("from HOADON where idTaiKhoan='"+idTaiKhoan+"'").getResultList();
			if(lstHoaDon != null)
				return lstHoaDon;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Transactional
	public List<HoaDon> TimKiemTheoSDT(String sdt) {
		Session session = sessioFactory.getCurrentSession();
		try {
			List<HoaDon> lstHoaDon = session.createQuery("from HOADON where sdt='"+sdt+"'").getResultList();
			if(lstHoaDon != null)
				return lstHoaDon;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Transactional
	public List<HoaDon> TimKiemTheoNgayDat(String ngayBD, String ngayKT) {
		Session session = sessioFactory.getCurrentSession();
		try {
			List<HoaDon> lstHoaDon = session.createQuery("FROM HOADON where ngayLap BETWEEN CAST('"+ngayBD+"' AS DATE) AND CAST('"+ngayKT+"' AS DATE)").getResultList();
			if(lstHoaDon != null)
				return lstHoaDon;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Transactional
	public HoaDon showHD(int idHoaDon) {
		Session session = sessioFactory.getCurrentSession();
		try {
			HoaDon hoaDon = (HoaDon) session.createQuery("from HOADON where idHoaDon='"+idHoaDon+"'").uniqueResult();
			if(hoaDon != null)
				return hoaDon;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Transactional
	public String updateHD(int idHoaDon, Boolean TinhTrang) {
		Session session = sessioFactory.getCurrentSession();
		HoaDon hoaDon = session.get(HoaDon.class, idHoaDon);
		hoaDon.setTinhTrang(TinhTrang);	
		return "";
	}

	
}
