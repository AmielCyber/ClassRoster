import java.util.Iterator;
import java.util.LinkedList;

/***********************************************************************************************************************
 * User class will keep a list of authorized users who have access to the system. The User class will also
 * check if a user is already in the list.
 **********************************************************************************************************************/
public class User {
  // Implement linked list to store student data
  LinkedList<Account> accountList = new LinkedList<>();

  Driver driver = new Driver();

  // Sets user account checks login

  /*********************************************************************************************************************
   * userLogin will check if a user is in the system or not.
   * @param account An Account object that will contain an account's username and password.
   * @return A boolean type that will check if the user is in the system(true) and if is not(false).
   ********************************************************************************************************************/
  public boolean userLogin(Account account) {
    accountList.add(new Account("admin", "password"));
    boolean isThere = false;

    int i = 0;
    int num = 0;

    while (accountList.size() > i) {
      if (account.getUserName().equals(accountList.get(num).getUserName())) {
        if (account.getPassword().equals(accountList.get(num).getPassword())) {
          isThere = true;
        }
      }
      num++;
      i++;
    }

    return isThere;
  }
}
