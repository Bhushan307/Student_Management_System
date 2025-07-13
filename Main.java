import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String c = sc.nextLine();
                    Student s = new Student(r, n, a, c);
                    StudentDAO.addStudent(s);
                    break;

                case 2:
                    StudentDAO.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    int ur = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String un = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int ua = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String uc = sc.nextLine();
                    Student updatedStudent = new Student(ur, un, ua, uc);
                    StudentDAO.updateStudent(updatedStudent);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int dr = sc.nextInt();
                    StudentDAO.deleteStudent(dr);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
