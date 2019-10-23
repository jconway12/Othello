public class EndScreen1 extends GUI{
	public EndScreen1(){
		this.boxes = new HitBox[2]; 
		this.boxes[0]= new HitBox(27.5,15.0,47.5,35.0,1); //change coordinates (BOX CODE = 66)
		this.boxes[1]= new HitBox(52.5,15.0,72.5,35.0,2);
		
		}
	public void draw(){
				StdDraw.clear();
				StdDraw.setXscale(0,100);
		StdDraw.setYscale(0,100);
				StdDraw.text(50.0,75.0, "Player 1 Wins!");
				StdDraw.text(50.0,50.0,"Play Again?");
				StdDraw.square(37.5,25.0,10.0);
				StdDraw.text(37.5, 25.0,"Yes");
				StdDraw.square(62.5,25.0,10.0);
				StdDraw.text(62.5, 25.0,"No");
				StdDraw.show();

}
	}
