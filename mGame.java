import java.util.*;
import java.io.*;
import java.Scanner.util.*;

public class mGame {
	public static void main(String[] args) throws UnsupportedEncodingException {

    int loop = 0;

    while(loop == 0) {
    UpdatedStartScreen ss = new UpdatedStartScreen();
    EndScreen1 es1 = new EndScreen1();
    EndScreen2 es2 = new EndScreen2();
    EndScreen3 es3 = new EndScreen3();
    Board gameBoard = null;
    GUI gb = null;

    Player p1, p2;

    ss.draw();
    int s1 = ss.waitForResponse();

 if(s1 == 1) {                                 //Play Othello
  gameBoard = new OthelloBoard();
  gb = new GameBoard(gameBoard);

}

else if(s1 == 2) {                                    //Play TTT
   gameBoard = new TicTacToeBoard(); 
   gb = new TicTacToeGUI(gameBoard);

}

int p = PlayerSelect.waitForResponse(); //????

if(p == 1) {
  p1 = new HumanPlayer(1, gb);
}
else if (p == 2) {
  p1 = new RandomPlayer(gameBoard);
}

int t = PlayerSelect.waitForResponse();

if(t == 1) {
  p2 = new HumanPlayer(2, gb);
}
else if(t == 2) {
  p2 = new RandomPlayer(gameBoard);
}

gb.draw();
int move = gb.waitForResponse();

 	while(gameBoard.curPlayer() != 0) {   //While Game not Over

    
    if(gameBoard.curPlayer() == 1) {
      move = p1.decideMove();
    }
    else {
      move = p2.decideMove();
    }
    if(move == -1) {
      gameBoard.undoMove();
    }
    else {
      gameBoard.makeMove();
    }

  

    gameBoard.makeMove(move);

    if(move == 65) {
      System.exit(0);
    }

    gb.draw();
  }

  int replay;

  if(gameBoard.getWinner() == 1) {
   es1.draw();
   replay = es1.waitForResponse();
 }
 else if(gameBoard.getWinner() == 2) {
   es2.draw();
   replay = es2.waitForResponse();
 }
 else {
   es3.draw();
   replay = es3.waitForResponse();
 }

  if(replay == 2) {        //fix later
    loop += 1;
  }

}




  int[] totWins = new int[3];
  String ans;
    //This is a more advanced way of printing characters to the console 
    //System.out.println doesn't always display Unicode well.
  PrintStream out = new PrintStream(System.out, true, "UTF-8");
  Scanner scnr = new Scanner(System.in);
    // Instead of System.out, just use out
    //out.println("Welcome to Othello!");
    // For every game that is played

	}
}