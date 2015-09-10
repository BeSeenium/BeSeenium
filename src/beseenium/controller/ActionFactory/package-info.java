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