package mockinterview.level2;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		int rottenRow = -1, rottenCol = -1, freshCount = 0;
		int mat[][] = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };

		RottenOranges obj = new RottenOranges();
		outterLoop: for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] == 2) {
					rottenRow = i;
					rottenCol = j;
					break outterLoop;
				}
			}
		}
		if (rottenRow == -1) {
			System.out.println("The time is : 0");
		} else {
			System.out.println("Output : " + obj.findMinumumTime(mat, rottenRow, rottenCol));
		}

	}

	private int findMinumumTime(int[][] mat, int rottenRow, int rottenCol) {
		int timeMinutes = -1;
		int[][] positions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean visited[][] = new boolean[mat.length][mat.length];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { rottenRow, rottenCol, 0 });
		while (!queue.isEmpty()) {
			int len = queue.size();
			timeMinutes++;
			for (int i = 0; i < len; i++) {
				int arr[] = queue.poll();

				for (int[] position : positions) {
					if (isValidMove(arr[0] + position[0], arr[1] + position[1], mat, visited)) {
						visited[arr[0] + position[0]][arr[1] + position[1]] = true;
						mat[arr[0] + position[0]][arr[1] + position[1]] = 2;
						queue.offer(new int[] { arr[0] + position[0], arr[1] + position[1], arr[2] + 1 });
					}
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] == 1) {
					return -1;
				}
			}
		}
		return timeMinutes;
	}

	private boolean isValidMove(int row, int col, int[][] mat, boolean[][] visited) {
		if (row >= 0 && row < mat.length && col >= 0 && col < mat.length && mat[row][col] == 1 && !visited[row][col]) {
			return true;
		} else {
			return false;
		}
	}

}
