import java.util.Random;
import java.util.Arrays;

public class ArraysAndLoops {
	
	public static void main(String[] args) {
		ArraysAndLoops l = new ArraysAndLoops();
		int[] numbers = new int[30];
		numbers = l.populatedArray(numbers, 100);
		
		System.out.print("Array: ");
		l.printArray(numbers);
		System.out.println("index of 10: " + l.findFirstIndex(numbers, 10));
		
		if(l.areDuplicates(numbers)) {
			System.out.println("There are duplicates.");
		}else{
			System.out.println("There are no duplicates.");
		}
		System.out.print("longest odd subsequence: ");
		l.printArray(l.longestSubSeqOdd(numbers));
		
		
		l.sortArray(numbers, "bts");
		System.out.print("sorted largest to smallest: ");
		l.printArray(numbers);
		l.sortArray(numbers, "stb");
		System.out.print("sorted smallest to largest: ");
		l.printArray(numbers);
		
		
		
	}

	int getMaxOfArray(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	void printArray(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) {
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
			a[i] = rand.nextInt(maxNum)+1;
		}
		return a;
	}

	int sumOfArray(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		return sum;
	}

	void sortArray(int[] a, String direction) {
		boolean inOrder;
		int n = 1;
		int subNum;
		switch (direction) {
		case "bts":

			do {
				inOrder = true;
				for (int i = 0; i < a.length - n; i++) {
					if (a[i] < a[i + 1]) {
						inOrder = false;
						subNum = a[i + 1];
						a[i + 1] = a[i];
						a[i] = subNum;
					}
				}
				n++;
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

	boolean isPalindrome(int[] a) {
		for (int j = 0; j < a.length/2; j++) {
			if (a[j] != a[(a.length-1)-j]) {
				return false;
			}
		}
		return true;
	}
	
	boolean areDuplicates(int[] a) {
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if (i != j && a[i] == a[j]) {
					return true;
				}
			}
		}
		return false;
	}

	int[] longestSubSeqOdd(int[] a) {
		int subSeqLength = 0;
		int longestSeqLength = subSeqLength;
		int[] subSeq = new int[100];
		int[] longestSubSeq = new int[100];
		for(int i = 0; i < a.length; i++) {
			if(a[i]%2==1) {
				subSeq[subSeqLength] = a[i];
				subSeqLength++;
				if(subSeqLength > longestSeqLength) {
					longestSeqLength = subSeqLength;
					longestSubSeq = subSeq;
				}
			}else{
				 subSeqLength = 0;
			}
		}
		return Arrays.copyOfRange(longestSubSeq, 0, longestSeqLength);
	}

	int findFirstIndex(int[] a, int value) { // returns index or -1
		for (int i = 0; i < a.length; i++) {
			if (a[i] == value) {
				return i;
			}
		}
		return -1;
	}
}

