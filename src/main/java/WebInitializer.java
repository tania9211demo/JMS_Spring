import config.ApplicationConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by tatiana.biliaieva on 5/10/2016.
 */
public class WebInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    servletContext.addListener(new ContextLoaderListener(context));
    context.register(ApplicationConfig.class);

    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
                                                                    new DispatcherServlet(context));
    servlet.addMapping("/*");
    servlet.setLoadOnStartup(1);
  }
}
