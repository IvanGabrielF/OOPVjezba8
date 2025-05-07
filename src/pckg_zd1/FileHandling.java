package pckg_zd1;

import java.io.*;
import java.util.Scanner;

public class FileHandling {

    public static void readFileScanner(String fileName){
        File file = new File(fileName);
        boolean val = true;
        while (true){
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                val = false;
                break;
            }catch (FileNotFoundException fnfe){
                System.out.println("File not found!");
                System.out.println("Try again? (y for  y, n for no): ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y")){
                    System.out.println("Enter file path: ");
                    fileName = scanner.nextLine();
                    file = new File(fileName);
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Exiting...");
                    break;
                }else {
                    System.out.println("Unkonwn coommand!");
                }
            }
        }
    }

    public static void readFileBufferedReader(String fileName){
        File file = new File(fileName);
        try(BufferedReader bw = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bw.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException fnfe){
            System.out.println("File not found!");

        }
    }

    public static void writeToFile(String fileName, String content) {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Datoteka ne postoji. Kreira se nova...");
        } else if (!file.canWrite()) {
            System.out.println("Datoteka postoji, ali je read-only. Zapis nije moguć.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Tekst uspješno zapisan u datoteku: " + fileName);
        } catch (IOException e) {
            System.out.println("Došlo je do greške prilikom pisanja u datoteku: " + e.getMessage());
        }
    }





}



