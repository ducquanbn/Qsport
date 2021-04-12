package Implements;

import java.util.List;

import Entity.DanhMuc;

public interface DanhMucImp {
	List<DanhMuc> ShowDanhMuc();
	DanhMuc HTDanhMuc(int idDanhMuc);
	String themDanhMuc(DanhMuc danhMuc);
	String updateDanhMuc(int  idDanhMuc, String tenDanhMuc);
}
