package tw.pan.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public class UserInfoDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public UserInfoDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public UserInfo select(String userid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserInfo.class, userid);
	}
	

	
}
