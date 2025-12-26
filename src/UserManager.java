import java.util.HashMap;

public class UserManager {
    HashMap<String, User> userList = new HashMap();
    // In frontend, we will receive some user input regarding the Sign-In or Sign-Up choice
    // Our backend should first receive the user input, then act upon
    // If the input is Sign Up, we need to prompt the user with new input fields
    private boolean userDecisionSignUp = false;
    private boolean userDecisionSignIn = false;
    private boolean loginAccess = false; // If set to true, access to the dashboard
    private boolean usernameValid = false;
    private boolean mailAddressValid = false;
    private boolean passwordValid = false;
    String [] numList = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String [] letterList = {"a", "b", "c", "d", "e", "f", "g", "j", "k", "l", "m", "n", "o", "p"};
    String [] charlist = {"!", "_", "."};
    String [] mailProviderList = {"gmail.com", "yahoo.com"};


    // But, in order to create this user object, the input should be valid. We need a checker method for user input, above all methods.
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
    public Boolean signInManager(String username, String password){ // Takes the username and password, then check them in the HashMap
        if(userList.containsKey(username)){
            User foundUser = userList.get(username);
            if(foundUser.getPassword().equals(password)){
                loginAccess = true;
            }
            else{
                System.out.println("Wrong password");
                loginAccess = false;
            }
        }
        else{
            System.out.println("Username does not exist");
            return loginAccess == false;
        }
        return loginAccess;
    }


}

// Input Conditions
// 1. Username should be 5-12 characters, should contain at least 1 letter and 1 number. But no characters or symbols are allowed.
// 2. Password should be 5-12 characters, should contain at least 1 letter, 1 number and 1 char from the following list: "!, _, +, %, &, >, £, #, $, ½"
// 3. Location should be a valid country name, one of 195 in the country list. No case sensitive but typos are not accepted.
// 4. Birth Date should be in the format of DD/MM/YYYY.
// 5. Mail Address should have 1 @ character, and it should end with a valid provider extension like "gmail.com"