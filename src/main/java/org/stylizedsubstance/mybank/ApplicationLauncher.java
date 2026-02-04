package org.stylizedsubstance.mybank;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.stylizedsubstance.mybank.web.MyBankServlet;

public class ApplicationLauncher {
    static void main() throws LifecycleException {
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

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myBankServlet", new MyBankServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }
}
