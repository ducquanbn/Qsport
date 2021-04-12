package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="MAUSAC")
public class MauSac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMauSac;
	public int getIdMauSac() {
		return idMauSac;
	}
	public void setIdMauSac(int idMauSac) {
		this.idMauSac = idMauSac;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	String tenMau;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idMauSac")
	List<ChiTietSanPham> lstCTSP;
	public List<ChiTietSanPham> getLstCTSP() {
		return lstCTSP;
	}
	public void setLstCTSP(List<ChiTietSanPham> lstCTSP) {
		this.lstCTSP = lstCTSP;
	}
}
