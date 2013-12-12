//Tom Harren, Brian Mitchell, & Pazao Vue
import java.util.Random;

public class Gameboard {
	private String[][] board = new String[3][3];
	private int size = 0;

	//returns the value of the spot
	public String getValue(int x, int y) {
		return board[x][y];
	}

	//checks to see if the spot is taken, then calls play()
	public boolean played(int x, int y) {
		if (board[x][y] == null) {
			play(x,y);
			return true;
		} else {
			return false;
		}
	}
	
	//player gets turn if there's one spot left.
	//otherwise, the computer will play randomly following user's turn
	public void play(int x, int y){
		if(size == 8){
			board[x][y] = "X";
			size++;
		}else if(size % 2 == 0){
			board[x][y] = "X";
			size++;
			
			Random rand = new Random();
			int a = rand.nextInt(3);
			int b = rand.nextInt(3);
			while(played(a,b) == false){
				a = rand.nextInt(3);
				b = rand.nextInt(3);
			}
			board[a][b] = "O";
			size++;
		}
	}
	
	//returns the size/number of turns taken
	public int getSize() {
		return size;
	}
	//resets the game
	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
			}
		}
		size = 0;
		TicTacToeGOOEY.win = 0;
		TicTacToeGOOEY.updateView();
	}
	
	//returns the win value as a string
	public String getWin(int num) {
		if (num == 1) return "you won!";
		if (num == 2) return "you lost!";
		if (num == 3) return "draw!";
		else return "error";
	}
}
