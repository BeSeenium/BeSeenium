
/**
 *	This is the root package for the ActionFactory implementation, similarly to the 
 *	ActionDataFactory, it is a factory method style implementation. However the inheritance
 *	hierarchy for this factory is much broader than that of ActionDataFactory, as such only 
 *	its Abstract base is located in the root package. All specialisations of MakeAction (the
 *	abstract base) are grouped in packages so that classes that make similar actions are 
 *	co-located. The package structure of the specialisations somewhat mirrors the structure 
 *	of the action package in the model.
 *
 * @author Jan P.C. Hanson
 *
 */
package beseenium.controller.ActionFactory;