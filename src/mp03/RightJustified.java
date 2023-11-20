package mp03;

/**
 * Given a text block and a width, builds a new block that right-justifies the input block within that width.
 * 
 * @author Joyce Gill
 */

public class RightJustified implements TextBlock {
  // +--------+---------------------------------------------------------
  // | Fields |
  // +--------+---------------------------------------------------------

  /** The contents in the block */
  TextBlock block;

  /** The width of the block */
  int max;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+---------------------------------------------------

  /** Build a new line with block  */
  public RightJustified(TextBlock _block, int _max) {
    this.max = _max;
    this.block = _block;
  } // RightJustified (TextBlock, int)

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
    if (this.max == 0) { // Return empty string when empty
      return "";
    } // if

    if (i < 0 || i >= this.block.height()) { // Check that i is in the valid range
      throw new Exception("Error: Invalid row");
    } // if

    if (this.block.width() > this.max) { // If the block's width is greater than this.max
      TextBlock block2 = new Truncated(block, max);
      return block2.row(i);
    } // if
    else {
      int pad = this.max - this.block.width(); // Pad the row to right-justify the string
      return TBUtils.spaces(pad) + this.block.row(i);
    } // else
  } // row(int)

  /** Determine how many rows are in the block. */
  public int width() {
    return this.block.width();
  } // width()

  /** Determine how many columns are in the block. */
  public int height() {
    return this.block.height();
  } // height()
} // class RightJustified
