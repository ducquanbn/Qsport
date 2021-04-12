package Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="SANPHAM")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSanPham;
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public DanhMuc getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getKieuDang() {
		return kieuDang;
	}
	public void setKieuDang(String kieuDang) {
		this.kieuDang = kieuDang;
	}
	public String getMauSacGiay() {
		return mauSacGiay;
	}
	public void setMauSacGiay(String mauSacGiay) {
		this.mauSacGiay = mauSacGiay;
	}
	public String getChatLuong() {
		return chatLuong;
	}
	public void setChatLuong(String chatLuong) {
		this.chatLuong = chatLuong;
	}
	
	
	@OneToOne
	@JoinColumn(name="idDanhMuc")
	DanhMuc danhMuc;
	
	public Set<GiamGia> getListGiamGia() {
		return listGiamGia;
	}
	public void setListGiamGia(Set<GiamGia> listGiamGia) {
		this.listGiamGia = listGiamGia;
	}
	String chatLieu;
	String kieuDang;
	String mauSacGiay;
	String chatLuong;
	String hinhAnh;
	String tenSanPham;
	int Gia;
	int soLuongBan;
	public int getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idSanPham")
	Set<ChiTietSanPham> listCTSP;
	
	public Set<ChiTietSanPham> getListCTSP() {
		return listCTSP;
	}
	public void setListCTSP(Set<ChiTietSanPham> listCTSP) {
		this.listCTSP = listCTSP;
	}
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="CHITIETGIAMGIA" ,
	joinColumns = { @JoinColumn(name="idSanPham" , referencedColumnName = "idSanPham") },
	inverseJoinColumns = {@JoinColumn(name="idGiamGia", referencedColumnName = "idGiamGia")})
	Set<GiamGia> listGiamGia;
}
