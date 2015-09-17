package helpermethods.random;

import java.util.Random;

public class RandomHelper {

	private Random randGenerator;
	
	public RandomHelper(){
		randGenerator = new Random();
	}
	
	
	/**
	 * Make array of size (sizeOfArray) containing numbers from 0 to (highestAllowedNumber)
	 * @param sizeOfArray 
	 * @param highestAllowedNumber
	 * @return Random array
	 */
	public int[] generateRandomIntArrayOfSizeX(int sizeOfArray, int highestAllowedNumber){

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
}
