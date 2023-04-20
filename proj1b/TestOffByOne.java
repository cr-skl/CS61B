import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    @Test
    public void testOffByOne() {
        OffByOne obo = new OffByOne();
        boolean actual = obo.equalChars('a', 'b');  // true
        obo.equalChars('r', 'q');  // true
        assertEquals(true, actual);
        boolean actual1 = obo.equalChars('r', 'q');
        assertEquals(true, actual1);
        boolean actual2 =obo.equalChars('z', 'a');
        assertEquals(false, actual2);
    }
}
