import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHttpContext;

public class Start
{
    public static void main(String[] args) throws Exception
    {
        //A server running at http://localhost:8085 is created
        Server server = new Server();
        server.addListener(":8085");

        ServletHttpContext context = (ServletHttpContext) server.getContext("/");
        context.addServlet("/", "beseenium.view.Servlet");

        server.start();
    }
}