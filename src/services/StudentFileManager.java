package services;

import entities.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileManager {

    private static final String FILE_NAME = "studentsfile.dat";

    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
            System.out.println("Students saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Student> loadStudents() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ No saved students found. Starting with empty list.");
            return new ArrayList<>();
        }
    }
}
