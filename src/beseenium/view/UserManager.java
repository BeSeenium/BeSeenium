package beseenium.view;

import java.util.HashMap;
import java.util.Map;

import beseenium.controller.ActionController;

public class UserManager 
{
	/** holds the ActionController for each user **/
	private Map<String, ActionController> users;
	
	/**
	 * initialises the object data
	 */
	public UserManager()
	{
		users = new HashMap<String, ActionController>();
	}
	
	/**
	 * adds a new user to the UserManager
	 * @param userID the unique identifier of the user to add
	 */
	public void addUser(String userID)
	{
		if (users.containsKey(userID))
		{
			throw new UserAlreadyExistsException("cannot add a user who already exists");
		}
		else
		{
			users.put(userID, new ActionController());
		}		
	}
	
	/**
	 * removes a user from the UserManager
	 * @param userID the unique identifier of the user to remove
	 */
	public void removeUser(String userID)
	{
		if (users.containsKey(userID)==false)
		{
			throw new UserDoesNotExistException("cannot remove a user that does not exist");
		}
		else
		{
			users.remove(userID);
		}
	}
	
	/**
	 * gets the ActionController associated with a particular user
	 * @param userID the unique identifier of the user
	 * @return ActionController associated with a particular user
	 */
	public ActionController getUserContext(String userID)
	{
		if (users.containsKey(userID)==false)
		{
			throw new UserDoesNotExistException("cannot get data for a user that does not exist");
		}
		else
		{
			return users.get(userID);
		}
	}
}
