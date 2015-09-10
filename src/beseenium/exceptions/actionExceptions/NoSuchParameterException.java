package beseenium.exceptions.actionExceptions;
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
 * specific action exception does what it says on the tin.
 *
 * @author Jan P.C. Hanson
 *
 */
public class NoSuchParameterException extends ActionException 
{
	
	/**
	 * serialisation needed to avoid warnings
	 */
	private static final long serialVersionUID = -4253915626939934718L;

	public NoSuchParameterException()
	{
		super();
	}
	
	/**
	 * instsnciate excecption with message 
	 * @param message string to display
	 */
	public NoSuchParameterException(String message)
	{
		super(message);
	}
}
