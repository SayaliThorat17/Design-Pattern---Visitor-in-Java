/**
 * 
 */
package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import troubleShootSearch.util.Results;

/**
 * @author sayali
 *
 */
public class dSeaGateProducts implements Visitor {
	
	List<String> ExactList = new ArrayList<String>();
	List<String> SemanticList = new ArrayList<String>();
	List<String> NaiveStemmingList = new ArrayList<String>();
	List<String> NoMatchList = new ArrayList<String>();
	
	List<String> ProductList= new ArrayList<String>();
	List<String> InputFromUser= new ArrayList<String>();
	HashMap<String, String> dictionary = new HashMap<String, String>();
	Results robj;
	
	public void input (List<String> productList2 , List<String> inputFromUser, HashMap<String, String> map, Results robj ) {
		
		this.ProductList = productList2;
		this.InputFromUser = inputFromUser;
		this.dictionary = map;
		this.robj = robj;
		
		/*for(String key : dictionary.keySet()) {
			
			System.out.println(key + " " + dictionary.get(key));
		} */
	}
	
	@Override
	public void visit(ExactMatch EM) {
		// TODO Auto-generated method stub
		
		
		for(String userInput : InputFromUser) {
		
		for(String s : ProductList) {
			//System.out.println("Hola");
			//System.out.println(s);
			//System.out.println(userInput);
			//if(s.matches(userInput)){
			//if(s.matches("(.*)" + userInput + "(.*)")) {
			if(s.matches("(.*)(\\A|[^\\w])(" + userInput +")(\\Z|[^\\w])(.*)")) {
			//if(s.contains(userInput)) {
				
				System.out.println("Exact match : " + s);
				robj.writeToFile("Exact match : " + s);
				ExactList.add(s);
			}
		
		}
		
		}
		
		//System.out.println(ExactList);
	}

	@Override
	public void visit(NaiveStemmingMatch NM) {
		// TODO Auto-generated method stub
		
		
		for(String userInput : InputFromUser) {
			
			String Temp ;
			
			Temp = userInput;
			String firstKeyword = Temp.split(" ")[0];
			//System.out.println("First keyword is : " + firstKeyword);
			
			for(String s : ProductList) {
				
				//if(str.indexOf(query.split(" ")[0]) >= 0) {
				
				if(s.indexOf(firstKeyword) >= 0) {
				//if(s.contains(firstKeyword)) {
					
					System.out.println("Naive Stemming match : " + s);
					robj.writeToFile("\nNaive Stemming match : " + s);
					NaiveStemmingList.add(s);
				}
			}
			
		}
		//	System.out.println(NaiveStemmingList); 
			
		
	}

	@Override
	public void visit(SemanticMatch SM) {
		// TODO Auto-generated method stub
		
		
		
		robj.writeToFile("\n");

		for(String userInput : InputFromUser) {
			
			String Temp = userInput;
			
			String[] parts = Temp.split(" ");
			String lastWord = parts[parts.length - 1];
			//System.out.println(lastWord);
			
			String value = dictionary.get(lastWord);
			//System.out.println("Value of "+lastWord+" is "+value);
			
			String key = null;
			
			for (Entry<String, String> entry : dictionary.entrySet()) {
	            if (entry.getValue().equals(lastWord)) {
	                key = entry.getKey();
	            	//System.out.println("Key of "+lastWord + " is "+key);
	            }
	        }
			
			//System.out.println("Key " + key);
			
			
			for(String s : ProductList) {
				if( (s.matches("(.*)(\\A|[^\\w])(" + value +")(\\Z|[^\\w])(.*)"))  || (s.matches("(.*)(\\A|[^\\w])(" + key +")(\\Z|[^\\w])(.*)"))) {
					
					System.out.println("Semantic match : " + s);
					robj.writeToFile("Semantic match : " + s);
					SemanticList.add(s);
				}
			
			}  
		}
		
		
		
		//System.out.println(SemanticList);
	}

	
	
	
}
