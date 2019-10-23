public class UpdatedStartScreen extends GUI{
	public UpdatedStartScreen(){
		 this.boxes = new HitBox[2]; 
		this.boxes[0]= new HitBox(18.3, 18.3,48.5,48.5,1);
		this.boxes[1]= new HitBox(51.6,18.3,70.0,48.5,2);
		}
	public void draw(){
		StdDraw.clear();
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(0,100);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.text(50.0,75.0, "Let's Play!");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledSquare(33.3,33.3,15.0);
		StdDraw.filledSquare(66.6,33.3,15.0);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.text(33.3,33.3,"Play Othello");
		StdDraw.text(66.6,33.3,"Play Tic Tac Toe");
		StdDraw.show();
	}

}