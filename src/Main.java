import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import static java.lang.System.in;

public class Main {
    public static void saveUser(HashMap<String, User> userList){
        try{
            FileOutputStream fos = new FileOutputStream("users.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
            System.out.println("User has been saved successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static HashMap <String, User> loadUser(){
        HashMap<String, User> savedUser = null;
        try{
            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            savedUser = (HashMap<String, User>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (FileNotFoundException e){
            System.out.println("No saved user found. Creating new user.");
            savedUser = new HashMap<>();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            savedUser = new HashMap<>();
        }
        return savedUser;
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner(in);
        UserManager userManager = new UserManager();
        PublicDashboard publicDashboard = new PublicDashboard();
        // AUTH LOOP
        while(!userManager.getLoginAccess()){
            System.out.println("Please select an option (1/2/3): ");
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            int answer = scanner.nextInt();
            scanner.nextLine();
            if(answer == 2){
                System.out.println("Welcome to the Sign Up Screen!");
                System.out.print("Please enter a valid username: ");
                String username = scanner.nextLine();
                userManager.usernameChecker(username);
                System.out.print("Please enter a valid password: ");
                String password = scanner.nextLine();
                userManager.passwordChecker(password);
                System.out.print("Please enter your mail address: ");
                String mailAddress = scanner.nextLine();
                userManager.mailAddressChecker(mailAddress);
                System.out.print("Please enter your location: ");
                String location = scanner.nextLine();
                System.out.print("Please enter your birth date (DD/MM/YYYY): ");
                String birthDate = scanner.nextLine();
                userManager.receiver(username, mailAddress, password, location, birthDate);
                saveUser(userManager.getUserList());
            }
            else if(answer == 1){
                System.out.println("Welcome to the Sign In Screen!");
                System.out.print("Please enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                userManager.signInManager(username, password);
            }
            else if(answer == 3){
                System.exit(0);
            }
        }
        //DASHBOARD LOOP
        while(userManager.getLoginAccess()){
            publicDashboard.displayFeed();
            System.out.println("Create your content to share: ");
            String content = scanner.nextLine();
            publicDashboard.contentManager(content);
        }

    }
}
