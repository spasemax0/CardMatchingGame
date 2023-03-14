import java.util.Scanner;
/* Author: Spase Maximillien Sandoval
 * Date: 2/20/23
 * Class: CSC 1060
 * Assignment: HW4
 */
public class Hw4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char selection;
		// Display Full Name in Capital
		String fullName;
		int userCardValue, userCardSuit, computerCardValue, computerCardSuit;
		// Define an array of card values and suits
		String[] cardValues = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		String[] cardSuits = { "Clubs", "Diamonds", "Hearts", "Spades" };

		// Print the Welcome Statement
		System.out.println("Welcome to the Card Matching Game!");
		System.out.print("Please enter your full name: ");
		fullName = scanner.nextLine();
		// Print good luck message
		System.out.printf("Good luck, %s!%n", fullName.split(" ")[0].toUpperCase());

		// Selection values
		do {
			System.out.println("Enter 'p' to play or 'q' to quit.");
			System.out.print("Selection: ");
			selection = scanner.nextLine().toLowerCase().charAt(0);

			if (selection == 'p') {
				// Generate random card for computer
				computerCardValue = (int) (Math.random() * 13 + 1);
				computerCardSuit = (int) (Math.random() * 4);

				// Prompt user to enter card value and suit
				System.out.print("Enter card value (1 for Ace, 11 for Jack, 12 for Queen, 13 for King): ");
				userCardValue = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter card suit (1 for Clubs, 2 for Diamonds, 3 for Hearts, 4 for Spades): ");
				userCardSuit = Integer.parseInt(scanner.nextLine());

				// Validate user input
				if (userCardValue < 1 || userCardValue > 13) {
					System.out.println("Invalid card value. Please enter a value between 1 and 13.");
				} else if (userCardSuit < 1 || userCardSuit > 4) {
					System.out.println("Invalid card suit. Please enter a value between 0 and 4.");
				} else {
					// Check for match
					if (userCardValue - 1 == computerCardValue && userCardSuit == computerCardSuit) {
						System.out.println("Congratulations! You matched the computer's card: "
								+ cardValues[computerCardValue - 1] + " of " + cardSuits[computerCardSuit] + ".");
					} else {
						System.out.println("Sorry, you did not match the computer's card. The computer's card was: "
								+ cardValues[computerCardValue - 1] + " of " + cardSuits[computerCardSuit] + ".");
					}
				}
			} else if (selection != 'q') {
				System.out.println("Invalid selection. Please enter 'p' to play or 'q' to quit.");
			}
		} while (selection != 'q');

		System.out.println("Thanks for playing the Card Matching Game!");
	}

}
