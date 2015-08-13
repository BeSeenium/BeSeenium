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
package beseenium.view;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import beseenium.controller.Test;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.testExceptions.TestAlreadyExistsException;
import beseenium.exceptions.testExceptions.TestDoesNotExistException;

public class TestManager 
{
	/** holds the tests **/
	private Map<String, Test> tests;
	
	/**
	 * initialises the object data
	 */
	public TestManager()
	{
		tests = new HashMap<String, Test>();
	}
	
	/**
	 * adds a new test to the testManager
	 * @param testID the unique identifier of the test to add
	 * @throws TestAlreadyExistsException 
	 * @throws MalformedURLException 
	 * @throws ActionDataFactoryException 
	 */
	public void addTest(String testID) 
			throws TestAlreadyExistsException, ActionDataFactoryException, MalformedURLException
	{
		if (tests.containsKey(testID))
		{
			throw new TestAlreadyExistsException("cannot add a test who already exists");
		}
		else
		{
			tests.put(testID, new Test());
		}		
	}
	
	/**
	 * removes a test from the testManager
	 * @param testID the unique identifier of the test to remove
	 * @throws TestDoesNotExistException 
	 */
	public void removeTest(String testID) throws TestDoesNotExistException
	{
		if (tests.containsKey(testID)==false)
		{
			throw new TestDoesNotExistException("cannot remove a test that does not exist");
		}
		else
		{
			tests.remove(testID);
		}
	}
	
	/**
	 * gets the ActionController associated with a particular test
	 * @param testID the unique identifier of the test
	 * @return ActionController associated with a particular test
	 * @throws TestDoesNotExistException 
	 */
	public Test getTestContext(String testID) throws TestDoesNotExistException
	{
		if (tests.containsKey(testID)==false)
		{
			throw new TestDoesNotExistException("cannot get data for a test that does not exist");
		}
		else
		{
			return tests.get(testID);
		}
	}
}
