import java.awt.*;
import javax.swing.*;

public class GameBoard extends GUI {
		
		OthelloBoard boom;

	public GameBoard(OthelloBoard boom) {
		this.boom = boom;
		this.boxes = new HitBox[66];
		int a = 1;
		
		double y = 80.0; 
		double y1 = 90.0;


		for(int j = 0; j < 8; j++) {
			double x1=20.0;
			double x=10.0;	
			for(int i = 0; i < 8; i++) {
			
					
					boxes[a-1] = new HitBox(x, y, x1, y1, a);
					a++;

					x1=x1+10.0;
					x= x+10.0;
			}

			y=y-10.0;
			y1=y1-10.0;
		}

		HitBox c = new HitBox(90.0, 10.0, 100, 20.0, 65);
		boxes[64] = c;

		//HitBox d = new HitBox(40.0, 91.0, 60.0, 99.0, 66);
		//boxes[65] = d;
	}


		public void draw() {
			StdDraw.clear();
			StdDraw.setXscale(0,100);
			StdDraw.setYscale(0,100);

			double circleY = 85;

			for(int g = 0; g < 8; g++) {
				double circleX = 15;
				for(int b = 0; b < 8; b++) {
					if(boom.getBoardPiece(g, b) == 1) {
						StdDraw.picture(circleX, circleY, "panda.png",10.0,10.0);
					}
					else if (boom.getBoardPiece(g, b) == 2) {
						StdDraw.picture(circleX, circleY, "octopus.png",10.0,10.0);
					}
					circleX += 10;
				}
				circleY -= 10;
			}

					
			
			StdDraw.line(10.0,10.0,10.0,90.0);
			StdDraw.line(20.0,10.0,20.0,90.0);
			StdDraw.line(30.0,10.0,30.0,90.0);
			StdDraw.line(40.0,10.0,40.0,90.0);
			StdDraw.line(50.0,10.0,50.0,90.0);
			StdDraw.line(60.0,10.0,60.0,90.0);
			StdDraw.line(70.0,10.0,70.0,90.0);
			StdDraw.line(80.0,10.0,80.0,90.0);
			StdDraw.line(90.0,10.0,90.0,90.0);

			StdDraw.line(10.0,10.0,90.0,10.0);
			StdDraw.line(10.0,20.0,90.0,20.0);
			StdDraw.line(10.0,30.0,90.0,30.0);
			StdDraw.line(10.0,40.0,90.0,40.0);
			StdDraw.line(10.0,50.0,90.0,50.0);
			StdDraw.line(10.0,60.0,90.0,60.0);
			StdDraw.line(10.0,70.0,90.0,70.0);
			StdDraw.line(10.0,80.0,90.0,80.0);
			StdDraw.line(10.0,90.0,90.0,90.0);
        	StdDraw.square(95.0,15.0,5.0);
			StdDraw.text(95.0,15.0,"Quit?");
			//StdDraw.line(40.0, 91.0, 60.0, 91.0);
			//StdDraw.line(40.0, 99.0, 60.0, 99.0);
			//StdDraw.line(40.0, 91.0, 40.0, 99.0);
			//StdDraw.line(60.0, 91.0, 60.0, 99.0);
			//StdDraw.text(50.0, 95.0, "No move?");
			StdDraw.show();



		}
	}
