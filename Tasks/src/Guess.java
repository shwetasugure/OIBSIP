
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {

        int guess ;
        int attempt = 0;
        int score = 0;
        int min = 0;
        int max = 100;
        int attemps = 0;
        int num = (int)(Math.random()*(max-min+1)+min);

        Scanner Scan = new Scanner(System.in);
        System.out.println("Number guessing Game");
        System.out.println("A random number is ");
        System.out.println("A Random number is choosen by the program between 0 to 100, You have to guess it.");
        do {
            System.out.println();
            System.out.print("Enter your guess: ");
            guess = Scan.nextInt();
            attempt++;

            if (guess > num) {
                System.out.println("You guessed a Greater Number...!"+" Try Again:");
            } else if (guess < num) {
                System.out.println("You guessed a Lower Number...!"+" Try Again:");
            } else {
                System.out.println("Congratulations! You guessed the number ");
                System.out.println("You needed " + attempt + " attempts to guess it correct.");
                score = 100-attempt*5;
                System.out.println("Score is:"+ score);
            }
        } while (guess != num);

        Scan.close();
    }
}
