/**
 * @author Namita Singla
 *
 * Class representing Othello Board
 */
public class Board {
  private int row, column;
  private int board[][];

  /**
   * Constructor Create and initialize the board
   *
   * @param row
   *            number of rows
   * @param col
   *            number of columns
   */
  public Board(int row, int column) {
    this.row = row;
    this.column = column;
    board = new int[row][column];
    reset();
  }

  /**
   * Reset board
   */

  public void reset() {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        board[i][j] = 0;
      }
    }
    // initial board setup
    set(1, 1, 1);
    set(1, 2, 2);
    set(2, 1, 2);
    set(2, 2, 1);
  }

  /**
   * Set the piece in board
   *
   * @param row
   *            of the piece
   * @param col
   *            of the piece
   * @param playerId
   */
  public void set(int row, int col, int playerId) {
    if (inRange(row, col)) {
      board[row][col] = playerId;
    }
    else {
      throw new OutOfBoardException("Accessing out of Board");
    }
  }

  /**
   * Return no. of rows in board
   * @return no. of rows
   */
  public int getRow() {
    return row;
  }

  /**
   * Return no. of columns in board
   * @return no. of columns
   */
  public int getColumn() {
    return column;
  }

  /**
   * Is board full?
   * @return true if board is full
   */
  public boolean isFull() {
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (get(r, c) == 0) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Is (row,col) in range of the board?
   * @param row Row
   * @param col Column
   * @return true if (row,col) in range
   */
  public boolean inRange(int testRow, int testCol) {
   
    if ((testRow >= 0 && testRow < row) && (testCol >= 0 && testCol < column))
         return true;  

      else
        return false;
  }

  /**
   * Get piece in board.
   * @param row Row
   * @param col Column
   * @return Player Id
   */
  public int get(int row, int col) {
    if (inRange(row, col)) {
      return (board[row][col]);
    }
    else {
      throw new OutOfBoardException("Accessing out of Board");
    }
  }

  /**
   * Draw board
   */
  public void drawBoard() {
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (board[r][c] == 0) {
          System.out.print("." + "\t");
        }
        else {
          if (get(r, c) == 1) {
            System.out.print("H" + "\t");
          }
          if (get(r, c) == 2) {
            System.out.print("M" + "\t");
          }
        }
      }
      System.out.println();
    }
  }
}
