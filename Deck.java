import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		int[] points = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck.add(new Card(suit, ranks[i], points[i], false));
            }
        }
    }

    public Deck(String[] suits, String[] ranks, int[] points) {
        //ranks and points must be the same length
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck.add(new Card(suit, ranks[i], points[i]));
            }   
        }
    }

    public Deck(String[] suits, String[] ranks, int[] points, Boolean flipped) {
        //ranks and points must be the same length
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck.add(new Card(suit, ranks[i], points[i], flipped));
            }   
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        // Deals card on top of the deck
        if (deck.isEmpty()) {
            return null;
        } else {
            return deck.remove(0);
        }
    }

    public void addCard(Card card) {
        // Adds card to bottom of the deck
        deck.add(card);
    }

    public int getCardCount() {
        return deck.size();
    }

    public String toString() {
        StringBuilder fullDeck = new StringBuilder();
        for (Card card : deck) {
            fullDeck.append(card.toString());
            fullDeck.append("\n");
        }
        return fullDeck.toString();
    }

}
