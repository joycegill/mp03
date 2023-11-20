package mp03;

/**
 * Given a text block and a width, builds a new block that centers the block within that width.
 * 
 * @author Joyce Gill
 */
public class Centered implements TextBlock {
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

  /** Build a new line with contents _contents */
  public Centered(TextBlock _block, int _max) {
    this.max = _max;
    this.block = _block;
  } // Centered(TextBlock, int)

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
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
      int center = (this.max - this.block.width()) / 2; // Determine the number of spaces to pad the row
      return TBUtils.spaces(center) + this.block.row(i) + TBUtils.spaces(center);
    } // if/else
  } // row(int)

  public int width() {
    return this.block.width();
  } // width()

  public int height() {
    return this.block.height();
  } // height()

} // class Centered
