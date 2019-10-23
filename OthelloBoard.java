// Directions: Make an object to represent a Othello/Reversi board object.

// It is entirely up to you to decide how you want to store the game
// state, what variables you want you use, what helper methods you want to
// write, etc.
// Your code will be graded primarily on correctness. It will also be graded
// on good style, efficiency, organization, and proper encapsulation
//
// You may implement this object in anyway you wish. The only requirements are
// that you keep the interface methods the same.

// The Extra Credit component on this assignment is:
// Make the user interface better by listing the set of valid moves as
// row,column pairs for the player.
// You would need to modify Game.java as well as adding a helper method in
// OthelloBoard. (20%)

/*PROBLEMS:
1. BLUE PLAYER CANNOT MAKE A WRONG MOVE OR WILL LOSE TURN
2. BOUNDARY AREAS CAUSE ARRAY ISSUES (CANNOT END GAME NATURALLY)
*/
import java.util.ArrayList;
public class OthelloBoard extends Board {
 private boolean p1turn = true;
 private boolean p1wins = true;
 private boolean tie;
 private String[][] board;
 private boolean move;
 private int[] bc = new int[64];
 private int turncount = 1;
 private boolean boardFull;
 private ArrayList<Integer> flipHistory = new ArrayList<Integer>();
 public int curPlayer;
 public int[] moveTracker = new int[2];
  /*
   * Construct a blank OthelloBoard object.
   */
  public OthelloBoard() {
    board = new String[8][8];


    for(int j = 0; j < 8; j++) {
      for(int i = 0; i < 8; i++) {
        board[j][i] = "[_]";
      }
    } 
    board[3][3] = "[X]";
    board[4][3] = "[O]";
    board[3][4] = "[O]";
    board[4][4] = "[X]";
    this.curPlayer=1;

    /*for(int a = 0; a < 8; a++) {
      System.out.println();
      for(int b = 0; b < 8; b++) {
        System.out.print(board[b][a]);
      } */
    }


  /*
   * Returns 1 or 2 depending on who the current player is
   * Return 0 if the game is over.
   */


  public int curPlayer() {
return curPlayer;
  }


  



  /*
   * Returns 1 or 2 if player 1 or 2 won the game
   * Return 0 if the game is a tie
   * This function will only be called AFTER the Game file already knows that
   * the game is over via curPlayer.
   *
   * See the code in Game.java
   */
  public int getWinner() {
    int numO = 0;
    int numX = 0;
    for(int j = 0; j < 8; j++) {
      for(int i = 0; i < 8; i++) {
        if(this.board[i][j].equals("[X]")) {
          numX++;
        }
        if(this.board[i][j].equals("[O]")) {
          numO++;
        }
      }
    }

    if(numX > numO) {
      this.p1wins = true; 
      return 1;
    }
    if(numO > numX) {
      this.p1wins = false; 
      return 2;
    }

    else {
      return 0;
    }
  }

  /*
   * Returns 0 if the board at row,column is empty, otherwise return 1 or 2
   * corresponding to the player.
   */

  public int getBoardPiece(int row, int column) {
   if (board[row][column].equals("[X]")) {
    return 2;
  }
  else if (board[row][column].equals("[O]")) {
    return 1;
  }
  else {
    return 0;
  }
}

public int isWinning() {
    int numO = 0;
    int numX = 0;
    for(int j = 0; j < 8; j++) {
      for(int i = 0; i < 8; i++) {
        if(this.board[i][j].equals("[X]")) {
          numX++;
        }
        if(this.board[i][j].equals("[O]")) {
          numO++;
        }
      }
    }

    if(numO > numX) {
      return 1;
    }
    else if (numX > numO) {
      return 2;
    }
    else {
      return 0; //tie
    }
}

public int minMove() {
    boolean validMove = false;
    int i=1;
    while(validMove == false){
      
      if(isValidMove(i)){
        validMove=true;
      }

      else{i++;}
      if(i>64){
        i=-1;
        validMove=true;
      }

    }

  return i;
}



public int maxMove() {
  boolean validMove= false;
    int i=64;
    while(validMove=false){
      
      if(isValidMove(i)){
        validMove=true;
      }

      else{i--;}

    }
    if(i<0){
        i=-1;
        validMove=true;
      }


  return i;

}

public void undoMove() {
  String pp, op;

  if(curPlayer == 1) {
    pp = "[O]";
    op = "[X]";
  }
  else {
    pp = "[X]";
    op = "[O]";
  }

  int a = flipHistory.size();
  int row = moveTracker[0];
  int column = moveTracker[1];
  board[row][column] = op;
  int r, c;

  for(int i = 0; i < a; i++) {  //fix syntax but right idea
    int place = flipHistory.get(0);
    r = (place - 1) / 8;
    c = (place - 1) % 8;
    board[r][c] = op;
    flipHistory.remove(new Integer(0));
  }

  curPlayer = 3-curPlayer;
  turncount--;

}

public boolean isValidMove(int boxCode) {
   System.out.println("Turncount: " + turncount);
  int row = (boxCode - 1) / 8;
  int column = (boxCode - 1) % 8;
    String playerPiece;
    String otherPiece;

    if(curPlayer==1) {
     playerPiece = "[O]";
     otherPiece = "[X]";
   }
   else {
    playerPiece = "[X]";
    otherPiece = "[O]";
  }


    this.move = false; //player 1 turn, player 2 is X
    if (row >= 8 || column >= 8){
      move = false;
    }
    else if (board[row][column].equals("[O]") || board[row][column].equals("[X]")){
      move = false;
    }

    else {

      if(row > 0 && board[row-1][column].equals(otherPiece)) {
        int r = row-1;
        while(board[r][column].equals(otherPiece) && r > 0) {
          r--;
        }
        if(board[r][column].equals(playerPiece)){
          move = true;
        }

      }

      if (column > 0 && board[row][column-1].equals(otherPiece)) {
        int c = column-1;
        while(board[row][c].equals(otherPiece) && c > 0) {
          c--;
        }
        if(board[row][c].equals(playerPiece)){
          move = true;
        }

      }
      

      if (row > 0 && column > 0 && board[row-1][column-1].equals(otherPiece)) {
        int r1 = row-1;
        int c1 = column-1;
        while(board[r1][c1].equals(otherPiece) && r1 > 0 && c1 > 0) {
          r1--;
          c1--;
        }
        if(board[r1][c1].equals(playerPiece)) {
          move = true;
        }

      }

      if (row < 7 && column < 7 && board[row+1][column+1].equals(otherPiece)) {
        int r2 = row+1;
        int c2 = column+1;
        while(board[r2][c2].equals(otherPiece) && r2 < 7 && c2 < 7) {
          r2++;
          c2++;
        }
        if(board[r2][c2].equals(playerPiece)) {
          move = true;
        }

      }

      if (row < 7 && column > 0 && board[row+1][column-1].equals(otherPiece)) {
       int r3 = row+1;
       int c3 = column-1;
       while(board[r3][c3].equals(otherPiece) && r3 < 7 && c3 > 0) {
        r3++;
        c3--;
      }
      if(board[r3][c3].equals(playerPiece)) {
        move = true;
      }

    }

    if (row > 0 && column < 7 && board[row-1][column+1].equals(otherPiece)) {
     int r4 = row-1;
     int c4 = column+1;
     while(board[r4][c4].equals(otherPiece) && r4 > 0 && c4 < 7) {
      r4--;
      c4++;
    }
    if(board[r4][c4].equals(playerPiece)) {
      move = true;

    }

  }

  if (column < 7 && board[row][column+1].equals(otherPiece)) {
    int c5 = column+1;
    while(board[row][c5].equals(otherPiece) && c5 < 7) {
      c5++;
    }
    if(board[row][c5].equals(playerPiece)){
      move = true;

    }
  }

    if (row < 7 && board[row+1][column].equals(otherPiece)) {
      int r5 = row+1;
      while(board[r5][column].equals(otherPiece) && r5 < 7) {
        r5++;
      }
      if(board[r5][column].equals(playerPiece)){
        move = true;

      }

    }  
  }

if (move) {
  board[row][column] = playerPiece;
  //add move to moveHistory
}


return move;
}
 
 public boolean hasValidMove() {
        boolean validMove = false;
        String playerPiece;
        String otherPiece;

        if(curPlayer == 1) {
           playerPiece = "[O]";
           otherPiece = "[X]";
       }
       else {
        playerPiece = "[X]";
        otherPiece = "[O]";
    }

    for(int i = 1; i < 65; i++) {
      int row = (i - 1) / 8;
      int column = (i - 1) % 8;

      if(row > 0 && board[row-1][column].equals(otherPiece)) {
        int r = row-1;
        while(board[r][column].equals(otherPiece) && r > 0) {
          r--;
      }
      if(board[r][column].equals(playerPiece)){
          validMove = true;
      }

  }

  if (column > 0 && board[row][column-1].equals(otherPiece)) {
    int c = column-1;
    while(board[row][c].equals(otherPiece) && c > 0) {
      c--;
  }
  if(board[row][c].equals(playerPiece)){
      validMove = true;
  }

}


if (row > 0 && column > 0 && board[row-1][column-1].equals(otherPiece)) {
    int r1 = row-1;
    int c1 = column-1;
    while(board[r1][c1].equals(otherPiece) && r1 > 0 && c1 > 0) {
      r1--;
      c1--;
  }
  if(board[r1][c1].equals(playerPiece)) {
      validMove = true;
  }

}

if (row < 7 && column < 7 && board[row+1][column+1].equals(otherPiece)) {
    int r2 = row+1;
    int c2 = column+1;
    while(board[r2][c2].equals(otherPiece) && r2 < 7 && c2 < 7) {
      r2++;
      c2++;
  }
  if(board[r2][c2].equals(playerPiece)) {
      validMove = true;
  }

}

if (row < 7 && column > 0 && board[row+1][column-1].equals(otherPiece)) {
 int r3 = row+1;
 int c3 = column-1;
 while(board[r3][c3].equals(otherPiece) && r3 < 7 && c3 > 0) {
    r3++;
    c3--;
}
if(board[r3][c3].equals(playerPiece)) {
    validMove = true;
}

}

if (row > 0 && column < 7 && board[row-1][column+1].equals(otherPiece)) {
   int r4 = row-1;
   int c4 = column+1;
   while(board[r4][c4].equals(otherPiece) && r4 > 0 && c4 < 7) {
      r4--;
      c4++;
  }
  if(board[r4][c4].equals(playerPiece)) {
      validMove = true;

  }

}

if (column < 7 && board[row][column+1].equals(otherPiece)) {
    int c5 = column+1;
    while(board[row][c5].equals(otherPiece) && c5 < 7) {
      c5++;
  }
  if(board[row][c5].equals(playerPiece)){
      validMove = true;

  }
}

if (row < 7 && board[row+1][column].equals(otherPiece)) {
  int r5 = row+1;
  while(board[r5][column].equals(otherPiece) && r5 < 7) {
    r5++;
}
if(board[r5][column].equals(playerPiece)){
    validMove = true;

}

}  

}

return validMove;
}



public boolean makeMove(int boxCode) {
  int[] moveTracker = new int[2];
  System.out.println("Turncount: " + turncount);
  int row = (boxCode - 1) / 8;
  int column = (boxCode - 1) % 8;
  String playerPiece;
  String otherPiece;
  if(curPlayer==1) {
   playerPiece = "[O]";
   otherPiece = "[X]";
 }
 else {
  playerPiece = "[X]";
  otherPiece = "[O]";
}


    this.move = false; //player 1 turn, player 2 is X
    if (row >= 8 || column >= 8){
      move = false;
    }
    else if (board[row][column].equals("[O]") || board[row][column].equals("[X]")){
      move = false;
    }

    else {

      if(row > 0 && board[row-1][column].equals(otherPiece)) {
        int r = row-1;
        while(board[r][column].equals(otherPiece) && r > 0) {
          r--;
        }
        if(board[r][column].equals(playerPiece)){
          move = true;
          while(r < row) {
            r++;
            this.board[r][column] = playerPiece;

            flipHistory.add((r)*8 + (column + 1));
          } 
        }

      }

      if (column > 0 && board[row][column-1].equals(otherPiece)) {
        int c = column-1;
        while(board[row][c].equals(otherPiece) && c > 0) {
          c--;
        }
        if(board[row][c].equals(playerPiece)){
          move = true;
          while(c < column) {
            c++;
            this.board[row][c] = playerPiece;

            flipHistory.add((row)*8 + (c + 1));
          }
        }

      }
      

      if (row > 0 && column > 0 && board[row-1][column-1].equals(otherPiece)) {
        int r1 = row-1;
        int c1 = column-1;
        while(board[r1][c1].equals(otherPiece) && r1 > 0 && c1 > 0) {
          r1--;
          c1--;
        }
        if(board[r1][c1].equals(playerPiece)) {
          move = true;
          while(r1 < row && c1 < column) { 
            r1++;
            c1++;
            this.board[r1][c1] = playerPiece;

            flipHistory.add((r1)*8 + (c1 + 1));
          }
        }

      }

      if (row < 7 && column < 7 && board[row+1][column+1].equals(otherPiece)) {
        int r2 = row+1;
        int c2 = column+1;
        while(board[r2][c2].equals(otherPiece) && r2 < 7 && c2 < 7) {
          r2++;
          c2++;
        }
        if(board[r2][c2] .equals(playerPiece)) {
          move = true;
          while(r2 > row && c2 > column) {
            r2--;
            c2--;
            this.board[r2][c2] = playerPiece;

            flipHistory.add((r2)*8 + (c2 + 1));
          }
        }

      }

      if (row < 7 && column > 0 && board[row+1][column-1].equals(otherPiece)) {
       int r3 = row+1;
       int c3 = column-1;
       while(board[r3][c3].equals(otherPiece) && r3 < 7 && c3 > 0) {
        r3++;
        c3--;
      }
      if(board[r3][c3].equals(playerPiece)) {
        move = true;
        while(c3 < column && r3 > row){
          r3--;
          c3++;
          this.board[r3][c3] = playerPiece;

            flipHistory.add((r3)*8 + (c3 + 1));
        }
      }

    }

    if (row > 0 && column < 7 && board[row-1][column+1].equals(otherPiece)) {
     int r4 = row-1;
     int c4 = column+1;
     while(board[r4][c4].equals(otherPiece) && r4 > 0 && c4 < 7) {
      r4--;
      c4++;
    }
    if(board[r4][c4].equals(playerPiece)) {
      move = true;
      while(r4 < row && c4 > column) {
        r4++;
        c4--; 
        this.board[r4][c4] = playerPiece;

        flipHistory.add((r4)*8 + (c4 + 1));
      }

    }

  }
  if (column < 7 && board[row][column+1].equals(otherPiece)) {
    int c5 = column+1;
    while(board[row][c5].equals(otherPiece) && c5 < 7) {
      c5++;
    }
    if(board[row][c5].equals(playerPiece)){
      move = true;
      while(c5 > column) {
        c5--;
        this.board[row][c5] = playerPiece;

        flipHistory.add((row)*8 + (c5 + 1));
      }
    }

  }

  if (row < 7 && board[row+1][column].equals(otherPiece)) {
    int r5 = row+1;
    while(board[r5][column].equals(otherPiece) && r5 < 7) {
      r5++;
    }
    if(board[r5][column].equals(playerPiece)){
      move = true;
      while(r5 > row) {
        r5--;
        this.board[r5][column] = playerPiece;

        flipHistory.add((r5)*8 + (column + 1));
      }
    }

  }

}  

if (move) {
  board[row][column] = playerPiece;
  curPlayer = 3 - curPlayer;
  turncount++;

  moveTracker[0] = row;
  moveTracker[1] = column;
}

if(hasValidMove() == false) {
  curPlayer = 3 - curPlayer;
}
if(hasValidMove() == false) {
  curPlayer = 0;
}

return move;
}


}

//right now makeMove is redundant, does it only need to make the move?




