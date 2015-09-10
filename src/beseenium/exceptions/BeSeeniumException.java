package beseenium.exceptions;
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
 * the root class for the beseenium exception hierarchy
 * @author JPC Hanson
 *
 */
public abstract class BeSeeniumException extends Exception 
{
	/**
	 * Serialisation needed to avoid warnings
	 */
	private static final long serialVersionUID = 5427176352533290074L;
	
	/**
	 * default constructor
	 */
	protected BeSeeniumException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public BeSeeniumException(String message)
	{
		super(message);
	}
}
