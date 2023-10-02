import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
 * Class Student represents a student entity and contains information 
 * about a student's personal details and academic performance.
 * It provides methods to retrieve individual attributes 
 * such as last name, first name, and student ID, as well as to access the complete list of marks 
 * and compute the total mark for the student.
 * @author (Rubi Bhandari)
 * @version (9/16/23)
 */
class Student{
    // Instance variables 
    private String lastName; //Represents the last name of the student.
    private String firstName; //Represents the first name of the student.
    private String studentID; //Represents the unique student identifier or ID.
    private List<Float> marks; //Represents a list of floating-point numbers (marks) associated with the student's academic performance.

    /**
     * Student class has a constructor that initializes 
     * a Student object with the provided values for 
     * last name, first name, student ID, and a list of marks.
     */
    public Student(String lastName, String firstName, String studentID, List<Float> marks)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.marks = marks;
    }
    
    /**
     * getLastName method returns the last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getFirstName method returns the first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getStudentID method returns student's unique identifier (ID).
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * List<Float> getMarks method returns the list of marks 
     * associated with the student's academic performance.
     */
    public List<Float> getMarks() {
        return marks;
    }
    
    /**
     * getTotalMark method calculates and returns the total marks 
     * for the student by summing up all the marks in the list of marks.
     */
    public float getTotalMark() {
        float total = 0;
        for (Float mark : marks) {
            total += mark;
        }
        return total;
    }
}


/**
 * Class StudentStatisticsApp serves as the main application 
 * that allows users to interact with student data stored in a CSV file named "Assignment.csv.
 * Users can choose from various options(a menu system) to view and analyze student performance statistics.
 * It reads data from an external file, processes it, and provides meaningful statistics to the user.
 * The class demonstrates common programming constructs such as file I/O, menu-driven interfaces, sorting algorithms, and data presentation.
 * It is designed to be user-friendly and useful for educational or academic contexts where student performance analysis is required.
 */

public class StudentStatisticsApp {
    //instance variable
    private static List<Student> students = new ArrayList<>(); //stores instances of the Student class, representing student data.

    /**
     * Below is the main method that welcomes user, 
     * and prompts user to take actions using a menu system,
     * to choose various statistical operations, 
     * such as displaying students' total marks, 
     * displaying students below a certain threshold, 
     * displaying the top students with the highest or lowest total marks, 
     * and exiting the program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");
        System.out.println("This program computes statistics of students' marks in an assignment with functional requirements.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file name as 'Assignment.csv': "); //The user will provide the given file name.
        String fileName = scanner.nextLine();
        
        readFromFile(fileName); //Calling the readFromFile method to read student data from the CSV file.
        
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: "); //A simple menu system to allow users to select and execute each function
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayStudentsWithTotalMarks(); //Prints the list of students with total marks
                    break;
                case 2:
                    System.out.print("Enter the threshold: "); //Prints the list of students with total marks less than a certain threshold
                    float threshold = scanner.nextFloat();
                    displayStudentsBelowThreshold(threshold);
                    break;
                case 3:
                    displayTopStudents(true);
                    break;
                case 4:
                    displayTopStudents(false);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        while (choice != 5);
        scanner.close();  
    }
    
     /**
     * Method readFromFile reads student data from a CSV file and 
     * populates the students list.
     */
        private static void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
            //Opens and reads the CSV file line by line, skipping header and comment lines.
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
                } //Parses each line to extract student information, including last name, first name, student ID, and assignment marks (stored in a list of floats).

                students.add(new Student(lastName, firstName, studentID, marks)); //Creates Student objects and adds them to the students list.
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    /**
     * Method displayMenu displays a menu of options for the user to choose from, 
     * including displaying students' total marks, 
     * displaying students below a threshold, 
     * displaying top students, 
     * and exiting the program.
     */
     private static void displayMenu() 
     {
        System.out.println("\nMenu:");
        System.out.println("1. Display students with total marks");
        System.out.println("2. Display students with total marks below a threshold");
        System.out.println("3. Display top 5 students with highest total marks");
        System.out.println("4. Display top 5 students with lowest total marks");
        System.out.println("5. Exit");
    }
    
    /**
     * Method displayStudentsWithTotalMarks displays information 
     * about all students, including last name, first name, student ID, assignment marks, and total marks.
     */
    private static void displayStudentsWithTotalMarks() 
    {
        for (Student student : students) {
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Assignment Marks: " + student.getMarks());
            System.out.println("Total Marks: " + student.getTotalMark());
            System.out.println();
        }
    }
    
    /**
     * Method displayStudentsBelowThreshold displays information 
     * about students, whose total marks are below a specified threshold.
     */
    private static void displayStudentsBelowThreshold(float threshold) {
        for (Student student : students) {
            if (student.getTotalMark() < threshold) {
                System.out.println("Last Name: " + student.getLastName());
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Assignment Marks: " + student.getMarks());
                System.out.println("Total Marks: " + student.getTotalMark());
                System.out.println();
            }
        }
    }
    
    /**
       Method findMin finds and returns the minimum of two integers a and b.
       **/
    private static int findMin(int a, int b) {
        return a < b ? a : b;
    }
    
    /**
     * Method displayTopStudents information about the top (highest or lowest) students 
     * based on their total marks. 
     * The number of top students displayed is limited to five. */
    private static void displayTopStudents(boolean highest) 
    {
        int numStudents = students.size();
        int maxStudents = 5;
    
        System.out.println("Top " + (highest ? "highest" : "lowest") + " " + findMin(numStudents, maxStudents) + " students:");
    
        List<Student> sortedStudents = new ArrayList<>(students);
        if (highest) {
            bubbleSortHighest(sortedStudents);
        } else {
            bubbleSortLowest(sortedStudents);
        }
    
        int numToDisplay = findMin(numStudents, maxStudents);
        for (int i = 0; i < numToDisplay; i++) {
            Student student = sortedStudents.get(i);
            System.out.println((i + 1) + ". Last Name: " + student.getLastName() +
                    ", First Name: " + student.getFirstName() +
                    ", Total Marks: " + student.getTotalMark());
        }
    }
    
    /**
     * Method bubbleSortHighest implements the bubble sort algorithm 
     * to sort a list of students in descending order of total marks 
     * (highest to lowest). */
    private static void bubbleSortHighest(List<Student> students) 
    {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getTotalMark() < students.get(j + 1).getTotalMark()) {
                    // Swap
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
    
     /**
     * Method bubbleSortLowest implements the bubble sort algorithm 
     * to sort a list of students in ascending order of total marks 
     * (lowest to highest). */
    private static void bubbleSortLowest(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getTotalMark() > students.get(j + 1).getTotalMark()) {
                    // Swap
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
}
