package helpermethods.array;

import java.util.Random;

public class ArrayHelper {

	/**
	 * Generic method, mimicking contains() method for Lists, for arrays
	 * <p>
	 * NOTE that if used on strings, this will be case sensitive
	 * @param array
	 * @param needle
	 * @return
	 */
	public <T> boolean contains(T[] array, T needle){
		boolean contains = false;
		for(T value : array){
			if(value.equals(needle)){
				contains = true;
			}
		}
		return contains;
	}
	
	/**
	 * Mimicking contains() method for Lists, for String arrays
	 * <p>
	 * If case sensitivity is wanted, use the generic method "contains" in this package instead
	 * @param array
	 * @param needle
	 * @return
	 */
	
	public  boolean containsIgnoringCase(String[] array, String needle){
		boolean contains = false;
		for(String value : array){
			if(value.equalsIgnoreCase((needle))){
				contains = true;
			}
		}
		return contains;
	}
	
	/**
	 * Get highest int from int array
	 * @param array
	 * @return
	 */
	public int getHighestFromArray(int[] array){
		int highestNow = 0;
		for(int i = 0; i < array.length; i++){
			int currentNumber = array[i];
			if(currentNumber > highestNow){
				highestNow = currentNumber;
			}
		}
		return highestNow;
	}
	
	/**
	 * Get lowest int from int array
	 * @param array
	 * @return
	 */
	public int getLowestFromArray(int[] array){
		int lowest = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++){
			int currentNumber = array[i];
			if(currentNumber < lowest){
				lowest = currentNumber;
			}
		}
		return lowest;
	}
	
	/**
	 * Sort int[] lowest to highest
	 * @param sortMe
	 * @return sorted array
	 */
	public int[] sort(int[] sortMe) {
		
		// after each finished loop, the previously last index is sorted, so next loop can stop one earlier 
		int stopHere = sortMe.length;
		
		int num1;
		int num2;
		
		int index;
		
		do{
			for(index = 1; index < stopHere; index++){
				
				num1 = sortMe[index -1];
				num2 = sortMe[index];
				
				if(num2 < num1){
					sortMe[index -1] = num2;
					sortMe[index] = num1;
				}
			}
			// after each finished loop, the previously last index is guaranteed
			// to be sorted, so next loop can stop one earlier 
			stopHere--;
			
		} while (stopHere != 0);
		
		return sortMe;
	}
	
	/**
	 * Make array of size (sizeOfArray) containing numbers from 0 to (highestAllowedNumber)
	 * @param sizeOfArray 
	 * @param highestAllowedNumber
	 * @return Random array
	 */
	public int[] generateRandomIntArrayOfSizeX(int sizeOfArray, int highestAllowedNumber){

		Random randGenerator = new Random();
		// create new array of the size the user requested
		int[] randArray = new int[sizeOfArray];
		// populate array with random numbers from zero to highestAllowedNumber
		for(int i = 0; i < randArray.length; i++){
			// each position of the array is assigned with a random number
			// nextInt() can take a parameter: bound. the random number will not higher NOR equal to this upper bound
			randArray[i] = randGenerator.nextInt(highestAllowedNumber + 1); // +1  because bound is 'exclusive'
		}
		return randArray;
	}
	
	
	/**
	 * To get a string with all the values, like so:  [val1, val2, etc] 
	 * <p>
	 * NOTE: this not work for primitive types. 
	 * @param array
	 * @return
	 */
	public <T> String arrayToString(T[] array){
		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0; i < array.length; i++){
			sb.append(array[i]);
			// append ", " after every value except last
			if(i != array.length -1){
				sb.append(", ");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	/**
	 * To get a string with all the int values, like so:  [val1, val2, etc] 
	 * @param array
	 * @return
	 */
	public String intArrayToString(int[] array){
		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0; i < array.length; i++){
			sb.append(array[i]);
			// append ", " after every value except last
			if(i != array.length -1){
				sb.append(", ");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	
}
