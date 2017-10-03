package hello.testsupport;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebappTestSupport {

  private Server server;

  public void before() throws Exception {
    startIfNecessary();
  }

  public void after() throws Exception {
    shutdownIfNecessary();
  }

  public int localPort() {
    return ((ServerConnector)server.getConnectors()[0]).getLocalPort();
  }

  private void startIfNecessary() throws Exception {
    if (server != null) {
      return;
    }

    server = new Server(0);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setResourceBase("src/main/webapp");
    webapp.setExtraClasspath("out/production/classes");
    webapp.setParentLoaderPriority(true);

    Configuration.ClassList classlist = Configuration.ClassList
            .setServerDefault( server );
    classlist.addBefore(
            "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
            "org.eclipse.jetty.annotations.AnnotationConfiguration" );

    webapp.setAttribute(
            "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
            ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$" );
    
    server.setHandler(webapp);

    server.start();
  }

  private void shutdownIfNecessary() throws Exception {
    if (server == null) {
      return;
    }

    try {
      server.stop();
    } finally {
      server = null;
    }
  }

}
