package Implements;

import java.util.List;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonId;

public interface ChiTietHoaDonImp {
	boolean ThemChiTietHD(ChiTietHoaDon CTHD);
	List<ChiTietHoaDon> lstCTHD(int idHoaDon);
}
