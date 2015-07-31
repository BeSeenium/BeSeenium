package beseenium;

import java.net.MalformedURLException;

import beseenium.controller.ActionController;
import beseenium.exceptions.actionDataExceptions.ActionDataException;
import beseenium.exceptions.actionDataExceptions.ActionDataFactoryException;
import beseenium.exceptions.actionExceptions.ActionException;

public class Run 
{
	public static void main(String[] args) throws MalformedURLException, ActionDataException, ActionException
	{
		ActionController controller = new ActionController();
		try 
		{
			controller.setBrowser("firefox");
			controller.addAction("PageGet", "www.google.com", 0);
			controller.addAction("BrowserQuit", "", 0);
			controller.executeActions();
		} 
		
		catch (ActionDataException | ActionException e) 
		{
			e.printStackTrace();
			controller.emergencyShutdown();
		}
	}
}
