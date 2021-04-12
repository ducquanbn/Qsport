package Entity;

import java.sql.Date;
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

@Entity(name="GIAMGIA")
public class GiamGia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idGiamGia;
	public int getIdGiamGia() {
		return idGiamGia;
	}
	public void setIdGiamGia(int idGiamGia) {
		this.idGiamGia = idGiamGia;
	}
	public String getTenGiamGia() {
		return tenGiamGia;
	}
	public void setTenGiamGia(String tenGiamGia) {
		this.tenGiamGia = tenGiamGia;
	}

	public int getSoTienGiam() {
		return soTienGiam;
	}
	public void setSoTienGiam(int soTienGiam) {
		this.soTienGiam = soTienGiam;
	}
	public String getThoiGianBD() {
		return thoiGianBD;
	}
	public void setThoiGianBD(String thoiGianBD) {
		this.thoiGianBD = thoiGianBD;
	}
	public String getThoiGianKT() {
		return thoiGianKT;
	}
	public void setThoiGianKT(String thoiGianKT) {
		this.thoiGianKT = thoiGianKT;
	}
	String tenGiamGia;
	String thoiGianBD;
	String thoiGianKT;
	int soTienGiam;
	
	public Set<SanPham> getListSanPham() {
		return listSanPham;
	}
	public void setListSanPham(Set<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="CHITIETGIAMGIA" ,
	joinColumns = { @JoinColumn(name="idGiamGia" , referencedColumnName = "idGiamGia") },
	inverseJoinColumns = {@JoinColumn(name="idSanPham", referencedColumnName = "idSanPham")})
	Set<SanPham> listSanPham;
}
