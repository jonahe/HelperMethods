package helpermethods.io;

import java.util.Scanner;

public class ScannerHelper {

	private Scanner intScanner;
	private Scanner strScanner;
	
	public ScannerHelper() {
		intScanner = new Scanner(System.in);
		strScanner = new Scanner(System.in);
	}
	
	/**
	 * Ask user for input, and keep asking until s/he chooses one of the valid options
	 * 
	 * @param askMessage
	 * @param validOptions "Varargs", meaning "a","b","c" would be ok, as well as 0 args, and String[] as arg
	 * @return one of the valid options, or anything, if no validOptions was provided
	 */
	
	public String askForAndGetNextString(String askMessage, boolean caseSensitive, String... validOptions){
		String input = "";
		do{
			System.out.print(askMessage + "\n: ");
			input = strScanner.nextLine();
			// if it's not one of the valid options, repeat the message - start over
			
			if(validOptions.length == 0){
				// any option will be fine
				break;
			}
			
			// NOTE: the use of the generic "contains" method means input will be case sensitive
			if(caseSensitive){
				if(!contains(validOptions, input)){
					System.out.println("That's not a valid option..");
					continue;
				} else {
					break;
				}
			} else {
				if(!containsIgnoringCase(validOptions, input)){
					System.out.println("That's not a valid option..");
					continue;
				} else {
					break;
				}
			}
			
		} while (true);

		
		return input;
	}
	
	
	/**
	 * Ask user for input, and keep asking until s/he chooses one of the valid options
	 * 
	 * @param askMessage
	 * @param validOptions "varargs", meaning 3,4,5 would be ok, as well as 0 args, and Integer[] as arg
	 * @return one of the valid options, or anything, if no validOptions was provided
	 */
	public int askForAndGetNextInt(String askMessage, Integer... validOptions){
		int input = 99;
		do{
			System.out.print(askMessage + "\n: ");
			// check if we really have an int waiting.
			if(intScanner.hasNextInt()){
				input = intScanner.nextInt();
			} else {
				intScanner.nextLine();
				System.out.println("That's not an integer!\n");
				continue;
			}
			// if no options were sent, then any input is OK
			if(validOptions.length == 0){
				break;
			}
			
			// if it's not one of the valid options, repeat the message - start over
			if(!contains(validOptions, input)){
				System.out.println("That's not a valid number..");
				continue;
			} else {
				// go to return 
				break;
			}
			
		} while (true);
		
		return input;
	}
	
	/**
	 * Ask user for input, return the input as a String
	 * @param askMessage
	 * @return
	 */
	
	public String askForAndGetNextString(String askMessage){
		return askForAndGetNextString(askMessage, true); 
		// NOTE: case sensitivity does nothing here, since no options are passed along
	}
	
	/**
	 * Generic method, mimicking contains() method for Lists, for arrays
	 * <p>
	 * NOTE that if used on strings, this will be case sensitive
	 * @param array
	 * @param needle
	 * @return
	 */
	private <T> boolean contains(T[] array, T needle){
		boolean contains = false;
		for(T value : array){
			if(value.equals(needle)){
				contains = true;
			}
		}
		return contains;
	}
	
	private boolean containsIgnoringCase(String[] array, String needle){
		boolean contains = false;
		for(String value : array){
			if(value.equalsIgnoreCase((needle))){
				contains = true;
			}
		}
		return contains;
	}
	
}
