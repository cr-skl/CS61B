public class Palindrome {
    public Deque<Character> wordToDeque (String word) {
        /**
         * @param  String c = "ABCDEFG",  the char "A" is  c.charAt(i)
         */
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPlaindromeRecursive(String word) {
        Deque dq = wordToDeque(word);
        return isPlaindromeRecursiveHelper(dq);
    }

    private static boolean isPlaindromeRecursiveHelper(Deque word) {
        if (word.size() <= 1) {
            return true;
        }
        Character a = (Character) word.removeFirst();
        Character b = (Character) word.removeLast();
        if (a == b) {
            return isPlaindromeRecursiveHelper(word);
        }
        return false;
    }
    public boolean isPalindrome(String word) {
        Deque dq = wordToDeque(word);
        if (dq.size() <= 1) {
            return true;
        }
        //  size vary in two ways:  8 -> 6 -> 4 -> 2 -> 0  true
        //                          9 -> 7 -> 5 -> 3 -> 1  true
        while (!dq.isEmpty() && dq.size() != 1) {
            Character a = (Character) dq.removeFirst();
            Character b = (Character) dq.removeLast();
            if (a == b) {
                continue;
            }
            return false;
        }
        return true;
    }

//    public boolean isPalindrome(String word, CharacterComparator cc){
//
//    }
}
