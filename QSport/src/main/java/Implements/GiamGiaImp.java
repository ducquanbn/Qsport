package Implements;

import java.util.List;

import Entity.GiamGia;
import Entity.SanPham;

public interface GiamGiaImp {
	List<GiamGia> lstGiamGia();
	boolean themGiamGia(GiamGia giamgia);
	GiamGia showGG(int idGiamGia);
	String themspgg(int idGiamGia, SanPham sp);
	String xoaspgg(int idGiamGia, SanPham sp);
	String update(int idGiamGia, GiamGia gg);
}
