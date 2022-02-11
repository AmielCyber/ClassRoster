import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Scanner;

/***********************************************************************************************************************
 * The Course class will be responsible to maintaining a list of students of students that are in a particular
 * course. The Course class will be used to add, remove, and display students. The course class will also be
 * responsible for saving the students in a class in a file.
 **********************************************************************************************************************/
public class Course {
  private String FILE_NAME = "class-roster.txt";
  // Implement linked list to store student data
  LinkedList<Student> studentList = new LinkedList<>();
  Driver driver = new Driver();

  /*******************************************************************************************************************
   * addStudent method adds a student to the list. Method calls the driver class containing UI menu
   * driver class gets info needed to make a student object.
   ******************************************************************************************************************/
  public void addStudent() {
    boolean existingStudent;
    Student newStudent = driver.getStudentInfo();
    existingStudent = studentList.contains(newStudent);
    if (existingStudent){
      System.out.println("Student already exists in the roster!");
      System.out.println("No new students added.");
    }else {
      studentList.add(newStudent);
    }
  }

  /*******************************************************************************************************************
   * removeStudent removes student with matching ID. The method will check if a student is in the system to remove
   * and will display a message if a student was removed.
   *
   * @param scanner The Scanner object which we wil be getting the user's input.
   ******************************************************************************************************************/
  public void removeStudent(Scanner scanner) {

    if (studentList.isEmpty()){
      // If there are no students in the roster let the user know
      System.out.println("There are no students in the roster to remove.");
      System.out.println("No students were removed.");
    }else{
      // if the student list is not empty then search for that student and remove if found
      System.out.println("Enter Student ID Number: ");
      int id_Number = Integer.parseInt(scanner.nextLine());

      boolean found;
      found = studentList.removeIf(student -> student.getId() == id_Number);
      if (!found){
        // If id number was not found
        System.out.println("Student Number ID#: " + id_Number + " was not found!");
        System.out.println("No student was removed.");
      }else{
        System.out.println("Student with ID number " + id_Number + " was removed.");
      }
    }

  }

  //

  /*******************************************************************************************************************
   * displaySortID Prints a list of students based on ID. The method will print of all students in the course
   * sorted by ID number.
   ******************************************************************************************************************/
  public void displaySortID() {
    if (studentList.isEmpty()) {
      // If student list is empty
      System.out.println("There are currently no students in the roster!");
    } else {
      // If student list is not empty
      studentList.sort(new CompareID());
      for (Student s : studentList) {
        System.out.println(s);
      }
    }
  }

  /*******************************************************************************************************************
   * CompareID inner class in order to compare students by ID number.
   ******************************************************************************************************************/
  private static class CompareID implements Comparator<Student> {

    /***************************************************************************************************************
     * compare method to compare two students by ID number.
     *
     * @param s1 Student 1 to compare.
     * @param s2 Student 2 to compare.
     * @return an Integer object containing a negative(s1<s2), positive(s1>s2), zero value(s1=s2).
     **************************************************************************************************************/
    @Override
    public int compare(Student s1, Student s2) {
      return Integer.compare(s1.getId(), s2.getId());
    }
  }

  /*******************************************************************************************************************
   * displaySortName will display the Students sorted by last name, then first name, and then by ID number.
   ******************************************************************************************************************/
  public void displaySortName() {
    if (studentList.isEmpty()) {
      // If student list is empty
      System.out.println("There are currently no students in the roster!");
    } else {
      // If student list is not empty
      Student[] studentArray = new Student[studentList.size()];
      studentArray = studentList.toArray(studentArray); // Convert list to array
      Arrays.sort(studentArray); // Sort new array list
      for (Student student : studentArray) {
        // Display each student
        System.out.println(student);
      }
    }
  }

  /*******************************************************************************************************************
   * saveRoster will save a file containing all students in the course.
   *
   * @throws IOException If the file does not exist
   ******************************************************************************************************************/
  public void saveRoster() throws IOException {
    File yourFile = new File(FILE_NAME);
    yourFile.createNewFile(); // if file already exists will do nothing
    FileOutputStream fos = new FileOutputStream(yourFile, false);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    // Write the serialized students to the file.
    for (Student student: studentList){
      oos.writeObject(student);
    }

    // Close file
    oos.close();
    fos.close();
    System.out.println("The Class roster has been written to the " + FILE_NAME + " file.");
  }

  /***************************************NEEDS TO BE IMPLEMENTED****************************************************/

  //Extract Persistent student info and add to list
  public void loadRoster() throws IOException, ClassNotFoundException {
    // Get file
    File file = new File(FILE_NAME);
    if (file.exists()){
      // Create the stream objects.
      FileInputStream fis = new FileInputStream(FILE_NAME);
      ObjectInputStream ois = new ObjectInputStream(fis);

      boolean endOfFile = false;
      while(!endOfFile){
        try {
          // Read the students from the file and populate the Student linked list.
          Student student = (Student) ois.readObject();
          studentList.add(student);
        }catch(EOFException e){
          endOfFile = true;
        }
      }
      // Close file
      fis.close();
      ois.close();
    }
  }
}
