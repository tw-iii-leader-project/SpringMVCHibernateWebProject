package tw.pan.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebFilter("/*")
public class OpenSessionViewFilter implements Filter {

	private SessionFactory sessionFactory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//String SessionFactoryBeanName = filterConfig.getInitParameter("SessionFactoryBeanName");
		ServletContext application = filterConfig.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
		sessionFactory = context.getBean("sessionFactory",SessionFactory.class);
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin.");
			
			chain.doFilter(request, response);
			
			session.getTransaction().commit();
			System.out.println("Transaction Commit.");
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction Rollback.");
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed.");
		}
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}


}










