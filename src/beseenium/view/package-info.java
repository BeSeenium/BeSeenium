/**
 * This is the root package for the View module of the application. It contains the classes 
 * responsible for providing graphical output in the form of web pages. For the most part the
 * view is based around a Jetty implementation. The HttpServer is responsible for doing servery
 * type stuff: listening for connections, and passing connections through to the servlet's.
 * 
 * The BeSeenmiumServlet is a servlet implementation that takes http requests and turns them 
 * into output that will be displayed on the users browser. It does this using the functionality
 * provided by the sub-packages under this one.
 * 
 * @author Jan P.C. Hanson
 *
 */
package beseenium.view;