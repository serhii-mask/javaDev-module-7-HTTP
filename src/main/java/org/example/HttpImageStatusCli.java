package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter HTTP status code (or -1 for exit): ");

            if (scanner.hasNextInt()) {
                int code = scanner.nextInt();

                if (code == -1) {
                    break;
                }

                try {
                    HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
                    downloader.downloadStatusImage(code);

                    System.out.println("Image downloaded!");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Please, enter correctly value status code.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
