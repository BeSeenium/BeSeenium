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
import java.util.Arrays;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionFactoryException;
import beseenium.exceptions.testExceptions.TestException;
import beseenium.view.helpers.StringSplit;

/**
 * represents a request to add a series of actions to a test.
 * @author Jan P.C. Hanson
 *
 */
public class AddActionsRequest extends AbstractTestRequest
{
	/**
	 * call super constructor passing in the appropriate request data.
	 * @param requestData
	 */
	public AddActionsRequest(String requestData)
	{
		super(requestData);		
	}

	/* (non-Javadoc)
	 * @see beseenium.view.inputHandlers.AbstractTestRequest#executeRequest()
	 * 
	 * \n addActions String of the form:
	 * "name+inputParam+optional|name+inputParam+optional|name+inputParam+optional|..."
	 * 
	 * \n return String of the form:
	 * "ACTIONS ADDED:"+"[[action1, inputParam1, index1],[action2, inputParam2, index2]...[actionN, inputParamN, indexN]]
	 */
	@Override
	public String executeRequest(Test test) 
			throws ActionDataException, NullPointerException, ActionFactoryException, 
			NumberFormatException, TestException
	{
		String[][] actions = new StringSplit().urlSplitString(super.requestData);
		String result="";
		
		for(String[] actionSet: actions)
		{
			if(actionSet.length == 3 )
			{
				test.addAction(actionSet[0], actionSet[1], Integer.parseInt(actionSet[2]));
			}
		
			else
			{
				throw new TestException("badly formatted addAction string: " 
								+ Arrays.deepToString(actionSet));
			}
			
			//format results
			result+="+"+actionSet[0]+","+actionSet[1]+","+actionSet[2]+"+";
		}
		
//		return "ACTIONS ADDED: " + Arrays.deepToString(actions) + "\n";
		return result;
	}
}
