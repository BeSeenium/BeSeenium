import org.mortbay.http.handler.ResourceHandler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHttpContext;



public class Start
{
    public static void main(String[] args) throws Exception
    {
    
        Server server = new Server();
        server.addListener(":"+args[0]);
        
       
        ServletHttpContext context = (ServletHttpContext) server.getContext("/");
        context.addServlet("/", "beseenium.view.Servlet");
       
     
        
        server.start();
        server.join();
    }
    
   
}