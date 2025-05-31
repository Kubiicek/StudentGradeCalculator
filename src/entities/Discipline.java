package entities;

import java.io.Serializable;

public class Discipline implements Serializable {
    private static final long serialVersionUID = 1L;

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
