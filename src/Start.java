import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;



public class Start
{
    public static void main(String[] args) throws Exception
    {
    
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(Integer.valueOf(args[0]));
        server.setConnectors(new Connector[] {connector});
        
               
       
        ContextHandler context0 = new ContextHandler();
        context0.setContextPath("/");
        
        ServletContextHandler serv = new ServletContextHandler();
        serv.addServlet(beseenium.view.Servlet.class, "/*");
        context0.setHandler(serv);
       
        
        
        ContextHandler context1 = new ContextHandler();
        context1.setContextPath("/home");
        
        ResourceHandler res = new ResourceHandler();
        res.setBaseResource(Resource.newResource("./resources/"));
        context1.setHandler(res);
       
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { context1, context0});
 
        server.setHandler(contexts);
        
        
        server.start();
        server.join();
    }
    
   
}