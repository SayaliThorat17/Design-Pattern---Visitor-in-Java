/**
 * 
 */
package troubleShootSearch.driver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import troubleShootSearch.util.MyLogger;
import troubleShootSearch.dSeaGate.ExactMatch;
import troubleShootSearch.dSeaGate.NaiveStemmingMatch;
import troubleShootSearch.dSeaGate.ReadInputs;
import troubleShootSearch.dSeaGate.SemanticMatch;
import troubleShootSearch.dSeaGate.dSeaGateProducts;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Results;

/**
 * @author sayali
 *this class is used to create all objects and to deal with 
 *command line arguments
 */
public class Driver {

	/**
	 * @param args 
	 * ProductA.txt, ProductB.txt, ProductC.txt, 
	 * ProductD.txt, userInputs.txt, output.txt and debugger value
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
try {
			String ProductInfo1 =args[0];
			String ProductInfo2 =args[1];
			String ProductInfo3 =args[2];
			String userInput =args[3];
			String synonym=args[4];
			String outputFile = args[5];
			String debug = args[6];
			
			System.out.println("Argo 0 "+ProductInfo1);
			System.out.println("Argo 1 "+ProductInfo2);
			System.out.println("Argo 2 "+ProductInfo3);
			System.out.println("Argo 3 "+userInput);
			System.out.println("Argo 4 "+synonym);
			System.out.println("Argo 5 "+outputFile);
			System.out.println("Argo 6 "+debug+"\n");
			
			int debugValue = Integer.parseInt(args[6]);
			
			if((debugValue >4) || (debugValue<0)) {
				
				System.out.println("Invalid debug argument .Please enter debug value from 0 to 4");
				System.exit(0);
			}
			MyLogger.setDebugValue(debugValue); 

			/**
			 * Lists for storing inputs from 4 Products info
			 */
			List<String> ProductAList = new ArrayList<String>();
			List<String> ProductBList = new ArrayList<String>();
			List<String> ProductCList = new ArrayList<String>();
			
			ReadInputs object = new ReadInputs();
			
			ProductAList = object.Read(ProductInfo1);
			ProductBList = object.Read(ProductInfo2);
			ProductCList = object.Read(ProductInfo3);
			
			FileProcessor fpobj = new FileProcessor();

			/**
			 * Here userInput.txt is read and stored in arraylist
			 */
			 BufferedReader br1 = fpobj.OpenFile(userInput);
			 String line1 = fpobj.readLine(br1);
			 List<String> InputFromUser = new ArrayList<String>();
			 
			 while (line1 != null) {
				 
				 if(line1.length() > 0) {
					 InputFromUser.add(line1);
				 }
				 
				 line1 = fpobj.readLine(br1);
				}		
			 
			 /**
			  * Read synonyms.txt and store in HashMap
			  */
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
					line2 = fpobj.readLine(br2);
				}	
				
				/**
				 * Objects created for all classes
				 */
				dSeaGateProducts obj = new dSeaGateProducts();
				ExactMatch aobj = new ExactMatch();
				NaiveStemmingMatch bobj = new NaiveStemmingMatch();
				SemanticMatch cobj = new SemanticMatch();
				Results robj = new Results(outputFile);
				
				/**
				 * Inputfiles and result obj is send and ExactMatch,
				 * NaiveSTemmingMatch, and SemanticMatch
				 *  are executed respectively
				 */
				obj.input(ProductAList, InputFromUser,dictionary,robj);
				aobj.accept(obj);											/** ExactMatch */
				
				obj.input(ProductBList, InputFromUser,dictionary,robj);
				bobj.accept(obj);											/** NaiveSTemmingMatch */
				
				obj.input(ProductCList, InputFromUser,dictionary,robj);
				cobj.accept(obj);											/** SemanticMatch */
				
				
				/**
				 * The noMatch entries are not printed in outputfile
				 * So output file will have only 24 entries with 8 each for 
				 * ExactMatch,NaiveSTemmingMatch, and SemanticMatch
				 */
				
				robj.closeFile();
			 
		}
		catch (Exception e) {
			
			System.out.println("Exception for main caught : Invalid number of Arguments");
			
		}
	}
}