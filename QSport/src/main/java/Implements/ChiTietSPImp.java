package Implements;

import java.util.List;

import Entity.ChiTietSanPham;
import Entity.Size;

public interface ChiTietSPImp {
	List<String> DsMau(int idSanPham);
	int kiemTraSLSanPham(int idSanPham,String hinhAnh,int idSize);
	String kiemTraSanPham(int idSanPham,int idMauSac);
	ChiTietSanPham showCTSP(int idChiTietSanPham);
	int layMaCTSP(int idSanPham,String hinhAnh,int idMauSac);
	String XoaSLSanPham(int idChiTietSanPham, int SoLuong);
	String ThemCTSP(ChiTietSanPham chiTietSanPham);
	List<ChiTietSanPham> layCTSPTheoIdSP(int idSanPham);
	int getMaCTSP(int idSanPham, int idMauSac, int idSize);
	String updateSoLuong(int idChiTietSanPham, int SoLuong);
}
