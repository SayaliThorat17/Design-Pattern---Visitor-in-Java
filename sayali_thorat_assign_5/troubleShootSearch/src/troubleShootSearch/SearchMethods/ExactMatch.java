/**
 * 
 */
package troubleShootSearch.SearchMethods;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author sayali
 *
 */
public class ExactMatch {
	
	/*
      
       List<String[]> list = //some data
Iterator<String> itr = list.iterator();
while (itr.hasNext()){
    String[] array = itr.next(); // You were just missing saving the value for reuse
    System.out.println(array[3] + ":" + array[5]);
}

       */

	List<String> ExactList = new ArrayList<String>();
	public void search(List<String> productList, String userInput) {
		
		
		for(String s : productList) {
			//if(s.matches(userInput)){
			if(s.matches("(.*)" + userInput + "(.*)")) {
				
				ExactList.add(s);
			}
		}
		
		System.out.println(ExactList);
		
		/*for (int i = 0; i < ProductList.size(); i++) {
			
			if(ProductList(i).matches "(.*)" + userInput + "(.*)") {
				
			} 
		
		
		} */
		
	}
	
}
