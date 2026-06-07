import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = input.nextDouble();

                    students.add(new Student(id, name, marks));

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\nStudent Records:");
                        for (Student s : students) {
                            s.displayStudent();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = input.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getStudentId().equals(searchId)) {
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        double total = 0;

                        for (Student s : students) {
                            total += s.getMarks();
                        }

                        double average = total / students.size();

                        System.out.println("Average Marks: " + average);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        input.close();
    }
}