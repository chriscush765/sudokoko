package sudoku;

public class sudoku {

	public static int success = 1;

	public static double wow = 0;

	public static void main(String[] args) {
		int[][] board = new int[9][9];

		placeNumber(0, 0, board);
		System.out.println(wow);
	}

	public static boolean placeNumber(int x, int y, int[][] arr) {
		wow++;
		if (checkBoard(arr))
			return true;
		if (y >= arr.length) // not off board
			return false;
		if (x >= arr[0].length) // not off to right
			return placeNumber(0, y + 1, arr);
		if (arr[y][x] == 1 || arr[y][x] == 2) // not on legitimate spot
			return placeNumber(x + 1, y, arr);

		arr[y][x] = 2;
		drawLines(arr);

		if (!placeNumber(x + 1, y, arr)) {
			arr[y][x] = 0;
			clearOnes(arr);
			drawLines(arr);
			return placeNumber(x + 1, y, arr);
		} else {
			System.out.println(success);
			for (int[] row : arr) {
				for (int cell : row) {
					System.out.print(cell + " ");
				}
				System.out.println();
			}
			success++;
			arr[y][x] = 0;
			clearOnes(arr);
			drawLines(arr);
			return placeNumber(x + 1, y, arr);
		}
	}

	public static void drawLines(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2)
					drawLine(j, i, arr);
			}

		}
	}

	public static void drawLine(int x, int y, int[][] arr) {
		for (int right = x; right < arr[0].length; right++)
			if (arr[y][right] == 0)
				arr[y][right] = 1;
		for (int left = x; left >= 0; left--)
			if (arr[y][left] == 0)
				arr[y][left] = 1;
		for (int up = y; up >= 0; up--)
			if (arr[up][x] == 0)
				arr[up][x] = 1;
		for (int down = y; down < arr.length; down++)
			if (arr[down][x] == 0)
				arr[down][x] = 1;

		// up left
		int a = x - 1;
		int b = y - 1;
		while (a >= 0 && b >= 0) {
			arr[b][a] = 1;
			a--;
			b--;
		}

		// up right
		a = x + 1;
		b = y - 1;
		while (a < arr[0].length && b >= 0) {
			arr[b][a] = 1;
			a++;
			b--;
		}

		// down left
		a = x - 1;
		b = y + 1;
		while (a >= 0 && b < arr.length) {
			arr[b][a] = 1;
			a--;
			b++;
		}

		// down right
		a = x + 1;
		b = y + 1;
		while (a < arr[0].length && b < arr.length) {
			arr[b][a] = 1;
			a++;
			b++;
		}
	}

	public static boolean checkBoard(int[][] arr) {
		return false;
	}

	public static void clearOnes(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1)
					arr[i][j] = 0;
			}

		}
	}
}
