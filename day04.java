import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*	advent of code 2021 day 4 parts 1 and 2. 
 *	this code is so god-awful and terribly done its embarassing
 */


public class day04
{
	private static int lastDrawnNumber = 0;
	private static int[][] calcBoardWinners(ArrayList<Integer> drawnNumbers, ArrayList<int[][]> boards)
	{
		// loop through each drawn number
		for (Integer num : drawnNumbers)
		{
			lastDrawnNumber = num;
			// go through each board 			
			for (int[][] board : boards)
			{
				// mark occurence(s) of drawn number
				for (int row = 0; row < 5; row++)
				{
					for (int col = 0; col < 5; col++)
					{
						if (board[row][col] == num) 
							board[row][col] = -1;
					}
				}
				// check for 5 in a row horizontally
				for (int row = 0; row < 5; row++)
				{
					if (board[row][1] == -1 && board[row][2] == -1 && board[row][3] == -1 && board[row][4] == -1 && board[row][0] == -1)
						//System.out.println(Arrays.deepToString(board) + "is a winner. (horizontal 5 in a row)");
						return board;
				}
				// check for 5 in a row vertically
				for (int row = 0; row < 5; row++) // just pretend row is actually col
				{
					if (board[1][row] == -1 && board[2][row] == -1 && board[3][row] == -1 && board[4][row] == -1 && board[0][row] == -1)
						//System.out.println(Arrays.deepToString(board) + "is a winner. (vertical 5 in a row)");
						return board;
				}
			}
			
		}
		return new int[5][5];
	}
	private static int[][] calcBoardLoser(ArrayList<Integer> drawnNumbers, ArrayList<int[][]> boards)
	{
		int boardsWon = 0;
		// loop through each drawn number
		for (Integer num : drawnNumbers)
		{
			lastDrawnNumber = num;
			// go through each board 			
			for (int[][] board : boards)
			{
				// mark occurence(s) of drawn number
				for (int row = 0; row < 5; row++)
				{
					for (int col = 0; col < 5; col++)
					{
						if (board[row][col] == num) 
							board[row][col] = -1;
					}
				}
					for (int row = 0; row < 5; row++)
					{
						if (board[row][1] == -1 && board[row][2] == -1 && board[row][3] == -1 && board[row][4] == -1 && board[row][0] == -1)
						{
							if (boardsWon == boards.size()-1)
								return board;
							else
							{
								for (int[] r: board)
								{
									Arrays.fill(r, -2);
								}
									boardsWon++;
							}
						}
					}
					// check for 5 in a row vertically
					for (int row = 0; row < 5; row++) // just pretend row is actually col
					{
						if (board[1][row] == -1 && board[2][row] == -1 && board[3][row] == -1 && board[4][row] == -1 && board[0][row] == -1)
						{
							if (boardsWon == boards.size()-1)
								return board;
							else
							{
								for (int[] r: board)
								{
									Arrays.fill(r, -2);
								}
									boardsWon++;
							}
						}
					}
			}
			
		}
		return new int[5][5];
	}
	public static void main (String[] args) throws FileNotFoundException
	{
		File inputFile = new File("input/input04");	

		// ---------- part 1: ----------
		Scanner input = new Scanner(inputFile);

		// set up list of drawn numbers
		ArrayList<Integer> drawnNumbers = new ArrayList<Integer>();
		Scanner dNums = new Scanner(input.nextLine().replace(',', ' '));

		int tmp;

		while (dNums.hasNext())
		{
			drawnNumbers.add(dNums.nextInt());
		}

		// set up list of boards
		ArrayList<int[][]> boards = new ArrayList<int[][]>();

		for (int i = 0; input.hasNext(); i++)
		{
			int[][] board = new int[5][5];
			for (int row = 0; row < 5; row++)
			{
				for (int col = 0; col < 5; col++)
				{
					board[row][col] = input.nextInt();
				}
			}
			boards.add(board);
		}

		// find the winning board
		int[][] winningBoard = calcBoardWinners(drawnNumbers, boards);

		int sum = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j =0;j<5;j++)
			{
				if (winningBoard[i][j] != -1)
					sum += winningBoard[i][j];
			}
		}
		System.out.println("pt1: "+sum*lastDrawnNumber);

		int[][] losingBoard = calcBoardLoser(drawnNumbers, boards);
		sum = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j =0;j<5;j++)
			{
				if (losingBoard[i][j] != -1)
					sum += losingBoard[i][j];
			}
		}
		System.out.println("pt2: "+sum*lastDrawnNumber);

	}
}
