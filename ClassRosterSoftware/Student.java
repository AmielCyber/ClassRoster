import java.io.Serializable;
/***********************************************************************************************************************
 * Student class will store a student's first name, last name, major, graduation year, and unique ID number
 **********************************************************************************************************************/
public class Student implements Comparable<Student>, Serializable {
  private String firstName;
  private String lastName;
  private String major;
  private int year;
  private int id;

  /*********************************************************************************************************************
   * Student Constructor
   *
   * @param firstName First Name of Student
   * @param lastName  Lirst Name of Student
   * @param major     Area of study
   * @param year      Expected graduation year
   * @param id        Unique school's ID number
   *********************************************************************************************************************/
  public Student(String firstName, String lastName, String major, int year, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.major = major;
    this.year = year;
    this.id = id;
  }

  /*********************************************************************************************************************
   * compareTo will compare a Student with the current Student base on their last name first, then first name,
   * then id number. This method is used to sort an array of Students.
   *
   * @param s student being compare to this student.
   * @return an integer that will give a value if the current student's attributes are greater then the other
   * student s. The possible values are: 0 if the students are the same, Positive if the current student is greater,
   * and negative if this student is less than the other student s.
   ********************************************************************************************************************/
  @Override
  public int compareTo(Student s) {
    int diff = lastName.compareTo(s.lastName);
    if (diff == 0) {
      // If last names are the same, then we compare by first name
      diff = firstName.compareTo(s.firstName);
      if (diff == 0) {
        // If first name are the same, then we compare by id number
        diff = id - s.id;
      }
    }
    return diff;
  }

  /*********************************************************************************************************************
   * equals method will check if the current student is the same as the student pass. In our case a student will
   * be the same if they have the same ID number.
   *
   * @param obj The student object which we will compare.
   * @return A boolean value to determine if the students are the same.
   ********************************************************************************************************************/
  @Override
  public boolean equals(Object obj) {
    Student other = (Student) obj;
    return id == other.id;
  }

  /*********************************************************************************************************************
   * toString method will display the Student's attributes in a formatted form.
   *
   * @return String object containing the student's attributes.
   ********************************************************************************************************************/
  @Override
  public String toString() {
    return this.firstName
        + " "
        + this.lastName
        + " "
        + this.major
        + " "
        + this.year
        + " "
        + this.id;
  }

  // Setters and Getters defined here.

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
