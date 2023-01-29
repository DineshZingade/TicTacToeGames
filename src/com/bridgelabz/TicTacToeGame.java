package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {

	final int boardSize = 10;
	char computerLetter = ' ';
	char palyerLetter = ' ';
	char board[] = new char[boardSize];
	Scanner sc = new Scanner(System.in);

	TicTacToeGame() {
		for (int i = 0; i < boardSize; i++)
			board[i] = ' ';
		System.out.println("**Game started**");
	}

	public void inputSymbol() {
		System.out.println("Enter your symbol X or O :");

		char input = sc.next().charAt(0);
		if (input == 'X' || input == 'O' || input == 'x' || input == 'o') {
			switch (input) {
			case 'x':
			case 'X':
				palyerLetter = 'X';
				computerLetter = 'O';
			case 'o':
			case 'O':
				palyerLetter = 'X';
				computerLetter = 'X';
			}
		} else
			System.out.println("wrong input");
	}

	public void showBoard() {
		int charIndex = 0;
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

	public static void main(String... args) {

		TicTacToeGame TicTacToe = new TicTacToeGame();
		TicTacToe.inputSymbol();
		TicTacToe.showBoard();

	}
}