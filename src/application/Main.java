package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String name = input.nextLine();

        System.out.print("How many subjects? ");
        int subjects = input.nextInt();
        input.nextLine();

        Map<String, Double> grades = new HashMap<>();

        for (int i = 0; i < subjects; i++) {
            System.out.print("Subject " + (i+1) + " name: ");
            String discplineName = input.nextLine();
            System.out.print("Grade: ");
            Double disciplineGrade = input.nextDouble();
            input.nextLine();

            grades.put(discplineName, disciplineGrade);
        }

        double sum = 0;
        for (double nota : grades.values()) {
            sum += nota;
        }
        double average = sum / grades.size();

        System.out.printf("\n%s's average: %.2f\n", name, average);

        if (average < 7) {
            System.out.println("Status: Failed ❌");
        } else {
            System.out.println("Status: Approved ✅");
        }

        input.close();
    }
}
