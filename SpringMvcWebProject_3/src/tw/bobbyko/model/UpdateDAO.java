package tw.bobbyko.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean update(
			String user_acc,
			String user_pwd,
			String user_phone,
			String user_birth,
			String user_email) {
		// data prepared to update is stored in Bean: rBean.
		// method update is used to update data which is entered in database.

		Session session = sessionFactory.getCurrentSession();
		int id = getid(user_acc);
		// first step: use user_acc to get user_id to execute session.get() method.

//		String user_acc = "user_acc";
//		String hql = String.format("from Userdata where %s =?1", user_acc);

		// fixed up the user_acc to let user can only update his or her own data.

		Userdata userData = session.get(Userdata.class, id);

		userData.setUser_pwd(user_pwd);
		userData.setUser_phone(user_phone);
		userData.setBirthday(user_birth);
		userData.setEmail(user_email);
		
		
		return true;

	}

	public int getid(String user_acc) {

		Session session = sessionFactory.getCurrentSession();
		try {
			// String targetName = "userid";
			String tableName = "Userdata";
			String columnName = "user_acc";
			// String hqlsql = "from Login as l where l.username=?1";

			String hqlsql = String.format("from %s as l where l.%s=?1", tableName, columnName);
			Query<Userdata> query = session.createQuery(hqlsql, Userdata.class);
			query.setParameter(1, user_acc);

			System.out.println("SEARCH SUCCESS");

			int id0 = query.list().get(0).getUserid();
			System.out.println(id0);
			return id0;
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
			return -1;
		}
	}
}
