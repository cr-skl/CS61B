import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testOffByOne() {
        CharacterComparator obo = new OffByOne();
        boolean actual = palindrome.isPalindrome("persiflage", obo);
        assertEquals(false, actual);
        boolean actual2 = palindrome.isPalindrome("rbabr", obo);
        assertEquals(false, actual2);
        boolean actual3 = palindrome.isPalindrome("abcab", obo);
        assertEquals(true, actual3);
    }
}
