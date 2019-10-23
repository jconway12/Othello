import java.util.Random;
import java.util.ArrayList;

public class RandomPlayer extends Player{

  /* Fields */
  Random rand;
  Board b;

  /* Methods */
  public RandomPlayer(Board b) {
    this.rand = new Random();
    this.b = b;
  }

  public String callSign() {
    return "Random";
  }

  public int decideMove() {
    ArrayList<Integer> valids = b.validMoves();
    return valids.get(rand.nextInt(valids.size()));
  }
}