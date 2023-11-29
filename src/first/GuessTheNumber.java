package first;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guess the Number game!");

        int totalAttempts = 0;
        int totalRounds = 0;

       
        boolean playAgain;
        do {
            int attemptsInCurrentRound = playGame(scanner);
            totalAttempts += attemptsInCurrentRound;
            totalRounds++;

            System.out.println("Total Score: " + calculateScore(totalAttempts, totalRounds));

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
      
        int min = 1;
        int max = 100;
        int randomNumber = generateRandomNumber(min, max);

     
        int maxAttempts = 10;
        int attempts = 0;
        boolean correctGuess = false;

       
        do {
            System.out.print("Enter your guess (between " + min + " and " + max + "): ");
            int userGuess = scanner.nextInt();

          
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! Your guess is correct.");
                correctGuess = true;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts++;

        } while (!correctGuess && attempts < maxAttempts);

       
        if (!correctGuess) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
        }

        return attempts;
    }


    private static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

   
    private static double calculateScore(int totalAttempts, int totalRounds) {
        if (totalRounds == 0) {
            return 0;
        }
        return (int) totalAttempts / totalRounds;
    }
}