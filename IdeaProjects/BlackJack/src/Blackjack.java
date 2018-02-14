import java.util.*;

public class Blackjack {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int round = 0;
        double round1 = 0;
        int card = 0;
        int option = 1;
        int playerwins = 0;
        double playerwins1 = 0;
        int dealerwins = 0;
        int dealer = 0;
        int tiegames = 0;
        double tiegames1 = 0;
        P1Random rng = new P1Random();
        do {
            //adds rounds
            round = round + 1;
            round1 = round1 + 1;

            //sets the true/false variable to true
            int win = 0;

            System.out.println("START GAME #" + round + "\n");
            option = 1;

            //resets hand to 0
            int hand = 0;
            dealer = 0;

            do {
                //tells program what to do based on response
                if (option == 1) {
                    //random card
                    card = rng.nextInt(13) + 1;

                    //prints what your card is
                    if (card == 1) {
                        System.out.println("Your card is a ACE!");
                    } else if (card == 11) {
                        card = 10;
                        System.out.println("Your card is a JACK!");
                    } else if (card == 12) {
                        card = 10;
                        System.out.println("Your card is a QUEEN!");
                    } else if (card == 13) {
                        card = 10;
                        System.out.println("Your card is a KING!");
                    } else {
                        System.out.println("Your card is a " + card + "!");
                    }

                    //adds up hand as you go through
                    hand = card + hand;

                    //tells you what your hand is
                    System.out.println("Your hand is: " + hand);

                    //ends round if you exeed 21
                    if (hand > 21) {
                        System.out.println("\nYou exceeded 21! You lose.\n");
                        dealerwins = dealerwins + 1;
                        break;
                    } else if (hand == 21) {
                        System.out.println("\nBLACKJACK! You win!\n");
                        playerwins = playerwins + 1;
                        playerwins1 = playerwins1 + 1;
                        break;
                    }

                    //asks what you want to do next
                    System.out.println("\n1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.print("\nChoose an option: ");
                    option = scanner.nextInt();
                    System.out.print("\n");
                } else if (option == 2) {
                    //gives dealer a hand
                    dealer = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealer);
                    System.out.println("Your hand is: " + hand + "\n");
                    if (hand > dealer && hand <= 21) {
                        System.out.println("You win!");
                        win = 1;
                        playerwins = playerwins + 1;
                        playerwins1 = playerwins + 1;
                    } else if (dealer > hand && dealer <= 21) {
                        System.out.println("Dealer wins!\n");
                        win = 1;
                        dealerwins = dealerwins + 1;
                    } else if (dealer > 21) {
                        System.out.println("You win!\n");
                        win = 1;
                        playerwins = playerwins + 1;
                        playerwins1 = playerwins1 + 1;
                    } else if (hand == dealer) {
                        System.out.println("It's a tie! No one wins!\n");
                        tiegames = tiegames + 1;
                        tiegames1 = tiegames1 + 1;
                        win = 1;
                    }
                } else if (option == 3) {
                    double percent = ((playerwins1)/ (round1-1)) * 100;
                    int games = round - 1;
                    System.out.println("Number of Player wins: " + playerwins);
                    System.out.println("Number of Dealer wins: " + dealerwins);
                    System.out.println("Number of tie games: " + tiegames);
                    System.out.println("Total # of games played is: " + games);
                    System.out.println("Percentage of Player wins: " + percent + "%");

                    System.out.println("\n1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.print("\nChoose an option: ");
                    option = scanner.nextInt();
                    System.out.print("");
                } else if (option == 4) {
                    break;
                } else {
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    System.out.println("\n1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.print("\nChoose an option: ");
                    option = scanner.nextInt();
                    System.out.print("\n");
                    while (option > 4 || option < 0) {
                        System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                        System.out.println("\n1. Get another card");
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit");
                        System.out.print("\nChoose an option: ");
                        option = scanner.nextInt();
                        System.out.print("\n");
                    }
                }
            }
            while (win ==0);
        }
        while (option < 4);
    }
}