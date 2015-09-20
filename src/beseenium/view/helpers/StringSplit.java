package beseenium.view.helpers;
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
import beseenium.helpers.CopyrightIgnore; 
/**
 * helper class that splits a string into an appropriate 2d array of strings.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public class StringSplit
{
	/**
	 * default constructor
	 */
	public StringSplit()
	{super();}
	
	/**
	 * split a string of the form "V01 V02 ... V0n|V11 V12 ... V1n|Vm1 Vm2 ... Vmn" into a 
	 * 2d String array of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 * @param stringToSplit string of the form "V01 V02 ... V0n|V11 V12:... V1n|Vm1 Vm2 ... Vmn"
	 * @return String[][] of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 */
	public String[][] urlSplitString(String stringToSplit)
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
	
	/**
	 * split a string according to 2 delimiters, produces a 2d array
	 * @param stringToSplit the string to split
	 * @param split1Regex first string to split at
	 * @param split2Regex second string to split at
	 * @return String[][] of the form {{V01,V02...V0n},{V11,V12...V1n}...{Vm1, Vm2... Vmn}}
	 */
	public static String[][] generic2d(String stringToSplit, String split1Regex, String split2Regex)
	{
		String[] firstSplit = stringToSplit.split(split1Regex); //={"key:value", "key:value"}
		int split1Len = firstSplit.length;
		int split2Len = firstSplit[0].split(split2Regex).length;
		String[][] resultArray = new String[split1Len][split2Len];// = {{"key","value"},{"key","value"}};
		
		for(int i = 0; i < firstSplit.length; ++i)
		{
			resultArray[i]=firstSplit[i].split(split2Regex);
		}
		return resultArray;
	}
}
