/**
 * This package holds the compositors which are used by the output handler to compose the 
 * result strings into the format requested by the user. The hierarchy is based around the 
 * AbstractCompositor abstract base class which provides default construction to the derived
 * classes. Derived classes are specialised to individual result types i.e. execution results, 
 * addAction results, capability results and browser results.
 * 
 * @author Jan P.C. Hanson
 *
 */
package beseenium.view.outputHandlers.compositors;