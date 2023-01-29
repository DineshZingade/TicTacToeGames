package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {

	static char playerLetter;
	static char computerLetter;

	public static void input() {
		System.out.println("Enter char ");
		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);
		if (input == 'X' || input == 'O') {
			switch (input) {
			case 'X':
				playerLetter = 'X';
				computerLetter = 'O';
				break;

			case 'O':
				playerLetter = 'O';
				computerLetter = 'X';
			}
		} else
			System.out.println("input is not correct");
	}

	public static void main(String[] args) {
		input();
	}
}
