package beseenium.view;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import beseenium.controller.TestController;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.testExceptions.TestAlreadyExistsException;
import beseenium.exceptions.testExceptions.TestDoesNotExistException;

public class TestManager 
{
	/** holds the ActionController for each test **/
	private Map<String, TestController> tests;
	
	/**
	 * initialises the object data
	 */
	public TestManager()
	{
		tests = new HashMap<String, TestController>();
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
			tests.put(testID, new TestController());
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
	public TestController getTestContext(String testID) throws TestDoesNotExistException
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
