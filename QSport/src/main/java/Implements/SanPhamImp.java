package Implements;

import java.util.List;

import Entity.SanPham;

public interface SanPhamImp {
	List<SanPham> showSanPham();
	List<SanPham> showSanPhamIndex();
	SanPham LayChiTietSP(int idSanPham);
	boolean XoaSanPham(int idSanPham);
	List<SanPham> showSanPhamLimt(int soBatDau);
	boolean ThemSanPham(SanPham sp);
	boolean SuaSanPham(SanPham sp);
	List<SanPham> TimKiem(String tenSanPham);
	String updateSoLuongBan(int idSanPham, int sl);
	List<SanPham> showSanPhamBanChay();
}
