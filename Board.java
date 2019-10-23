// Abstract Class for any 2-Dimensional, 2-Player game board.
import java.util.ArrayList;

public abstract class Board {

  abstract int getBoardPiece(int r, int c);

  abstract int curPlayer();
     
  abstract int isWinning();

  // MODIFIED!
  // Take a single integer as the parameter instead of a row/col
  abstract boolean isValidMove(int boxcode);
   



  // MODIFIED!
  // Take a single integer as the parameter instead of a row/col
  // ALSO, make sure valid moves are stored in the "history"
  abstract boolean makeMove(int boxcode);
    
  // NEW!!
  // Return the minimum possible move number
  abstract int minMove();

  // NEW!!
  // Return the maximum possible move number
  abstract int maxMove();

  // NEW!!
  // Undo a move that was made
  // NOTE: This means that each board must keep histories of all moves that
  // were made in such a way that they are easy to undo
  abstract void undoMove();

  // abstract int getWinner();

  // NEW!!
  /*
   * Return a method that works for all "boards"
   *
   * Return the set of all possible moves for the current player, as an
   * ArrayList
   */
  public ArrayList<Integer> validMoves() {
    // Your code goes here
    ArrayList availableMoves = new ArrayList();
    
    for(int i=this.minMove();i<=this.maxMove();i++){
      if(isValidMove(i)== true){
       availableMoves.add(i);
      }

    }

    return availableMoves;
  }

}