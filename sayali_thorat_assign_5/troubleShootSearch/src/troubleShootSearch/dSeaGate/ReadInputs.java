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
 *
 */
public class ReadInputs {
	
	List<String> ProductList = new ArrayList<String>();
	
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
