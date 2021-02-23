package poker;

public class Card {
    private static String[] suits = {"diamonds", "clubs", "spades", "hearts"};
    private static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
    private int suit, rank;

    @Override
    public String toString() {
        return this.rank + "of" +this.suit;
    }
}
