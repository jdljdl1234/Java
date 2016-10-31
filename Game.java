/**
 * @author Namita Singla
 *
 * Class representing othello game
 */
import java.util.Scanner;

public class Game {

  /**
   * Constructor
   *
   */
  public Game() {
    board = new Board(4, 4);
    player1 = new HumanPlayer(1, this);
    player2 = new MachinePlayer(2, this);
    player1.setNext(player2);
    player2.setNext(player1);
    board.drawBoard();
  }

  /**
   * Compute the score for the given player for a play at position (row, col)
   */
  public int score(Player player, Board bd) {
    int value = 0;
    int dx, dy;
    for (dx = -1; dx <= 1; dx++) {
      for (dy = -1; dy <= 1; dy++) {
        value = value + lineValue(player, bd, dx, dy);
      }
    }
    return value;
  }

  /**
   * Compute the value of a line starting at (row,col) position and in the
   * direction specified by (dx,dy).
   *
   * @param player
   *            Player
   * @param bd
   *            Board
   * @param dx
   *            X direction
   * @param dy
   *            Y direction
   * @return value of line
   */
  private int lineValue(Player player, Board bd, int dx, int dy) {
    int score = 0;
    int tempRow = player.getRow() + dx;
    int tempCol = player.getCol() + dy;
    Player opponent = player.getNext();
    if ( (dx == 0) && (dy == 0)) {
      return 0; // simple case
    }
    else {
      while (opponentPieces(bd, tempRow, tempCol, opponent)) {
        score++;
        tempRow = tempRow + dx;
        tempCol = tempCol + dy;
      }
      if (myPiece(bd, tempRow, tempCol, player)) {
        return score;
      }
      else {
        return 0;
      }
    }
  }

  /**
   * Check if piece (row,col) occupied by opponent
   *
   * @param bd
   *            Board
   * @param tempRow
   * @param tempCol
   * @param opponent
   * @return true if piece occupied by opponent
   */
  private boolean opponentPieces(Board bd, int tempRow, int tempCol,
                                 Player opponent) {
    return bd.inRange(tempRow, tempCol) && (bd.get(tempRow, tempCol) != 0)
        && (bd.get(tempRow, tempCol) == opponent.getId());
  }

  /**
   * Check if piece (row,col) occupied by me
   *
   * @param bd
   *            Board
   * @param tempRow
   * @param tempCol
   * @param me
   *            Me
   * @return true if piece occupied by me
   */
  private boolean myPiece(Board bd, int tempRow, int tempCol, Player me) {
    return bd.inRange(tempRow, tempCol) && (bd.get(tempRow, tempCol) != 0)
        && (bd.get(tempRow, tempCol) == me.getId());
  }

  /**
   * Determine if the play at (row, col) is valid for the given player
   *
   * @param player
   *            Given player
   * @param bd
   *            board
   * @return true if (row, col) is a valid move
   */
  public boolean validMove(Player player, Board bd) {

    int row = player.getRow();
    int col = player.getCol();
    return (bd.inRange(row, col) && bd.get(row, col) == 0 && score(player,
        bd) > 0);
  }

  /**
   * No valid move. Player must pass.
   *
   * @param player
   * @param bd
   * @return true if player must pass
   */
  private boolean mustPass(Player player, Board bd) {
    int row, col;
    for (row = 0; row < board.getRow(); row++) {
      for (col = 0; col < board.getColumn(); col++) {
        player.setRow(row);
        player.setCol(col);
        if (bd.get(row, col) == 0) {
          if (validMove(player, bd)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Is game over?
   *
   * @param player
   *            Player trying to make move
   * @param bd
   *            Board
   * @return true if game is over
   */
  public boolean gameOver(Player player, Board bd) {
    // game has yet to start
    if ( (bd == null) || (player == null)) {
      return false;
    }
    return (bd.isFull() || (mustPass(player1, bd) && mustPass(player2, bd)));
  }

  /**
   * Next move
   *
   * @param player
   *            Player making move
   * @param bd
   *            Board
   */
  public void successor(Player player, Board bd) {
    int howMany; // how many to flip?
    int dx, dy;
    int row = player.getRow();
    int col = player.getCol();
    Player opponent = player.getNext();
    bd.set(row, col, player.getId());
    player.setScore(player.getScore() + 1);
    for (dx = -1; dx <= 1; dx++) {
      for (dy = -1; dy <= 1; dy++) {
        howMany = lineValue(player, bd, dx, dy);
        if (howMany > 0) {
          flip(player, bd, dx, dy, howMany);
        }
        player.setScore(player.getScore() + howMany);
        opponent.setScore(opponent.getScore() - howMany);
      }
    }
  }

  /**
   * Flip the pieces (capture them) for the given player for the line starting
   * at (row,col) in (dx,dy) direction.
   *
   * @param player
   * @param bd
   * @param dx
   * @param dy
   * @param num
   */
  private void flip(Player player, Board bd, int dx, int dy, int num) {

    int tempRow = player.getRow();
    int tempCol = player.getCol();
    Player opponent = player.getNext();
    int score = 0;
    if ( (dx == 0) && (dy == 0)) {
      return;
    }
    else {
      tempRow = tempRow + dx;
      tempCol = tempCol + dy;
      while (opponentPieces(bd, tempRow, tempCol, opponent)) {
        score++;
        bd.set(tempRow, tempCol, player.getId());
        tempRow = tempRow + dx;
        tempCol = tempCol + dy;
      }
      if ( (score != num)
          || ( (bd.inRange(tempRow, tempCol))
              && (bd.get(tempRow, tempCol) != 0) && (bd.get(
                  tempRow, tempCol) != player.getId()))) {
        System.out.println("Flip failed consistency check!");
      }
    }
  }

  /**
   * Get winner
   * @return String
   */
  public String getWinner() {
    if (player1.getScore() > player2.getScore()) {
      return "You won";
    }
    else if (player2.getScore() > player1.getScore()) {
      return "Machine won";
    }
    else {
      return "Draw";
    }

  }

  /**
   * Return cuurent player
   *
   * @return Current player
   */
  public Player getCurentPlayer() {
    return turn;
  }

  /**
   * Return board for this game
   *
   * @return
   */
  public Board getBoard() {
    return board;
  }

  /**
   * Play othello game
   */
  public void play() {
    turn = player1;
    System.out.println("--------------------------------");
    while (!gameOver(turn, board)) {
      if (mustPass(turn, board)) {
        if (turn instanceof MachinePlayer) {
          display("No valid move: Machine must pass");
        }
        else {
          display("No valid move: You must pass");
        }
        turn = turn.getNext();
      }
      if (turn instanceof MachinePlayer) {
        turn.makeMove();
      }
      else {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter row (0-3):");
        int r = input.nextInt();
        System.out.print("Enter column (0-3):");
        int c = input.nextInt();
        turn.selectCell(r, c);
      }
      if (validMove(turn, board)) {
        successor(turn, board);
        turn = turn.getNext();
      }
      else {
        display("Illegal move!Select again");
      }
      board.drawBoard();
      System.out.println("----------------------------------");
      System.out.println("Your score:" + player1.getScore());
      System.out.println("Machine score:" + player2.getScore());
    }
  }

  /**
   * Display string on output stream
   */
  private void display(String string) {
    System.out.println(string);
  }

  private Board board;

  private Player player1;

  private Player player2;

  private Player turn; // current player

  /**
   * Main entry point
   *
   * @param args
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.play();
    System.out.println(game.getWinner());
  }

}
