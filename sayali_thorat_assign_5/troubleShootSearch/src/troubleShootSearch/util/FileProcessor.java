/**
 * 
 */
package troubleShootSearch.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sayali
 *this class is used to read the input file and process it.
 */
public class FileProcessor {

private String fileName;
	

/**
 * method to open input file
 * @param fileName : inputfile name
 * @return br : bufferedReader
 * @throws FileNotFoundException : if error while opening file
 */
	public BufferedReader OpenFile(String fileName) throws FileNotFoundException {
		BufferedReader br;
		
		this.fileName=fileName;
		
			br = new BufferedReader(new FileReader(fileName));
	
		return br;
	}
	
	
	/**
	 * method to read a single line from input file
	 * @param br : BufferedReader
	 * @return line :  reading single line of file
	 */
	public synchronized String readLine(BufferedReader br) {
		String line="";
		try {
			line = br.readLine();
		}
		catch (IOException e) {
			
			System.err.print("Error Reading file");
			e.printStackTrace();
		}
			return line;
	}
	
	
	/**
	 * method to close file
	 * @param br : BufferedReader
	 * @throws IOException : Exception thrown if error occurs while closing file
	 */
	public void closeFile(BufferedReader br) throws IOException {
		br.close();
		
	}

}

