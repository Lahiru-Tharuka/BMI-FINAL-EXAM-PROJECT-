/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tester;

/**
 *
 * @author Lahiru
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Bmi {
    private final int id;
    private final String name;
    private final int yob;
    private final int height;
    private final int weight;

    public Bmi(int id, String name, int yob, int height, int weight) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public double calculate() {
        return (double) weight / ((double) height * height / 10000);
    }

    // Calculate age based on year of birth and current year
    public int calculateAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - yob;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yob);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Age: " + calculateAge() + " years");
        

        double bmiValue = calculate();
        System.out.println("BMI: " + bmiValue);

        String category;
        if (bmiValue < 16) {
            category = "Severe undernourishment";
        } else if (bmiValue >= 16 && bmiValue <= 16.9) {
            category = "Medium undernourishment";
        } else if (bmiValue >= 17 && bmiValue <= 18.4) {
            category = "Slight undernourishment";
        } else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
            category = "Normal nutrition state";
        } else if (bmiValue >= 25 && bmiValue <= 29.9) {
            category = "Overweight";
        } else if (bmiValue >= 30 && bmiValue <= 39.9) {
            category = "Obesity";
        } else {
            category = "Pathological obesity";
        }

        System.out.println("BMI Category: " + category);
    }
}

public class Tester {
    private static ArrayList<Bmi> bmiRecords = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    deleteAll();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Create a record");
        System.out.println("2. Show BMI data for all users");
        System.out.println("3. Show BMI data for a selected user");
        System.out.println("4. Delete all");
        System.out.println("5. Exit application");
    }

    private static void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //  newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter year of birth: ");
        int yob = scanner.nextInt();

        System.out.print("Enter height (in cm): ");
        int height = scanner.nextInt();

        System.out.print("Enter weight (in kg): ");
        int weight = scanner.nextInt();

        Bmi bmi = new Bmi(id, name, yob, height, weight);
        bmiRecords.add(bmi);
        System.out.println("Record created.");
    }

    private static void showAll() {
        for (Bmi bmi : bmiRecords) {
            bmi.display();
            System.out.println("--------------------");
        }
    }

    private static void view() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user id to view: ");
        int userId = scanner.nextInt();

        for (Bmi bmi : bmiRecords) {
            if (bmi.getId() == userId) {
                bmi.display();
                return;
            }
        }

        System.out.println("User not found with ID: " + userId);
    }

    private static void deleteAll() {
        bmiRecords.clear();
        System.out.println("All records deleted.");
    }

    private static void exit() {
        System.out.println("Exiting application.");
        System.exit(0);
    }
}
