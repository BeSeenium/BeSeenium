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
				tempRes += elements.get(i).getTagName() + " , " +
						elements.get(i).getAttribute("id") +  " , " +
						elements.get(i).getAttribute("class") +  " , " +
						elements.get(i).getAttribute("name") +  " , " +
						elements.get(i).getAttribute("href") +  " , " +
						elements.get(i).toString()+"\n";
			}
		
		return tempRes;
		}
		
		else
		{
			return  elements.get(n).getTagName() + " , " +
					elements.get(n).getAttribute("id") +  " , " +
					elements.get(n).getAttribute("class") +  " , " +
					elements.get(n).getAttribute("name") +  " , " +
					elements.get(n).getAttribute("href") +  " , " +
					elements.get(n).toString()+"\n";
		}
		
	}
}
