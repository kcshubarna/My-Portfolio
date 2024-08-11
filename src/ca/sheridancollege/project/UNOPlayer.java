package ca.sheridancollege.project;

/**
 *
 * @author Shubarna Kc
 */
import java.util.ArrayList;
import java.util.List;

public class UNOPlayer {
    private String name;
    private List<UNOCard> hand;

    public UNOPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(UNODeck deck) {
        UNOCard drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.add(drawnCard);
            System.out.println(name + " drew a card: " + drawnCard);
        }
    }

    public void playCard(UNOCard card, UNODeck deck, List<UNOCard> discardPile) {
        if (hand.contains(card)) {
            hand.remove(card);
            discardPile.add(card);
            System.out.println(name + " played: " + card);
        } else {
            System.out.println(name + " cannot play: " + card);
        }
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public String getName() {
        return name;
    }

    public List<UNOCard> getHand() {
        return hand;
    }
}
