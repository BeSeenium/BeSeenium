package beseenium.action;

import java.util.ArrayList;
import java.util.List;
import beseenium.actionData.ActionData;
import beseenium.exceptions.ActionDataException;
import beseenium.exceptions.ActionException;

/**
 * This class acts as the invoker in a GOF command style pattern. It stores and
 * tries to execute a series of Actions loaded at runtime.
 * @author JPC Hanson
 *
 */
public class ActionController 
{
	private List<AbstractAction> actions;
	private List<String> inputParams;
	private List<Integer> optionalIndex;
	private ActionData context;
	private List<String> result;
	
	public ActionController()
	{
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
	 */
	public void remove()
	{
		int sizeOfList = actions.size()-1;
		this.actions.remove(sizeOfList);
		this.inputParams.remove(sizeOfList);
		this.optionalIndex.remove(sizeOfList);
	}
	
	/**
	 * iterates through the commands stored in the list and executes
	 * @return List<String> the results of the various actions, to be used in reporting.
	 * @throws ActionException 
	 * @throws ActionDataException 
	 */
	public List<String> execute() throws ActionDataException, ActionException
	{
		for (int i = 0; i < actions.size(); ++i)
		{
			AbstractAction individualAction = actions.get(i);
			String inputString = inputParams.get(i);
			int index = optionalIndex.get(i);
			
			context = individualAction.getActionData();
			context.setInputParam(inputString);
			result.add(individualAction.execute(index));		
		}
		
		return this.result;		
	}
}
