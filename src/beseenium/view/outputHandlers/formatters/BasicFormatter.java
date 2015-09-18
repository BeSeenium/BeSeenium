package beseenium.view.outputHandlers.formatters;
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
 * This class is responsible for doing the basic output formatting for the results of a test. 
 * The purpose of this being that other output formatters can then transform the output from 
 * this class into the format the user has requested.
 * @author Jan P.C. Hanson
 *
 * \todo implement BasicFormatter properly
 */
public class BasicFormatter implements AbstractOutputFormatter
{
	/**
	 * default constructor
	 */
	public BasicFormatter()
	{super();}

	/* (non-Javadoc)
	 * @see beseenium.view.outputFormatters.AbstractOutputFormatter#asKeyVal(java.lang.String, java.lang.String)
	 */
	@Override
	public String asKeyVal(String key, String val, String delimiter)
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see beseenium.view.outputFormatters.AbstractOutputFormatter#asKVset(java.lang.String, java.lang.String)
	 */
	@Override
	public String asKVset(String label, String stringToFormat, String delimiter)
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see beseenium.view.outputFormatters.AbstractOutputFormatter#asKVsuperSet(java.lang.String, java.lang.String)
	 */
	@Override
	public String asKVsuperSet(String label, String stringToFormat, String delimiter)
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see beseenium.view.outputFormatters.AbstractOutputFormatter#finalForm(java.lang.String, java.lang.String)
	 */
	@Override
	public String finalForm(String label, String stringToFormat, String delimiter)
	{
		
		return null;
	}
	
	
}
