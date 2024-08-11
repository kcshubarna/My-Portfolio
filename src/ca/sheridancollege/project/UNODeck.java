package ca.sheridancollege.project;

/**
 *
 * @author Shubarna Kc
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UNODeck {
    private List<UNOCard> cards;

    public UNODeck() {
        this.cards = new ArrayList<>();
        generateDeck();
        shuffle();
    }

    private void generateDeck() {
        for (Color color : Color.values()) {
            if (color == Color.WILD) continue;
            for (Value value : Value.values()) {
                if (value == Value.WILD || value == Value.DRAW_FOUR) continue;
                cards.add(new UNOCard(color, value));
                if (value != Value.ZERO) {
                    cards.add(new UNOCard(color, value)); // Add two cards for each number (except zero)
                }
            }
        }
        // Add wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new UNOCard(Color.WILD, Value.WILD));
            cards.add(new UNOCard(Color.WILD, Value.DRAW_FOUR));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UNOCard drawCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }

    public List<UNOCard> getCards() {
        return cards;
    }
}
