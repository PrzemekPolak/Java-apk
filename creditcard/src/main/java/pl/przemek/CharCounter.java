package pl.przemek;

public class CharCounter {
    public int count(final char charToBeCounted, String inputStr) {
        return (int) inputStr
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c.equals(charToBeCounted))
                .count();
    }
}
