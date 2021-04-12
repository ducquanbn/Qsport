package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.ChiTietSanPham;
import Entity.Size;
import Implements.ChiTietSPImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietSPDao implements ChiTietSPImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<String> DsMau(int idSanPham) {
		Session session = sessionFactory.getCurrentSession();
		List<String> lstMau =  (List<String>) session.createQuery("select DISTINCT hinhAnh  from CHITIETSANPHAM where idSanPham='"+idSanPham+"'").getResultList();
		return lstMau ;
	}

	@Transactional
	public int kiemTraSLSanPham(int idSanPham, String hinhAnh, int idSize) {
		Session session = sessionFactory.getCurrentSession();
		try{
			ChiTietSanPham CTSP =  (ChiTietSanPham) session.createQuery("from CHITIETSANPHAM where idSanPham='"+idSanPham+"' and hinhAnh='"+ hinhAnh +"' and idSize='"+idSize+"'").getSingleResult();
			if(CTSP == null) {
				return -1;
			}else {
				if(CTSP.getSoLuongCon() < 1)
					return -1;
				else
					return CTSP.getSoLuongCon();
			}
		}catch (Exception e) {
			return -1;
		}
	}

	@Transactional
	public int layMaCTSP(int idSanPham, String hinhAnh, int idSize) {
		Session session = sessionFactory.getCurrentSession();
		try{
			ChiTietSanPham CTSP =  (ChiTietSanPham) session.createQuery("from CHITIETSANPHAM where idSanPham='"+idSanPham+"' and hinhAnh='"+ hinhAnh +"' and idSize='"+idSize+"'").getSingleResult();
			if(CTSP != null)
				return CTSP.getIdChiTietSanPham();
		}catch (Exception e) {
			return 0;
		}
		return 0;
	}

	@Transactional
	public int getMaCTSP(int idSanPham, int idMauSac, int idSize) {
		Session session = sessionFactory.getCurrentSession();
		try{
			ChiTietSanPham CTSP =  (ChiTietSanPham) session.createQuery("from CHITIETSANPHAM where idSanPham='"+idSanPham+"' and idMauSac='"+ idMauSac+"' and idSize='"+idSize+"'").getSingleResult();
			if(CTSP != null)
				return CTSP.getIdChiTietSanPham();
		}catch (Exception e) {
			return 0;
		}
		return 0;
	}
	
	@Transactional
	public String XoaSLSanPham(int idChiTietSanPham, int SoLuong) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietSanPham chiTietSanPham = session.get(ChiTietSanPham.class, idChiTietSanPham);
		int SLCu = chiTietSanPham.getSoLuongCon();
		int SLMoi = SLCu - SoLuong;
		chiTietSanPham.setSoLuongCon(SLMoi);
		session.update(chiTietSanPham);
		return "";
	}

	@Transactional
	public String ThemCTSP(ChiTietSanPham chiTietSanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		session.flush();
		session.save(chiTietSanPham);		
		return "";
	}

	@Transactional
	public List<ChiTietSanPham> layCTSPTheoIdSP(int idSanPham) {
		Session session = sessionFactory.getCurrentSession();
		List<ChiTietSanPham> lstCTSP =  (List<ChiTietSanPham>) session.createQuery("from CHITIETSANPHAM where idSanPham='"+idSanPham+"'").getResultList();
		return lstCTSP;
	}

	@Transactional
	public String updateSoLuong(int idChiTietSanPham, int SoLuong) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietSanPham ctsp = session.get(ChiTietSanPham.class, idChiTietSanPham);
		ctsp.setSoLuongCon(SoLuong);
		session.update(ctsp);
		return null;
	}

	@Transactional
	public String kiemTraSanPham(int idSanPham, int idMauSac) {
		Session session = sessionFactory.getCurrentSession();
		try{
			List<ChiTietSanPham> lstCTSP =  (List<ChiTietSanPham>) session.createQuery("from CHITIETSANPHAM where idSanPham='"+idSanPham+"' and idMauSac='"+ idMauSac +"'").getResultList();
			if(lstCTSP != null) {
				return lstCTSP.get(0).getHinhAnh();
			}
		}catch (Exception e) {
			
		}
		return "";
	}

	@Transactional
	public ChiTietSanPham showCTSP(int idChiTietSanPham) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietSanPham  ctsp=(ChiTietSanPham) session.createQuery("from CHITIETSANPHAM where idChiTietSanPham='"+idChiTietSanPham+"'").uniqueResult();
		return ctsp ;
	}

}
