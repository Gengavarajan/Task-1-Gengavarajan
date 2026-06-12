import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        do {
            int targetNumber = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.\n");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                try {
                    int guess = sc.nextInt();
                    attempts++;

                    if (guess == targetNumber) {
                        System.out.println("🎉 Correct! You guessed the number in "
                                + attempts + " attempts.");
                        totalScore += (maxAttempts - attempts + 1) * 10;
                        guessedCorrectly = true;
                        break;
                    } else if (guess < targetNumber) {
                        System.out.println("📉 Too Low!");
                    } else {
                        System.out.println("📈 Too High!");
                    }

                    System.out.println("Attempts left: "
                            + (maxAttempts - attempts) + "\n");

                } catch (Exception e) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    sc.nextLine(); // clear buffer
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n😢 Game Over!");
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.println("Current Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            sc.nextLine(); // clear buffer
            playAgain = sc.nextLine().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nFinal Score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}