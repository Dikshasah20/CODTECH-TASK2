package Grade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeTracker {
    private static ArrayList<Double> grades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Grade");
            System.out.println("2. Edit Grade");
            System.out.println("3. Delete Grade");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Display Overall Grade");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Clear the buffer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the buffer for invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addGrade(sc);
                    break;
                case 2:
                    editGrade(sc);
                    break;
                case 3:
                    deleteGrade(sc);
                    break;
                case 4:
                    calculateAverageGrade();
                    break;
                case 5:
                    displayOverallGrade();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        sc.close();
    }

    private static void addGrade(Scanner sc) {
        System.out.println("Enter the Grade: ");
        double grade = sc.nextDouble();
        grades.add(grade);
        System.out.println("Grade added successfully.");
    }

    private static void editGrade(Scanner sc) {
        if (grades.isEmpty()) {
            System.out.println("No grades to edit.");
            return;
        }
        System.out.println("Enter the index of the grade to edit (0 to " + (grades.size() - 1) + "): ");
        int index = sc.nextInt();
        if (index < 0 || index >= grades.size()) {
            System.out.println("Invalid index.");
            return;
        }
        System.out.print("Enter the new grade: ");
        double newGrade = sc.nextDouble();
        grades.set(index, newGrade);
        System.out.println("Grade updated successfully.");
    }

    private static void deleteGrade(Scanner sc) {
        if (grades.isEmpty()) {
            System.out.println("No grades to delete.");
            return;
        }
        System.out.println("Enter the index of the grade to delete (0 to " + (grades.size() - 1) + "): ");
        int index = sc.nextInt();
        if (index < 0 || index >= grades.size()) {
            System.out.println("Invalid index.");
            return;
        }
        grades.remove(index);
        System.out.println("Grade deleted successfully.");
    }

    private static void calculateAverageGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades to calculate an average.");
            return;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        System.out.println("Average grade: " + average);
    }

    private static void displayOverallGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades to display the overall grade.");
            return;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        char letterGrade;

        if (average >= 90) {
            letterGrade = 'A';
        } else if (average >= 80) {
            letterGrade = 'B';
        } else if (average >= 70) {
            letterGrade = 'C';
        } else if (average >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        System.out.println("Overall Grade: " + letterGrade);
    }
}
