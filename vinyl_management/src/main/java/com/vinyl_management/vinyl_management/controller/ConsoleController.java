package com.vinyl_management.vinyl_management.controller;

import com.vinyl_management.vinyl_management.model.Vinyl;
import com.vinyl_management.vinyl_management.service.VinylService;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {

    private final VinylService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleController(VinylService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== VINYL MANAGEMENT ===");
            System.out.println("1. Add vinyl");
            System.out.println("2. List all vinyls");
            System.out.println("3. Delete vinyl by id");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addVinylFlow();
                case 2 -> listVinylsFlow();
                case 3 -> deleteVinylFlow();
                case 4 -> {
                    System.out.println("Hajox, ape!");
                    return;
                }
                default -> System.out.println("Invalid choice, ape");
            }
        }
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number, ape: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter a number, ape: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    private void addVinylFlow() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Year: ");
        int year = readInt();

        System.out.print("Condition: ");
        String condition = scanner.nextLine();

        System.out.print("Price: ");
        double price = readDouble();

        Vinyl v = new Vinyl(0, title, artist, genre, year, condition, price);
        service.addVinyl(v);
        System.out.println("Saved, ape");
    }

    private void listVinylsFlow() {
        List<Vinyl> list = service.getAll();
        if (list.isEmpty()) {
            System.out.println("No vinyls yet.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void deleteVinylFlow() {
        System.out.print("Enter id to delete, ape: ");
        int id = readInt();
        service.deleteById(id);
        System.out.println("Deleted (if id existed).");
    }
}
