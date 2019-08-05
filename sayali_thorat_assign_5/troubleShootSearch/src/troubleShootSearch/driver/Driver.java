/**
 * 
 */
package troubleShootSearch.driver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import troubleShootSearch.dSeaGate.ExactMatch;
import troubleShootSearch.dSeaGate.NaiveStemmingMatch;
import troubleShootSearch.dSeaGate.ReadInputs;
import troubleShootSearch.dSeaGate.SemanticMatch;
import troubleShootSearch.dSeaGate.dSeaGateProducts;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Results;

/**
 * @author sayali
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
try {
			
			
			String ProductA =args[0];
			String ProductB =args[1];
			String ProductC =args[2];
			String ProductD =args[3];
			String userInput =args[4];
			String synonym=args[5];
			String outputFile = args[6];
			
			System.out.println("Argo 0 "+ProductA+"\n");
			System.out.println("Argo 1 "+userInput+"\n");
			System.out.println("Argo 2 "+synonym+"\n");
			System.out.println("Argo 3 "+outputFile+"\n");

			
			
			/*
			//Technical References
			FileProcessor fpobj = new FileProcessor();
			BufferedReader br = fpobj.OpenFile(ProductA);
			String line = fpobj.readLine(br);
			List<String> ProductList = new ArrayList<String>();
			
			
			while (line != null) {
				
				ProductList.add(line);
				line = fpobj.readLine(br);
			}			
			
			//System.out.println("Hi");
			for (int i = 0; i < ProductList.size(); i++) {
			//	System.out.print(ProductList.get(i)+"\n\n");
			}  
			//System.out.println(ProductList);
			
			
			*/
			
			List<String> ProductAList = new ArrayList<String>();
			List<String> ProductBList = new ArrayList<String>();
			List<String> ProductCList = new ArrayList<String>();
			List<String> ProductDList = new ArrayList<String>();
			
			ReadInputs object = new ReadInputs();
			
			ProductAList = object.Read(ProductA);
			//System.out.println("Howz " + ProductAList);
			ProductBList = object.Read(ProductB);
			ProductCList = object.Read(ProductC);
			ProductDList = object.Read(ProductD);

			
			
			FileProcessor fpobj = new FileProcessor();
			 //User Input
			 BufferedReader br1 = fpobj.OpenFile(userInput);
			 String line1 = fpobj.readLine(br1);
			 List<String> InputFromUser = new ArrayList<String>();
			 
			 while (line1 != null) {
				 
				 if(line1.length() > 0) {
					 InputFromUser.add(line1);
				 }
				 
				 line1 = fpobj.readLine(br1);
				}		
			 
			 
			 //Read synonyms.txt and store in HashMap
			 BufferedReader br2 = fpobj.OpenFile(synonym);
			 String line2 = fpobj.readLine(br2);
			 HashMap<String, String> dictionary = new HashMap<String, String>();

				
				while (line2 != null) {
					String[] parts = line2.split(" ",2);
					if(parts.length >= 2)
					{
						String key = parts[0];
						String value = parts[1];
						dictionary.put(key, value);
					}
					else {
						
						//System.out.println("Ignoring line : " + line2);
					}
					
					line2 = fpobj.readLine(br2);

				}	
				
				for(String key : dictionary.keySet()) {
					
					//System.out.println(key + " " + dictionary.get(key));
				}
			 
				
				
				dSeaGateProducts obj = new dSeaGateProducts();
				
				ExactMatch aobj = new ExactMatch();
				NaiveStemmingMatch bobj = new NaiveStemmingMatch();
				SemanticMatch cobj = new SemanticMatch();
				
				Results robj = new Results(outputFile);
				
				robj.writeToFile("Search Results are : \n\n");
				obj.input(ProductAList, InputFromUser,dictionary,robj);
				aobj.accept(obj);
				bobj.accept(obj);
				cobj.accept(obj);
				
				robj.writeToFile("\n");
				obj.input(ProductBList, InputFromUser,dictionary,robj);
				aobj.accept(obj);
				bobj.accept(obj);
				cobj.accept(obj);
				
				robj.writeToFile("\n");
				robj.writeToFile("\n");
				obj.input(ProductCList, InputFromUser,dictionary,robj);
				aobj.accept(obj);
				bobj.accept(obj);
				cobj.accept(obj);
				
				robj.writeToFile("\n");
				robj.writeToFile("\n");
				obj.input(ProductDList, InputFromUser,dictionary,robj);
				aobj.accept(obj);
				bobj.accept(obj);
				cobj.accept(obj);
				
				robj.closeFile();
			 
		}
		catch (Exception e) {
			
			System.out.println("Exception for main caught : Invalid number of Arguments");
			
		}

	}

	}


