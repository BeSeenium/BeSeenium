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
package beseenium.view.outputHandlers.requestHandlers;

/**
 * abstract base for a chain of responsibility that takes abstractTestRequests
 * and uses them to generate output in various forms: log messages, User messages,
 * as well as taking care of exception handling.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractRequestHandler
{
	/** reference to the successor object **/
	private AbstractRequestHandler successor;
	
	/**
	 * sets the next concrete request handler in the chain.
	 * @param requestHandler
	 */
	public abstract void setSuccessor(AbstractRequestHandler successor);
	
	/**
	 * provides implemntation to handle the request.
	 * @return
	 */
	public abstract String handleRequest();
}
