import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClassRoster {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // Instantiate Classes
    Driver driver = new Driver();
    Course course = new Course();
    User user = new User();

    // Software Logo
    driver.logoBanner();

    // User Login
    boolean userLogin = false;

    while (!userLogin) {
      userLogin = user.userLogin(driver.getAccountInfo());
      if (!userLogin) {
        System.out.println("Incorrect Username or Password\n");
      } else {
        System.out.println("Login Successful");
      }
    }

    /** Loads saved roster on startup  */

      File yourFile = new File("class-roster.txt");
      if (yourFile.exists())
          course.loadRoster();

    // Takes user input from main menu and insert into switch
    // Loops through until user selects exit
    Scanner scanner = new Scanner(System.in);
    boolean rosterStatus = true;
    boolean userExit = false;

    while (!userExit) {
      String userChoice = mainMenu();
      switch (userChoice) {
        case "1": // Call Add Student
          if (rosterStatus) {
            course.addStudent();
          } else {
            System.out.print("\nRoster is Locked\n");
          }
          break;
        case "2": // Call Remove Student
          if (rosterStatus) {
            course.removeStudent(scanner);
          } else {
            System.out.print("\nRoster is Locked\n");
          }
          break;
        case "3": // Call Display Class Roster sorted by Name
          course.displaySortName();
          break;
        case "4": // Call Display Class Roster sorted by ID
          course.displaySortID();
          break;
        case "5": // Save Roster
          course.saveRoster();
          break;
        case "6": // Lock/Unlock Roster
          System.out.print(
              "1: Lock Roster\n"
                  + "2: Unlock Roster\n"
                  + "Would you like to Lock or Unlock roster: ");
          int statusChoice = Integer.parseInt(scanner.nextLine());
          rosterStatus = statusChoice != 1;
          break;
        case "7":
          userExit = true;
          // Close Program
          break;
        default:
          System.out.println("Invalid Choice: ");
      }
    }
    System.out.println("ClassRoster has been exited successfully.");
  }

  /*********************************************************************************************************************
   * mainMenu Will print ClassRoster Menu and get user selection                                                              *
   * @return User menu selection                                                                                       *
   ********************************************************************************************************************/
  public static String mainMenu() {
    System.out.println(
        "\n==== User Options ====\n"
            + "1: Add Student\n"
            + "2: Remove Student\n"
            + "3: Display Class Roster sorted by Name\n"
            + "4: Display Class Roster sorted by ID\n"
            + "5: Save Roster\n"
            + "6: Lock/Unlock Class Roster\n"
            + "7: Exit");

    System.out.print("Enter a menu option 1-7: ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
