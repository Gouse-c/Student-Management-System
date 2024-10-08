import java.util.Scanner;
class StudentManagementSystem {
    Student[] students = new Student[100];
    int studentCount = 0;
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }
    void run() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student Details");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: 
					addStudent(); 
					break;
                case 2: 
					viewStudents(); 
					break;
                case 3: 
					deleteStudent(); 
					break;
                case 4: 
					System.out.println("Exiting..."); 
					break;
                default: 
					System.out.println("Invalid choice. Try again.");
            }
        }
    }
    void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students.");
            return;
        }
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        students[studentCount] = new Student(id, name, age, course, address, cgpa);
        studentCount++;
        System.out.println("Student added successfully!");
    }
    void viewStudents() {
        if (studentCount == 0) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- Student List ---");
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i]);
            }
        }
    }
    void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < studentCount - 1; i++) {
                students[i] = students[i + 1];
            }
            studentCount--;
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    class Student {
        int id;
        String name;
        int age;
        String course;
        String address;
        double cgpa;
        Student(int id, String name, int age, String course, String address, double cgpa) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
            this.address = address;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String toString() {
            return "ID: " + id + "\nName: " + name + "\nAge: " + age + 
                   "\nCourse: " + course + "\nAddress: " + address + 
                   "\nCGPA: " + cgpa;
        }
    }
}