package Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name="PHANQUYEN")
public class PhanQuyen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idPhanQuyen;
	
	public int getIdPhanQuyen() {
		return idPhanQuyen;
	}

	public void setIdPhanQuyen(int idPhanQuyen) {
		this.idPhanQuyen = idPhanQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	String tenQuyen;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CHUCVU" ,
	joinColumns = { @JoinColumn(name="idPhanQuyen" , referencedColumnName = "idPhanQuyen") },
	inverseJoinColumns = {@JoinColumn(name="idTaiKhoan", referencedColumnName = "idTaiKhoan")})
	
	List<TaiKhoan> lstTaiKhoan;

	public List<TaiKhoan> getLstTaiKhoan() {
		return lstTaiKhoan;
	}

	public void setLstTaiKhoan(List<TaiKhoan> lstTaiKhoan) {
		this.lstTaiKhoan = lstTaiKhoan;
	}
	
}
