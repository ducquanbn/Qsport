package Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="DANHMUC")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idDanhMuc;
	
	public int getIdDanhMuc() {
		return idDanhMuc;
	}

	public void setIdDanhMuc(int idDanhMuc) {
		this.idDanhMuc = idDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	String tenDanhMuc;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idDanhMuc")
	Set<SanPham> ListsanPham;

	public Set<SanPham> getListsanPham() {
		return ListsanPham;
	}

	public void setListsanPham(Set<SanPham> listsanPham) {
		ListsanPham = listsanPham;
	}
	
}
