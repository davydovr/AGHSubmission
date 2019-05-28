package AGH;

//Ruth Davydov

import java.util.Stack;

public class NextNumber {

	/*
	 * Write a function that takes a positive integer of at least three digits, 
	 * and return the next largest integer that is formed by the same digits, 
	 * if no larger integer can be formed 
	 * (i.e. current input integer is max number) 
	 * then return `false`.
	 * 
	 */

	public static void main(String[] args) {

		int[] nums = new int[3];
		nums[0] = 112;
		nums[1] = 110;
		nums[2] = 34512;

		for (int x = 0; x < nums.length; x++) {
			int nextNum = getNextNum(nums[x]);
			if (nextNum == 0) {
				System.out.println("False");
			}
			else {
				System.out.println(nextNum);	
			}
		}


	}

	public static int getNextNum(int num) {

		//cannot be negative number
		if (num < 0) {
			return 0;
		}

		int numCopy = num;
		
		
		/* AT LEAST 3 NUMBERS!!! */
		

		//get number of digits in given number
		int numDigits = String.valueOf(numCopy).length();

		//place all digits of given number into array
		int[] allDigits = new int[numDigits];

		//the numbers come on backwards, putting them on a stack to pop them off in order into the array. 
		Stack <Integer> stack = new Stack <Integer> ();
		for (int x = 0; x < numDigits; x++) {
			stack.push(numCopy % 10);
			numCopy = numCopy / 10;
		}

		int ctr = 0;
		while (!stack.isEmpty()) {
			allDigits[ctr] = stack.pop();
			ctr++;
		}

		//prepare to iterate through array of numbers backwards
		int curr = numDigits-1, 
				prev = numDigits-2;


		/*
		 * starting from the end, if array[currentNum] is greater than the number preceding it, 
		 * swap the two digits - we found the next number greater than the given number! 
		 */


		boolean changed = false;
		while (curr != 0) {
			if (allDigits[curr] > allDigits[prev]) {
				int temp = allDigits[curr];
				allDigits[curr] = allDigits[prev];
				allDigits[prev] = temp;
				changed = true;
				break;
			}
			else {
				curr--;
				prev--;
			}
		}

		if (changed) {
			//assemble the new greater number
			String s = String.valueOf(allDigits[0]);
			for (int x = 1; x < numDigits; x++) {
				s+= String.valueOf(allDigits[x]);
			}
			System.out.println(s);
			int realNum = Integer.parseInt(s);
			return realNum;
		}

		//if not changed, there was no greater number than the current one. 
		return 0;
	}

}
