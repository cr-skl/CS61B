public class OffByNFinder {

    public static void main(String[] args) {
        int biggest = 0;
        int biggestIndex = 0;
        for (int i = 0; i <= 20; i++) {
            if (findOffByn(i) > biggest) {
                biggest = findOffByn(i);
                biggestIndex = i;
            }
        }
        System.out.printf("The num of OffBy%d words is biggest, which is %d .", biggestIndex, biggest);
    }

    public static int findOffByn(int obj) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        OffByN obn = new OffByN(obj);
        int cnt = 0;
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,obn)) {
                System.out.println(word);
                cnt++;
            }
        }
        System.out.printf("The total number of  OffBy%d words in the List is %d", obj, cnt);
        return cnt;
    }
}