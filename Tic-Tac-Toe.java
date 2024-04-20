package Practise;

import java.util.Scanner;

public class TicTacToe {

	private char[][] board;
	private char currentPlayer;
	
	public TicTacToe() {
		board = new char[3][3];
		currentPlayer = 'X';
		initializeBoard();
	}
	
	//Initialize the board with empty spaces
	private void initializeBoard() {
		for(int i=0; i<3; i++) {
			for(int j =0; j<3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	//Print the current state of the board
	private void printBoard() {
	    System.out.println("-------------");
	    for (int i = 0; i < 3; i++) {
	        System.out.print("| ");
	        for (int j = 0; j < 3; j++) {
	            System.out.print(board[i][j] + " | ");
	        }
	        System.out.println("\n-------------");
	    }
	}
	
	//Check if the game is a draw
	private boolean isDraw() {
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j] == ' ') {
					return false; //If there is an empty cell, game is not a draw
				}
			}
		}
		return true; // All cells are filled, game is a draw
	}
	
	//Check if there is a winner
	private boolean hasWinner() {
		for(int i=0; i<3; i++) {
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
			if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		//Check diagonals
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}
		if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		return false;
	}
	
	//Switch the current player
	private void switchPlayer() {
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}
	
	//Make a move
	private boolean makeMove(int row, int col) {
		if(row >= 0 && row <3 && col >= 0 && col < 3 && board[row][col] == ' ' ) {
			board[row][col] = currentPlayer;
			return true;
		}
		return false;
	}
	
	//Main game loop
	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe! ");
		while(true) {
			printBoard();
			System.out.println("Player" + currentPlayer+ "enter your move (row and colowm)");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			if(makeMove(row, col)) {
				if(hasWinner()) {
					printBoard();
					System.out.println("Player" + currentPlayer+ "wins!");
					break;
				}
				else if(isDraw()) {
					printBoard();
					System.out.println("It's a draw");
					break;
				}
				switchPlayer();
			}
			else {
				System.out.println("Invalid move! Please try again.");
			}
		}
		scanner.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe();
		game.playGame();

	}

}
