package tw.bobbyko.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	private LoginDAO lDAO;
		
	public boolean check(Userdata rBean) {
		return lDAO.check(rBean);
	}
}
