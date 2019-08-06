/**
 * 
 */
package troubleShootSearch.util;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *This class is used to display results stored in log according to the input to switch case
 *this logger class is used for debugging mechanism
 */
public class MyLogger {
	
	/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
	  DEBUG_VALUE=3 [Print to stdout everytime the FILE_PROCESSOR is called i.e File is opened for reading.(Specified in FileProcessor.java)]
	  DEBUG_VALUE=2 [FIXME: Print to stdout everytime  you write results to file.(Specified in Results.java file)]
	  DEBUG_VALUE=1 [FIXME: Print to stdout everytime searching results found for any of three methods.(Specified in dSeaGateProducts.java file)]
	  DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
	*/

	public static enum DebugLevel {RELEASE, SEARCH_RESULTS, IN_RESULTS, FILE_PROCESSOR, CONSTRUCTOR , NONE
	                               };

	private static DebugLevel debugLevel;


	public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
		  		break;
		      // FIXME: add code for other cases
		  		
		  case 3: debugLevel = DebugLevel.FILE_PROCESSOR; 
				break;
				
		  case 2: debugLevel = DebugLevel.IN_RESULTS; 
				break;
				
		  case 1: debugLevel = DebugLevel.SEARCH_RESULTS; 
				break;
				
		  case 0: debugLevel = DebugLevel.RELEASE; 
		  		break;
		  		
		  default:
				debugLevel = DebugLevel.NONE;
				break;
		}
	}

	public static void setDebugValue (DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage (String  message  ,
	                                 DebugLevel levelIn ) {
		if (levelIn == debugLevel)
		    System.out.println(message);
	}

		/**
		 * @return String
		 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}


}
