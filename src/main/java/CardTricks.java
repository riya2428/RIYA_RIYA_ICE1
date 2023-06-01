package Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * author 
 */
public class CardTrick {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final int HAND_SIZE = 7;

    private final List<String> hand;

    /**
     * Constructs a CardTrick object and fills the hand with random cards.
     */
    public CardTrick() {
        hand = new ArrayList<>();
        fillHandWithRandomCards();
    }

    /**
     * Fills the hand with random cards.
     */
    private void fillHandWithRandomCards() {
        Random random = new Random();
        for (int i = 0; i < HAND_SIZE; i++) {
            String suit = SUITS[random.nextInt(SUITS.length)];
            int cardNumber = random.nextInt(13) + 1;
            String card = suit + " " + cardNumber;
            hand.add(card);
        }
    }

    /**
     * Asks the user to pick a card and searches the hand for the chosen card.
     */
    public void searchCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a card (e.g., Hearts 7): ");
        String chosenCard = scanner.nextLine();

        boolean found = hand.contains(chosenCard);

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    /**
     * Main method to test the CardTrick class.
     * @param args
     */
    public static void main(String[] args) {
        CardTrick cardTrick = new CardTrick();
        cardTrick.searchCard();
    }
