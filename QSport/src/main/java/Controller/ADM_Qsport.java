package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Entity.QSport;
import Services.QSportSer;
import Services.TaiKhoanSer;

@Controller
@RequestMapping("/admin/Qsport")
public class ADM_Qsport {

	@Autowired
	QSportSer qSportSer;
	@Autowired
	TaiKhoanSer taiKhoanSer;
	@GetMapping
	String Defaut(HttpSession httpSession,ModelMap mdMap) {
		if(httpSession.getAttribute("TaiKhoan") == null) {
			return "error";
		}
		String tenHT =(String) httpSession.getAttribute("TaiKhoan");
		mdMap.addAttribute("tenHT", tenHT);
		int idTK =  (Integer) httpSession.getAttribute("idTaiKhoan");
		if(!taiKhoanSer.ShowTaiKhoan(idTK).getPhanQuyen().getTenQuyen().equals("Quản trị")) {
			return "error";
		}
		
		mdMap.addAttribute("Q", qSportSer.showQSport());
		return "ADM_Qsport";
	}
	
	@GetMapping("/Sua")
	@ResponseBody
	String suaQsport(@RequestParam String sdt, @RequestParam String email, @RequestParam String diachi, @RequestParam String mota) {
		QSport qsport = new QSport();
		qsport.setSdt(sdt);
		qsport.setDiaChi(diachi);
		qsport.setEmail(email);
		qsport.setMoTa(mota);
		qSportSer.updateQsport(qsport);
		return "";
	}
}
