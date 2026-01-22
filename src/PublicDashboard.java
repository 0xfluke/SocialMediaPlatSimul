import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PublicDashboard {
    private ArrayList<String> bannedWords = new ArrayList<>();
    private ArrayList<Message> publicFeed = new ArrayList<>();
    public PublicDashboard() {
        this.publicFeed = readFeed();
        if(this.publicFeed.isEmpty()){
            this.publicFeed = new ArrayList<>();
        }
    }
    UserManager userManager;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String timestamp =  LocalDateTime.now().format(dtf);
    public static void saveFeed(Message content) {
        try {
            FileOutputStream fos1 = new FileOutputStream("publicFeed.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(content);
            oos1.close();
            fos1.close();
            System.out.println("Successfully saved the feed!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Message> readFeed() {
        ArrayList<Message> content = null;
        try {
            FileInputStream fis1 = new FileInputStream("publicFeed.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            content = (ArrayList<Message>) ois1.readObject();
            ois1.close();
            fis1.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            content = new ArrayList<Message>();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            content = new ArrayList<Message>();
        }
        return content;
    }
    public boolean contentChecker(String content){
        if(content.isEmpty()){
            System.out.println("Empty Content");
            return false;
        } else if (content.length()<8) {
            System.out.println("Content too short");
            return false;
        } else if (content.length() > 280) {
            System.out.println("Content too long");
            return false;
        } else {
            for(int i = 0; i < bannedWords.size(); i++){
                if(content.contains(bannedWords.get(i))){
                    System.out.println("Banned Word");
                    return false;
                }
            }
        }
        return true;
    }
    public void contentManager(String content){
        if(contentChecker(content)){
            Message newMessage = new Message(userManager.getCurrentUser().getUsername(), content, timestamp);
            saveFeed(newMessage);
        }
    }
    public ArrayList<Message> displayFeed(){
        return readFeed();
    }
}
