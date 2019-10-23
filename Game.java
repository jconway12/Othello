import java.util.*;
import java.io.*;

public class Game {
  public static void main(String[] args) throws UnsupportedEncodingException {

   UpdatedStartScreen ss = new UpdatedStartScreen();
   OthelloBoard gameBoard = new OthelloBoard();
   TicTacToeBoard tBoard = new TicTacToeBoard();
   EndScreen1 es1 = new EndScreen1();
   EndScreen2 es2 = new EndScreen2();
   EndScreen3 es3 = new EndScreen3();
   GameBoard ogb = new GameBoard(gameBoard);
   TicTacToeGUI tgb = new TicTacToeGUI(tBoard);

   Player p1, p2;

   ss.draw();
   
   if(ss.waitForResponse()==1){
    //start othello
    ogb.draw();
    while(gameBoard.curPlayer() != 0) {

      int move = ogb.waitForResponse();
    //System.out.println(gameBoard.curPlayer());
   // System.out.println(move);
      
      gameBoard.makeMove(move);
      
      if(move == 66) {
        gameBoard.curPlayer -= 1;
      }

      if(move==65){
       System.exit(0);
     }

     ogb.draw();
     
   }
   if(gameBoard.getWinner()==1){
    es1.draw();
  }
  else if(gameBoard.getWinner()==2){
    es2.draw();
  }
  else{es3.draw();}
}


else if(ss.waitForResponse()==2){
  tgb.draw();
  while(gameBoard.curPlayer() != 0) {
    int move=tgb.waitForResponse();
    tBoard.makeMove(move);
    tgb.draw();}

    if(gameBoard.getWinner()==1){
      es1.draw();
    }
    else if(gameBoard.getWinner()==2){
      es2.draw();
    }
    else{es3.draw();}
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

