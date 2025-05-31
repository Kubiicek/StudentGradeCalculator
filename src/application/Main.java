package application;

import entities.Student;
import services.StudentFileManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = StudentFileManager.loadStudents();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new student");
            System.out.println("2. View all student reports");
            System.out.println("3. Save and Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Student name: ");
                    String name = input.nextLine();
                    Student student = new Student(name);

                    System.out.print("How many subjects? ");
                    int count = input.nextInt();
                    input.nextLine();

                    for (int i = 0; i < count; i++) {
                        System.out.printf("Subject %d name: ", i + 1);
                        String subject = input.nextLine();

                        double grade;
                        do {
                            System.out.print("Grade (0–10): ");
                            grade = input.nextDouble();
                            input.nextLine();
                        } while (grade < 0 || grade > 10);

                        student.addDiscipline(subject, grade);
                    }

                    students.add(student);
                    System.out.println("✅ Student added.");
                }

                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("⚠️ No students registered.");
                    } else {
                        for (Student s : students) {
                            s.printReport();
                            System.out.println("------------------------");
                        }
                    }
                }

                case 3 -> {
                    StudentFileManager.saveStudents(students);
                    running = false;
                }

                default -> System.out.println("❌ Invalid option.");
            }
        }

        input.close();
    }
}
