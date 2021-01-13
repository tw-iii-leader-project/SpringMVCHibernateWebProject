package tw.pan.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("commodityDao")
public class CommodityDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public CommodityDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//INSERT
	public Commodity insert(Commodity com) {
		Session session = sessionFactory.getCurrentSession();
		String tableName = "Commodity";
		String columnName = "comName";
		String hqlsql = String.format("from %s as l where %s =?1", tableName,columnName);
		
		Query<Commodity> query = session.createQuery(hqlsql,Commodity.class);
		query.setParameter(1, com.getComName());
		if(query.list().isEmpty()) {
			session.save(com);
			System.out.println("Add Success!!!");
			return com;
		}
		else {
			System.out.println("Date add failed!!!");
			return null;
		}
	}

	//SELECT
	public Commodity select(String comName) {
		Session session = sessionFactory.getCurrentSession();
		String tableName = "Commodity";
		String columnName = "comName";
		String hqlsql = String.format("from %s as l where %s =?1", tableName,columnName);
		
		Query<Commodity> query = session.createQuery(hqlsql,Commodity.class);
		Commodity cBean = query.uniqueResult();
		if (cBean != null) {
			cBean.getComId();
			cBean.getComName();
			cBean.getPrice();
			System.out.println("This is you need!!!");
			return cBean;
			
		} else {
			System.out.println("No Answer");
			return cBean;
		}

	}

	//SELECTALL
	public List<Commodity> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Commodity> query = session.createQuery("from Commodity", Commodity.class);
		System.out.println("There are you need!!!");
		return query.list();
	}
	
	//UPDATE
	public Commodity update(Commodity com) {
		Session session = sessionFactory.getCurrentSession();
		Commodity cBean = session.get(Commodity.class, com.getComId());
		if (cBean != null) {
			cBean.setComName(com.getComName());
			cBean.setPrice(com.getPrice());
			System.out.println("Information has been updated!!!");
			return cBean;
		} else {
			System.out.println("Update failed!!!");
			return cBean;
		}
	}

	//DELETE
	public boolean delete(String comName) {
		Session session = sessionFactory.getCurrentSession();
		String tableName = "Commodity";
		String columnName = "comName";
		String hqlsql = String.format("from %s as l where %s =?1", tableName,columnName);
		
		Query<Commodity> query = session.createQuery(hqlsql,Commodity.class);
		query.setParameter(1, comName);
		Commodity cBean = query.uniqueResult();
		if (cBean != null) {
			session.delete(cBean);
			System.out.println("Informatiom has been deleted!!!");
			return true;
		} else {
			System.out.println("Delete failed!!!");
			return false;
		}
	}
	}

