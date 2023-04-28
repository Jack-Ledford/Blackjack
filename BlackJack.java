import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    private static int MAX_HANDS = 5;
    private static ArrayList<Hand> playerHands = new ArrayList<Hand>();
    public static void main(String[] args) {

        // TODO: implement $ to play with
        // TODO: fix comma after last card when listing it to terminal (hand class)
        
        playGame();
    
    }

    public static void playGame() {
        
        //* Initialize deck, shuffle deck, and initialize hands */
        Deck deck = new Deck();
        deck.shuffle();
        Hand dealerHand = new Hand();
        
        System.out.print("\n\nHow many hands would you like to play? (maximum of 5): ");
        Scanner userInput = new Scanner(System.in);
        int numHands = userInput.nextInt();

        while (numHands > MAX_HANDS || numHands < 0) {
            System.out.println("\nThere can be a maximum of 5 hands. Enter a number from 1 - 5");
            System.out.print("How many hands would you like to play?: ");
            numHands = userInput.nextInt();
        }

        //* Set the name of each player hand (playerHand1, playerHand2, etc.) */
        for(int i = 0; i < numHands; i++) {
            Hand playerHand = new Hand();
            playerHand.setName("Hand " + (i+1));
            playerHands.add(playerHand);
        }
        
        //* Deal the cards */
        for (int i = 0; i < 2; i++) {
            for (Hand hand : playerHands) {
                hand.addCard(deck.dealCard());
                hand.getCard(i).flip();
            }
            dealerHand.addCard(deck.dealCard());
        }
        dealerHand.getCard(1).flip();

        //* Print cards dealt and point totals to terminal */
        System.out.println("\nDealer hand: " + dealerHand.getCard(1) + " and " + dealerHand.getCard(0));

        for (Hand hand : playerHands) {
            System.out.println(hand.getName()+ ": " + hand.getCard(0) + " and " + hand.getCard(1) + " (" + hand.getPointTotal() + ")");
        }

        //* Play game */
        for (Hand hand : playerHands) {
            
            if (hand.getPointTotal() == 21) {       //* Blackjack */
                System.out.println(hand.getName() + ": BlackJack! You win!");
                continue;
            }

            //* Keep asking for a decision until the hand's point total <= 21 or it breaks out */
            
            
            
            while (hand.getPointTotal() <= 21) {
                
                System.out.print("\n" + hand.getName() + " (" + hand.getPointTotal() + "): hit, stand, split, or double?: ");
                String decision = userInput.next();

                while (!decision.equals("hit") && !decision.equals("stand") && !decision.equals("split") && !decision.equals("double")) {
                    System.out.println("Invalid decision; please try again: ");
                    decision = userInput.next();
                }

                if (decision.toLowerCase().equals("hit")) {
                    hand.addCard(deck.dealCard());
                    hand.getCard(hand.getHandSize() - 1).flip();
                    for (int i = 0; i < hand.getHandSize(); i++) {
                        if (hand.getCard(i).getPoints() == 11 && hand.getPointTotal() > 21) {
                            hand.getCard(i).changePoints(1);
                        }
                    }
                    System.out.println("You hit. You now have " + hand.toString() + "(" + hand.getPointTotal() + ")");
                }

                else if (decision.toLowerCase().equals("stand")) {
                    System.out.println("You stand.");
                    break;
                }

                else if (decision.toLowerCase().equals("split")) {
                    //TODO: make sure cards are the same number
                    if (hand.getHandSize() == 2) {          //* Make sure they haven't hit yet */
                        Hand splitHand = new Hand();
                        playerHands.add(playerHands.indexOf(hand) + 1, splitHand);      //* adds splitHand at index after current hand in Playerhands */
                        hand.setName("Split Hand 1"); 
                        splitHand.setName("Split Hand 2");       //* renames the split hands */
                        Card card = hand.getCard(1);
                        splitHand.addCard(card);
                        hand.discard(1);        //* takes the second card of the current hand and puts it in the second split hand */
                        System.out.println("You split. Your new hand is " + hand.toString());
                        continue;
                    }
                    else {
                        System.out.println("Cannot split hand; you have already hit.");
                        continue;

                    }
                }

                else if (decision.toLowerCase().equals("double")) {

                } 


            } 
            

        }
    }
}
