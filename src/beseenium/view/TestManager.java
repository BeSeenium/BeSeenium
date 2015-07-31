package beseenium.view;

import java.util.HashMap;
import java.util.Map;

import beseenium.controller.ActionController;
import beseenium.exceptions.testExceptions.TestAlreadyExistsException;
import beseenium.exceptions.testExceptions.TestDoesNotExistException;

public class TestManager 
{
	/** holds the ActionController for each test **/
	private Map<String, ActionController> tests;
	
	/**
	 * initialises the object data
	 */
	public TestManager()
	{
		tests = new HashMap<String, ActionController>();
	}
	
	/**
	 * adds a new test to the testManager
	 * @param testID the unique identifier of the test to add
	 * @throws TestAlreadyExistsException 
	 */
	public void addTest(String testID) throws TestAlreadyExistsException
	{
		if (tests.containsKey(testID))
		{
			throw new TestAlreadyExistsException("cannot add a test who already exists");
		}
		else
		{
			tests.put(testID, new ActionController());
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
	public ActionController getTestContext(String testID) throws TestDoesNotExistException
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
