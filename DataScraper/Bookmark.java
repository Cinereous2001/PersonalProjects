/************************************************
  Author:     Mahir Rahman
  Class:      Personal Project
  Date:       9/21/2021
  Compiler:   Eclipse
************************************************/
/**
  Description:
  The program lists all your favourite lines from different books. Then, you can open
  the whole list anytime you want. You can add new lines to it.
  Secondly, when you view the lines, you can open any one of the quotes to see
  which book it is from. It can even open the pdf from which the line was collected
  that is stored on your computer
*/
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bookmark {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//Menu
		System.out.println("Welcome to your bookmark collection! What would you like to do today?");
		System.out.println("1: Save a new quote");
		System.out.println("2: See list of existing bookmarks");
		System.out.print("Please select one of the previous options: ");
		int choice = in.nextInt();
		String garbage = in.nextLine();
		//The following arrayLsits hold pg num, bookname, and folder location
		ArrayList <Integer> fetchPgNum = new ArrayList <Integer>();
		ArrayList <String> fetchBookName = new ArrayList <String>();
		ArrayList <String> fetchPath = new ArrayList <String>();
		String[] content = new String[3];
		
		//Locates the files in desktop
		String filename = "C:/Users/parve/OneDrive/Desktop/MU Fall 2021/CSE 271/PersonalProjects/FavBookMarks.txt";
		File file = new File(filename);
		String filename1 = "C:/Users/parve/OneDrive/Desktop/MU Fall 2021/CSE 271/PersonalProjects/details.txt";
		File hiddenFile = new File(filename1);
		
		if (choice == 1)
		{			
			appendFile(filename, content);
			appendHiddenFile(filename1, content);
		}		
		if (choice == 2)
		{
			try {
				
				//This allows us to open up txt or pdf files automatically
				Desktop desktop = Desktop.getDesktop();
		        desktop.open(file);
		        
		        Scanner fileReader = new Scanner(hiddenFile);
	        	Scanner keyboard = new Scanner(System.in);
	        	
		        System.out.println("Would you like to open any of the quotes? (Y/N): ");
		        String[] split = new String[2];
		        String decision = in.nextLine();
		        decision = decision.trim();
		        if (decision.equals("Y"))
		        {
		        	int i = 0;
		        	while (fileReader.hasNext())
		        	{
		        		fetchPgNum.add(fileReader.nextInt());
		        		String mix = fileReader.nextLine();
		        		split = mix.split("\t", 2); //Separates the file name from path
		        		fetchBookName.add(split[0]);
		        		fetchPath.add(split[1]);
		        		i++;
		        	}
		        	System.out.println("Which one would you like to open up?: ");
		        	int options = keyboard.nextInt();
		        	
		        	System.out.println("This line is from page " + fetchPgNum.get(i - 1) + " from the book " + fetchBookName.get(i - 1));
		        	System.out.print("Are you certain that the location fo the file has not changed? (Y/N): ");
		        	String change = in.next();
		        	if (change.equals("Y"))
		        	{
		        		split[1] = split[1].replace('\\', '/'); //Changes the file loc data to allow compiler to open pdfs
		        		System.out.println("Please give me a few moments to open the book... Enjoy!");
		        		
		        		Desktop pdf = Desktop.getDesktop();
		        		
				        pdf.open(new File(split[1]));
		        	}
		        	else if (decision.equals("N"))
		        	{
		        		System.out.print("Please enter new location: ");
		        		String newLocation = in.nextLine();
		        		newLocation = newLocation.replace("\\", "/");
		        		System.out.println("Please give me a few moments to open the book... Enjoy!");
		        		
		        		Desktop pdf = Desktop.getDesktop();
		        		
				        pdf.open(new File(newLocation));		        		
		        	}
		        	
		        	
		        }
		        else
		        {
		        	System.out.println("Thank you! Hope to see you soon.");
		        }
		        fileReader.close();
		        keyboard.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  finally {
				try {
					in.close();					
				} catch (Exception f) {
					f.printStackTrace();
				}			
			}		
		}
	}
	
	/**
	 * Appends info at the bottom of a file
	 * @param fileName
	 * @param content
	 */
	public static void appendFile(String fileName, String[] content)
	{
		Scanner in = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(fileName, true); //This allows us to append at the bottom of a file
			pw = new PrintWriter(fw);
			in = new Scanner(System.in);
			
			System.out.print("Please insert the line you wish to save: ");
			String line = in.nextLine();
			System.out.print("Please enter the page number: ");
			content[0] = in.nextLine();
			System.out.print("Please enter the book name: ");
			content[1] = in.nextLine();
			System.out.print("Please enter the file path: ");
			content[2] = in.nextLine();
			
			pw.println(line);
			
		/*The following lines are the standard try, catch, and finally 
		      statements used to catch exceptions*/	
		} catch (FileNotFoundException e) {
			System.err.println("****File Not Found Exiting Append Method****");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				in.close();
				fw.close();
				pw.close();
			} catch (Exception f) {
				f.printStackTrace();
			}			
		}		
	} //end method appendFile
	
	/**
	 * Appends info at the bottom of another file
	 * @param fileName
	 * @param content
	 */
	public static void appendHiddenFile(String fileName, String[] content)
	{
		Scanner key = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(fileName, true); //This allows us to append at the bottom of a file
			pw = new PrintWriter(fw);
			key = new Scanner(System.in);
			
			System.out.print("Thank you for your patience. The bookmarks have been updated.");
			
			pw.println(content[0] + " " + content[1] + "\t" + content[2]);
			
		/*The following lines are the standard try, catch, and finally 
		      statements used to catch exceptions*/	
		} catch (FileNotFoundException e) {
			System.err.println("****File Not Found Exiting Append Method****");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				key.close();
				fw.close();
				pw.close();
			} catch (Exception f) {
				f.printStackTrace();
			}			
		}		
	} //end method appendHiddenFile

}
