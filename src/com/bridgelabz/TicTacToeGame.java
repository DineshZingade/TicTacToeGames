package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeGame {

	final int boardSize = 10;
	char computerLetter = ' ';
	char playerLetter = ' ';
	char currentPlayer = ' ';
	char toss = ' ';
	char board[] = new char[boardSize];
	Scanner sc = new Scanner(System.in);

	TicTacToeGame() {
		for (int i = 0; i < boardSize; i++)
			board[i] = ' ';
		System.out.println("**Game started**");
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public void inputSymbol() {
		System.out.println("Enter your symbol X or O :");

		char input = sc.next().charAt(0);
		if (input == 'X' || input == 'O' || input == 'x' || input == 'o') {
			switch (input) {
			case 'x':
			case 'X':
				playerLetter = 'X';
				computerLetter = 'O';
				break;
			case 'o':
			case 'O':
				playerLetter = 'O';
				computerLetter = 'X';
			}
		} else
			System.out.println("wrong input");
	}

	public void showBoard() {
		int charIndex = 1;

		System.out.println("");
		for (int i = 1; i <= 3; i++) {

			for (int j = 1; j <= 3; j++) {
				System.out.print(" " + board[charIndex] + " ");
				charIndex++;
				if (j != 3)
					System.out.print("|");
			}
			System.out.println("");

			for (int j = 1; j <= 11 && i != 3; j++)
				System.out.print("-");
			System.out.println("");
		}
		System.out.println("");
	}

	public void drawMove() {
		currentPlayer = playerLetter;

		System.out.println("your turn draw move, enter index: ");
		int index = sc.nextInt();
		if (index > 0 && index < boardSize) {
			if (board[index] == ' ') {
				board[index] = playerLetter;
				System.out.println("move drawn");
			} else
				System.out.println("index is not empty");
		} else
			System.out.println("wrong index");
	}

	public void checkWinnigPlaces() {

	}

	public void computersMove() {

		ArrayList<Integer> emptyCells = new ArrayList<Integer>();

		int i = 1, k = 0;
		currentPlayer = computerLetter;
		System.out.println("computer's move");
		boolean b = true;
		for (i = 1; i < boardSize; i++) {
			if (board[i] != ' ') {
				b = false;
			} else
				emptyCells.add(i);
		}
		if (b) {
			i = (int) (Math.random() * 10) % 4;
			int[] corners = { 1, 3, 7, 9 };
			int index = corners[i];
			board[index] = computerLetter;
		} else {
			char checkLetter = playerLetter;

			for (i = 0; i < 1; i++) {
				checkPossibleWinning: for (int cell : emptyCells) {
					switch (cell) {

					case 1:
						if ((board[2] == checkLetter && board[3] == checkLetter)
								|| (board[4] == checkLetter && board[7] == checkLetter)
								|| (board[5] == checkLetter && board[9] == checkLetter)) {

							board[1] = computerLetter;
							break checkPossibleWinning;
						}
					case 2:
						if ((board[1] == checkLetter && board[3] == checkLetter)
								|| (board[5] == checkLetter && board[8] == checkLetter)) {

							board[2] = computerLetter;

							break checkPossibleWinning;
						}

					case 3:
						if ((board[1] == checkLetter && board[2] == checkLetter)
								|| (board[5] == checkLetter && board[7] == checkLetter)
								|| (board[6] == checkLetter && board[9] == checkLetter)) {

							board[3] = computerLetter;
							break checkPossibleWinning;
						}

					case 4:
						if ((board[1] == checkLetter && board[7] == checkLetter)
								|| (board[5] == checkLetter && board[6] == checkLetter)) {

							board[4] = computerLetter;
							break checkPossibleWinning;
						}
					case 5:
						if ((board[4] == checkLetter && board[6] == checkLetter)
								|| (board[2] == checkLetter && board[8] == checkLetter)
								|| (board[1] == checkLetter && board[9] == checkLetter)
								|| (board[7] == checkLetter && board[3] == checkLetter)) {

							board[5] = computerLetter;
							break checkPossibleWinning;
						}
					case 6:
						if ((board[3] == checkLetter && board[9] == checkLetter)
								|| (board[4] == checkLetter && board[5] == checkLetter)) {

							board[6] = computerLetter;
							break checkPossibleWinning;
						}

					case 7:
						if ((board[1] == checkLetter && board[4] == checkLetter)
								|| (board[8] == checkLetter && board[9] == checkLetter)
								|| (board[5] == checkLetter && board[3] == checkLetter)) {

							board[7] = computerLetter;
							break checkPossibleWinning;
						}

					case 8:
						if ((board[7] == checkLetter && board[9] == checkLetter)
								|| (board[2] == checkLetter && board[5] == checkLetter)) {

							board[8] = computerLetter;
							break checkPossibleWinning;
						}

					case 9:
						if ((board[1] == checkLetter && board[5] == checkLetter)
								|| (board[3] == checkLetter && board[6] == checkLetter)
								|| (board[7] == checkLetter && board[8] == checkLetter)) {

							board[9] = computerLetter;
							break checkPossibleWinning;
						}
					}

				}
			}

		}

	}

	public void toss() {

		System.out.println("Toss: Heads 'H' or Tails 'T' :");
		toss = sc.next().charAt(0);
		String tossResult = (int) (Math.random() * 10) % 2 == 0 ? "Heads" : "Tails";
		System.out.println("Tossed: " + tossResult);

		if (toss != tossResult.charAt(0)) {
			computersMove();
			showBoard();
			currentPlayer = computerLetter;
		} else
			currentPlayer = playerLetter;
	}

	public boolean checkBoardStatus() {
		boolean status = false;
		for (char ch : board) {
			if (ch == ' ') {
				status = true;
			}
		}
		if (status == false) {
			System.out.println("No place left, game tie");
			return false;
		}

		return true;
	}

	public boolean checkGameStatus() {

		if (currentPlayer == board[1] && currentPlayer == board[2] && currentPlayer == board[3]
				|| currentPlayer == board[4] && currentPlayer == board[5] && currentPlayer == board[6]
				|| currentPlayer == board[7] && currentPlayer == board[8] && currentPlayer == board[9] ||

				currentPlayer == board[1] && currentPlayer == board[4] && currentPlayer == board[7]
				|| currentPlayer == board[2] && currentPlayer == board[5] && currentPlayer == board[8]
				|| currentPlayer == board[3] && currentPlayer == board[6] && currentPlayer == board[9] ||

				currentPlayer == board[1] && currentPlayer == board[5] && currentPlayer == board[9]
				|| currentPlayer == board[7] && currentPlayer == board[5] && currentPlayer == board[3]) {

			if (currentPlayer == playerLetter) {
				System.out.println("***You Won***");
				showBoard();

			} else
				System.out.println("***Computer Won***");
			return false;
		} else
			return true;
	}

	public static void main(String... args) {

		TicTacToeGame TicTacToe = new TicTacToeGame();
		TicTacToe.inputSymbol();
		TicTacToe.showBoard();
		TicTacToe.toss();
		int c = 2;
		while (TicTacToe.checkGameStatus() && TicTacToe.checkBoardStatus()) {

			switch (c % 2) {
			case 0:
				TicTacToe.drawMove();
				TicTacToe.showBoard();
				break;
			case 1:
				TicTacToe.computersMove();
				TicTacToe.showBoard();
				break;
			}
		}
	}

}
