package beseenium.model.helpers;

import java.util.List;

import org.openqa.selenium.WebElement;

public class FormatOutput 
{
	/**
	 * formats the output string of a findElementBy... output string
	 * @return
	 */
	public static String formatFindElementOutput(List<WebElement> elements, int n)
	{
		String tempRes = "";
		
		if(n == -1)
		{
			for(int i=0; i< elements.size(); ++i)
			{
				tempRes += elements.get(i).toString()+" , ";
			}
		
		return tempRes;
		}
		
		else
		{
			return elements.get(n).toString();
		}
		
	}
}
