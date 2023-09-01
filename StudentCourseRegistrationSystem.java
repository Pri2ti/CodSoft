import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [ID: " + id + ", Name: " + name + "]";
    }
}

class Course {
    private String courseCode;
    private String courseName;
    private int maxSeats;
    private int availableSeats;

    public Course(String courseCode, String courseName, int maxSeats) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxSeats = maxSeats;
        this.availableSeats = maxSeats;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean registerStudent() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Course [Code: " + courseCode + ", Name: " + courseName + ", Available Seats: " + availableSeats + "]";
    }
}

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        courses.add(new Course("CS101", "Data Structure And Algorithm.", 30));
        courses.add(new Course("CS102", "Centre for Development And Advanced Computing.", 25));
        courses.add(new Course("CS103", "Systems,Application & Products in Data Processing.", 20));
        courses.add(new Course("CS104", "Master of Business Administration.", 40));


        while (true) {
            System.out.println("1. Register The Student");
            System.out.println("2. List Of Courses");
            System.out.println("3.  Name Of Register Student for Course");
            System.out.println("4.Delete the Student Name From Registration. ");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    int studentId = students.size() + 1;
                    students.add(new Student(studentName, studentId));
                    System.out.println("Student registered successfully.");
                    break;
                case 2:
                    System.out.println("Courses available:");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int studentIdToRegister = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    String courseCodeToRegister = scanner.next();

                    Student studentToRegister = null;
                    for (Student student : students) {
                        if (student.getId() == studentIdToRegister) {
                            studentToRegister = student;
                            break;
                        }
                    }

                    Course courseToRegister = null;
                    for (Course course : courses) {
                        if (course.getCourseCode().equalsIgnoreCase(courseCodeToRegister)) {
                            courseToRegister = course;
                            break;
                        }
                    }

                    if (studentToRegister != null && courseToRegister != null) {
                        if (courseToRegister.registerStudent()) {
                            System.out.println("Registration successful for " + studentToRegister.getName() + " in " + courseToRegister.getCourseName());
                        } else {
                            System.out.println("Course is full. Registration failed.");
                        }
                    } else {
                        System.out.println("Invalid student ID or course code. Registration failed.");
                    }
                    break;
                    case 4:
                    System.out.print("Enter student ID to remove: ");
                    int removeId=scanner.nextInt();
                    boolean remove = false;
                    for (Student student : students) {
                     if (student.getId() == removeId) {
                     students.remove(student);
                      remove = true;
                     System.out.println("Student with ID " + removeId + " removed.");
                     break;
                     }
                    }
                
                case 5:
                    System.out.println("Exiting the registration system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

