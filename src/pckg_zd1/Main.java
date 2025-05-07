package pckg_zd1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fileName = "src/pckg_zd1/randTekst.txt";

        System.out.println("********** Scanner reading **********");
        FileHandling.readFileScanner(fileName);

        System.out.println("\n********** BufferedReader reading **********");
        FileHandling.readFileBufferedReader(fileName);

        System.out.println("\n********** Writing to file **********");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite tekst koji želite zapisati u datoteku: ");
        String userText = scanner.nextLine();

        FileHandling.writeToFile(fileName, userText);
        System.out.println("Provjera nakon pisanja u datoteku:");
        FileHandling.readFileBufferedReader(fileName);

    }
}
