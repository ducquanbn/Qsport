package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="QSPORT")
public class QSport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idQSport;
	public int getIdQSport() {
		return idQSport;
	}
	public void setIdQSport(int idQSport) {
		this.idQSport = idQSport;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	String sdt;
	String email;
	String diaChi;
	String moTa;
}
