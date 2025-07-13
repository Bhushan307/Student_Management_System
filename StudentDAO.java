import java.sql.*;
import java.util.*;

public class StudentDAO {
    public static void addStudent(Student s) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, s.rollNo);
            pst.setString(2, s.name);
            pst.setInt(3, s.age);
            pst.setString(4, s.course);
            pst.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Add Error: " + e.getMessage());
        }
    }

    public static void viewStudents() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt(1) + ", Name: " + rs.getString(2) +
                                   ", Age: " + rs.getInt(3) + ", Course: " + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public static void updateStudent(Student s) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE students SET name=?, age=?, course=? WHERE roll_no=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s.name);
            pst.setInt(2, s.age);
            pst.setString(3, s.course);
            pst.setInt(4, s.rollNo);
            int updated = pst.executeUpdate();
            if (updated > 0)
                System.out.println("Student updated!");
            else
                System.out.println("Student not found!");
        } catch (Exception e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    public static void deleteStudent(int rollNo) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM students WHERE roll_no=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, rollNo);
            int deleted = pst.executeUpdate();
            if (deleted > 0)
                System.out.println("Student deleted!");
            else
                System.out.println("Student not found!");
        } catch (Exception e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}
