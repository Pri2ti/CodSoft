import java.util.ArrayList;
import java.util.Scanner;

class Student{
    private String name;
    private int id;
    private int roll_no;
    private double gpa;

    public Student(String name, int id, double gpa,int roll_no) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGPA() {
        return gpa;
    }
    public int getRollNo(){
        return roll_no;
    }

    @Override
    public String toString() {
        return "ID: " + id + " || Name: " + name + " || GPA: " + gpa + " || Roll No: "+roll_no;
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private int nextId;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        nextId = 1;
    }

    public void addStudentdata(String name, double gpa,int roll_no) {
        Student student = new Student(name, nextId, gpa,roll_no);
        students.add(student);
        nextId++;
        System.out.println("Student are added successfully.");
    }

    public void showStudentsdata() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void removeStudentdata(int id) {
        boolean remove= false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                remove = true;
                System.out.println("Student data with ID " + id + " deleted.");
                break;
            }
        }
        if (!remove) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void SearchStudentdata(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student data");
            System.out.println("2. Show Students data");
            System.out.println("3. Delete Student data");
            System.out.println("4. Search Student data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student GPA: ");
                    double gpa = scanner.nextDouble();
                    System.out.println("Enter the roll number");
                    int roll_no = scanner.nextInt();
                    sms.addStudentdata(name, gpa, roll_no);
                    break;
                case 2:
                    sms.showStudentsdata();
                    break;

                case 3:
                    System.out.print("Enter student ID to deleted: ");
                    int removeId = scanner.nextInt();
                    sms.removeStudentdata(removeId);
                    break;

                case 4:
                    System.out.print("Enter student ID to search the student data: ");
                    int searchId = scanner.nextInt();
                    sms.SearchStudentdata(searchId);
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
