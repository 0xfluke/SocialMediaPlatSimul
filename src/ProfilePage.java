import java.io.*;

public class ProfilePage {
    UserManager userManager;
    PublicDashboard publicDashboard;
    FileInputStream fis1;
    ObjectInputStream ois1;
    ObjectOutputStream oos;
    User sessionUser = userManager.getCurrentUser();
    public ProfilePage(User sessionUser){
        displayStats(sessionUser);
        displayPersonalContent(sessionUser);
    }
    public void displayStats(User sessionUser){
        System.out.println("|-----> Welcome to the Profile Page <-----|");
        System.out.println("USERNAME: " + sessionUser.getUsername());
        System.out.println("PASSWORD: " + sessionUser.getPassword());
        System.out.println("MAIL ADDRESS: " + sessionUser.getMailAddress());
        System.out.println("BIRTH DATE: " + sessionUser.getBirthDate());
        System.out.println("LOCATION: " + sessionUser.getLocation());
        System.out.println("|-------------------------------------------|");
    }
    public void displayPersonalContent(User sessionUser){
            for (Message content : publicDashboard.displayFeed()) {
                if(content.getSender().equals(sessionUser.getUsername())){
                    System.out.println("|--------------------|");
                    System.out.println(content.getContent());
                }
            }
    }
}
