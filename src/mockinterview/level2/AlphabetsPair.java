package mockinterview.level2;

import java.util.Scanner;

public class AlphabetsPair {

	public static void main(String[] args) {
		String alphabets;
		Scanner read = new Scanner(System.in);
		AlphabetsPair obj = new AlphabetsPair();
		System.out.print("Enter the alphabet string : ");
		alphabets = read.next();
		System.out.print("Output : " + obj.findTheMinimumSwap(alphabets));
	}

	private int findTheMinimumSwap(String alphabets) {
		char arr[] = alphabets.toCharArray();
		int swapCount = 0;
		char c;
		for (int i = 0; i < arr.length - 1; i++) {
			c = arr[i];
			if (arr[i + 1] == c) {
				continue;
			}
			for (int j = i + 2; j < arr.length; j++) {
				if (arr[j] == c) {
					swap(i + 1, j, arr);
					swapCount++;
					break;
				}
			}
		}
		return swapCount;
	}

	private void swap(int i, int j, char[] arr) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;

	}

}
