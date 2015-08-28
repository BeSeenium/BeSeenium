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
package beseenium.view.helpers;

/**
 * helper class that splits a string into an appropriate 2d array of strings.
 * @author Jan P.C. Hanson
 *
 */
public class URLStringSplit
{
	/**
	 * default constructor
	 */
	public URLStringSplit()
	{super();}
	
	/**
	 * split a string of the form "V01:V02:...:V0n|V11:V12:...:V1n|Vm1:Vm2:...:Vmn" into a 
	 * 2d String array of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 * @param string of the form "V01:V02:...:V0n|V11:V12:...:V1n|Vm1:Vm2:...:Vmn"
	 * @return String[][] of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 */
	public String[][] splitString(String stringToSplit)
	{
		String[] firstSplit = stringToSplit.split("\\|"); //={"key:value", "key:value"}
		int split1Len = firstSplit.length;
		int split2Len = firstSplit[0].split(" ").length;
		String[][] resultArray = new String[split1Len][split2Len];// = {{"key","value"},{"key","value"}};
		
		for(int i = 0; i < firstSplit.length; ++i)
		{
			resultArray[i]=firstSplit[i].split(" ");
		}
		return resultArray;
	}
}
