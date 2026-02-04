package org.stylizedsubstance.mybank;

import jakarta.servlet.ServletContext;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.stylizedsubstance.mybank.context.ApplicationConfiguration;

public class ApplicationLauncher {
    public static void main() throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        // Try to get custom port from command line
        int port;
        try {
            port = Integer.parseInt(System.getProperty("Dserver.port"));
        } catch (NumberFormatException e) {
            port = 8080;
        }

        tomcat.setPort(port);
        tomcat.getConnector();

        Context tomcatCtx = tomcat.addContext("", null);
        WebApplicationContext appCtx = createApplicationContext(tomcatCtx.getServletContext());
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);
        Wrapper servlet = Tomcat.addServlet(tomcatCtx, "dispatcherServlet", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

    public static WebApplicationContext createApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ApplicationConfiguration.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        ctx.registerShutdownHook();
        return ctx;
    }
}
