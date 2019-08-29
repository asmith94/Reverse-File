/**************************** ReverseFile *******************************
ReverseFile by : Austin Smith
Purpose:
   This is a program that uses one part of Java's collection framework, 
   ArrayLists, to take any text file and reverse the lines of the file
   while also reversing the order of each word in the line. You are 
   required to enter the name of the file that will be reversed, and
   then the resulting reversed file will be output with "_Reversed"
   appended.
Results:
	This creates a class that showcases Java's util and I/O as well 
	as uses one of Java's most useful lists, the ArrayList. It will 
	ask for an input file name and give you a txt file of the reversed
	original.
    
*************************************************************************/

import java.util.*;
import java.io.*;

public class ReverseFile {

	public static String sFileName = "";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		Scanner input = null;

		System.out.println("This program will take a file that you specify and reverse it, and output it to a new file.");
		System.out.println();
		
		

		input = getFile(console, input);

		String sFileOut = sFileName + "_Reversed.txt";

		PrintStream output = new PrintStream(new File(sFileOut));

		
		fileReverse(input, output, list);

	}


	/************************** getFile *****************************
	Purpose:
		This is a basic method made of boilerplate code that
		gets a filename from the user of the program. It stores
		the file name in the data field of 'sFileName' and then
		opens a Scanner object to that file. If there is no such
		file, the code will ask for a another input from the user.
	****************************************************************/
	public static Scanner getFile(Scanner console, Scanner input) {

		do {
			System.out.println("What is the file you would like to reverse?");
			try {
				sFileName = console.next();
				input = new Scanner(new File(sFileName));
			} catch (FileNotFoundException e) {
				System.out.println("No such file found. Please re-type the name");

			}
		} while (input == null);

		return input;
	}



	/*************************** getFile ***************************
	Purpose:
		This is the method that has the algorithm that will drive our 
		program. It adds every word of the input file (split by spaces)
		into an ArrayList object, and then starts appending the last 
		words of the list in decending order, while deleting the 
		original word. The result is an ArrayList that is completely reversed. 
	***************************************************************/
	public static void fileReverse(Scanner fInput, PrintStream fOutput, ArrayList<String> words) {

		while (fInput.hasNext()) {
			String line = fInput.nextLine();
			for (String s : line.split(" ")) {
				words.add(s);
			}
		}
	
		int m = words.size();

		for(int i = m - 1; i >= 0; i--) {
			words.add(words.get(i));
			words.remove(i);
		}


		for (String s : words) {
			fOutput.print(s + " ");
		}
	}


}