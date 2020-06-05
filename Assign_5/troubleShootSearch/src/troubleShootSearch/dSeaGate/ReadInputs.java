/**
 * 
 */
package troubleShootSearch.dSeaGate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.util.FileProcessor;

/**
 * @author sayali
 *This class is used to read inputs of file and for creating 
 *arraylist for them
 */
public class ReadInputs {
	
	List<String> ProductList = new ArrayList<String>();
	
	/**
	 * 
	 * @param ProductInfo : Inputfiles accepted in main class
	 * @return :String ArrayList created for inputFile
	 * @throws FileNotFoundException :when File not found
	 */
	public List<String> Read(String ProductInfo) throws FileNotFoundException {
		
		FileProcessor fpobj = new FileProcessor();
		BufferedReader br = fpobj.OpenFile(ProductInfo);
		String line = fpobj.readLine(br);
		List<String> ProductList = new ArrayList<String>();
		
		
		while (line != null) {
			
			ProductList.add(line);
			line = fpobj.readLine(br);
		}			
		return ProductList;
		
	} 

}
