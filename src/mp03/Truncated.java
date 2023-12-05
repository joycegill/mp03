package mp03;

/**
 * Given a text block and a maximum width, builds a new block that truncates the input block to that width.
 * 
 * @author Joyce Gill
 */

public class Truncated implements TextBlock {
  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+---------------------------------------------------------

  // The contents in the block 
  TextBlock block;

  // The maximum width of the TextBlock block 
  int max;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+---------------------------------------------------

  /** Build a new line with block _block */
  public Truncated(TextBlock _block, int _max) {
    this.max = _max;
    this.block = _block;
  } // Truncated(TextBlock, int)

  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+--------------------------------------------------------

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= 1 < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    // Return empty string when empty
    if (this.max == 0) { 
      return "";
    } // if
    
    // Check that i is in the valid range
    if (i < 0 || i >= this.block.height()) { 
      throw new Exception("Error: Invalid row");
    } // if
    // If the block's width is greater than this.max
    else if (this.block.width() < this.max) { 
      return this.block.row(i);
    } // else if
    else {
      while (i < this.max) {
        return this.block.row(i).substring(0, max);
      } // while
    } // else
    return null;
  } // row(int)

  /** Determine how many rows are in the block */
  public int width() {
    return this.block.width();
  } // width()

  /** Determine how many columns are in this block */
  public int height() {
    return this.block.height();
  } // height()
} // class Truncated
