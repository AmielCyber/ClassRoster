/***********************************************************************************************************************
 * The Account class will be use to store a user's username and password.
 **********************************************************************************************************************/
public class Account {

  private String userName;
  private String password;

  /**
   * Account constructor
   *
   * @param userName The username of the user.
   * @param password The password of the user.
   */
  public Account(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  /*********************************************************************************************************************
   * toString will display the User's Account attributes.
   *
   * @return The name and password of a particular account.
   ********************************************************************************************************************/
  @Override
  public String toString() {
    return this.userName + " " + this.password;
  }

  // Setters and Getters defined here.

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
