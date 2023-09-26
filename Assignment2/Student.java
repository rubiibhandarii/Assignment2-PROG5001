import java.io.BufferedReader;
import java.io.FileReader;
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
    
    public float getTotalMark() {
        float total = 0;
        for (Float mark : marks) {
            total += mark;
        }
        return total;
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
        
        readFromFile(fileName);
        
         int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: "); //A simple menu system to allow users to select and execute each function
            choice = scanner.nextInt();

            
        } 
        while (choice != 5);
        scanner.close();  
    }
    
        private static void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (lineNumber < 3) {
                    continue; // Skip header and comments
                }

                String[] parts = line.split(",");
                String lastName = parts[0].trim();
                String firstName = parts[1].trim();
                String studentID = parts[2].trim();
                List<Float> marks = new ArrayList<>();

                for (int i = 3; i < parts.length; i++) {
                    marks.add(parts[i].isEmpty() ? 0 : Float.parseFloat(parts[i].trim()));
                }

                students.add(new Student(lastName, firstName, studentID, marks));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
