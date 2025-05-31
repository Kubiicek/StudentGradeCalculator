package application;

import entities.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String studentName = input.nextLine();

        Student student = new Student(studentName);

        System.out.print("How many subjects? ");
        int subjectCount = input.nextInt();
        input.nextLine();

        for (int i = 0; i < subjectCount; i++) {
            System.out.printf("Subject %d name: ", i + 1);
            String subjectName = input.nextLine();

            double grade;
            do {
                System.out.print("Grade (0 to 10): ");
                grade = input.nextDouble();
                input.nextLine();
                if (grade < 0 || grade > 10) {
                    System.out.println("Invalid grade. Try again.");
                }
            } while (grade < 0 || grade > 10);

            student.addDiscipline(subjectName, grade);
        }

        student.printReport();
        input.close();
    }
}
