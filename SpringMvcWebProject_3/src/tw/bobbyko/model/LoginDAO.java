package tw.bobbyko.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean check(Userdata rBean) {
		// method checkExist is used to check whether the account is already created.
		Session session = sessionFactory.getCurrentSession();

		String target_1 = "user_acc";
		String target_2 = "user_pwd";

		String hql = String.format("from Userdata as u where u.%s =?1 and u.%s =?2", target_1, target_2);

		System.out.println("Search Start.");

		Query<Userdata> query = session.createQuery(hql, Userdata.class);
		query.setParameter(1, rBean.getUser_acc());
		query.setParameter(2, rBean.getUser_pwd());

		return !query.list().isEmpty();

		// if line35 return true, means there is acc and pwd existed in database, and
		// accept to login.
	}
}
