import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            System.out.println(" Guess: (1)  Vs Computer: (2)  Enter 1 or 2: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                userGuessGame(scanner, random);
            } else if (choice == 2) {
                computerGuessGame(scanner);
            } else {
                System.out.println("hey stinky, enter a number");
            }

            System.out.println("wanna play again? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("ok get out >:(");
        scanner.close();
    }

    public static void userGuessGame(Scanner scanner, Random random) {
        System.out.print("Enter an upper bound: ");
        int upperBound = scanner.nextInt();
        int maxGuesses = (int) Math.ceil(Math.log(upperBound) / Math.log(2)) + 2;
        int target = random.nextInt(upperBound);
        int guess = -1;
        int numGuesses = 0;

        System.out.println("You have " + maxGuesses + " guesses.");

        while (guess != target && numGuesses < maxGuesses) {
            System.out.print("Guess?: ");
            guess = scanner.nextInt();
            numGuesses++;
            if (guess < target) {
                System.out.println("Too low!");
            } else if (guess > target) {
                System.out.println("Too high!");
            } else {
                System.out.println("nice you got it in " + numGuesses + " guesses.");
            }
        }

        if (guess != target) {
            System.out.println("you suck, you used all your " + maxGuesses + " guesses. the correct number was " + target + ".");
        }
    }

    public static void computerGuessGame(Scanner scanner) {
        System.out.print("Enter an upper bound: ");
        int upperBound = scanner.nextInt();
        int low = 0;
        int high = upperBound - 1;
        int numGuesses = 0;

        System.out.println("Think of a number between 0 and " + (upperBound - 1) + ".");
        System.out.println("Press Enter when ready...");
        scanner.nextLine();
        scanner.nextLine();

        while (low <= high) {
            int guess = (low + high) / 2;
            System.out.println("My guess is " + guess + ". Is it too high, too low, or correct?");
            String feedback = scanner.nextLine().trim().toLowerCase();
            numGuesses++;

            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("correct")) {
                System.out.println("I guessed the number in " + numGuesses + " guesses!");
                break;
            } else {
                System.out.println("enter 'high', 'low', or 'correct' >:(");
            }
        }
    }
}



