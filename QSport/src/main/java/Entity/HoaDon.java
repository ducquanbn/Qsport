package Entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="HOADON")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idHoaDon;
	public int getIdHoaDon() {
		return idHoaDon;
	}


	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}


	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public String getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}


	@Column(name = "ngayLap", nullable=false)
	String ngayLap;
	Boolean tinhTrang;
	String sdt;
	String diaChi;
	String hinhThucNhan;
	public String getHinhThucNhan() {
		return hinhThucNhan;
	}


	public void setHinhThucNhan(String hinhThucNhan) {
		this.hinhThucNhan = hinhThucNhan;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	String tenKhachHang;
	public String getTenKhachHang() {
		return tenKhachHang;
	}


	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	String ghiChu;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idTaiKhoan")
	TaiKhoan TaiKhoan;
	public TaiKhoan getTaiKhoan() {
		return TaiKhoan;
	}
	
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idHoaDon")
	Set<ChiTietHoaDon> lstCTHD;
	public Set<ChiTietHoaDon> getLstCTHD() {
		return lstCTHD;
	}


	public void setLstCTHD(Set<ChiTietHoaDon> lstCTHD) {
		this.lstCTHD = lstCTHD;
	}
}
