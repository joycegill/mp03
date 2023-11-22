package mp03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**
 * Test to make sure that the procedures for TextBlock works correctly
 * 
 * @author Joyce Gill
 */

public class TextBlockTests {
  TextBlock emptyTest = new TextLine("");
  TextBlock lineLess = new TextLine("Hello");
  TextBlock lineTest = new TextLine("Hello World");
  TextBlock boxTest = new BoxedBlock(lineTest);

  /* Test to make sure truncate() works correctly */
  @Test
  public void truncateTest() {
    // Create objects
    TextBlock emptyTest_ = new Truncated(emptyTest, 0); 
    TextBlock lineTestLess = new Truncated(lineTest, 5);
    TextBlock lineTestEqual = new Truncated(lineTest, 11);
    TextBlock lineTestGreater = new Truncated(lineTest, 30);
    TextBlock boxTestEqual = new Truncated(boxTest, 13);
    
    try {
      // Make sure they work correctly 
      assert(TBUtils.equal(emptyTest, emptyTest_));
      assert(TBUtils.equal(lineLess, lineTestLess));
      assert(TBUtils.equal(lineTest, lineTestEqual));
      assert(TBUtils.equal(lineTest, lineTestGreater)); //output?
      assert(TBUtils.equal(boxTest, boxTestEqual));
    } catch (Exception e) {
      assertTrue(false);
    } // try/catch

  } // truncateTest()

  /* Test to make sure centered() works correctly */
  @Test
  public void centeredTest() {
    // Create objects
    TextBlock emptyTest_ = new Centered(emptyTest, 0); 
    TextBlock lineTestLess = new Centered(lineTest, 5);
    TextBlock lineTestEqual = new Centered(lineTest, 11);
    TextBlock lineTestGreater = new Centered(lineTest, 30);
    TextBlock boxTest_ = new Centered(boxTest, 13);
    
    try { 
      // Make sure they work correctly 
      assert(TBUtils.equal(emptyTest, emptyTest_));
      assert(TBUtils.equal(new TextLine("Hello"), lineTestLess));
      assert(TBUtils.equal(lineTest, lineTestEqual)); 
      assert(TBUtils.equal(new TextLine("         Hello World         "), lineTestGreater));
      assert(TBUtils.equal(boxTest, boxTest_));
    } catch (Exception e) {
      assert(false): "Error: Centered working incorrectly";
    } // try/catch
  } // centeredTest()

  /* Test to make sure rightJustified() works correctly */
  @Test
  public void rightJustifiedTest() {
    // Create objects
    TextBlock emptyTest_ = new RightJustified(emptyTest, 0); 
    TextBlock lineTestLess = new Centered(lineTest, 5);
    TextBlock lineTestEqual = new RightJustified(lineTest, 11);
    TextBlock lineTestGreater = new RightJustified(lineTest, 30);
    TextBlock boxTest_ = new RightJustified(boxTest, 13);

    try { 
      // Make sure they work correctly 
      assert(TBUtils.equal(emptyTest, emptyTest_));
      assert(TBUtils.equal(new TextLine("Hello"), lineTestLess));
      assert(TBUtils.equal(lineTest, lineTestEqual));
      assert(TBUtils.equal(new TextLine("                   Hello World"), lineTestGreater));
      assert(TBUtils.equal(boxTest, boxTest_));
    } catch (Exception e) {
        assert(false): "Error: RightJustified working incorrectly";
    } // try/catch
  } // rightJustifiedTest()

  /* Test to make sure LeftJustified() works correctly */
  @Test
  public void LeftJustifiedTest() {
    // Create objects
    TextBlock emptyTest_ = new LeftJustified(emptyTest, 0); 
    TextBlock lineTestLess = new Centered(lineTest, 5);
    TextBlock lineTestEqual = new LeftJustified(lineTest, 11);
    TextBlock boxTest_ = new LeftJustified(boxTest, 13);
    
    try { 
      // Make sure they work correctly 
      assert(TBUtils.equal(emptyTest, emptyTest_));
      assert(TBUtils.equal(new TextLine("Hello"), lineTestLess));
      assert(TBUtils.equal(lineTest, lineTestEqual)); // output?
      assert(TBUtils.equal(boxTest, boxTest_));
    } catch (Exception e) {
        assert(false): "Error: LeftJustified working incorrectly";
    } // try/catch
  } // leftJustifiedTest()

  /* Test to make sure horizontallyFlipped() works correctly */
  @Test
  public void horizontallyFlippedTest() { 
    // Create objects
    TextBlock emptyTest_ = new HorizontallyFlipped(emptyTest); 
    TextBlock lineTest_ = new HorizontallyFlipped(lineTest);
    TextBlock boxTest_ = new HorizontallyFlipped(boxTest);

    try {
      // Make sure they work correctly 
      assert(TBUtils.equal(emptyTest, emptyTest_));
      assertFalse(TBUtils.equal(lineTest, lineTest_));
      assertFalse(TBUtils.equal(boxTest, boxTest_));
    } catch (Exception e) {
        assert(false): "Error: Horizontally Flipped working incorrectly";
    } // try/catch
  } // horizontallyFlippedTest()

  /* Test to make sure verticallyFlipped() works correctly */
  @Test
  public void verticallyFlippedTest() {
    // Create objects
    TextBlock emptyTest_ = new VerticallyFlipped(emptyTest); 
    TextBlock lineTest_ = new VerticallyFlipped(lineTest);
    TextBlock boxTest_ = new VerticallyFlipped(boxTest);
    
    try {
        // Make sure they work correctly 
        assert(TBUtils.equal(emptyTest, emptyTest_));
        assert(TBUtils.equal(lineTest, lineTest_));
        assert(TBUtils.equal(boxTest, boxTest_));
    } catch (Exception e) {
        assert(false): "Error: Vertically Flipped working incorrectly";
    } // try/catch
  } // verticallyFlippedTest()

} // class TextBlockTests