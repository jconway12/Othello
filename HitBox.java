public class HitBox{
  private double x0;
  private double y0;
  private double x1;
  private double y1;
  private int boxcode;

  public HitBox(double x0, double y0, double x1, double y1, int boxcode) {
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
    this.boxcode = boxcode;
  }

  /*
   * Return true if this HitBox contains this point
   */
  public boolean contains(double x, double y) {
    boolean c = false;
    if(x > this.x0 && x < this.x1 && y > this.y0 && y < this.y1) {
      c = true;
    }
    return c; 
  }

  public int getBoxcode() {
    return this.boxcode;
  }

}