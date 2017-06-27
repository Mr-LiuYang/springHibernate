package springHibernate.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by liuyang on 2017/6/24.
 */
public class RootConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(MvcConfiguration.class);
        context.register(DatabaseConfig.class);
        context.register(CacheConfig.class);
        ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }
}
