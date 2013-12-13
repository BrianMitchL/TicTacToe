//Tom Harren, Brian Mitchell, & Pazao Vue
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ClickListener implements ActionListener { 
	private Gameboard game;
	private int x;
	private int y;

	public ClickListener(Gameboard game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}

	public void actionPerformed(ActionEvent event) {
		//will only play if no one has won or lost the game
		if (TicTacToeGOOEY.win == 0) {

			game.played(x, y);
			TicTacToeGOOEY.updateView();

			//1 == player win, 2 == computer win
			if (winner() == 1){
				TicTacToeGOOEY.win = 1;
				TicTacToeGOOEY.human++;
			}else if (winner() == 2){
				TicTacToeGOOEY.win = 2;
				TicTacToeGOOEY.computer++;
			}else if (game.getSize() == 9){
				TicTacToeGOOEY.tie++;
			}

			//Endgame popup
			if (winner() != 0 || game.getSize() == 9) {
				if (JOptionPane.showConfirmDialog(null, game.getWin(TicTacToeGOOEY.win) 
						+"\n Human: "+ TicTacToeGOOEY.human
						+"\n Computer: "+ TicTacToeGOOEY.computer
						+"\n Ties: "+ TicTacToeGOOEY.tie
						+"\nGame over. Play again?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				 game.resetBoard();
				}else System.exit(0);
			}
		}
	}

	// returns 0 if there is no winner, 1 for a player X win and 2 for a player O win
	public int winner(){
		if(game.getValue(0,0) == (game.getValue(0, 1)) && game.getValue(0, 1) == (game.getValue(0, 2))){
			if (game.getValue(0, 1) == "X")	return 1;
			else if (game.getValue(0, 1) == "O") return 2;
		}else if (game.getValue(1, 0) == (game.getValue(1, 1)) && game.getValue(1, 1) == (game.getValue(1, 2))){
			if (game.getValue(1, 1) == "X")	return 1;
			else if (game.getValue(1, 1) == "O") return 2;
		}else if (game.getValue(2, 0) == (game.getValue(2, 1)) && game.getValue(2, 1) == (game.getValue(2, 2))){
			if (game.getValue(2, 1) == "X")	return 1;
			else if (game.getValue(2, 1) == "O") return 2;
		}

		else if (game.getValue(0,0) == (game.getValue(1,0)) && game.getValue(1,0) == (game.getValue(2,0))){
			if (game.getValue(1,0) == "X")	return 1;
			else if (game.getValue(1,0) == "O") return 2;
		}else if (game.getValue(0,1) == (game.getValue(1,1)) && game.getValue(1,1) == (game.getValue(2,1))){
			if (game.getValue(1,1) == "X")	return 1;
			else if (game.getValue(1,1) == "O") return 2;
		}else if (game.getValue(0,2) == (game.getValue(1,2)) && game.getValue(1,2) == (game.getValue(2,2))){
			if (game.getValue(1,2) == "X")	return 1;
			else if (game.getValue(1,2) == "O") return 2;
		}

		else if (game.getValue(0,0) == (game.getValue(1,1)) && game.getValue(1,1) == (game.getValue(2,2))){
			if (game.getValue(1,1) == "X")	return 1;
			else if (game.getValue(1,1) == "O") return 2;
		}
		else if (game.getValue(2,0) == (game.getValue(1,1)) && game.getValue(1,1) == (game.getValue(0,2))){
			if (game.getValue(1,1) == "X")	return 1;
			else if (game.getValue(1,1) == "O") return 2;
		}
		return 0;
	}
}
