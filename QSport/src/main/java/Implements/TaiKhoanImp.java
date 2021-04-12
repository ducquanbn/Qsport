package Implements;

import java.util.List;

import Entity.TaiKhoan;

public interface TaiKhoanImp {
	int KiemTraDangNhap(String user, String pass);
	TaiKhoan ShowTaiKhoan(int idTaiKhoan);
	boolean KiemTraDangKy(String user, String pass, int idQuyen);
	List<TaiKhoan> lstTK();
	int ShowTaiKhoanUser(String tenTaiKhoan);
	String update(TaiKhoan tk, int idTaiKhoan);
	boolean checkTrangThai(String user);
	String updateTrangThai(int idTaiKhoan, String trangThai);
}
