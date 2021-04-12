package Implements;

import java.util.List;

import Entity.MauSac;

public interface MauSacImp {
	MauSac ShowMS(int idMau);
	List<MauSac> showDSMau();
	String themMau(MauSac mau);
	String updateMau(int idMauSac, String tenMau);
}
