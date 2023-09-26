
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

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
