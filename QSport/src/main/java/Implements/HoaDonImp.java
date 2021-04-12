package Implements;

import java.util.List;

import Entity.HoaDon;

public interface HoaDonImp {
	boolean ThemHoaDon(HoaDon hoaDon);
	List<HoaDon> lstHoaDon();
	List<HoaDon> TimKiemTheoUser(int idTaiKhoan);
	List<HoaDon> TimKiemTheoSDT(String sdt);
	List<HoaDon> TimKiemTheoNgayDat(String ngayBD, String ngayKT);
	HoaDon showHD(int idHoaDon);
	String updateHD(int idHoaDon,Boolean TinhTrang);
}
