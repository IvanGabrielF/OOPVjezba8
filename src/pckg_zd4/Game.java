package pckg_zd4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static int ageToGuess;
    private static int cntr;
    private static int broj = 1;
    private static boolean gameProceed;

    public Game(){
        this.cntr = broj++;
        this.gameProceed = true;

    }
    public static UserInpts runGame(){
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game started");
        System.out.println("Enter lower and upper bound of the game: ");
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        Generator generator = new Generator(low, high);
        int totalGuess = 0;
        ageToGuess = Generator.genAgeGuess(generator);
        System.out.println("Age to guess is: " + ageToGuess);
        while (continGame()) {
            try {
                UserInpts.setLwr(low);
                UserInpts.setUppr(high);
                UserInpts usrInpt = userInpts();
                isInputNegative(usrInpt.getPlayerGuess());
                boolean status = guessStatus(usrInpt, ageToGuess);
                totalGuess++;
                if (status) {
                    System.out.println("You guessed the age in " + totalGuess + " guesses.");
                    System.out.println("Would you like to play again? (y/n)");
                    scanner.nextLine();
                    String answer = scanner.nextLine();
                    if (answer.equals("y")) {
                        System.out.println("Enter the lower and upper bound of the age: ");
                        low = scanner.nextInt();
                        high = scanner.nextInt();
                        generator = new Generator(low, high);
                        ageToGuess = Generator.genAgeGuess(generator);
                        System.out.println("Age to guess is: " + ageToGuess);
                        totalGuess = 0;
                    } else {
                        System.out.println("Doviđenja");
                        gameProceed = false;
                    }
                }
            } catch (UsrInptException usrInptExcpt) {
                System.out.println(usrInptExcpt.getMessage());
                System.out.println("Would you like to try again? (y/n)");
                scanner.nextLine();
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    System.out.print("Please enter a solid number value: ");
                } else {
                    System.out.println("Goodbye!");
                    gameProceed = false;
                }
            }
        }
        return null;
    }

    private static UserInpts userInpts() {
        int lower = UserInpts.getLwr();
        int upper = UserInpts.getUppr();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter a solid number value: ");
        try {
            UserInpts playerGuess = new UserInpts();
            playerGuess.setPlayerGuess(scanner1.nextInt());
            return playerGuess;
        } catch (InputMismatchException inptMissEx) {
            System.out.println("Wrong input only integers are allowed");
            System.out.println("Press y for trying again, for exiting program press n");
            scanner1.nextLine();
            String again = scanner1.nextLine();
            if (again.equals("y")) {
                System.out.println("Enter an integer value: ");
            } else {
                System.out.println("Exiting...");
                gameProceed = false;
            }
        }
        return null;
    }

    private static void isInputNegative(int inpt) throws UsrInptException {
        if (inpt < 0) {
            throw new UsrInptException("You entered a negative!");
        }
    }

    private static boolean continGame() {
        return gameProceed;
    }

    private static boolean guessStatus(UserInpts userInpts, int numToGuess) {
        int usrGuess = userInpts.getPlayerGuess();
        if (usrGuess == numToGuess) {
            System.out.println("You guessed the number!! ");
            UserInpts.setStatus(true);
            return UserInpts.isStatus();
        } else {
            if (numToGuess > usrGuess) {
                System.out.println("Your guess is too low, try higher");
                return UserInpts.isStatus();
            } else {
                System.out.println("Your guess is too high");
                UserInpts.setStatus(false);
                return UserInpts.isStatus();
            }
        }
    }
}
