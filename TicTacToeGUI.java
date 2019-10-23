public class TicTacToeGUI extends GUI{

  /*
   * Constructs a GUI for TicTacToe. Sets up the Boxes for the way it works
   */
  Board b;
  public TicTacToeGUI(Board b) {
    this.b = b;

    boxes = new HitBox[10];
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        boxes[3*r+c] = new HitBox(c,r,c+1,r+1,3*r+c+1);
      }
    }
    //Undo Box - with boxcode -1
    boxes[9] = new HitBox(3.25,1,4.25,2,-1);
  }

  public void draw() {
    StdDraw.clear();
    StdDraw.setXscale(-1.5,4.5);
    StdDraw.setYscale(0,4);
    //StdDraw.clear();
    //Draw lines
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(0,1,3,1);
    StdDraw.line(0,2,3,2);
    StdDraw.line(1,0,1,3);
    StdDraw.line(2,0,2,3);

    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        switch(b.getBoardPiece(r,c)){
          case 1: 
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(c+.5,r+.5,.375);
            break;
          case 2: 
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(c+.5,r+.5,.375);
            break;
        }
      }
    }

    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.rectangle(3.75,1.5,.5,.5);
    StdDraw.text(3.75,1.5,"Undo");
    StdDraw.show();
  }
}