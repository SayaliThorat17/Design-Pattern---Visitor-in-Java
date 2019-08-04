/**
 * 
 */
package troubleShootSearch.SearchMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sayali
 *
 */
public class NaiveStemmingMatch {
	
	
	List<String> NaiveStemmingList = new ArrayList<String>();
	String Temp ;
	public void search(List<String> productList, String userInput) {
		
		Temp = userInput;
		String firstKeyword = Temp.split(" ")[0];
		System.out.println("First keyword is : " + firstKeyword);
		
		for(String s : productList) {
			
			if(s.contains(firstKeyword)) {
				
				NaiveStemmingList.add(s);
			}
		}
		
		System.out.println(NaiveStemmingList);
		
	}

}
