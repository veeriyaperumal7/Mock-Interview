package mockinterview.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int len, amount;
		int coins[];
		CoinChange obj = new CoinChange();
		System.out.print("Enter the length of the array : ");
		len = read.nextInt();
		System.out.println("Enter the array elements one by one : ");
		coins = new int[len];
		for (int i = 0; i < len; i++) {
			coins[i] = read.nextInt();
		}
		System.out.print("Enter the amount : ");
		amount = read.nextInt();
		if (amount == 0) {
			System.out.println("Output : 0");
		} else {
			System.out.println("Output : " + obj.findSubArrayCount(coins, amount));
		}

	}

	private int findSubArrayCount(int[] coins, int amount) {
		int minimumCoins = Integer.MAX_VALUE;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { amount, 0 });
		while (!queue.isEmpty()) {
			int arr[] = queue.poll();
			if (arr[0] == 0) {
				minimumCoins = Math.min(minimumCoins, arr[1]);
			}
			for (int coin : coins) {
				if (arr[0] - coin >= 0) {
					queue.offer(new int[] { arr[0] - coin, arr[1] + 1 });
				}
			}
		}

		return (minimumCoins != Integer.MAX_VALUE) ? minimumCoins : -1;
	}

}
