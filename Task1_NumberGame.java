import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("========== NUMBER GAME ==========");

        do {

            int number = random.nextInt(100) + 1;
            int attempts = 10;
            boolean guessed = false;

            System.out.println("\nGuess the number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {

                int guess;

                do {
                    System.out.print("Enter your guess: ");
                    guess = sc.nextInt();

                    if (guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                    }

                } while (guess < 1 || guess > 100);

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    guessed = true;
                    score++;
                    break;
                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                attempts--;
                System.out.println("Attempts Left: " + attempts);
            }

            if (!guessed) {
                System.out.println("You Lost!");
                System.out.println("Correct Number: " + number);
            }

            System.out.println("Score: " + score);

            System.out.print("Play Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Thank You for Playing!");
        sc.close();
    }
}
