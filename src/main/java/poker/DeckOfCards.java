package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    List<Card> cards;
    DeckOfCards() {
        cards = new ArrayList<>();
    }

    //shuffle
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //distribute
    public void distribute() {

    }

}
