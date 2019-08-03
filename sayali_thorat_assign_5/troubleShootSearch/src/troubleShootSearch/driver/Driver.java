/**
 * 
 */
package troubleShootSearch.driver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

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
			
			
			String userInput =args[0];
			//String technicalSentence =args[1];
			//String synonym=args[2];
			
			System.out.println("Argo 0 "+userInput+"\n");
		//	System.out.println("Argo 1 "+technicalSentence+"\n");
		//	System.out.println("Argo 2 "+synonym+"\n");
			
			
			FileProcessor fpobj = new FileProcessor();
			BufferedReader br1 = fpobj.OpenFile(userInput);
			String line = fpobj.readLine(br1);
			List<String> myList = new ArrayList<String>();
			
			
			while (line != null) {
				
			}			
			
		}
		catch (Exception e) {
			
			System.out.println("Exception for main caught : Invalid number of Arguments");
			
		}

	}

}
