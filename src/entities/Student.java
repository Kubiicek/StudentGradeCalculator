package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Discipline> disciplines;

    public Student(String name) {
        this.name = name;
        this.disciplines = new ArrayList<>();
    }

    public void addDiscipline(String name, double grade) {
        disciplines.add(new Discipline(name, grade));
    }

    public double calculateAverage() {
        double sum = 0;
        for (Discipline d : disciplines) {
            sum += d.getGrade();
        }
        return sum / disciplines.size();
    }

    public String getStatus() {
        double average = calculateAverage();
        if (average >= 7.0) return "✅ Approved";
        else if (average >= 5.0) return "⚠️ Recovery";
        else return "❌ Failed";
    }

    public void printReport() {
        System.out.println("\n📘 Grades Report for " + name + ":");
        for (Discipline d : disciplines) {
            System.out.println(d);
        }
        System.out.printf("\nAverage: %.2f\n", calculateAverage());
        System.out.println("Status: " + getStatus());
    }
}
