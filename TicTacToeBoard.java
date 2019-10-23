import java.util.ArrayList;

public class TicTacToeBoard extends Board{
  private int totMoves = 0;
  private ArrayList<Integer> history = new ArrayList<Integer>();

  private int curPlayer;
  private int[][] gameBoard;


  public TicTacToeBoard() {
    this.gameBoard = new int[3][3];
    this.curPlayer = 1;
  }

  public int minMove() {
    return 1;
  }

  public int maxMove() {
    return 9;
  }


  public int getBoardPiece(int r, int c) {
    return gameBoard[r][c];
  }

  /* This is a requirement of a Board Object
   * Return true if the given move number is valid or not
   */
  public boolean isValidMove(int move) {
    return !( move < 1 || move > 9 || gameBoard[(move-1)/3][(move-1)%3] != 0);
  }

  public int curPlayer() {
    return curPlayer;
  }


  /*
   * Make a move - input is a single move number
   * Return true if the move was successful
   * Return false otherwise
   */
  public boolean makeMove(int move) {
    if(isValidMove(move)) {
      history.add(move);
      int row = (move-1)/3;
      int col = (move-1)%3;
      gameBoard[row][col] = curPlayer;
      totMoves++;

      if(isWinning() == curPlayer || totMoves == 9) {
        curPlayer = 0;
      } else {
        curPlayer = 3 - curPlayer;
      }
    }
    return false;
  }

  /*
   * Undo a move
   */
  public void undoMove() {
    int move = history.remove(history.size()-1);
    curPlayer = gameBoard[(move-1)/3][(move-1)%3];
    gameBoard[(move-1)/3][(move-1)%3] = 0;
    totMoves--;
  }

  // Returns 1 for a player 1 win
  // Returns 2 for a player 2 win
  // Returns 3 for a draw
  // Returns 0 for no winner
  public int isWinning() {
    for(int r = 0; r < 3; r++) {
      if( (gameBoard[r][0] != 0) &&
          (gameBoard[r][0] == gameBoard[r][1]) && 
          (gameBoard[r][0] == gameBoard[r][2]) ) {
        return gameBoard[r][0];
      }
    }
    for(int c = 0; c < 3; c++) {
      if( (gameBoard[0][c] != 0) &&
          (gameBoard[0][c] == gameBoard[1][c]) && 
          (gameBoard[0][c] == gameBoard[2][c]) ) {
        return gameBoard[0][c];
      }
    }
    if( (gameBoard[0][0] != 0) &&
        (gameBoard[0][0] == gameBoard[1][1]) && 
        (gameBoard[0][0] == gameBoard[2][2]) ) {
      return gameBoard[0][0];
    }
    if( (gameBoard[0][2] != 0) &&
        (gameBoard[0][2] == gameBoard[1][1]) && 
        (gameBoard[0][2] == gameBoard[2][0]) ) {
      return gameBoard[0][2];
    }
    return 0;
  }

  // This is no longer needed now that we have the GUI
  public String toString() {
    //A StringBuilder is an advanced way to avoid creating lots of string
    //objects as you do your addition.
    char vertLine = '|'; 
    char horzLine = '-'; 
    char crossLine = '+'; 
    StringBuilder s = new StringBuilder(2*(2*3+1)*(3+1));
    s.append(crossLine);
    for(int c = 0; c < 3; c++) {
      s.append(horzLine);
      s.append(crossLine);
    }
    s.append('\n');
    for(int r = 2; r >= 0; r--) {
      for(int c = 0; c < 3; c++) {
        s.append(vertLine);
        s.append(getBoardPiece(r,c));
      }
      s.append(vertLine);
      s.append('\n');
      //A horizontal Line
      s.append(crossLine);
      for(int c = 0; c < 3; c++) {
        s.append(horzLine);
        s.append(crossLine);
      }
      s.append('\n');
    }
    return s.toString();
  }


}