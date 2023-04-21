import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
//    Uncomment this class once you've created your Palindrome class.
    @Test
    public void testIsPalindrome() {
        boolean actual = palindrome.isPalindrome("persiflage");
        assertEquals(false, actual);
        boolean actual2 = palindrome.isPalindrome("rbabr");
        assertEquals(true, actual2);
        boolean actual3 = palindrome.isPalindrome("Boooob");
        assertEquals(false, actual3);
    }

//    @Test
//    public void testisPalindromeRecursive() {
//        boolean actual = palindrome.isPalindromeRecursive("persiflage");
//        assertEquals(false, actual);
//        boolean actual2 = palindrome.isPalindromeRecursive("rbabr");
//        assertEquals(true, actual2);
//        boolean actual3 = palindrome.isPalindromeRecursive("Boooob");
//        assertEquals(false, actual3);
//    }



    @Test
    public void testOffByN() {
        OffByN obn = new OffByN(3);
    }

}
