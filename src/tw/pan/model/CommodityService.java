package tw.pan.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commodityService")
public class CommodityService {

	private CommodityDao cDao;
	
	@Autowired
	public CommodityService(CommodityDao cDao) {
		this.cDao = cDao;
	}
	
	public Commodity insert(Commodity com) {
		return cDao.insert(com);
	}

	public Commodity select(String comName) {
		return cDao.select(comName);
	}
	
	public List<Commodity> selectAll(){
		return cDao.selectAll();
	}
	
	public Commodity update(Commodity com) {
		return cDao.update(com);
	}
	
	public boolean delete(String comName) {
		return cDao.delete(comName);
	}
}
