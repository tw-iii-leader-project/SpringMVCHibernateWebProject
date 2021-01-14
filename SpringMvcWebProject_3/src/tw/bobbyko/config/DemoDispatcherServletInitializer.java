package tw.bobbyko.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DemoDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMVCJavaConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter();
		encodeFilter.setEncoding("UTF-8");
		encodeFilter.setForceEncoding(true);
		
		return new Filter[] {encodeFilter};
	}	

}
