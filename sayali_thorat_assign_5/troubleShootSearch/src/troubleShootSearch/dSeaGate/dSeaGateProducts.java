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
	List<String>TempList = new ArrayList<String>();
	
	List<String> ProductList= new ArrayList<String>();
	List<String> InputFromUser= new ArrayList<String>();
	HashMap<String, String> dictionary = new HashMap<String, String>();
	Results robj;
	
	public void input (List<String> productList2 , List<String> inputFromUser, HashMap<String, String> map, Results robj ) {
		
		this.ProductList = productList2;
		this.InputFromUser = inputFromUser;
		this.dictionary = map;
		this.robj = robj;
		
	}
	
	@Override
	public void visit(ExactMatch EM) {
		// TODO Auto-generated method stub
		
		for(String userInput : InputFromUser) {

			//robj.writeToFile("\nSearch result for : " + userInput+"\n");
			//robj.writeToFile("Exact match : ");
			
			for(String s : ProductList) {
			
			if(s.matches("(.*)(\\A|[^\\w])(" + userInput +")(\\Z|[^\\w])(.*)")) {
				System.out.println("Exact match : " + s);
				ExactList.add(s);
				robj.writeToFile("Exact match : "+s+"\n");
				
			}
			
		
		}
		
		}
		
	}

	@Override
	public void visit(NaiveStemmingMatch NM) {
		// TODO Auto-generated method stub
		
		
		for(String userInput : InputFromUser) {
			
			//robj.writeToFile("\nSearch result for : " + userInput+"\n");
			//robj.writeToFile("Naive Stemming match : ");
			
			String Temp ;
			
			Temp = userInput;
			String firstKeyword = Temp.split(" ")[0];
			
			for(String s : ProductList) {
				
				
				if(s.contains(firstKeyword)) {
					
					System.out.println("Naive Stemming match : " + s);
					NaiveStemmingList.add(s);
					//robj.writeToFile(s);
					robj.writeToFile("\nNaive Stemming match : "+s);
					
				}
				
			}
			
		}
			
		
	}

	@Override
	public void visit(SemanticMatch SM) {
		// TODO Auto-generated method stub

		//robj.writeToFile("\n");

		for(String userInput : InputFromUser) {
			
			//robj.writeToFile("\nSearch result for : " + userInput);
			//robj.writeToFile("\nSemantic match : ");
			
			String Temp = userInput;
			
			String[] parts = Temp.split(" ");
			String lastWord = parts[parts.length - 1];
			
			String value = dictionary.get(lastWord);
			
			String key = null;
			
			for (Entry<String, String> entry : dictionary.entrySet()) {
	            if (entry.getValue().equals(lastWord)) {
	                key = entry.getKey();
	            }
	        }
			for(String s : ProductList) {
				if( (s.matches("(.*)(\\A|[^\\w])(" + value +")(\\Z|[^\\w])(.*)"))  || (s.matches("(.*)(\\A|[^\\w])(" + key +")(\\Z|[^\\w])(.*)"))) {
					
					System.out.println("Semantic match : " + s);
					SemanticList.add(s);
					robj.writeToFile("\nSemantic match : "+s);
					
				}
				
			}  
		}
	}

}
