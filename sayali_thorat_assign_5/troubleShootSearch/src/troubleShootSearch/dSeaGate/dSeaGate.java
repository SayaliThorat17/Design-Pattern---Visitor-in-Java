/**
 * 
 */
package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sayali
 *
 */
public class dSeaGate implements Visitor {
	
	
	List<String> ProductList= new ArrayList<String>();
	List<String> InputFromUser= new ArrayList<String>();

	
	public void input (List<String> productList2 , List<String> inputFromUser ) {
		
		ProductList = productList2;
		InputFromUser = inputFromUser;
		
	}
	
	@Override
	public void visit(ProductA EM) {
		// TODO Auto-generated method stub
		List<String> ExactList = new ArrayList<String>();
		
		for(String userInput : InputFromUser) {
		
		for(String s : ProductList) {
			//if(s.matches(userInput)){
			if(s.matches("(.*)" + userInput + "(.*)")) {
				
				ExactList.add(s);
			}
		
		}
		
		}
		System.out.println(ExactList);
	}

	@Override
	public void visit(ProductB NM) {
		// TODO Auto-generated method stub
		
		
		/*List<String> NaiveStemmingList = new ArrayList<String>();
		String Temp ;
			
			Temp = userInput;
			String firstKeyword = Temp.split(" ")[0];
			System.out.println("First keyword is : " + firstKeyword);
			
			for(String s : ProductList) {
				
				if(s.contains(firstKeyword)) {
					
					NaiveStemmingList.add(s);
				}
			}
			
			System.out.println(NaiveStemmingList); */
			
		
	}

	@Override
	public void visit(ProductC SM) {
		// TODO Auto-generated method stub
		
	}

	

	


}
