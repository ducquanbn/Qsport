package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="SIZE")
public class Size {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSize;
	public int getIdSize() {
		return idSize;
	}
	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}
	public String getTenSize() {
		return tenSize;
	}
	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}
	String tenSize;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSize")
	List<ChiTietSanPham> lstCTSP;
}
