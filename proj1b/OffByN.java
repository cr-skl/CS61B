public class OffByN implements CharacterComparator {
    private int N;
    public OffByN (int n) {
        N = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int a = x - 'a';
        int b = y - 'a';
        if(Math.abs(a - b) == N) {
            return  true;
        }
        return false;
    }
}
