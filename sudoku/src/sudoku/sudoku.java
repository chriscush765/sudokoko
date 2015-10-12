package sudoku;

public class sudoku {

	public static int success = 1;

	public static double wow = 0;

	public static void main(String[] args) {
		int[][] board = new int[9][9];

		placeNumber(0, 0, 1, board);
		System.out.println(wow);
	}

	public static boolean placeNumber(int x, int y, int n, int[][] arr) {
		wow++;
		if (checkBoard(arr))
			return true;
		if (y >= arr.length) // not off board
			return false;
		if (x >= arr[0].length) // not off to right
			return placeNumber(0, y + 1, 1, arr);
		if (arr[y][x] == 1 || arr[y][x] == 2) // not on legitimate spot
			return placeNumber(x + 1, y, 1, arr);

		if (!placeNumber(x + 1, y, 1, arr)) {
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
			return placeNumber(x + 1, y, arr);
		}
	}

	
	public static boolean checkBoard(int[][] arr) {
		return false;
	}

}
