package pckg_zd2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static boolean value = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("Molimo unesite cjelobrojnu vrijednost: ");
//        int unos = scanner.nextInt();
//
//        System.out.println("Unijeli ste -> " + unos);


        System.out.println("Unesite cjelobrojnu vrijednost: ");
        while (value){
            try {
                int br = scanner.nextInt();
                System.out.println("Unijeli ste -> " + br);
                value = false;
            }catch (InputMismatchException ime){
                System.out.println("Unos nije integer!");
                System.out.println("Za ponovni pokušaj pritisnite 'y'");
                scanner.nextLine();
                String opcija = scanner.nextLine();
                if (opcija.equalsIgnoreCase("y")){
                    System.out.println("Unesite cjelobrojnu vrijednost: ");

                }else {
                    System.out.println("Exiting...");
                }
            }
        }
    }
}
