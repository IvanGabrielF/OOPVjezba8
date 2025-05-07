package pckg_zd3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();
        int[] array = genArr(size);

        System.out.println("Enter index: ");
        System.out.println("Array length is: " + array.length);
        int idx = scanner.nextInt();

        try {
            System.out.println("Element at index " + idx + ": " + array[idx]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Exception: " + aioobe.getClass().getCanonicalName());
        } finally {
            System.out.println("Warning! Array length is: " + array.length);
        }

    }

    private static int[] genArr(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        System.out.println("Enter " + size + " integer values: ");

        while (true) {
            try {
                for (int i = 0; i < size; i++) {
                    System.out.print("Element " + i + ": ");
                    array[i] = scanner.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter integers only.");
                scanner.nextLine();
            }
        }

        return array;
    }
}
// ArrayIndexOutOfBoundsException
// za zadatak korištena pomoć ai-a
