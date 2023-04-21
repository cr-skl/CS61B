public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int a = x - 'a';
        int b = y - 'a';
        if(Math.abs(a - b) == 1) {
            return  true;
        }
        return false;
    }
}
