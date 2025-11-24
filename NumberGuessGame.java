import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!\n");

        boolean playAgain;

        do {
            int secretNumber = rand.nextInt(100) + 1;  // 1 to 100
            int guess;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                
                // Take input
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next(); // clear invalid input
                    continue;
                }

                guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess must be between 1 and 100. Try again.");
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
            }

            // Ask if user wants to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("y");

            System.out.println();

        } while (playAgain);

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
