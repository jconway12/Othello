public class HumanPlayer extends Player {

  // The GUI that the Human uses to input/output
  BoardGUI myGUI;
  // The number of the player (1 or 2)
  int number;

  public HumanPlayer(int number, BoardGUI myGUI) {
    this.number = number;
    this.myGUI = myGUI;
  }

  public String callSign() {
    return "Player "+number;
  }

  public int decideMove() {
    return myGUI.waitForResponse();
  }


}