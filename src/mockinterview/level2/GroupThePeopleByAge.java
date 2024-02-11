package mockinterview.level2;

import java.util.Arrays;
import java.util.Scanner;

public class GroupThePeopleByAge {

	public static void main(String[] args) {
		 Scanner read = new  Scanner(System.in);
		int len;
		int arr[];
		GroupThePeopleByAge obj = new GroupThePeopleByAge();
		System.out.print("Enter the length of the array : ");
		len = read.nextInt();
		System.out.println("Enter the array elements one by one : ");
		arr = new int[len];
		for(int i=0;i<len;i++) {
			arr[i]=read.nextInt();
		}
		obj.groupTheArray(arr);
		System.out.println("Output : " + Arrays.toString(arr));
		
	}

	private void groupTheArray(int[] arr) {
		int zero = 0, one = 0;
		for (int age : arr) {
			if (age == 0) {
				zero++;
			} else if (age == 1) {
				one++;
			} 
		}
		for(int i=0;i<arr.length;i++) {
			if(zero>0) {
				arr[i]=0;zero--;
			}
			else if(one>0) {
				arr[i]=1;one--;
			}else {
				arr[i]=2;
			}
		}

	}

}
