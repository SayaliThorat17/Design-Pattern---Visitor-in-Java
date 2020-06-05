/**
 *
 */
package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *This class implements Visitor interface and is responsible
 *for their deifferent operations
 */
public class dSeaGateProducts implements Visitor {

	

	/**
	 *
	 * @param productList2 - to accept input Arraylist
	 * @param inputFromUser - userinputs accepted
	 * @param map - HashMap is imported for synonmys.txt
	 * @param robj - Results class obj to write to file
	 */
	public void input (List<String> productList2 , List<String> inputFromUser, HashMap<String, String> map, Results robj ) {

		this.ProductList = productList2;
		this.InputFromUser = inputFromUser;
		this.dictionary = map;
		this.robj = robj;
	}

	/**
	 * ExactMethod Logic
	 */
	@Override
	public void visit(ExactMatch EM) {
		// TODO Auto-generated method stub

		for(String userInput : InputFromUser) {

			for(String s : ProductList) {

			if(s.matches("(.*)(\\A|[^\\w])(" + userInput +")(\\Z|[^\\w])(.*)")) {
				//System.out.println("Exact match : " + s);
	           	MyLogger.writeMessage("Exact match : " + s, DebugLevel.SEARCH_RESULTS);
				ExactList.add(s);
				robj.writeToFile("\nExact match : "+s);
			}
		}
		}
	}


	/**
	 * NaiveStemmingMatch Logic
	 */
	@Override
	public void visit(NaiveStemmingMatch NM) {
		// TODO Auto-generated method stub


		for(String userInput : InputFromUser) {

			String Temp ;

			Temp = userInput;
			String firstKeyword = Temp.split(" ")[0];

			for(String s : ProductList) {

				if(s.contains(firstKeyword)) {
					//System.out.println("Naive Stemming match : " + s);
		           	MyLogger.writeMessage("Naive Stemming match : "+s, DebugLevel.SEARCH_RESULTS);
					NaiveStemmingList.add(s);
					robj.writeToFile("\nNaive Stemming match : "+s);
				}
			}
		}
	}

	/**
	 * SemanticMatch Logic
	 */
	@Override
	public void visit(SemanticMatch SM) {
		// TODO Auto-generated method stub

		//robj.writeToFile("\n");
		for(String userInput : InputFromUser) {

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

			}
		}
	}

}
