import java.util.*;
public class LookAheadAIPlayer extends Player {

  // The number of the player (1 or 2)
  int thisPlayer;
  // The number of moves ahead to look
  int lookahead;
  // The Board that this is playing on
  Board board;

  public LookAheadAIPlayer(int thisPlayer, int lookahead, Board b) {
    this.thisPlayer = thisPlayer;
    this.lookahead = lookahead;
    this.board = b;
  }

  public String callSign() {
    switch(lookahead) {
      case(2): return "Easy AI";
      case(4): return "Medium AI";
      case(6): return "Hard AI";
    }
  }

  // Returns the int of the $move$, not the value that the Player chooses,
  // among the set of valid moves
  public int decideMove() {
    int move;

    return move;
  }
  

  //Returns the value of this board with respect to this player, as well as
  //the corresponding move number in a 2 element array.
  //
  // Look at the minimax algorithm on wikipedia for pseudocode.
  //
  // Instead of creating children nodes, as the pseudocode suggests, we will
  // 1. run *make move* when considering each possible valid move
  // 2. recusrively evaluate that board after the move is made
  // 3. run undomove before considering the next move on the list
  //
  private int[] minimax(int depth) {
    //bestMove = best (0 = value, 1 = boxCode)

    int[] bestMove = new int[2];
    int curMoveVal;
    bestMove[0] = -1000;

    if (depth == 0) {
      return bestMove;
    }

    else {

    
     for(int i = 1; i < 65; i++) {

       if(this.board.hasValidMove(i)) {

         this.board.makeMove(i);

         if (this.board.curPlayer() == 0 && this.board.getWinner() == this.thisPlayer) {
           curMoveVal = 1000;
           bestMove[1] = i;
         }

         else if (this.board.curPlayer() == 0 && this.board.getWinner() != this.thisPlayer) {
          curMoveVal = -1000;
        } 

        else {
          curMoveVal = 0;
        }

         if(curMoveVal > bestMove[0]) {
          bestMove[0] = curMoveVal;
          bestMove[1] = i;
        }

      } 
       
      return minimax(depth - 1);
      this.board.undoMove();

    }
    
  }

}


}