import java.util.ArrayList;

public class Hand {

    private String name;
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public String toString() {
        StringBuilder fullHand = new StringBuilder();
        for (Card card : hand) {
            fullHand.append(card.toString());
            fullHand.append(", ");
        }
        return fullHand.toString();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card discard(int index) {
        return hand.remove(index);
    }

    public boolean discard(Card card) {
        return hand.remove(card);
    }

    public boolean discard(String suit, String rank) {
        for (Card card : hand) {
            if (card.equals(new Card(suit, rank))) {
                hand.remove(card);
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Card getCard(int index)
	{
		return hand.get(index);
	}
	
	public int getHandSize()
	{
		return hand.size();
	}
	
	public int getPointTotal()
	{
		int total = 0;
		for(Card card : hand) total += card.getPoints();
		return total;
	}

}