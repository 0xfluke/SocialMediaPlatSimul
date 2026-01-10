import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
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


    }
}
