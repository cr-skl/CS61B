import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testOffByN() {
        CharacterComparator obn = new OffByN(3);
        boolean actual = palindrome.isPalindrome("persiflage", obn);
        assertEquals(false, actual);
        boolean actual2 = palindrome.isPalindrome("rbabr", obn);
        assertEquals(false, actual2);
        boolean actual3 = palindrome.isPalindrome("abcab", obn);
        assertEquals(false, actual3);
    }
}
