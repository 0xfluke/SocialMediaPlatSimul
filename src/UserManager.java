import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> userList = new HashMap();
    private boolean loginAccess = false; // If set to true, access to the dashboard
    private boolean usernameValid = false;
    private boolean mailAddressValid = false;
    private boolean passwordValid = false;
    private final String [] numList = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final String [] letterList = {"a", "b", "c", "d", "e", "f", "g", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private final String [] charlist = {"!", "_", "."};
    private final String [] mailProviderList = {"gmail.com", "yahoo.com"};
    private User currentUser;
    public UserManager(){
        //signInManager(currentUser.getUsername(), currentUser.getPassword());
    }

    // We need to check Username, Mail Address and Password for valid input. Location and Birth Date will be selected via a drop-down menu in the UI.
    public boolean usernameChecker(String username){
        if(userList.containsKey(username)){
            System.out.println("The username is already taken. Please select a new username.");
            usernameValid = false;
        }
        else if(username.length()< 5 || username.length()> 12){
            System.out.println("Username 5-12 characters. Please enter a new username.");
            usernameValid = false;
        }
        else {
            for(int i = 0 ; i < 30; i++){
                if(username.contains(charlist[i])){
                    System.out.println("Username should not contain any characters. Please only use letters and numbers.");
                    usernameValid = false;
                }
                else if(!username.contains(letterList[i])){
                    System.out.println("Username should contain at least 1 letter.");
                    usernameValid = false;
                }
                else if(!username.contains(numList[i])){
                    System.out.println("Username should contain at least 1 number.");
                    usernameValid = false;
                }
                else{
                    usernameValid = true;
                }
            }
        }
        return usernameValid;
    }
    public boolean mailAddressChecker (String mailAddress){
        if(!mailAddress.contains("@")){
            System.out.println("Mail address should contain '@'");
            mailAddressValid = false;
        }
        else {
            for(int i = 0; i < mailAddress.length(); i++){
                if(!mailAddress.contains(mailProviderList[i])){
                    System.out.println("Mail address should end with a valid provider extension like Gmail.");
                    mailAddressValid = false;
                }
                else {
                    mailAddressValid = true;
                }
            }
        }
        return mailAddressValid;
    }
    public boolean passwordChecker(String password){
        if(password.length()< 5 || password.length()> 12){
            System.out.println("Username 5-12 characters. Please enter a new username.");
            passwordValid = false;
        }
        else {
            for(int i = 0 ; i < 30; i++){
                if(!password.contains(charlist[i])){
                    System.out.println("Password should contain at least 1 character.");
                    passwordValid = false;
                }
                else if(!password.contains(letterList[i])){
                    System.out.println("Password should contain at least 1 letter.");
                    passwordValid = false;
                }
                else if(!password.contains(numList[i])){
                    System.out.println("Password should contain at least 1 number.");
                    passwordValid = false;
                }
                else{
                    passwordValid = true;
                }
            }
        }
        return passwordValid;
    }

    // This should take all necessary input, construct a User object with it and store that User object with the correct Key-Value mapping in our HashMap
    public void receiver(String username, String mailAddress, String password, String location, String birthDate){
        if(usernameChecker(username) && mailAddressChecker(mailAddress) && passwordChecker(password)){
            User myUser = new User(username, mailAddress, password, location, birthDate);
            userList.put(username, myUser);
        }
        else{
            if(!usernameChecker(username)){
                usernameChecker(username);
            }
            else if (!mailAddressChecker(mailAddress)) {
                mailAddressChecker(mailAddress);
            }
            else if (!passwordChecker(password)) {
                passwordChecker(password);
            }
            else{
                System.out.println("Something went wrong, please check your input.");
            }
        }

    }
    public boolean signInManager(String username, String password){ // Takes the username and password, then check them in the HashMap
        if(userList.containsKey(username)){
            User foundUser = userList.get(username);
            if(foundUser.getPassword().equals(password)){
                currentUser = foundUser;
                return true;
            }
            else{
                System.out.println("Wrong password");
                return false;
            }
        }
        else{
            System.out.println("Username does not exist");
            return false;
        }
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public boolean getLoginAccess(){
        return this.loginAccess;
    }
    public HashMap<String, User> getUserList(){
        return userList;
    }
}