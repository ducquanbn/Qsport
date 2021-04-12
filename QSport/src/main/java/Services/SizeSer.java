package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.SizeDao;
import Entity.Size;
import Implements.SizeImp;

@Service
public class SizeSer implements SizeImp {

	@Autowired
	SizeDao sizeDao;
	
	public List<Size> lstSize() {		
		return sizeDao.lstSize();
	}

	public Size showSize(int idSize) {
		// TODO Auto-generated method stub
		return sizeDao.showSize(idSize);
	}

	public String themSize(Size size) {
		// TODO Auto-generated method stub
		sizeDao.themSize(size);
		return null;
	}

	public String updateSize(int idSize, String tenSize) {
		// TODO Auto-generated method stub
		return sizeDao.updateSize(idSize, tenSize);
	}

}
