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
package beseenium;

import beseenium.view.HttpServer;

/**
 *This is the main entry point for the program, initial setup and configuration done here.
 *
 * @author Jan P.C. Hanson
 *
 */
public class Main
{
	/**
	 * passes the first command line argument to the http server, ostensibly the port number.
	 * @param args command line arguments.
	 */
	public static void main(String[] args)
	{
		HttpServer.launch(Integer.parseInt(args[0]));
	}
	
	
}
