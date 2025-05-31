package entities;

public class Discipline {
    private String name;
    private double grade;

    public Discipline(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + ": " + String.format("%.2f", grade);
    }
}
