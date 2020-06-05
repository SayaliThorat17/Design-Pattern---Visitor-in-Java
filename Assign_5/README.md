# CSX42: Assignment 5


-----------------------------------------------------------------------
-----------------------------------------------------------------------
Citations :

https://sourcemaking.com/design_patterns/visitor/java/1
https://www.geeksforgeeks.org/visitor-design-pattern/
https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by
https://beginnersbook.com/2014/08/hashmap-get-value-from-key-example/
https://www.tutorialspoint.com/java/java_string_matches.htm
https://stackoverflow.com/
https://stackoverflow.com/questions/6603015/check-whether-a-string-matches-a-regex-in-js

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

In the folder: "Assign_5/troubleShootSearch" run the following command:

ant -buildfile src/build.xml run -Darg0=ProductA.txt -Darg1=ProductB.txt -Darg2=ProductC.txt -Darg3=userInputs.txt -Darg4=synonyms.txt -Darg5=output.txt -Darg6=3

for -Darg6 enter values between 0 to 4 (Debugger values)

    DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
	  DEBUG_VALUE=3 [Print to stdout everytime the FILE_PROCESSOR is called i.e File is opened for reading.(Specified in FileProcessor.java)]
	  DEBUG_VALUE=2 [FIXME: Print to stdout everytime  you write results to file.(Specified in Results.java file)]
	  DEBUG_VALUE=1 [FIXME: Print to stdout everytime searching results found for any of three methods.(Specified in dSeaGateProducts.java file)]
	  DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]


-----------------------------------------------------------------------
## Description:

I have used Visitor design_pattern for this assignment.
Here I am accepting technical sentences for 4 products in three respective input files(ProductA.txt, ProductB.txt, ProductC.txt) and userInputs is accepted in userInputs.txt and output is written in output.txt. Synonym.txt file is also taken as input.

I have used String ArrayList to store my inputfiles and userInput file.
I have used HashMap to store key,value pairs for synonym.txt file. The words in synonym.txt file are space separated (e.g CPU processor)

My dSeaGateProducts.java class implements the visitor interface where logic for ExactMatch, NaiveStemmingMatch and SemanticMatch is written.

For ExactMatch i have used string.match as it returns true only when the string is matched.
For NaiveStemmingMatch i have used string.contains to check if substring is present.
Finally for SemanticMatch i have used hashmap and then string.match to get the required output.

All the results are written to output.txt when search matches are found.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- 08/05/2019
