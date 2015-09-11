/**
 * This package contains classes relevant to handling the user input, as well as sub-packages
 * That aid in this.
 * 
 * User input comes into the servlet in the form of URL query string parameters, this package,
 * with the aid of its sub-packages turns this into request objects, storing them as a map and
 * returning this map. This map can then be used by its calling object (the servlet) to perform,
 * various tasks on using these stored request objects.
 * 
 * @author Jan P.C. Hanson
 *
 */
package beseenium.view.inputHandlers;