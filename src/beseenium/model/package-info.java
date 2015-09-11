/**
 * This is the root package for the Model module of the BeSeenium application, it contains all
 * the classes related to the data model. The model is comprised of a GOF command style pattern
 * with the client being the controller module the ActionInvoker taking the role of invoker, 
 * AbstractAction taking the role of abstract command object and its derived classes are 
 * concrete command objects. The Reciever of these commands is the functionality exposed by 
 * the Selenium WebDriver API. Information on Selenium can be found at 
 * <a href="http://www.seleniumhq.org/" target="_blank">www.seleniumhq.org</a>
 * 
 * This package contains only the ActionInvoker, the command objects are located in the action
 * sub-package, and there is a helper sub-package that contains helper classes that do not 
 * fit neatly into the rest of the design.
 * 
 * @author Jan P.C. Hanson
 *
 */
package beseenium.model;