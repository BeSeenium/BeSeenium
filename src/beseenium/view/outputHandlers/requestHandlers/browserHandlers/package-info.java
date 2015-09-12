/**
 * This package contains all classes relevant to the chain of responsibility that processes
 * the 'browser' url query string. The RootBrowserHandler class is the start of the chain and
 * is responsible for the case where there are no errors or issues with the input. Passing it 
 * down the chain to the other handlers should an error occur.
 * 
 * in order to implement new exceptional behaviour cases a new child class of 
 * AbstractRequestHandler should be created containing the code to handle this case, then the
 * RootBrowserHandler class should be modified to add this new class to the chain.
 * 
 * @author Jan P.C. Hanson
 *
 */
package beseenium.view.outputHandlers.requestHandlers.browserHandlers;