package mockinterview.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PerfectSubArray {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int len, k;
		int arr[];
		PerfectSubArray obj = new PerfectSubArray();
		System.out.print("Enter the length of the array : ");
		len = read.nextInt();
		System.out.println("Enter the array elements one by one : ");
		arr = new int[] { 2, 4, 6 };

		for (int i = 0; i < len; i++) {
			arr[i] = read.nextInt();
		}
		System.out.print("Enter the k : ");
		k = read.nextInt();
		k = 1;
		if (k == 0) {
			System.out.println("Output : " + (len * len));
		} else {
			System.out.println("Output : " + obj.findSubArrayCount(arr, k));
		}

	}

	private int findSubArrayCount(int[] arr, int k) {
		int subArrayCount = 0, temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] % 2 != 0) {
					temp++;
				}
				if (temp == k) {
					subArrayCount++;
				} else if (temp > k) {
					break;
				}
			}
		}
		return subArrayCount;
	}

}
