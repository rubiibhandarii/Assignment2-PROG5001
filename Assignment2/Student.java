import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class Student here.
 *
 * @author (Rubi Bhandari)
 * @version (9/16/23)
 */
class Student
{
    // instance variables 
    private String lastName;
    private String firstName;
    private String studentID;
    private List<Float> marks;

    /**
     * Constructor for objects of class Student
     */
    public Student(String lastName, String firstName, String studentID, List<Float> marks)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.marks = marks;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStudentID() {
        return studentID;
    }

    public List<Float> getMarks() {
        return marks;
    }

public class StudentStatisticsApp {

    private static List<Student> students = new ArrayList<>();

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");
        System.out.println("This program computes statistics of students' marks in an assignment with functional requirements:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name as 'Assignment.csv': "); //The user will provide the given file name.
        String fileName = scanner.nextLine();
    }
}
