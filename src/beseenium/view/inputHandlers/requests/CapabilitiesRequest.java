package beseenium.view.inputHandlers.requests;
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
import java.net.MalformedURLException;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.testExceptions.TestException;
import beseenium.view.helpers.StringSplit;

/**
 * represents a request for a particular set of capabilities.
 * @author Jan P.C. Hanson
 *
 */
public class CapabilitiesRequest extends AbstractTestRequest
{
	/**
	 * call super constructor passing in the appropriate request data.
	 * @param requestData
	 */
	public CapabilitiesRequest(String requestData)
	{
		super(requestData);		
	}

	/* (non-Javadoc)
	 * @see beseenium.view.inputHandlers.AbstractTestRequest#executeRequest()
	 * 
	 * \n takes an input from servlet(via handleURL method) in the form of string 'get' URL parameter 
	 * 'capabilities' uses it to set the remoteDriver configuration, this is only of use when the 
	 * browser type is set as 'remote'.
	 * 
	 * \n takes a capabilities String of the form "key+value|key+value|key+value|..."
	 * 
	 * \n and returns a String of the form 
	 * "DESIRED CAPABILITES:" + "[[key1, value1], [key2, value2], [key3, value3]]"
	 */
	@Override
	public String executeRequest(Test test) 
			throws ActionDataException, NullPointerException, TestException, MalformedURLException
	{
		String[][] caps = new StringSplit().urlSplitString(super.requestData);
		String result="";
		
		for(String[] capabilitySet: caps)
		{
				if(capabilitySet.length == 2 )
				{
					test.configureRemoteDriver(capabilitySet[0], capabilitySet[1]);
				}
			
				else
				{
					throw new TestException("badly formatted capability string");
				}
				//format results
				result+=capabilitySet[0]+","+capabilitySet[1]+"~";
		}
//	return "DESIRED CAPABILITIES: "+Arrays.deepToString(caps) + "\n";
		return result;
	}
}
