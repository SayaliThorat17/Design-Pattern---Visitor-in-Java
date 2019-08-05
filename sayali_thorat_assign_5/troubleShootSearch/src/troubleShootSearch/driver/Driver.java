/**
 * 
 */
package troubleShootSearch.driver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import troubleShootSearch.dSeaGate.ProductA;
import troubleShootSearch.dSeaGate.ProductB;
import troubleShootSearch.dSeaGate.ProductC;
import troubleShootSearch.dSeaGate.ProductAccept;
import troubleShootSearch.dSeaGate.dSeaGate;
import troubleShootSearch.util.FileProcessor;

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
			
			
			String ProductInfo =args[0];
			String userInput =args[1];
			String synonym=args[2];
			
			System.out.println("Argo 0 "+ProductInfo+"\n");
			System.out.println("Argo 1 "+userInput+"\n");
			System.out.println("Argo 2 "+synonym+"\n");
			
			
			//Technical References
			FileProcessor fpobj = new FileProcessor();
			BufferedReader br = fpobj.OpenFile(ProductInfo);
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
			
			dSeaGate obj = new dSeaGate();
			
			ProductA aobj = new ProductA();
			ProductB bobj = new ProductB();
			ProductC cobj = new ProductC();
			
			
			
			
			
			/*List<ProductAccept> list = new ArrayList<ProductAccept>();
			list.add(new ProductA, new ProductB,ProductC);
			
			 for (ProductAccept element : list) {
		            element.accept(obj);
		        } 
			 */
			
			
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
			 
			/* ExactMatch EM = new ExactMatch();
			 System.out.println(" Exact matches are ");
			 for(String s : InputFromUser) {
				 EM.search(ProductList, s);
			 }
			 
			 NaiveStemmingMatch NM = new NaiveStemmingMatch();
			 System.out.println("Naive Stemming matches are");
			 for(String s : InputFromUser) {
				 NM.search(ProductList, s);
			 } */
			 
			 
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
						
						System.out.println("Ignoring line : " + line2);
					}
					
					line2 = fpobj.readLine(br2);

				}	
				
				for(String key : dictionary.keySet()) {
					
					System.out.println(key + " " + dictionary.get(key));
				}
			 
				
				
				obj.input(ProductList, InputFromUser);
				
				aobj.accept(obj);
				bobj.accept(obj);
				cobj.accept(obj);
				
			 
			 
		}
		catch (Exception e) {
			
			System.out.println("Exception for main caught : Invalid number of Arguments");
			
		}

	}

	}


