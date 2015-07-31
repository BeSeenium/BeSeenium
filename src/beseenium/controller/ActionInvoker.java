package beseenium.controller;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionExceptions.ActionException;
import beseenium.model.action.AbstractAction;
import beseenium.model.actionData.ActionData;

/**
 * This class acts as the invoker in a GOF command style pattern. It stores and
 * tries to execute a series of Actions loaded at runtime.
 * @author JPC Hanson
 *
 */
public class ActionInvoker 
{
	private List<AbstractAction> actions;
	private List<String> inputParams;
	private List<Integer> optionalIndex;
	private WebDriver driver;
	
	/**
	 * @throws ActionDataException 
	 * 
	 */
	public ActionInvoker(ActionData actionData) throws ActionDataException
	{
		this.driver = actionData.getDriver();
		this.actions = new ArrayList<AbstractAction>();
		this.inputParams = new ArrayList<String>();
		this.optionalIndex = new ArrayList<Integer>();
	}

	/**
	 * Adds an abstract action to the action queue, each action may have an input parameter
	 * and an index n. 
	 * @param action an AbstractAction derived type.
	 * @param inputParam dependant on the Action being performed.
	 * @param n dependant on the Action being performed.
	 */
	public void add(AbstractAction action, String inputParam, int n)
	{
		this.actions.add(action);
		this.inputParams.add(inputParam);
		this.optionalIndex.add(n);
	}
	
	/**
	 * removes the last Action and associated parameters
	 * @param actionToRemove the action to remove with 0 being the first action
	 */
	public void remove(int actionToRemove)
	{
		this.actions.remove(actionToRemove);
		this.inputParams.remove(actionToRemove);
		this.optionalIndex.remove(actionToRemove);
	}
	
	/**
	 * iterates through the commands stored in the list and executes
	 * @return List<String> the results of the various actions, to be used in reporting.
	 * @throws ActionException 
	 * @throws ActionDataException 
	 * 
	 */
	public List<String> execute() throws ActionDataException, ActionException
	{
		ActionData context;
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < actions.size(); ++i)
		{
			AbstractAction individualAction = actions.get(i);
			String inputString = inputParams.get(i);
			int index = optionalIndex.get(i);
						
			context = individualAction.getActionData();
			context.setInputParam(inputString);
			context.setDriver(driver);
		
			result.add(individualAction.execute(index));		
		}
		
		return result;		
	}
}
