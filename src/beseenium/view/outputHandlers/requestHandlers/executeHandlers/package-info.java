/**
 * This package is responsible for the chain of responsibility that executes a Test after all
 * inputs have been checked for errors. If this class picks up exceptional behaviour it calls
 * the next handler in the chain and so on until the problem is handled.
 * 
 * in order to implement new exceptional behaviour cases a new child class of 
 * AbstractRequestHandler should be created containing the code to handle this case, then the
 * RootExecuteHandler class should be modified to add this new class to the chain.
 * 
 * @author Jan P.C. Hanson
 *
 */
package beseenium.view.outputHandlers.requestHandlers.executeHandlers;