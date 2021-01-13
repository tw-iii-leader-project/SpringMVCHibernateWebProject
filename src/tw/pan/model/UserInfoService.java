package tw.pan.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoService {
	
	private UserInfoDao uDao;
	
	@Autowired
	public UserInfoService(UserInfoDao uDao) {
		this.uDao = uDao;
	}
	
	public UserInfo select(String userid) {
		return uDao.select(userid);
	}
}
