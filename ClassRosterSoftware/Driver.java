import java.io.PrintWriter;
import java.util.Scanner;

/***********************************************************************************************************************
 * The Driver class will be responsible for getting the user's input and validating the input when adding a new
 * student and prompting the login screen.
 **********************************************************************************************************************/
public class Driver {
  Scanner scanner = new Scanner(System.in);

  /*********************************************************************************************************************
   * getStudentInfo method is to get student infor to add student to a list.
   *
   * @return Student object containing the new student to be added to the roster.
   ********************************************************************************************************************/
  public Student getStudentInfo() {
    String firstName;
    String lastName;
    String major;
    int year;
    int id;

    // Get the student's attribute from the user.
    System.out.print("Enter Student First Name: ");
    firstName = scanner.nextLine();
    System.out.print("Enter Student Last Name: ");
    lastName = scanner.nextLine();
    System.out.print("Enter Student Major: ");
    major = scanner.nextLine();
    year = getYear(scanner);
    id = getID();

    return new Student(firstName, lastName, major, year, id);
  }

  /*********************************************************************************************************************
   * getAccountInfo method gets login info from the user.
   *
   * @return Account object containing the username and password.
   ********************************************************************************************************************/
  public Account getAccountInfo() {
    String userName;
    String password;

    System.out.print("Enter user name: ");
    userName = scanner.nextLine();
    System.out.print("Enter password: ");
    password = scanner.nextLine();

    return new Account(userName, password);
  }

  /*********************************************************************************************************************
   * getYear method gets the graduation year from the user and checks if its a valid input for our system.
   *
   * @param scanner The scanner object use to read the user's input.
   * @return the year which will be an integer value.
   ********************************************************************************************************************/
  private int getYear(Scanner scanner) {
    int MIN_YEAR = 1000, MAX_YEAR = 3000;
    int year = MAX_YEAR;
    boolean valid;

    do {
      valid = true;
      System.out.print("Enter Student Year: ");
      try {
        year = Integer.parseInt(scanner.nextLine());
        if (year < MIN_YEAR | year > MAX_YEAR) {
          throw new IllegalArgumentException();
        }
      } catch (NumberFormatException e) {
        // If user entered a non-integer value.
        System.out.println("Invalid input!");
        System.out.println("Only enter only whole numbers.\nPlease enter the year again.");
        valid = false;
      } catch (IllegalArgumentException e) {
        // If user entered a value not within the range of the minimum value and maximum value.
        System.out.println("Invalid input entered!");
        System.out.println("A year must be between " + MIN_YEAR + " and " + MAX_YEAR);
        System.out.println("Please enter the year again.");
        valid = false;
      }
    } while (!valid);

    return year;
  }

  /*********************************************************************************************************************
   * getID method gets the student's ID number from the user and checks if the input is valid for our system.
   *
   * @return The ID number(integer) for a student.
   ********************************************************************************************************************/
  private int getID() {
    int id = 0;
    boolean valid;

    do {
      valid = true;
      System.out.print("Enter Student ID: ");
      try {
        id = Integer.parseInt(scanner.nextLine());
        if (id < 1) {
          // If the user enters a non-positive value.
          throw new IllegalArgumentException();
        }
      } catch (NumberFormatException e) {
        // If user entered a non-integer value.
        System.out.println("Invalid input!");
        System.out.println(
            "Only positive integers are accepted.\nPlease enter the student's ID number again.");
        valid = false;
      } catch (IllegalArgumentException e) {
        // If the user entered a negative value
        System.out.println("Invalid input entered!");
        System.out.println("A student's ID must be a positive whole number.");
        System.out.println("Please enter the ID number again.");
        valid = false;
      }
    } while (!valid);

    return id;
  }

  /*********************************************************************************************************************
   * logoBanner displays the logo banner which is the program's name.
   ********************************************************************************************************************/
  public void logoBanner() {
    System.out.println(
        "\n"
            + "   ____   _                          ____                  _                 \n"
            + "  / ___| | |   __ _   ___   ___     |  _ \\    ___    ___  | |_    ___   _ __ \n"
            + " | |     | |  / _` | / __| / __|    | |_) |  / _ \\  / __| | __|  / _ \\ | '__|\n"
            + " | |___  | | | (_| | \\__ \\ \\__ \\    |  _ <  | (_) | \\__ \\ | |_  |  __/ | |   \n"
            + "  \\____| |_|  \\__,_| |___/ |___/    |_| \\_\\  \\___/  |___/  \\__|  \\___| |_|   \n"
            + "                                                                             \n");
  }
}
