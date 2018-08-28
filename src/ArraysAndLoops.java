import java.util.Random;
import java.util.Arrays;

public class ArraysAndLoops {

	public static void main(String[] args) {
		
		
		ArraysAndLoops l = new ArraysAndLoops();
		
		
		int[] numbers = new int[30];
		numbers = l.populatedArray(numbers, 100);
		
		//l.printDoubleArray(l.multTable(1, 20));
		//l.printArray(numbers);
		//for (int i = 0; i < numbers.length; System.out.print(numbers[i++] + " "));
		
		System.out.print("Array: ");
		l.printArray(numbers);
		System.out.println("index of 10: " + l.findFirstIndex(numbers, 10));

		if (l.areDuplicates(numbers)) {
			System.out.println("There are duplicates.");
		} else {
			System.out.println("There are no duplicates.");
		}
		System.out.print("longest odd subsequence: ");
		l.printArray(l.longestSubSeqOdd(numbers));

		l.selectionSortArray(numbers);
		System.out.print("sorted through selection sorting: ");
		l.printArray(numbers);
		
		l.bubbleSortArray(numbers, "bts");
		System.out.print("sorted largest to smallest: ");
		l.printArray(numbers);
		l.bubbleSortArray(numbers, "stb");
		System.out.print("sorted smallest to largest: ");
		l.printArray(numbers);
		
		
	}

	int getMaxOfArray(int[] a) {
		int max = a[0]; // the first number tested is always going to be the max until you test for
						// another number
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i]; // assigns largest value to the "max" value
			}
		}
		return max;
	}

	void printArray(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) { // prints a comma after every number except last one (it will print a bracket
										// instead)
				System.out.print(a[i] + ",");
			} else {
				System.out.print(a[i]);
			}
		}
		System.out.println("]");
	}

	int[] populatedArray(int[] a, int maxNum) {
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(maxNum) + 1; // '+1': will go from 1-100 instead of 0-99 when 100 is placed as argument.
		}
		return a;
	}

	int sumOfArray(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i; // adds every value into one variable
		}
		return sum;
	}

	void bubbleSortArray(int[] a, String direction) {
		boolean inOrder;
		int n = 1;
		int subNum;
		switch (direction) { // this is only to switch between largest to smallest or smallest to largest
		case "bts": // could probably be done a lot more efficiently.

			do {
				inOrder = true;
				for (int i = 0; i < a.length - n; i++) { // - n because you know for sure that the last value
					if (a[i] < a[i + 1]) { // that was checked is for sure the highest one
						inOrder = false;
						subNum = a[i + 1];
						a[i + 1] = a[i];
						a[i] = subNum;
					}
				}
				n++; // n is incremented according to how many runs of the do-while loop.
			} while (!inOrder);

			break;
		case "stb":

			do {
				inOrder = true;
				for (int i = 0; i < a.length - n; i++) {
					if (a[i] > a[i + 1]) {
						inOrder = false;
						subNum = a[i + 1];
						a[i + 1] = a[i];
						a[i] = subNum;
					}
				}
				n++;
			} while (!inOrder);

			break;
		default:
			System.out.println("please enter a valid argument");
		}

	}

	static int getMinPos(int[] a, int n) {
		int minPos = n;

		for (int i = n; i < a.length; i++) {
			if (a[i] < a[minPos]) {
				minPos = i;
			}
		}
		return minPos;
	}

	void selectionSortArray(int[] a) {
		int minPos, tmp;
		
		for (int i = 0; i < a.length - 1; i++) {
			minPos = getMinPos(a, i);
			tmp = a[minPos];
			a[minPos] = a[i];
			a[i] = tmp;
		}
	}

	boolean isPalindrome(int[] a) {
		for (int j = 0; j < a.length / 2; j++) { // ÷ by 2 because you only have to go to half the value
			if (a[j] != a[(a.length - 1) - j]) {
				return false;
			}
		}
		return true;
	}

	boolean areDuplicates(int[] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i != j && a[i] == a[j]) {
					return true; // if there are duplicates, then it's true
				}
			}
		}
		return false; // if it get's to this point you know it's false
	}

	int[] longestSubSeqOdd(int[] a) {
		int subSeqLength = 0; // had to create separate length variables because subSeq.length would return
								// 100.
		int longestSeqLength = subSeqLength;
		int[] subSeq = new int[100];
		int[] longestSubSeq = new int[100];
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) { // if the number is odd...
				subSeq[subSeqLength] = a[i]; // add it to the current subSequence for testing
				subSeqLength++; // then increment the length, manually, by one
				if (subSeqLength > longestSeqLength) {// if the current subSequence is longer than the previously
					longestSeqLength = subSeqLength; // declared 'longest subSequence' then make set the new longest
					longestSubSeq = subSeq; // subsequence to be the other subSequence in question.
				}
			} else {
				subSeqLength = 0; // if it's not odd, then begin testing a new subsequence
			}
		}
		return Arrays.copyOfRange(longestSubSeq, 0, longestSeqLength);
	}

	int findFirstIndex(int[] a, int value) { // returns index or -1
		for (int i = 0; i < a.length; i++) { // loops through every value to see if it equal to the desired number
			if (a[i] == value) {
				return i; // if it is, then return the index of that number
			}
		}
		return -1; // if it's not then return -1
	}

	int[][] multTable(int from, int to) {
		
		int[][] multTable = new int[to][to];
		
		for (int i = 0; i < to; i++) {
			for(int j = 0; j < to; j++) {
				multTable[i][j] = (i+1)*(j+1);
			}
		}
		
		return multTable;

	}

	void printDoubleArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("\n");
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j][i]);
				for(int k = 0; k < 5-Integer.toString(a[j][i]).length(); k++) {System.out.print(" ");};
			}
		}
	}
}
