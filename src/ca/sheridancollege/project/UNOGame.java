package ca.sheridancollege.project;

/**
 *
 * @author Shubarna Kc
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UNOGame {
    private int currentPlayerIndex;
    private boolean isClockwise;
    private UNODeck deck;
    private List<UNOPlayer> players;
    private List<UNOCard> discardPile;
    private UNOCard discardPileTopCard;

    public UNOGame() {
        this.deck = new UNODeck();
        this.players = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.isClockwise = true;
        this.currentPlayerIndex = 0;
        setupGame();
    }

    private void setupGame() {
        // Add players
        players.add(new UNOPlayer("Player 1"));
        players.add(new UNOPlayer("Player 2"));

        // Deal cards
        for (UNOPlayer player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }
        // Draw initial discard card
        discardPileTopCard = deck.drawCard();
        discardPile.add(discardPileTopCard);
        System.out.println("Initial discard card: " + discardPileTopCard);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            UNOPlayer currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer.getName() + "'s turn.");
            System.out.println("Current discard pile top card: " + discardPileTopCard);
            System.out.println("Your hand: " + currentPlayer.getHand());

            System.out.println("Enter command (play/draw/pass): ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "play":
                    System.out.println("Enter card to play (e.g., RED FIVE): ");
                    String[] cardInput = scanner.nextLine().split(" ");
                    Color color = Color.valueOf(cardInput[0]);
                    Value value = Value.valueOf(cardInput[1]);
                    UNOCard cardToPlay = new UNOCard(color, value);
                    if (isPlayable(cardToPlay)) {
                        currentPlayer.playCard(cardToPlay, deck, discardPile);
                        discardPileTopCard = cardToPlay;
                        applySpecialCardEffects(cardToPlay);
                        if (currentPlayer.hasWon()) {
                            declareWinner();
                            return;
                        }
                    } else {
                        System.out.println("Card cannot be played.");
                        drawCard(currentPlayer);
                    }
                    break;
                case "draw":
                    drawCard(currentPlayer);
                    if (currentPlayer.hasWon()) {
                        declareWinner();
                        return;
                    }
                    break;
                case "pass":
                    System.out.println(currentPlayer.getName() + " passed their turn.");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
           

            // Move to next player
            currentPlayerIndex = isClockwise ? (currentPlayerIndex + 1) % players.size() : (currentPlayerIndex - 1 + players.size()) % players.size();
            
        }
        
       
        
    }

    private boolean isPlayable(UNOCard card) {
        return card.getColor() == discardPileTopCard.getColor() || card.getValue() == discardPileTopCard.getValue() || card.getColor() == Color.WILD;
    }

    private void applySpecialCardEffects(UNOCard card) {
        switch (card.getValue()) {
            case REVERSE:
                reversePlayDirection();
                break;
            case SKIP:
                currentPlayerIndex = isClockwise ? (currentPlayerIndex + 1) % players.size() : (currentPlayerIndex - 1 + players.size()) % players.size();
                break;
            case DRAW_TWO:
                drawCardsForNextPlayer(2);
                break;
            case DRAW_FOUR:
                drawCardsForNextPlayer(4);
                break;
            default:
                break;
        }
    }

    private void drawCard(UNOPlayer player) {
        player.drawCard(deck);
        if (isPlayable(deck.getCards().get(deck.getCards().size() - 1))) {
            player.playCard(deck.getCards().get(deck.getCards().size() - 1), deck, discardPile);
        }
    }

    private void drawCardsForNextPlayer(int count) {
        UNOPlayer nextPlayer = players.get(isClockwise ? (currentPlayerIndex + 1) % players.size() : (currentPlayerIndex - 1 + players.size()) % players.size());
        for (int i = 0; i < count; i++) {
            nextPlayer.drawCard(deck);
        }
    }

    private void declareWinner() {
        UNOPlayer winner = players.get(currentPlayerIndex);
        System.out.println("Congratulations " + winner.getName() + "! You have won the game.");
    }

    public void reversePlayDirection() {
        isClockwise = !isClockwise;
        System.out.println("Play direction reversed.");
    }
}

