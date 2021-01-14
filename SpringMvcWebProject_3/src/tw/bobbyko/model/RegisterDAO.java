package tw.bobbyko.model;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Userdata insert(Userdata rBean) {
		Session session = sessionFactory.getCurrentSession();
		if (rBean != null) {
			session.save(rBean);
		}
		return rBean;
	}

	public boolean checkExist(Userdata rBean) {
		// method checkExist is used to check whether the account is already created.
		Session session = sessionFactory.getCurrentSession();

		
		String target = "user_acc";
		String hql = String.format("from Userdata where %s =?1", target);
				
		System.out.println("Search Start.");
		
		
		return session.createQuery(hql, Userdata.class).setParameter(1, rBean.getUser_acc()).list().isEmpty();
		
		// if RHS is null, it means there is no such account exist, so it is OK to use.
	}
}
