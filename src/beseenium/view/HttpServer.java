/** Copyright(C) 2015 Jan P.C. Hanson & BeSeen Marketing Ltd
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package beseenium.view;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;
//import org.eclipse.jetty.webapp.WebAppContext;
/**
 * This is the embedded Jetty Web Server, and the main entry point into the program
 * the server port is set by passing command line parameters on execution of the program.
 *
 * @author Jan P.C. Hanson
 *
 * @param args[0] the server port is set from this parameter
 */
public class HttpServer
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(Integer.valueOf(args[0]));
        
        
               
        //servlet handler
        ContextHandler context0 = new ContextHandler();
        context0.setContextPath("/results");        
        ServletContextHandler serv = new ServletContextHandler();
        serv.addServlet(beseenium.view.BeSeeniumServlet.class, "/*");
        context0.setHandler(serv);
       
        
        //gui handler
        ContextHandler context1 = new ContextHandler();
        context1.setContextPath("/");        
        ResourceHandler res = new ResourceHandler();
        res.setWelcomeFiles(new String[]{"index.html"});
        res.setBaseResource(Resource.newResource("./resources/"));
        context1.setHandler(res);
        
//        WebAppContext webApp = new WebAppContext();
//        webApp.setContextPath("/");
//        webApp.setResourceBase("/home/orpheus/projects/BeSeen/BeSeenium/resources/");
//        webApp.setWar("/home/orpheus/projects/BeSeen/BeSeenium/resources/quercus-4.0.18.war");
//        webApp.setServer(server);
       // context1.setHandler(webApp);
       
        //add handlers to collection
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { context1, context0});
 
        //give handler collection to server
        server.setHandler(contexts);
        server.setConnectors(new Connector[] {connector});
        
        server.start();
        server.join();
    }
    
   
}