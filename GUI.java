/*
 * GUI stands for graphical user interface. It controls all the user
 * input/output.
 * It should be separate from the "model" that stores/manipulates data. 
 */
public class GUI {
  //Available to subtypes
  protected HitBox[] boxes;

  /*
   * An already implemented helper method that 
   * returns false if there was no mouseclick
   * returns true if there was a mouseclick - this method only returns when
   * the mouse is let go
   */
  private boolean wasClicked(){
    if(StdDraw.mousePressed()) {
      while(StdDraw.mousePressed()){
      }
      return true; //This way, this only returns when the mouse button is let go
    }
    return false;
  }

  /*
   * This method should go into an infinite loop, and only return when a
   * valid HitBox for this object is pressed. Return the boxcode for that
   * hitbox object. 
   * You should use the wasClicked() method above.
   * You will need to look at the documentation for the StdDraw class to
   * figure out how to retrieve the x and y coordinates of the mouse click.
   */
  public int waitForResponse() {
    int bc = 0;
  while(true) {
   if(wasClicked()) {  
    double x = StdDraw.mouseX();
    double y = StdDraw.mouseY();


    for(int i = 0; i < boxes.length; i++) {
     if(boxes[i].contains(x, y)) {
      return boxes[i].getBoxcode();
     }
    }
  }}
  }

  /*
   * display output to the screen
   * Nothing happens in the base parent class, but this should be overwritten
   * by the children classes
   */
  public void draw() {
    StdDraw.clear();

    StdDraw.show();
  }



}