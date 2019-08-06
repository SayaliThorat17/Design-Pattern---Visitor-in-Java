/**
 * 
 */
package troubleShootSearch.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *This class implements 2 interfaces FileDisplay and StdoutDisplay to generate output files
 */
public class Results {
	
	 private BufferedWriter bw;
	    private String outputFileName;
	    private File fileWriter;
	    
	  
	    
	    /**
	     * Results to write to output file
	     * @param outfilename : name of output file
	     */
	    public Results(String outfilename)  {
			// TODO Auto-generated constructor stub
	    	outputFileName=outfilename;
	    	fileWriter = new File(outputFileName);
	    	
	    	MyLogger.writeMessage("Results Contructor is called.", DebugLevel.CONSTRUCTOR);

	        // Create file
	    	try {
				fileWriter.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	try {
	    		//System.out.println("Output File :- "+outputFileName);
				bw = new BufferedWriter(new FileWriter(outputFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	    
	    /**
	     * This is used to print the output on commandline
	     * @param s : string which will be printed on screen
	     */
		public void writeToStdout( String s)
		{
			System.out.println(s);
		}
		
		
		/**
		 * This is used to write results to file
		 * @param text : writing string to the output file
		 */
		public void writeToFile(String text)
	    {
	            if ( text == null )
	            {
	                    return;
	            }
	            try
	            {
	           	MyLogger.writeMessage("Writing results in File", DebugLevel.IN_RESULTS);
	                    bw.write(text);
	                    
	            }
	            catch( IOException e)
	            {
	                    System.err.println("Error while writing");
	                    e.printStackTrace();
	            }
	    }
		
		
		/**
		 * Function to close the output file
		 * @throws IOException : if error occurs while closing file
		 */
		public void closeFile() throws IOException {
			bw.close();
		}


}
