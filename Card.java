public class Card {

private String suit;
private String rank;
private int points;
private Boolean isVisible;

    public Card(String s, String r, int p, Boolean f) {
        suit = s;
        rank = r;
        points = p;
        isVisible = f;
    }

    public Card(String s, String r, int p) {
        suit = s;
        rank = r;
        points = p;
    }

    public Card(String s, String r) {
        suit = s;
        rank = r;
    } 

    public String toString() {
        if(isVisible) return rank + " of " + suit;
        else return "? of ?";
    }

// MUTATORS

    public void flip() {
        isVisible = !isVisible;
    }

    public void changePoints(int newP) {
        points = newP;
    }

    public int compareTo(Card other) {
        // Does suit matter?
        // If other card is bigger, return negative value. If other card is smaller, return positive value
        return this.points - other.points;
    }

    public Boolean equals(Card other) {
        return suit.equals(other.suit) && rank.equals(other.rank);
    }

// ACCESSORS

    public String getSuit() {
        return suit;
    }
    
    public String getrank() {
        return rank;
    }
    
    public int getPoints() {
        return points;
    }


}