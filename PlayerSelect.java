public class PlayerSelect extends GUI{
	public PlayerSelect(){
		 this.boxes = new HitBox[4]; 
		this.boxes[0]= new HitBox(23.3,43.3,10.0,30.0,1);
		this.boxes[1]= new HitBox(56.6,76.6,10.0,30.0,2);
		this.boxes[2]= new HitBox(23.3,43.3,35.0,55.0,3);
		this.boxes[3]= new HitBox(56.6,76.6,35.0,55.0,4);
		}
	public void draw(){
		StdDraw.clear();
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(0,100);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.text(50.0,80.0, "Select Player");
		StdDraw.text(33.3,60.0, "Player 1");
		StdDraw.text(66.6,60.0, "Player 2");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledSquare(33.3,45.0,10.0);
		StdDraw.filledSquare(33.3,20.0,10.0);
		StdDraw.filledSquare(66.6,45.0,10.0);
		StdDraw.filledSquare(66.6,20.0,10.0);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.text(33.3,45.0,"Human");
		StdDraw.text(66.6,45.0,"Human");
		StdDraw.text(33.3,20.0,"Computer");
		StdDraw.text(66.6,20.0,"Computer");
		StdDraw.show();
	}

}